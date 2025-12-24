package kr.co.wave.bnk2wave.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_MEMBER_CARD")
public class MemberCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_CARD_ID")
    private Long memberCardId;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Column(name = "CARD_ID", nullable = false)
    private Long cardId;

    @Column(name = "CARD_NUMBER", nullable = false, length = 20)
    private String cardNumber;

    @Column(name = "ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "CARD_STATUS", nullable = false, length = 10)
    private String cardStatus;

    @Column(name = "PAYMENT_DAY", nullable = false)
    private Integer paymentDay;

    @Column(name = "PAYMENT_BANK", nullable = false, length = 10)
    private String paymentBank;

    @Column(name = "PAYMENT_ACCOUNT", nullable = false, length = 20)
    private String paymentAccount;

    @Column(name = "OWNER_TYPE", nullable = false, length = 20)
    private String ownerType;
}
