package com.example.blogapparturascerniauskas.service;

import com.example.blogapparturascerniauskas.data.Blog;
import com.example.blogapparturascerniauskas.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Page<Blog> getBlogs (Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public void deleteBlog (UUID id){
        blogRepository.deleteById(id);
    }
}
