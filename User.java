package com.example.joinup.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "id", nullable = false, unique = true, length = 10) // 로그인 ID
    private String id;

    @Column(name = "password", nullable = false, length = 10) // 비밀번호
    private String password;

    @Column(name = "real_name", nullable = false, length = 20) // 이름
    private String realName;

    @Column(name = "nickname", nullable = false, unique = true, length = 15) // 닉네임
    private String nickname;

    @Column(name = "birth", nullable = false, length = 8) // 생년월일
    private String birth;

    @Column(name = "phone", nullable = false, unique = true, length = 11) // 전화번호
    @Pattern(regexp = "^010\\d{8}$", message = "전화번호는 010으로 시작하고 뒤에 숫자 8자가 와야 합니다.")
    private String phone;
}
