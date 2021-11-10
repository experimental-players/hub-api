package services;

import Utils.PageUtil;
import Utils.Specifications;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.models.Project;
import org.experimentalplayers.hubapi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projRepo;

    @Override
    public Page<Project> findAll(Integer page, Integer limit) {

        Iterable<Project> projects = projects = projRepo.findAll();
        List<Project> list = new ArrayList<Project>();
        while (projects.iterator().hasNext()) {
            list.add(projects.iterator().next());
        }
        Project project = new Project();
        Page<Project> pageProj = new PageImpl<Project>(
                list,
                new PageUtil(limit, page),
                list.size());

        return pageProj;
    }

    @Override
    public Project findByName(String name) {
        return null;
    }

}
