package com.example.joinup.user.repository;

import com.example.joinup.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // ID로 사용자 조회
    Optional<User> findById(String id);

    // 닉네임으로 사용자 조회
    Optional<User> findByNickname(String nickname);

    // ID와 비밀번호로 사용자 조회 (로그인)
    Optional<User> findByIdAndPassword(String id, String password);
}
