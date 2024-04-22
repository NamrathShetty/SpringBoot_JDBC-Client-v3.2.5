package com.example.jdbcclientpractice.post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Optional<Post> findId(String id);

    void create(Post post);

    void update(Post post, String id);

    void delete(String id);
}