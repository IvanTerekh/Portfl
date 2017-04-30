package com.terekh.portfl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terekh.portfl.model.Photo;
import com.terekh.portfl.model.Rating;
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

    public Photo findOne(Long photoId) {
        return this.photoRepository.findOne(photoId);
    }

    public List<Photo> findAll() {
        return this.photoRepository.findAll();
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
    
    @Transactional
    public void updateAverageRating(Photo photo){
    	Photo entity = this.photoRepository.findOne(photo.getId());
    	List<Rating> ratings = entity.getRatings();
    	entity.setMeanRating(this.countMeanRating(ratings));
    }
    
    private Float countMeanRating(List<Rating> ratings){
    	if (ratings.size() == 0){
    		return 0f;
    	}
    	int sumOfRatings = countSumOfRatings(ratings);
    	return ((float) sumOfRatings) / ratings.size();
    }
    
    private int countSumOfRatings(List<Rating> ratings){
    	int sumOfRatings = 0;
    	for(Rating rating : ratings){
    		sumOfRatings += rating.getRating();
    	}
    	return sumOfRatings;
    }
}