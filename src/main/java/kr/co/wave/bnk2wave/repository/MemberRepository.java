
/*
  날짜 : 2025-12-29
  내용 : MemberCardRepository 생성
  이름 : 박효빈
*/
package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
