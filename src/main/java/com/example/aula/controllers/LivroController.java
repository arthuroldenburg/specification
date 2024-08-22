//package com.example.aula.controllers;
//
//import com.example.aula.models.Livro;
//import com.example.aula.services.LivroService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@RestController
////@RequestMapping("/livros")
//public class LivroController {
//
//    @Autowired
//    private LivroService livroService;
//
//    @GetMapping
//    public ResponseEntity<List<Livro>> getLivros(
//            @RequestParam(value = "titulo", required = false) String titulo,
//            @RequestParam(value = "autor", required = false) String autor,
////            @RequestParam(value = "preco_gt", required = false)BigDecimal preco_gt,
//            @RequestParam(value = "categoria", required = false) String categoria
//            ){
//        Livro livro = new Livro();
//        livro.setTitulo(titulo);
//        livro.setCategoria(categoria);
//        livro.setAutor(autor);
////        livro.setPreco(preco);
//
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//
////        if (preco_gt != null) {
////            matcher.withMatcher("preco", match -> match.g)
////        }
//
//        Example<Livro> example = Example.of(livro, matcher);
//        return ResponseEntity.ok(livroService.buscarLivros(example));
//    }
//}
