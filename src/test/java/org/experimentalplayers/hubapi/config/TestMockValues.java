package org.experimentalplayers.hubapi.config;

import lombok.Getter;
import org.experimentalplayers.hubapi.models.Project;
import org.experimentalplayers.hubapi.models.Project.ProjectBuilder;
import org.experimentalplayers.hubapi.models.Category;
import org.experimentalplayers.hubapi.models.Category.CategoryBuilder;

import java.util.*;

@Getter
public class TestMockValues {

	public static final CategoryBuilder BUILDER_MINECRAFT = Category.builder()
			.id(UUID.fromString("2805fc7e-c22f-413d-8d94-8c2929704712"))
			.codename("minecraft")
			.fullname("Minecraft Plugins")
			.description("# Some Minecraft Plugins description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final CategoryBuilder BUILDER_DISCORD = Category.builder()
			.id(UUID.fromString("b210049b-b9a3-4f07-acdd-48c0aeae8f57"))
			.codename("discord")
			.fullname("Discord Bots")
			.description("# Some Discord Bots description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final ProjectBuilder BUILDER_UHC = Project.builder()
			.id(UUID.fromString("c892aeda-bd52-4fce-9209-06f536470342"))
			.codename("xkuhc")
			.fullname("xkUHC")
			.description("# Some UHC description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectBuilder BUILDER_DEATHSWAP = Project.builder()
			.id(UUID.fromString("554af97c-19df-4072-963b-6c9bbd6d700b"))
			.codename("xkds")
			.fullname("xkDeathSwap")
			.description("# Some DeathSwap description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectBuilder BUILDER_VGREETER = Project.builder()
			.id(UUID.fromString("81f100af-a95e-4e8d-946b-b1163807941b"))
			.codename("vgreeter")
			.fullname("VGreeter")
			.description("# Some Faina description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectBuilder BUILDER_MINCHIABBOT = Project.builder()
			.id(UUID.fromString("b94add28-6e45-4185-9ce4-42617cae25ff"))
			.codename("minchiabbot")
			.fullname("Minchiabbot")
			.description("# Some Minchiabbot description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static TestMockValues create() {

		HashMap<String, Category> mockCats = new HashMap<>();
		HashMap<String, Project> mockProjs = new HashMap<>();

		Category minecraft = BUILDER_MINECRAFT.build();
		Category discord = BUILDER_DISCORD.build();
		Project uhc = BUILDER_UHC.build();
		Project deathswap = BUILDER_DEATHSWAP.build();
		Project vgreeter = BUILDER_VGREETER.build();
		Project minchiabbot = BUILDER_MINCHIABBOT.build();

		bindCategory(minecraft, uhc, deathswap);
		bindCategory(discord, vgreeter, minchiabbot);

		mockCats.put(minecraft.getCodename(), minecraft);
		mockCats.put(discord.getCodename(), discord);
		mockProjs.put(uhc.getCodename(), uhc);
		mockProjs.put(deathswap.getCodename(), deathswap);
		mockProjs.put(vgreeter.getCodename(), vgreeter);
		mockProjs.put(minchiabbot.getCodename(), minchiabbot);

		return new TestMockValues(mockCats, mockProjs);

	}

	public static void bindCategory(Category category, Project... projects) {

		Set<Project> set = category.getProjects();
		for(Project project : projects) {

			project.setCategory(category);
			set.add(project);

		}

	}

	private final Map<String, Category> categories;
	private final Map<String, Project> projects;

	public TestMockValues(Map<String, Category> categoryMap, Map<String, Project> projectMap) {

		this.categories = Collections.unmodifiableMap(categoryMap);
		this.projects = Collections.unmodifiableMap(projectMap);

	}

}
