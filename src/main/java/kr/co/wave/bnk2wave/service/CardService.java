package kr.co.wave.bnk2wave.service;

import kr.co.wave.bnk2wave.dto.MyCardResponseDTO;
import kr.co.wave.bnk2wave.entity.CardBasic;
import kr.co.wave.bnk2wave.entity.MemberCard;
import kr.co.wave.bnk2wave.repository.CardBasicRepository;
import kr.co.wave.bnk2wave.repository.CardHistoryRepository;
import kr.co.wave.bnk2wave.repository.MemberCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {

    private final MemberCardRepository memberCardRepository;
    private final CardBasicRepository cardBasicRepository;
    private final CardHistoryRepository cardHistoryRepository;

    // Mypage용 카드 정보 통합 조회 서비스
    public MyCardResponseDTO getMyPageCardInfo(Long memberId){
        // 1. 회원이 가진 카드 중 가장 최근에 발급한 카드 1건 조회
        MemberCard memberCard = memberCardRepository.findFirstByMemberIdOrderByIssueDateDesc(memberId)
                .orElseThrow(() -> new RuntimeException("등록된 카드 정보가 없습니다."));

        // 2. 해당 카드의 기본 정보(이름, 이미지) 조회
        CardBasic cardBasic = cardBasicRepository.findById(memberCard.getCardId())
                .orElseThrow(() -> new RuntimeException("카드 상세 정보를 찾을 수 없습니다."));

        // 3. 이번 달 1일 00:00부터 현재까지의 결제 금액 합산 계산
        // 시작일: 2025년 12월 1일 00:00:00
        LocalDateTime startOfMonth = LocalDateTime.of(2025, 12, 1, 0, 0, 0);

        // 종료일: 2026년 1월 31일 23:59:59 (넉넉하게 오늘 이후까지 잡아도 무방합니다)
        LocalDateTime now = LocalDateTime.now();

        Long totalAmount = cardHistoryRepository.sumAmountByMonth(
                memberId,
                memberCard.getMemberCardId(),
                startOfMonth,
                now
        );

        // 금액이 없는 경우 0으로 처리
        if (totalAmount == null) totalAmount = 0L;

        // 4. 최종 DTO 생성 및 반환
        return MyCardResponseDTO.builder()
                .cardName(cardBasic.getCardName())
                .cardNumber(maskCardNumber(memberCard.getCardNumber()))
                .cardImageUrl(cardBasic.getCardImageUrl())
                .totalUsageAmount(totalAmount)
                .build();

    }

    // 카드번호 끝 4자리만 남기는 간단한 메서드
    private String maskCardNumber(String fullNumber) {
        if (fullNumber != null && fullNumber.length() >= 4) {
            return fullNumber.substring(fullNumber.length() - 4);
        }
        return "****";
    }


}
