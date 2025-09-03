package com.sahil.SecurityApp.SecurityApplication.repository;


import com.sahil.SecurityApp.SecurityApplication.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
