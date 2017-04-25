package com.terekh.portfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terekh.portfl.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
