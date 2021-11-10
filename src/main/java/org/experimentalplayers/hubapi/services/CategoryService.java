package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.Category;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CategoryService {

    public Page<Category> findAll(Integer page,Integer limit);

    public Optional<Category> findByName(String name);

}
