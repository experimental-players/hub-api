package org.experimentalplayers.hubapi.config;

/**
 * Mappings for {@link org.experimentalplayers.hubapi.controllers.ApplicationController ApplicationController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class ApplicationMappings {

	/**
	 * The root location to access the {@link org.experimentalplayers.hubapi.models.ApplicationModel Application} API.
	 *
	 * @see org.experimentalplayers.hubapi.controllers.ApplicationController ApplicationController
	 */
	public static final String ROOT = "/application";

	public static final String FIND_ALL = "/findAll";

	public static final String FIND_BY_NAME = "/find/{name}";

}
