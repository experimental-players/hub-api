package org.experimentalplayers.hubapi;

import org.experimentalplayers.hubapi.config.TestMockValues;
import org.experimentalplayers.hubapi.models.CategoryModel;
import org.experimentalplayers.hubapi.models.ProjectModel;
import org.experimentalplayers.hubapi.repositories.CategoryRepository;
import org.experimentalplayers.hubapi.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.experimentalplayers.hubapi.config.CategoryMappings.*;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class, MockitoExtension.class })
@SpringBootTest
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
class CategoryTests {

	@MockBean
	private CategoryRepository catRepo;

	@MockBean
	private ProjectRepository projRepo;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation))
				.build();

		TestMockValues mockValues = TestMockValues.create();
		Map<String, CategoryModel> mockCategories = mockValues.getCategories();
		Map<String, ProjectModel> mockProjects = mockValues.getProjects();

		when(catRepo.findAll()).thenReturn(mockCategories.values());
		when(projRepo.findAll()).thenReturn(mockProjects.values());

		when(catRepo.findByNameShort(anyString())).thenAnswer(invocation -> Optional.of(mockCategories.get(invocation.getArgument(
				0,
				String.class))));

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
				.andDo(document("category"));
	}

	@Test
	public void findByName() throws Exception {

		final String endpoint = ROOT + FIND_BY_NAME;

		mockMvc.perform(get(endpoint, "minecraft"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id",
						matchesPattern("[0-9a-f]{8}-[0-9a-f]{4}-[34][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")))
				.andDo(document("category",
						pathParameters(parameterWithName("name").description("The Category's codename")),
						responseFields(fieldWithPath("id").description("The Category's name")
										.type(JsonFieldType.STRING),
								fieldWithPath("nameShort").description(
												"The Category's codename. The codename is a short lower-kebab case name similar to the original one")
										.type(JsonFieldType.STRING),
								fieldWithPath("nameLong").description("The Category's original name")
										.type(JsonFieldType.STRING),
								fieldWithPath("description").description("The Category's description")
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
