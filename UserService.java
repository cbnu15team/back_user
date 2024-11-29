package com.example.joinup.user.service;

import com.example.joinup.user.entity.User;
import com.example.joinup.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public User registerUser(User user) {
        // ID 중복 확인
        if (userRepository.findById(user.getId()).isPresent()) {
            throw new RuntimeException("이미 존재하는 ID입니다.");
        }
        // 닉네임 중복 확인
        if (userRepository.findByNickname(user.getNickname()).isPresent()) {
            throw new RuntimeException("이미 존재하는 닉네임입니다.");
        }
        return userRepository.save(user);
    }

    // 로그인
    public User login(String id, String password) {
        return userRepository.findByIdAndPassword(id, password)
                .orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 잘못되었습니다."));
    }
}
