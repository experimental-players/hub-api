package org.experimentalplayers.hubapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.experimentalplayers.hubapi.config.ApplicationMappings.*;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest
class ApplicationTests {

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation))
				.build();

	}

	@Test
	void contextLoads() {
	}

	@Test
	public void findAll() throws Exception {

		final String endpoint = ROOT + FIND_ALL;

		mockMvc.perform(get(endpoint))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", isA(List.class)))
				.andDo(document("application"));
	}

	@Test
	public void findByName() throws Exception {

		final String endpoint = ROOT + FIND_BY_NAME;

		mockMvc.perform(get(endpoint, "minecraft"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id",
						matchesPattern("[0-9a-f]{8}-[0-9a-f]{4}-[34][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")))
				.andDo(document("application",
						pathParameters(parameterWithName("name").description("The Application's codename")),
						responseFields(fieldWithPath("id").description("The Application's name")
										.type(JsonFieldType.STRING),
								fieldWithPath("nameShort").description(
												"The Application's codename. The codename is a short lower-kebab case name similar to the original one")
										.type(JsonFieldType.STRING),
								fieldWithPath("nameLong").description("The Application's original name")
										.type(JsonFieldType.STRING),
								fieldWithPath("description").description("The Application's description")
										.type(JsonFieldType.STRING),
								fieldWithPath("urlLogo").description("A URL to an eventual application icon")
										.type(JsonFieldType.STRING)
										.optional(),
								fieldWithPath("urlBg").description("A URL to an eventual background image")
										.type(JsonFieldType.STRING)
										.optional(),
								fieldWithPath("color").description(
												"An eventual hex-code for a color matching the Application's theme")
										.type(JsonFieldType.STRING)
										.optional())));

	}

}
