package com.terekh.portfl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
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
			updateFields(entity, user);
			this.userRepository.save(entity);
		}
	}
	
	private void updateFields(User oldUser, User newUser){
		oldUser.setUsername(newUser.getUsername());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setRole(newUser.getRole());
		oldUser.setBirthYear(newUser.getBirthYear());
		oldUser.setHeight(newUser.getHeight());
		oldUser.setWeight(newUser.getWeight());
		oldUser.setGender(newUser.getGender());
	}

	@Transactional
	public void delete(Long id) {
		this.userRepository.delete(id);
	}
}