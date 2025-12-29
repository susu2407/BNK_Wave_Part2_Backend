/*
  날짜 : 2025-12-29
  내용 : CardHistoryRepository 생성
  이름 : 박효빈
*/

package kr.co.wave.bnk2wave.repository;

import kr.co.wave.bnk2wave.entity.CardHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CardHistoryRepository extends JpaRepository<CardHistory,Long> {
    // 특정 회원의 특정 카드에 대해, 이번 달(시작일~종료일) 사이의 결제 금액 합계를 구함
    @Query("SELECT SUM(h.approvalAmount) FROM CardHistory h " +
            "WHERE h.memberId = :memberId AND h.memberCardId = :cardId " +
            "AND h.approvalDatetime BETWEEN :start AND :end")
    Long sumAmountByMonth(Long memberId, Long cardId, LocalDateTime start, LocalDateTime end);
}
