package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

import java.io.Serializable;

public class GenreDTO implements Serializable {
    private Long id;
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
