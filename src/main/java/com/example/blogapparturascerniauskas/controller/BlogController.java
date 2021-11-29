package com.example.blogapparturascerniauskas.controller;

import com.example.blogapparturascerniauskas.data.Blog;
import com.example.blogapparturascerniauskas.data.Comment;
import com.example.blogapparturascerniauskas.service.BlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/public/blogs")
    public String loadBlogs (Model model, Pageable pageable){

        model.addAttribute("pageOfBlogs", blogService.getBlogs(pageable));
        model.addAttribute("newComment", new Comment());

        return "blogs";
}

    @PostMapping("/public/blogs")
    public String saveComment (@RequestParam (name = "id") UUID id, @Valid Comment comment){
        Blog blog = blogService.getBlog(id);
        comment.setBlog(blog);
        blog.addComment(comment);
        blogService.updateBlog(blog);
        return "redirect:/public/blogs";
    }

    @GetMapping ("/private/blogs/create")
    public String createNewBlog(Model model){
    model.addAttribute("blog", new Blog());
        return "newBlog";
}

    @PostMapping("/private/blogs/create")
    public String createBlog(@Valid Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/private/blogs/create";
    }

    @GetMapping("/private/blogs/{id}/delete")
    public String deleteBlog(@PathVariable UUID id) {
        blogService.deleteBlog(id);

        return "redirect:/public/blogs";
    }

    @GetMapping("/private/blogs/update")
    public String loadUpdateForm(@RequestParam UUID id, Model model){
        model.addAttribute("blog", blogService.getBlog(id));

        return "newBlog";
    }

    @PostMapping("/private/blogs/update")
    public String updateBlog (Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/public/blogs";
    }
}
