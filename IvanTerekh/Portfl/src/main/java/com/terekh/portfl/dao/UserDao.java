package com.terekh.portfl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terekh.portfl.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
