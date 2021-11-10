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
@Table(name = "input_types")
public class InputType {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_type")
	private UUID id;

	@Column(name = "description")
	private String description;

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		InputType that = (InputType) o;

		return Objects.equals(id, that.id);
	}

}
