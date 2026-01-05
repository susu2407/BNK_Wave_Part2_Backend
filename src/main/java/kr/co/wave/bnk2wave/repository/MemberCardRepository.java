
/*
  날짜 : 2025-12-29
  내용 : MemberCardRepository 생성
  이름 : 박효빈
*/
package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.MemberCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberCardRepository extends JpaRepository<MemberCard, Long> {

    boolean existsByMember_LoginIdAndPaymentAccountIsNotNull(String loginId);

    @Query("""
        select case when count(mc) > 0 then true else false end
        from MemberCard mc
        where mc.member.loginId = :loginId
          and mc.paymentAccount is not null
          and trim(mc.paymentAccount) <> ''
    """)
    boolean existsValidPaymentAccountByLoginId(@Param("loginId") String loginId);
}