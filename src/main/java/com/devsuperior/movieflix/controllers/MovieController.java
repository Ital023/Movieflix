package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieGenreDTO> getOneById(@PathVariable Long id) {
        MovieGenreDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }


    @GetMapping
    public ResponseEntity<Page<MovieDTO>> getPaged(Pageable pageable) {
        Page<MovieDTO> dto = service.getTest(pageable);
        return ResponseEntity.ok().body(dto);
    }


}
