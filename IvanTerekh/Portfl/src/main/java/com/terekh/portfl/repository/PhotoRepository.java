package com.terekh.portfl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terekh.portfl.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>  {
	
	List<Photo> findByUserId(Long userId);
	
}
