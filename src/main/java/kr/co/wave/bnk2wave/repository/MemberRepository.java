
/*
  날짜 : 2025-12-29
  내용 : MemberCardRepository 생성
  이름 : 박효빈
*/
package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByMemberNameAndEmail(String memberName, String email);

}
