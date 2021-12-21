package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Category;
import org.experimentalplayers.hubapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository catRepo;

    @Override
    public Page<Category> findAll(Integer page, Integer limit) {

		Pageable pageable = new PageUtil(limit,page);

		List<Category> categories = catRepo.findAll();

		return new PageImpl<>(categories, pageable, categories.size());
    }

    @Override
    public Category findByName(String name) {

    	log.info("Begin findByName(name)... ProjectServiceImpl");

		Optional<Category> optCat = catRepo.findAllByCodename(name);
        if(!optCat.isPresent())
            throw new NotFoundException();

		log.info("End findByName(name)... ProjectServiceImpl");
		return optCat.get();
    }

}
