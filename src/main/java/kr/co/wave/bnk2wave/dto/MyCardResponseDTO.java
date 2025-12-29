package kr.co.wave.bnk2wave.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyCardResponseDTO {
    private String cardName;        // 카드 이름 (CardBasic)
    private String cardNumber;      // 카드 번호 끝 4자리 (MemberCard)
    private String cardImageUrl;    // 카드 이미지 URL (CardBasic)
    private Long totalUsageAmount;  // 이번 달 결제 총액 (CardHistory - Repository 에서 계산)
}
