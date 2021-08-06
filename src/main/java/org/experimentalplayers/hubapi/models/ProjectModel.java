package org.experimentalplayers.hubapi.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "projects")
public class ProjectModel {

	@Id
	@Column(name = "id_proj")
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

	@Column(name = "url_github")
	private String urlGit;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_app")
	private ApplicationModel application;

}
