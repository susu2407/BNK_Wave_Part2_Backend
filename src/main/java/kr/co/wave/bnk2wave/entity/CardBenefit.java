package kr.co.wave.bnk2wave.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_CARD_BENEFIT")
public class CardBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BENEFIT_ID")
    private Long benefitId;

    @Column(name = "CARD_ID", nullable = false)
    private Long cardId;

    @Column(name = "BENEFIT_CATEGORY", nullable = false, length = 50)
    private String benefitCategory;

    @Column(name = "BENEFIT_NAME", nullable = false, length = 100)
    private String benefitName;

    @Column(name = "APPLICABLE_CATEGORY", length = 50)
    private String applicableCategory;

    @Column(name = "BENEFIT_TYPE", nullable = false, length = 10)
    private String benefitType;

    @Column(name = "BENEFIT_RATE", precision = 5, scale = 4)
    private BigDecimal benefitRate;

    @Column(name = "MONTHLY_LIMIT")
    private Integer monthlyLimit;
}
