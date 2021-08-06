package org.experimentalplayers.hubapi.config;

/**
 * Mappings for {@link org.experimentalplayers.hubapi.controllers.ProjectController ProjectController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class ProjectMappings {

	/**
	 * The root location to access the {@link org.experimentalplayers.hubapi.models.ProjectModel Project} API.
	 *
	 * @see org.experimentalplayers.hubapi.controllers.ProjectController ProjectController
	 */
	public static final String ROOT = "/project";

	public static final String FIND_ALL = "/findAll";

	public static final String FIND_BY_NAME = "/find/{name}";

}
