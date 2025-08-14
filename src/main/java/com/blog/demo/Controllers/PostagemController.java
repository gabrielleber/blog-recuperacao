package com.blog.demo.Controllers;

import com.blog.demo.Entities.Postagem;
import com.blog.demo.Repositories.PostagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")

public class PostagemController {

    public PostagemRepository postagemRepository;

    public PostagemController(PostagemRepository postagemRepository){
        this.postagemRepository = postagemRepository;
    }

    @PostMapping

    public Postagem criarPostagem(@RequestBody Postagem postagem){
        this.postagemRepository.save(postagem);
        return postagem;
    }

    @GetMapping

    public List<Postagem> listar(){
        return this.postagemRepository.findAll();
    }

    @GetMapping
    public List<Postagem> exibirDetalhes(){
        return this.postagemRepository.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Postagem ListarPostagemUsuario(@PathVariable Integer idUsuario){
        return this.postagemRepository.findById(idUsuario).get();
    }

}
