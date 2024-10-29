package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public MovieGenreDTO getById(Long id) {
        Movie entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));

        return new MovieGenreDTO(entity);
    }


    @Transactional(readOnly = true)
    public Page<MovieDTO> getPaged(String genreIdString, Pageable pageable) {
        Long genreId = Long.parseLong(genreIdString);

        if(genreId == 0) {
            return repository.searchMoviesWithoutGenres(pageable);

        }

        boolean idGenreExisting = genreRepository.existsById(genreId);
        if(!idGenreExisting) throw new ResourceNotFoundException("Resource not found");
        Page<Movie> result = repository.searchMoviesWithoutGenresById(genreId, pageable);
        return result.map(x -> new MovieDTO(x));
    }

}
