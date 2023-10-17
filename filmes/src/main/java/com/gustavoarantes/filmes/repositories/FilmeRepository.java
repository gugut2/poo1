package com.gustavoarantes.filmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gustavoarantes.filmes.models.FilmeModel;

public interface FilmeRepository extends JpaRepository<FilmeModel, Integer>{


}