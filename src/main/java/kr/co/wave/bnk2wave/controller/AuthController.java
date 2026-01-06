package kr.co.wave.bnk2wave.controller;

import jakarta.servlet.http.HttpSession;
import kr.co.wave.bnk2wave.dto.LoginRequestDTO;
import kr.co.wave.bnk2wave.dto.LoginResponseDTO;
import kr.co.wave.bnk2wave.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request,
            HttpSession session
    ) {
        return ResponseEntity.ok(authService.login(request, session));
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}