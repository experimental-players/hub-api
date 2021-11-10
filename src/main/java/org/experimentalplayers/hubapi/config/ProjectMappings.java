package org.experimentalplayers.hubapi.config;

import org.experimentalplayers.hubapi.controllers.ProjectController;
import org.experimentalplayers.hubapi.models.Project;

/**
 * Mappings for {@link ProjectController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class ProjectMappings {

    /**
     * The root location to access the {@link Project Project} API.
     *
     * @see ProjectController
     */
    public static final String ROOT = "/project";

    public static final String FIND_ALL = "/findAll";

    public static final String FIND_BY_NAME = "/find/{name}";

}
