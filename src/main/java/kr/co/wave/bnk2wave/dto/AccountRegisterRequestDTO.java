package kr.co.wave.bnk2wave.dto;

import lombok.Data;

@Data
public class AccountRegisterRequestDTO {

    // 어느 카드에 등록할지 식별하기 위한 ID
    private Long memberCardId;

    // 등록할 은행명과 계좌번호
    private String paymentBank;
    private String paymentAccount;

}
