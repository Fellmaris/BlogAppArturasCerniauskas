package com.example.blogapparturascerniauskas.service;

import com.example.blogapparturascerniauskas.data.Blog;
import com.example.blogapparturascerniauskas.data.Comment;
import com.example.blogapparturascerniauskas.exception.BlogNotExistException;
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
        return blogRepository.findByOrderByCreationdateDesc(pageable);
    }

    public Blog getBlog (UUID id){
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotExistException(id));
    }

    public void deleteBlog (UUID id){
        blogRepository.deleteById(id);
    }

    public void updateBlog(Blog blog){
        blogRepository.save(blog);
    }


}
