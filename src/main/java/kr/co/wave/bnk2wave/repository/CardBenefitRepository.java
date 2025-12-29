
/*
  날짜 : 2025-12-29
  내용 : CardBenefitRepository 생성
  이름 : 박효빈
*/
package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.CardBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardBenefitRepository extends JpaRepository<CardBenefit, Long> {
}
