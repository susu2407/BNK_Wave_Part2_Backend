/*
    날짜 : 2025-12-30
    이름 : 이수연
    내용 :
*/

package kr.co.wave.bnk2wave.controller;

import kr.co.wave.bnk2wave.dto.AccountRegisterRequestDTO;
import kr.co.wave.bnk2wave.service.PaymentAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentAccountController {

    private final PaymentAccountService accountService;

    // Flutter에서 POST http://.../payment/save 로 요청하면 이 함수가 실행됨
    @PostMapping("/save")
    public ResponseEntity<String> registerPaymentAccount(@RequestBody AccountRegisterRequestDTO requestDto) {
        log.info("Flutter로부터 계좌 등록 요청 수신: {}", requestDto);
        accountService.registerAccount(requestDto);
        // 간단한 성공 문자열을 반환하거나, 별도의 응답 DTO를 사용할 수 있습니다.
        return ResponseEntity.ok("결제 계좌가 성공적으로 등록되었습니다.");
    }
}
