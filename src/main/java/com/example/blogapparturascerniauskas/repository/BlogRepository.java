package com.example.blogapparturascerniauskas.repository;

import com.example.blogapparturascerniauskas.data.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BlogRepository extends JpaRepository<Blog, UUID> {

}
