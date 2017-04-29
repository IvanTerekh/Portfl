package com.terekh.portfl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terekh.portfl.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>  {
	
}

