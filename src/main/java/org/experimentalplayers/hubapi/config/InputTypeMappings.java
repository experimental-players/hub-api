package org.experimentalplayers.hubapi.config;

import org.experimentalplayers.hubapi.controllers.InputTypeController;
import org.experimentalplayers.hubapi.models.InputType;

/**
 * Mappings for {@link InputTypeController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class InputTypeMappings {

	/**
	 * The root location to access the {@link InputType Project} API.
	 *
	 * @see InputTypeController
	 */
	public static final String ROOT = "/inputType";

	public static final String FIND_ALL = "/findAll";

	public static final String FIND_BY_DESCRIPTION = "/find/{description}";

}
