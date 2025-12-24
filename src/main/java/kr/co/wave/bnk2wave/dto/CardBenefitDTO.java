package kr.co.wave.bnk2wave.dto;

import kr.co.wave.bnk2wave.entity.CardBenefit;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardBenefitDTO {

    private Long benefitId;
    private Long cardId;

    private String benefitCategory;
    private String benefitName;
    private String applicableCategory;

    private String benefitType;      // RATE / AMOUNT 등
    private BigDecimal benefitRate;  // 할인율, 적립률

    private Integer monthlyLimit;

    public static CardBenefitDTO fromEntity(CardBenefit entity) {
        return CardBenefitDTO.builder()
                .benefitId(entity.getBenefitId())
                .cardId(entity.getCardId())
                .benefitCategory(entity.getBenefitCategory())
                .benefitName(entity.getBenefitName())
                .applicableCategory(entity.getApplicableCategory())
                .benefitType(entity.getBenefitType())
                .benefitRate(entity.getBenefitRate())
                .monthlyLimit(entity.getMonthlyLimit())
                .build();
    }
}
