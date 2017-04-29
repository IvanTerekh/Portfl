package com.terekh.portfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terekh.portfl.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>  {

//    Photo findByUrl(@Param("url") String url);
}
