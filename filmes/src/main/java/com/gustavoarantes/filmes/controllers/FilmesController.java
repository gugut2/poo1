package com.gustavoarantes.filmes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gustavoarantes.filmes.dtos.FilmeDto;
import com.gustavoarantes.filmes.models.FilmeModel;
import com.gustavoarantes.filmes.repositories.FilmeRepository;

import jakarta.validation.Valid;

@RestController
public class FilmesController {
    
    @Autowired
    FilmeRepository filmeRepository;

    @GetMapping("/filmes")
    public ResponseEntity<List<FilmeModel>> listar(){
        List<FilmeModel> filmeList = filmeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(filmeList);
    }

    @PostMapping("/filmes")
    public ResponseEntity<FilmeModel> salvar(@RequestBody @Valid FilmeDto filmeDto){
        var FilmeModel = new FilmeModel();
        BeanUtils.copyProperties(filmeDto, FilmeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeRepository.save(FilmeModel));
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
        Optional<FilmeModel> filme = filmeRepository.findById(id);
        if(filme.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(filme.get());
    }

    @PutMapping("/filmes/{id}")
    public ResponseEntity<Object> atualizarFilme(@PathVariable(value = "id") Integer id,
                                                            @RequestBody @Valid FilmeDto filmeDto){
        Optional<FilmeModel> filme = filmeRepository.findById(id);
        if(filme.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
        BeanUtils.copyProperties(filmeDto, filme.get());
        return ResponseEntity.status(HttpStatus.OK).body(filmeRepository.save(filme.get()));
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Integer id){
        Optional<FilmeModel> filme = filmeRepository.findById(id);
        if(filme.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado");
        }
        filmeRepository.delete(filme.get());
        return ResponseEntity.status(HttpStatus.OK).body("O filme foi excluído");
    }
}

