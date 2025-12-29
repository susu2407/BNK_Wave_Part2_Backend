/*
  날짜 : 2025-12-18
  내용 : CardBasicDTO 생성
  이름 : 박효빈

  날짜 : 2025-12-29
  내용 : toEntity() 메서드 추가 (DTO -> Entity 변환)
  이름 : 박효빈
*/

package kr.co.wave.bnk2wave.dto;

import kr.co.wave.bnk2wave.entity.CardBasic;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardBasicDTO {

    private Long cardId;                    // 카드 ID
    private String cardName;                // 카드명
    private String bankName;                // 은행명
    private Integer annualFee;              // 연회비
    private String cardType;                // 카드 타입 (신용/체크)
    private String cardGrade;               // 카드 등급
    private Integer minPerformanceAmount;   // 최소 실적 금액
    private String cardImageUrl;            // 카드 이미지 URL

    /**
     * Entity -> DTO 변환 (조회 시 사용)
     * @param entity CardBasic 엔티티
     * @return CardBasicDTO
     */
    public static CardBasicDTO fromEntity(CardBasic entity) {
        return CardBasicDTO.builder()
                .cardId(entity.getCardId())
                .cardName(entity.getCardName())
                .bankName(entity.getBankName())
                .annualFee(entity.getAnnualFee())
                .cardType(entity.getCardType())
                .cardGrade(entity.getCardGrade())
                .minPerformanceAmount(entity.getMinPerformanceAmount())
                .cardImageUrl(entity.getCardImageUrl())
                .build();
    }

    /**
     * DTO -> Entity 변환 (생성/수정 시 사용)
     * @return CardBasic 엔티티
     */
    public CardBasic toEntity() {
        return CardBasic.builder()
                .cardId(cardId)
                .cardName(cardName)
                .bankName(bankName)
                .annualFee(annualFee)
                .cardType(cardType)
                .cardGrade(cardGrade)
                .minPerformanceAmount(minPerformanceAmount)
                .cardImageUrl(cardImageUrl)
                .build();
    }
}