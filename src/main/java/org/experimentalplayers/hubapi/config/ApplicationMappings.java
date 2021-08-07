package org.experimentalplayers.hubapi.config;

import org.experimentalplayers.hubapi.controllers.ApplicationController;
import org.experimentalplayers.hubapi.models.ApplicationModel;

/**
 * Mappings for {@link ApplicationController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class ApplicationMappings {

	/**
	 * The root location to access the {@link ApplicationModel Application} API.
	 *
	 * @see ApplicationController
	 */
	public static final String ROOT = "/application";

	public static final String FIND_ALL = "/findAll";

	public static final String FIND_BY_NAME = "/find/{name}";

}
