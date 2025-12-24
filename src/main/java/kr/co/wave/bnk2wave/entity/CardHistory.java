package kr.co.wave.bnk2wave.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_CARD_HISTORY")
public class CardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Column(name = "MEMBER_CARD_ID", nullable = false)
    private Long memberCardId;

    @Column(name = "APPROVAL_DATETIME", nullable = false)
    private LocalDateTime approvalDatetime;

    @Column(name = "APPROVAL_AMOUNT", nullable = false)
    private Integer approvalAmount;

    @Column(name = "MERCHANT_NAME", nullable = false, length = 100)
    private String merchantName;

    @Column(name = "MERCHANT_CATEGORY", length = 50)
    private String merchantCategory;

    @Column(name = "BENEFIT_ID")
    private Long benefitId;

    @Column(name = "BENEFIT_AMOUNT")
    private Integer benefitAmount;

    @Column(name = "IS_PERFORMANCE", nullable = false, length = 1)
    private String isPerformance;

    @Column(name = "LATITUDE", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "MERCHANT_ADDRESS", nullable = false, length = 255)
    private String merchantAddress;
}
