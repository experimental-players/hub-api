package org.experimentalplayers.hubapi.config;

import org.experimentalplayers.hubapi.controllers.BotController;
import org.experimentalplayers.hubapi.models.Bot;

/**
 * Mappings for {@link BotController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class BotMappings {

	/**
	 * The root location to access the {@link Bot Category} API.
	 *
	 * @see BotController
	 */
	public static final String ROOT = "/category";

	public static final String FIND_ALL = "/findAll";

	public static final String FIND_BY_NAME = "/find/{name}";

}
