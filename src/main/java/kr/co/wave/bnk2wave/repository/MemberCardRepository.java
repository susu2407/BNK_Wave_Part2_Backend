
/*
  날짜 : 2025-12-29
  내용 : MemberCardRepository 생성
  이름 : 박효빈
*/
package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.MemberCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberCardRepository extends JpaRepository<MemberCard,Long> {

    Optional<MemberCard> findFirstByMemberIdOrderByIssueDateDesc(Long memberId);
}
