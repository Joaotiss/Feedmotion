package com.example.demo.service;

import com.example.demo.model.Post;

import com.example.demo.model.User;
import com.example.demo.repository.RepositoryPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    public RepositoryPost repository;
    public UserService userService;

    PostService(RepositoryPost repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Post criarPost(String content, UUID userId) {
        User user = userService.buscarPorId(userId);

        Post post = new Post();
        post.setcontent(content);
        post.setUser(user);

        return repository.save(post);


    }

    public List<Post> listarPosts(){
    return repository.findAll();
    }


}
