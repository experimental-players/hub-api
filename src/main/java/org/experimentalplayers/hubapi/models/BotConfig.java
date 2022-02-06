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
@Table(name = "bot_configs")
@IdClass(BotConfig.class)
public class BotConfig implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_server")
    private Long idServer;

    @Id
    @Column(name = "id_input")
    private Integer idInput;

    @Lob
    @Column(name = "id_content", columnDefinition = "BLOB")
    private byte[] content;

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        BotConfig that = (BotConfig) o;

        return Objects.equals(idServer, that.idServer);
    }

}
