package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class MovieGenreDTO extends MovieDTO{

    private String synopsis;

    private GenreDTO genre;


    public MovieGenreDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, GenreDTO genre) {
        super(id, title, subTitle, year, imgUrl);
        this.synopsis = synopsis;
        this.genre = genre;
    }

    public MovieGenreDTO(Long id, String title, String subTitle, Integer year, String imgUrl, GenreDTO genre) {
        super(id, title, subTitle, year, imgUrl);
        this.genre = genre;
    }

    public MovieGenreDTO(Movie entity, String synopsis, GenreDTO genre) {
        super(entity);
        this.synopsis = synopsis;
        this.genre = genre;
    }

    public MovieGenreDTO(Movie entity) {
        super(
                entity.getId(),
                entity.getTitle(),
                entity.getSubTitle(),
                entity.getYear(),
                entity.getImgUrl()
        );
        this.synopsis = entity.getSynopsis();
        this.genre = new GenreDTO(entity.getGenre().getId(), entity.getGenre().getName());
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
