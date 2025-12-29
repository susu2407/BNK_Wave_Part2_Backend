/*
  날짜 : 2025-12-29
  내용 : CardBasicRepository 생성
  이름 : 박효빈
*/

package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.CardBasic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardBasicRepository extends JpaRepository<CardBasic, Long> {
}
