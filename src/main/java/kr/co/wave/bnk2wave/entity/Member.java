package kr.co.wave.bnk2wave.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "LOGIN_ID", nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "MEMBER_NAME", nullable = false, length = 50)
    private String memberName;

    @Column(name = "LAST_NAME_EN", nullable = false, length = 10)
    private String lastNameEn;

    @Column(name = "FIRST_NAME_EN", nullable = false, length = 10)
    private String firstNameEn;

    @Column(name = "BIRTH", nullable = false)
    private LocalDate birth;

    @Column(name = "RRN", nullable = false, length = 20)
    private String rrn;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "AGE_GROUP", length = 10)
    private String ageGroup;

    @Column(name = "GENDER", length = 1)
    private String gender;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "MOBILE_CARRIER", nullable = false, length = 5)
    private String mobileCarrier;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

    @Column(name = "ADDRESS", length = 300)
    private String address;

    @Column(name = "ADDRESS_DETAIL", length = 200)
    private String addressDetail;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "MEMBER_STATUS", nullable = false, length = 10)
    private String memberStatus;

    @Column(name = "MEMBER_TYPE", nullable = false, length = 10)
    private String memberType;

}
