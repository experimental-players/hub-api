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

		Pageable pageable = new PageUtil(page,limit);

		List<Category> categories = catRepo.findAll();
		Page<Category> categoryPage = new PageImpl<Category>(categories, pageable, categories.size());

        return categoryPage;
    }

    @Override
    public Optional<Category> findByName(String name) {

    	log.info("Begin findByName(name)... ProjectServiceImpl");

		Optional<Category> optCat = catRepo.findAllByCodename(name);

		log.info("End findByName(name)... ProjectServiceImpl");
		return optCat;
    }

}
