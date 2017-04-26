package com.terekh.portfl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terekh.portfl.model.User;
import com.terekh.portfl.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findOne(Long userId) {
        return this.userRepository.findOne(userId);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        User entity = this.userRepository.findOne(user.getId());

        if (Objects.nonNull(entity)) {
            entity.setUsername(user.getUsername());
            entity.setEmail(user.getEmail());
            entity.setRole(user.getRole());

            if (Objects.nonNull(user.getPassword())) {
                entity.setPassword(user.getPassword());
            }

            this.userRepository.save(entity);
        }
    }

    @Transactional
    public void delete(Long id) {
        this.userRepository.delete(id);
    }

}