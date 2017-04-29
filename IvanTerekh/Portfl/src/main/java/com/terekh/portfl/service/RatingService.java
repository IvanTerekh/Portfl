package com.terekh.portfl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terekh.portfl.model.Rating;
import com.terekh.portfl.model.User;
import com.terekh.portfl.repository.RatingRepository;
import com.terekh.portfl.repository.UserRepository;
import com.terekh.portfl.security.SecurityHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RatingService {

	private final UserRepository userRepository;
	private final RatingRepository ratingRepository;
	private final PhotoService photoService;

	public Rating findOne(Long ratingId) {
        return this.ratingRepository.findOne(ratingId);
    }
	
	public List<Rating> findAll() {
		return this.ratingRepository.findAll();
	}

	@Transactional
	public void create(Rating rating) {
        final Long currentUserId = SecurityHelper.getUserId();
        final User currentUser = this.userRepository.findOne(currentUserId);
        rating.setUser(currentUser);
		this.ratingRepository.save(rating);
	}

	@Transactional
	public void update(Rating rating) {
		Rating entity = this.ratingRepository.findOne(rating.getId());
		if (Objects.nonNull(entity)) {
			entity.setRating(rating.getRating());
			this.ratingRepository.save(entity);
		}
	}

	@Transactional
	public void delete(Long id) {
		this.ratingRepository.delete(id);
	}
}
