package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;


public class MovieDTO {

    private Long id;

    private String title;

    private String subTitle;

    private Integer year;

    private String imgUrl;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
    }

    public MovieDTO(Movie entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subTitle = entity.getSubTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
