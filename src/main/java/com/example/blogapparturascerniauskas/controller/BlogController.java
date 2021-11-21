package com.example.blogapparturascerniauskas.controller;

import com.example.blogapparturascerniauskas.data.Blog;
import com.example.blogapparturascerniauskas.service.BlogService;
import com.example.blogapparturascerniauskas.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;
    private final MessageService messageService;

    public BlogController(BlogService blogService, MessageService messageService) {
        this.blogService = blogService;
        this.messageService = messageService;
    }

@GetMapping
    public String loadBlogs (Model model, Pageable pageable){
        model.addAttribute("pageOfBlogs", blogService.getBlogs(pageable));
        return "blogs";
}

@GetMapping ("/create")
    public String createNewBlog(Model model){
    model.addAttribute("blog", new Blog());
        return "newBlog";
}
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable UUID id) {
        blogService.deleteBlog(id);

        return "redirect:/blogs";
    }
}
