package org.experimentalplayers.hubapi.config;

import lombok.Getter;
import org.experimentalplayers.hubapi.models.CategoryModel;
import org.experimentalplayers.hubapi.models.CategoryModel.CategoryModelBuilder;
import org.experimentalplayers.hubapi.models.ProjectModel;
import org.experimentalplayers.hubapi.models.ProjectModel.ProjectModelBuilder;

import java.util.*;

@Getter
public class TestMockValues {

	public static final CategoryModelBuilder BUILDER_MINECRAFT = CategoryModel.builder()
			.id(UUID.fromString("2805fc7e-c22f-413d-8d94-8c2929704712"))
			.nameShort("minecraft")
			.nameLong("Minecraft Plugins")
			.description("# Some Minecraft Plugins description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final CategoryModelBuilder BUILDER_DISCORD = CategoryModel.builder()
			.id(UUID.fromString("b210049b-b9a3-4f07-acdd-48c0aeae8f57"))
			.nameShort("discord")
			.nameLong("Discord Bots")
			.description("# Some Discord Bots description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final ProjectModelBuilder BUILDER_UHC = ProjectModel.builder()
			.id(UUID.fromString("c892aeda-bd52-4fce-9209-06f536470342"))
			.nameShort("xkuhc")
			.nameLong("xkUHC")
			.description("# Some UHC description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_DEATHSWAP = ProjectModel.builder()
			.id(UUID.fromString("554af97c-19df-4072-963b-6c9bbd6d700b"))
			.nameShort("xkds")
			.nameLong("xkDeathSwap")
			.description("# Some DeathSwap description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_VGREETER = ProjectModel.builder()
			.id(UUID.fromString("81f100af-a95e-4e8d-946b-b1163807941b"))
			.nameShort("vgreeter")
			.nameLong("VGreeter")
			.description("# Some Faina description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_MINCHIABBOT = ProjectModel.builder()
			.id(UUID.fromString("b94add28-6e45-4185-9ce4-42617cae25ff"))
			.nameShort("minchiabbot")
			.nameLong("Minchiabbot")
			.description("# Some Minchiabbot description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static TestMockValues create() {

		HashMap<String, CategoryModel> mockCats = new HashMap<>();
		HashMap<String, ProjectModel> mockProjs = new HashMap<>();

		CategoryModel minecraft = BUILDER_MINECRAFT.build();
		CategoryModel discord = BUILDER_DISCORD.build();
		ProjectModel uhc = BUILDER_UHC.build();
		ProjectModel deathswap = BUILDER_DEATHSWAP.build();
		ProjectModel vgreeter = BUILDER_VGREETER.build();
		ProjectModel minchiabbot = BUILDER_MINCHIABBOT.build();

		bindCategory(minecraft, uhc, deathswap);
		bindCategory(discord, vgreeter, minchiabbot);

		mockCats.put(minecraft.getNameShort(), minecraft);
		mockCats.put(discord.getNameShort(), discord);
		mockProjs.put(uhc.getNameShort(), uhc);
		mockProjs.put(deathswap.getNameShort(), deathswap);
		mockProjs.put(vgreeter.getNameShort(), vgreeter);
		mockProjs.put(minchiabbot.getNameShort(), minchiabbot);

		return new TestMockValues(mockCats, mockProjs);

	}

	public static void bindCategory(CategoryModel category, ProjectModel... projects) {

		Set<ProjectModel> set = category.getProjects();
		for(ProjectModel project : projects) {

			project.setCategory(category);
			set.add(project);

		}

	}

	private final Map<String, CategoryModel> categories;
	private final Map<String, ProjectModel> projects;

	public TestMockValues(Map<String, CategoryModel> categories, Map<String, ProjectModel> projects) {

		this.categories = Collections.unmodifiableMap(categories);
		this.projects = Collections.unmodifiableMap(projects);

	}

}
