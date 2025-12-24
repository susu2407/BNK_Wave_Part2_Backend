package kr.co.wave.bnk2wave.dto;
import kr.co.wave.bnk2wave.entity.CardHistory;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardHistoryDTO {

    private Long transactionId;

    private Long memberId;
    private Long memberCardId;

    private LocalDateTime approvalDatetime;
    private Integer approvalAmount;

    private String merchantName;
    private String merchantCategory;

    private Long benefitId;
    private Integer benefitAmount;

    private String isPerformance;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String merchantAddress;

    public static CardHistoryDTO fromEntity(kr.co.wave.bnk2wave.entity.CardHistory entity) {
        return CardHistoryDTO.builder()
                .transactionId(entity.getTransactionId())
                .memberId(entity.getMemberId())
                .memberCardId(entity.getMemberCardId())
                .approvalDatetime(entity.getApprovalDatetime())
                .approvalAmount(entity.getApprovalAmount())
                .merchantName(entity.getMerchantName())
                .merchantCategory(entity.getMerchantCategory())
                .benefitId(entity.getBenefitId())
                .benefitAmount(entity.getBenefitAmount())
                .isPerformance(entity.getIsPerformance())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .merchantAddress(entity.getMerchantAddress())
                .build();
    }
}
