/*
  날짜 : 2025-12-18
  내용 : CardBenefitDTO 생성
  이름 : 박효빈
  
  날짜 : 2025-12-29
  내용 : toEntity() 메서드 추가 (DTO -> Entity 변환)
  이름 : 박효빈
*/

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

    private Long benefitId;             // 혜택 ID
    private Long cardId;                // 카드 ID

    private String benefitCategory;     // 혜택 카테고리
    private String benefitName;         // 혜택명
    private String applicableCategory;  // 적용 카테고리

    private String benefitType;         // 혜택 타입 (RATE / AMOUNT 등)
    private BigDecimal benefitRate;     // 할인율, 적립률

    private Integer monthlyLimit;       // 월 한도

    /**
     * Entity -> DTO 변환 (조회 시 사용)
     * @param entity CardBenefit 엔티티
     * @return CardBenefitDTO
     */
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

    /**
     * DTO -> Entity 변환 (생성/수정 시 사용)
     * @return CardBenefit 엔티티
     */
    public CardBenefit toEntity() {
        return CardBenefit.builder()
                .benefitId(benefitId)
                .cardId(cardId)
                .benefitCategory(benefitCategory)
                .benefitName(benefitName)
                .applicableCategory(applicableCategory)
                .benefitType(benefitType)
                .benefitRate(benefitRate)
                .monthlyLimit(monthlyLimit)
                .build();
    }
}