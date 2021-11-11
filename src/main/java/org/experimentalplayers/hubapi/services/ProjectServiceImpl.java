package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Project;
import org.experimentalplayers.hubapi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projRepo;

    @Override
    public Page<Project> findAll(Integer page, Integer limit) {

		log.info("Begin findAll()... ProjectServiceImpl");


		Pageable pageable = new PageUtil(limit,page);

        List<Project> projects = projRepo.findAll();
		Page<Project> pageProject = new PageImpl<Project>(projects, pageable, projects.size());

		log.info("End findAll()... ProjectServiceImpl");
		return pageProject;
    }

    @Override
    public Project findByName(String name) {

		log.info("Begin findByName(name)... ProjectServiceImpl");

		Optional<Project> optProj = projRepo.findAllByCodename(name);
		if(!optProj.isPresent())
			throw new NotFoundException();

		log.info("End findByName(name)... ProjectServiceImpl");
		return optProj.get();
    }

}
