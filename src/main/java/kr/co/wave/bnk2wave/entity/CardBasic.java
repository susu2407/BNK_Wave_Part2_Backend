package kr.co.wave.bnk2wave.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_CARD_BASIC")
public class CardBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long cardId;

    @Column(name = "CARD_NAME")
    private String cardName;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "ANNUAL_FEE")
    private Integer annualFee;

    @Column(name = "CARD_TYPE")
    private String cardType;

    @Column(name = "CARD_GRADE")
    private String cardGrade;

    @Column(name = "MIN_PERFORMANCE_AMOUNT")
    private Integer minPerformanceAmount;

    @Column(name = "CARD_IMAGE_URL")
    private String cardImageUrl;
}
