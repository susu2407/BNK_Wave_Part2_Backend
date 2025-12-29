/*
  날짜 : 2025-12-18
  내용 : MemberCardDTO 생성
  이름 : 박효빈
  
  날짜 : 2025-12-29
  내용 : toEntity() 메서드 추가 (DTO -> Entity 변환)
  이름 : 박효빈
*/

package kr.co.wave.bnk2wave.dto;

import kr.co.wave.bnk2wave.entity.MemberCard;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberCardDTO {

    private Long memberCardId;          // 회원 카드 ID

    private Long memberId;              // 회원 ID
    private Long cardId;                // 카드 ID

    private String cardNumber;          // 카드 번호

    private LocalDate issueDate;        // 발급일
    private LocalDate expiryDate;       // 만료일

    private String cardStatus;          // 카드 상태

    private Integer paymentDay;         // 결제일
    private String paymentBank;         // 결제 은행
    private String paymentAccount;      // 결제 계좌

    /**
     * Entity -> DTO 변환 (조회 시 사용)
     * @param entity MemberCard 엔티티
     * @return MemberCardDTO
     */
    public static MemberCardDTO fromEntity(MemberCard entity) {
        return MemberCardDTO.builder()
                .memberCardId(entity.getMemberCardId())
                .memberId(entity.getMemberId())
                .cardId(entity.getCardId())
                .cardNumber(entity.getCardNumber())
                .issueDate(entity.getIssueDate())
                .expiryDate(entity.getExpiryDate())
                .cardStatus(entity.getCardStatus())
                .paymentDay(entity.getPaymentDay())
                .paymentBank(entity.getPaymentBank())
                .paymentAccount(entity.getPaymentAccount())
                .build();
    }

    /**
     * DTO -> Entity 변환 (생성/수정 시 사용)
     * @return MemberCard 엔티티
     */
    public MemberCard toEntity() {
        return MemberCard.builder()
                .memberCardId(memberCardId)
                .memberId(memberId)
                .cardId(cardId)
                .cardNumber(cardNumber)
                .issueDate(issueDate)
                .expiryDate(expiryDate)
                .cardStatus(cardStatus)
                .paymentDay(paymentDay)
                .paymentBank(paymentBank)
                .paymentAccount(paymentAccount)
                .build();
    }
}