package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {

	Page<Category> findAll(Integer page, Integer limit);

	Category findByName(String name);

}
