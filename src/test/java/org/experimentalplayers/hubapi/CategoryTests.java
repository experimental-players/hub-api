package org.experimentalplayers.hubapi;

import org.experimentalplayers.hubapi.config.CommonDescriptors;
import org.experimentalplayers.hubapi.config.TestMockValues;
import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.models.Category;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.models.Project;
import org.experimentalplayers.hubapi.repositories.BotRepository;
import org.experimentalplayers.hubapi.repositories.CategoryRepository;
import org.experimentalplayers.hubapi.repositories.InputTypeRepository;
import org.experimentalplayers.hubapi.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

import static org.experimentalplayers.hubapi.config.BotMappings.*;
import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
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
@Disabled("Disabled tests until rework")
class CategoryTests {

	// TODO: TEST PAGEABLE

	@MockBean
	private CategoryRepository catRepo;

	@MockBean
	private ProjectRepository projRepo;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {

		mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation)
						.operationPreprocessors()
						.withResponseDefaults(prettyPrint()))
				.build();

		TestMockValues mockValues = TestMockValues.create();
		Map<String, Category> mockCategories = mockValues.getCategories();
		Map<String, Project> mockProjects = mockValues.getProjects();

		when(catRepo.findAll()).thenReturn((List<Category>) mockCategories.values());
//		when(projRepo.findAll()).thenReturn((List<Project>) mockProjects.values());

		when(catRepo.findAllByCodename(anyString())).thenAnswer(invocation -> Optional.of(mockCategories.get(invocation.getArgument(
				0,
				String.class))));

	}

	@Test
	public void findAllCategories() throws Exception {

		final String endpoint = ROOT + FIND_ALL;

		mockMvc
				.perform(get(endpoint))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(document("find-all-categories",
						responseFields(fieldWithPath("page")
										.description("Number of page")
										.type(JsonFieldType.NUMBER),
								fieldWithPath("limit")
										.description("Max items in a page")
										.type(JsonFieldType.NUMBER),
								fieldWithPath("maxPage")
										.description("Max pages")
										.type(JsonFieldType.NUMBER)
										// TODO: IMPLEMENT PAGES COUNT
										.optional(),
								fieldWithPath("result")
										.description("Fetched items")
										.type(JsonFieldType.ARRAY))
								// COMMENT TO KEEP INDENT BC INTELLIJ'S CODE FORMATTER IS BROKEN
								.andWithPrefix("result[].", CommonDescriptors.CATEGORY_FIELDS)));
	}

	@Test
	public void findCategoryByCodename() throws Exception {

		final String endpoint = ROOT + FIND_BY_NAME;

		mockMvc
				.perform(get(endpoint, "minecraft"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id",
						matchesPattern("[0-9a-f]{8}-[0-9a-f]{4}-[34][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")))
				.andDo(document("find-category-by-codename",
						pathParameters(parameterWithName("name").description("Category's codename")),
						responseFields(CommonDescriptors.CATEGORY_FIELDS)));

	}

}
