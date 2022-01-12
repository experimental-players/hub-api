package org.experimentalplayers.hubapi.config;


import org.experimentalplayers.hubapi.controllers.CategoryController;
import org.experimentalplayers.hubapi.models.Category;

/**
 * Mappings for {@link CategoryController},
 * listed in this class as constants for easy and detailed access.
 */
public abstract class CategoryMappings {

    /**
     * The root location to access the {@link Category Category} API.
     *
     * @see CategoryController
     */
    public static final String ROOT = "/category";

    public static final String FIND_ALL = "/findAll";

    public static final String FIND_BY_NAME = "/find/{name}";

    public static final String FIND_BY_ID = "/findById/{idCategory}";

}