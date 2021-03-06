package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "bot_inputs")
@IdClass(BotInput.class)
public class BotInput implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_bot")
    private UUID idBot;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "id_input")
    private UUID idInput;

    @Column(name = "id_type")
    private Integer idType;

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        BotInput that = (BotInput) o;

        return Objects.equals(name, that.name);
    }

}
