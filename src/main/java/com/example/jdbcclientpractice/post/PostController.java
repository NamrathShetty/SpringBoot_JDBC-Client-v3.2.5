package com.example.jdbcclientpractice.post;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    private final PostService postService;

    public PostController(JdbcTemplatePostService postService){
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> findAll(){
        return postService.findAll();
    }

    Optional<Post> findByID(@PathVariable String id){
        return postService.findId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody Post post){
        postService.create(post);
    }

    @PutMapping("/{id}")
    void update(@RequestBody Post post, @PathVariable String id){
        postService.update(post, id);
    }

    void delete(@PathVariable String id){
        postService.delete(id);
    }
}
