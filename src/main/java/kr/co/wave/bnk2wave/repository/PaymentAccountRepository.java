package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount,Long> {
    boolean existsByMemberId(Long memberId);
}
