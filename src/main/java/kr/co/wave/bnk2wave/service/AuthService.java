package kr.co.wave.bnk2wave.service;

import jakarta.servlet.http.HttpSession;
import kr.co.wave.bnk2wave.dto.LoginRequestDTO;
import kr.co.wave.bnk2wave.dto.LoginResponseDTO;
import kr.co.wave.bnk2wave.entity.Member;
import kr.co.wave.bnk2wave.repository.MemberRepository;
import kr.co.wave.bnk2wave.repository.PaymentAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PaymentAccountRepository paymentAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO request, HttpSession session) {

        Member member = memberRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new RuntimeException("아이디 오류"));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호 오류");
        }

        // ✅ 세션에 로그인 정보 저장
        session.setAttribute("LOGIN_MEMBER_ID", member.getMemberId());

        boolean hasAccount =
                paymentAccountRepository.existsByMemberId(member.getMemberId());

        return new LoginResponseDTO(hasAccount);
    }
}