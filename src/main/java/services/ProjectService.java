package services;

import org.experimentalplayers.hubapi.models.Project;
import org.springframework.data.domain.Page;

public interface ProjectService {

    public Page<Project> findAll(Integer page,Integer limit);

    public Project findByName(String name);

}
