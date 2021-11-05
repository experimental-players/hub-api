package org.experimentalplayers.hubapi.config;

import lombok.Getter;
import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.models.Bot.CategoryModelBuilder;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.models.InputType.ProjectModelBuilder;

import java.util.*;

@Getter
public class TestMockValues {

	public static final CategoryModelBuilder BUILDER_MINECRAFT = Bot.builder()
			.id(UUID.fromString("2805fc7e-c22f-413d-8d94-8c2929704712"))
			.name("minecraft")
			.fullname("Minecraft Plugins")
			.description("# Some Minecraft Plugins description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final CategoryModelBuilder BUILDER_DISCORD = Bot.builder()
			.id(UUID.fromString("b210049b-b9a3-4f07-acdd-48c0aeae8f57"))
			.codename("discord")
			.fullname("Discord Bots")
			.description("# Some Discord Bots description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.projects(new HashSet<>());

	public static final ProjectModelBuilder BUILDER_UHC = InputType.builder()
			.id(UUID.fromString("c892aeda-bd52-4fce-9209-06f536470342"))
			.codename("xkuhc")
			.fullname("xkUHC")
			.description("# Some UHC description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_DEATHSWAP = InputType.builder()
			.id(UUID.fromString("554af97c-19df-4072-963b-6c9bbd6d700b"))
			.codename("xkds")
			.fullname("xkDeathSwap")
			.description("# Some DeathSwap description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_VGREETER = InputType.builder()
			.id(UUID.fromString("81f100af-a95e-4e8d-946b-b1163807941b"))
			.codename("vgreeter")
			.fullname("VGreeter")
			.description("# Some Faina description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static final ProjectModelBuilder BUILDER_MINCHIABBOT = InputType.builder()
			.id(UUID.fromString("b94add28-6e45-4185-9ce4-42617cae25ff"))
			.codename("minchiabbot")
			.fullname("Minchiabbot")
			.description("# Some Minchiabbot description")
			.urlBg(null)
			.urlBg(null)
			.color(null)
			.category(null);

	public static TestMockValues create() {

		HashMap<String, Bot> mockCats = new HashMap<>();
		HashMap<String, InputType> mockProjs = new HashMap<>();

		Bot minecraft = BUILDER_MINECRAFT.build();
		Bot discord = BUILDER_DISCORD.build();
		InputType uhc = BUILDER_UHC.build();
		InputType deathswap = BUILDER_DEATHSWAP.build();
		InputType vgreeter = BUILDER_VGREETER.build();
		InputType minchiabbot = BUILDER_MINCHIABBOT.build();

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

	public static void bindCategory(Bot category, InputType... projects) {

		Set<InputType> set = category.getProjects();
		for(InputType project : projects) {

			project.setCategory(category);
			set.add(project);

		}

	}

	private final Map<String, Bot> categories;
	private final Map<String, InputType> projects;

	public TestMockValues(Map<String, Bot> categories, Map<String, InputType> projects) {

		this.categories = Collections.unmodifiableMap(categories);
		this.projects = Collections.unmodifiableMap(projects);

	}

}
