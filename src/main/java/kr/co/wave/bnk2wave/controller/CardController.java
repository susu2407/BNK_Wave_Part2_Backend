package kr.co.wave.bnk2wave.controller;

import kr.co.wave.bnk2wave.dto.MyCardResponseDTO;
import kr.co.wave.bnk2wave.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/mypage/{memberId}")
    public ResponseEntity<MyCardResponseDTO> getMyPageInfo(@PathVariable("memberId") Long memberId) {

        // 서비스 호출하여 데이터 가져오기
        MyCardResponseDTO response = cardService.getMyPageCardInfo(memberId);

        // 200 OK 상태코드와 함께 JSON 데이터 반환
        return ResponseEntity.ok(response);
    }

}
