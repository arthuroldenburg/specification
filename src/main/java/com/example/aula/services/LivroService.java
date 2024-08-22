package com.example.aula.services;

import com.example.aula.models.Livro;
import com.example.aula.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;

public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarLivros(Example<Livro> example){
        return livroRepository.findAll(example);
    }
}
