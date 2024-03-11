package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Transactional(readOnly = true)
    public Page<GenreDTO> findAllPage(Pageable pageable) {
        Page<Genre> page = repository.findAll(pageable);
        return page.map(GenreDTO::new);
    }

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> list = repository.findAll();
        return list.stream().map(GenreDTO::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public GenreDTO findById(Long id) {
        Optional<Genre> obj = repository.findById(id);
        Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GenreDTO(entity);
    }
}
