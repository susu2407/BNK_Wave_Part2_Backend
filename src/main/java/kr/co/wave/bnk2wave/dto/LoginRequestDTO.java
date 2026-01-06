package kr.co.wave.bnk2wave.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String loginId;
    private String password;

    private String accessToken;
    private boolean hasAccount;

    public LoginRequestDTO(String accessToken, boolean hasAccount) {
    }
}
