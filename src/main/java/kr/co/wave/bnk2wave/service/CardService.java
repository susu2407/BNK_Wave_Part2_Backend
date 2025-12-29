package kr.co.wave.bnk2wave.service;

import kr.co.wave.bnk2wave.repository.CardBasicRepository;
import kr.co.wave.bnk2wave.repository.CardHistoryRepository;
import kr.co.wave.bnk2wave.repository.MemberCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {

    private final MemberCardRepository memberCardRepository;
    private final CardBasicRepository cardBasicRepository;
    private final CardHistoryRepository cardHistoryRepository;

    // Mypage용 카드 정보 통합 조회 서비스

    
}
