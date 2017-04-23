package com.terekh.portfl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.terekh.portfl.entity.User;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
