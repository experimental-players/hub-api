package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "bots")
public class Bot {

	@Id
	@Column(name = "id_bot")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "page_content")
	private String pageContent;

	@Column(name = "project_url")
	private String projectUrl;

	@Column(name = "logo_url")
	private String logoUrl;

	@Column(name = "banner_url")
	private String bannerUrl;

	@Column(name = "color")
	private String color;

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Bot that = (Bot) o;

		return Objects.equals(id, that.id);
	}

}
