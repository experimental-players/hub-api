package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "applications")
public class ApplicationModel {

	@Id
	@Column(name = "id_app")
	private UUID id;

	@Column(name = "name_short")
	private String nameShort;

	@Column(name = "name_long")
	private String nameLong;

	@Column(name = "description")
	private String description;

	@Column(name = "url_logo")
	private String urlLogo;

	@Column(name = "url_bg")
	private String urlBg;

	@Column(name = "color")
	private String color;

	@JsonIgnore
	@OneToMany(mappedBy = "application")
	private Set<ProjectModel> projects;

}
