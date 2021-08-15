package org.experimentalplayers.hubapi.config;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

public class CommonDescriptors {

	public static final FieldDescriptor[] CATEGORY_FIELDS = new FieldDescriptor[7];

	static {

		// DOING THIS BECAUSE INTELLIJ'S CODE FORMATTER IS BROKEN
		// (CHAINED METHODS INSIDE ARRAY INITIALIZATION)

		CATEGORY_FIELDS[0] = fieldWithPath("id")
				.description("Category's UUID")
				.type(JsonFieldType.STRING);
		CATEGORY_FIELDS[1] = fieldWithPath("codename")
				.description("Category's codename, a short lower-kebab-case name similar to the fullname")
				.type(JsonFieldType.STRING);
		CATEGORY_FIELDS[2] = fieldWithPath("fullname")
				.description("Category's full name")
				.type(JsonFieldType.STRING);
		CATEGORY_FIELDS[3] = fieldWithPath("description")
				.description("Category's description")
				.type(JsonFieldType.STRING);
		CATEGORY_FIELDS[4] = fieldWithPath("urlLogo")
				.description("A URL to an eventual category's icon")
				.type(JsonFieldType.STRING)
				.optional();
		CATEGORY_FIELDS[5] = fieldWithPath("urlBg")
				.description("A URL to an eventual background image")
				.type(JsonFieldType.STRING)
				.optional();
		CATEGORY_FIELDS[6] = fieldWithPath("color")
				.description("An eventual hex-code of a color matching the category's theme")
				.type(JsonFieldType.STRING)
				.optional();

	}

}
