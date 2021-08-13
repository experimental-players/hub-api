package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
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
@Table(name = "categories")
public class CategoryModel {

	@Id
	@Column(name = "id_cat")
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
	@OneToMany(mappedBy = "category")
	@ToString.Exclude
	private Set<ProjectModel> projects;

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		CategoryModel that = (CategoryModel) o;

		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return 977141811;
	}

}
