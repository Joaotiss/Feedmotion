package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.RepositoryUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    public RepositoryUser repository;

    UserService(RepositoryUser repository){this.repository = repository;}

    public void registrar(User user){

        if (repository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado");
        }
            if (user.getEmail() == null || user.getEmail().isBlank()) {
                throw new IllegalArgumentException("Erro no Email");
            }
        repository.save(user);
        }

    public User login(String email, String password){
        User user = repository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException("usuario inexistente"));

        if (!user.getPassword().equals(password)){
            throw new IllegalArgumentException("senha incorreta");
        }
        return user;
    }

    public User atualizarBio(UUID id,String bio){
        User user = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Não encontrado"));
        user.setBio(bio);

        return repository.save(user);
    }

    public List<User> buscarPorNome(String name){
        return repository.findBynameContainingIgnoreCase(name);
    }
    public User buscarPorId(UUID id) {

        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
    }

