/*
  날짜 : 2025-12-18
  내용 : CardHistoryDTO 생성
  이름 : 박효빈
  
  날짜 : 2025-12-29
  내용 : toEntity() 메서드 추가 (DTO -> Entity 변환)
  이름 : 박효빈
*/

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

    private Long transactionId;         // 거래 ID

    private Long memberId;              // 회원 ID
    private Long memberCardId;          // 회원 카드 ID

    private LocalDateTime approvalDatetime;  // 승인 일시
    private Integer approvalAmount;          // 승인 금액

    private String merchantName;        // 가맹점명
    private String merchantCategory;    // 가맹점 카테고리

    private Long benefitId;             // 혜택 ID
    private Integer benefitAmount;      // 혜택 금액

    private String isPerformance;       // 실적 인정 여부

    private BigDecimal latitude;        // 위도
    private BigDecimal longitude;       // 경도
    private String merchantAddress;     // 가맹점 주소

    /**
     * Entity -> DTO 변환 (조회 시 사용)
     * @param entity CardHistory 엔티티
     * @return CardHistoryDTO
     */
    public static CardHistoryDTO fromEntity(CardHistory entity) {
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

    /**
     * DTO -> Entity 변환 (생성/수정 시 사용)
     * @return CardHistory 엔티티
     */
    public CardHistory toEntity() {
        return CardHistory.builder()
                .transactionId(transactionId)
                .memberId(memberId)
                .memberCardId(memberCardId)
                .approvalDatetime(approvalDatetime)
                .approvalAmount(approvalAmount)
                .merchantName(merchantName)
                .merchantCategory(merchantCategory)
                .benefitId(benefitId)
                .benefitAmount(benefitAmount)
                .isPerformance(isPerformance)
                .latitude(latitude)
                .longitude(longitude)
                .merchantAddress(merchantAddress)
                .build();
    }
}