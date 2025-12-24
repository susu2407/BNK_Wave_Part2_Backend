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

    private Long cardId;
    private String cardName;
    private String bankName;
    private Integer annualFee;
    private String cardType;
    private String cardGrade;
    private Integer minPerformanceAmount;
    private String cardImageUrl;

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
}


