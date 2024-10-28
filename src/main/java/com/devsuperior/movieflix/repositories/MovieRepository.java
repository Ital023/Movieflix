package com.devsuperior.movieflix.repositories;


import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query(value = "SELECT new com.devsuperior.movieflix.dto.MovieDTO(obj.id, obj.title, obj.subTitle, obj.year, obj.imgUrl) " +
            "FROM Movie obj ",
            countQuery = "SELECT COUNT(obj) FROM Movie obj"
    )
    Page<MovieDTO> searchMoviesWithoutGenres(Pageable pageable);

}
