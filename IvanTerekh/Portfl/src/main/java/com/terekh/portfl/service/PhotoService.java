package com.terekh.portfl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terekh.portfl.model.Photo;
import com.terekh.portfl.model.User;
import com.terekh.portfl.repository.PhotoRepository;
import com.terekh.portfl.repository.UserRepository;
import com.terekh.portfl.security.SecurityHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public Photo findOne(Long todoId) {
        return this.photoRepository.findOne(todoId);
    }

    public List<Photo> findAll() {
        final Long currentUserId = SecurityHelper.getUserId();
        return this.photoRepository.findByUserId(currentUserId);
    }

    @Transactional
    public void create(Photo photo) {
        final Long currentUserId = SecurityHelper.getUserId();
        final User currentUser = this.userRepository.findOne(currentUserId);

        photo.setUser(currentUser);
        this.photoRepository.save(photo);
    }

    @Transactional
    public void delete(Long id) {
        this.photoRepository.delete(id);
    }
}