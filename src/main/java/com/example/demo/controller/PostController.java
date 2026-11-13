package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {


    private final PostService service;

   public PostController(PostService service){
       this.service = service;
   }

   @PostMapping
    public Post criarPost(@RequestParam UUID userId,
                          @RequestParam String content){
       return service.criarPost(content,userId);
   }


   @GetMapping
    public List<Post> listarPosts(){
       return service.listarPosts();

    //fim do projeto
   }
}
