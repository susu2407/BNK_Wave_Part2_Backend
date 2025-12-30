package kr.co.wave.bnk2wave.service;

import kr.co.wave.bnk2wave.dto.AccountRegisterRequestDTO;
import kr.co.wave.bnk2wave.entity.Member;
import kr.co.wave.bnk2wave.entity.MemberCard;
import kr.co.wave.bnk2wave.repository.MemberCardRepository;
import kr.co.wave.bnk2wave.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentAccountService {

    // 저장 로직
    //public void saveAccount(){
    //  System.out.println("saveAccount...");
    //};

    private final MemberCardRepository memberCardRepository;
    private final MemberRepository memberRepository; // 회원 상태 변경을 위해 추가

    @Transactional // 데이터를 변경하는 작업이므로 @Transactional 추가
    public void registerAccount(AccountRegisterRequestDTO requestDto) {
        // 1. Entity 조회
        MemberCard memberCard = memberCardRepository.findById(requestDto.getMemberCardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드를 찾을 수 없습니다."));

        // 2. Entity의 비즈니스 메서드 호출 (Service는 어떻게 바뀌는지 신경쓰지 않음)
        memberCard.updatePaymentAccount(
                requestDto.getPaymentBank(),
                requestDto.getPaymentAccount()
        );

        // 3. (부가 기능) 회원 상태 변경
        Member member = memberRepository.findById(memberCard.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));


        // 3. 회원 상태 변경 (예시: 최초 계좌 등록 시)
        // Member member = memberRepository.findById(memberCard.getMember().getId()).orElseThrow(...);
        // if (member.getStatus() == MemberStatus.INITIAL) {
        //     member.changeStatus(MemberStatus.ACTIVE);
        // }

        // 4. Repository는 변경된 내용을 감지(Dirty Checking)하고 자동으로 DB에 update 쿼리를 날립니다.
        //    (따로 save를 호출할 필요 없음)
    }
}
