package kr.co.wave.bnk2wave.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "PAYMENT_ACCOUNT")
@Getter
public class PaymentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false)
    private Long memberId;
}
