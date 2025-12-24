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


    private Long memberCardId;

    private Long memberId;
    private Long cardId;

    private String cardNumber;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    private String cardStatus;

    private Integer paymentDay;
    private String paymentBank;
    private String paymentAccount;

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
}
