package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class BotInput {

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
    private UUID idType;

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
