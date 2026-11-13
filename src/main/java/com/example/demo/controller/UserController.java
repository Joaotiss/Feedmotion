package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService service;


    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/registrar")
    public void registrar(@RequestParam User user){
        service.registrar(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam User user){
        return service.login(user.getEmail(), user.getPassword());
    }

    @PutMapping("/{id}/bio")
    public User atualizarBio(@PathVariable UUID id,
                             @RequestBody String bio){
        return service.atualizarBio(id,bio);

    }

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable UUID id){
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<User> buscarPorNome(@RequestParam String name){
        return service.buscarPorNome(name);
    }

}
