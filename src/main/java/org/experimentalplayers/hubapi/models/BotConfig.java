package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;
import org.postgresql.largeobject.LargeObject;

import javax.persistence.*;
import java.math.BigInteger;
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
public class BotConfig {

    @Id
    @Column(name = "id_server")
    private Long idServer;

    @Column(name = "id_input")
    private UUID idInput;

    @Lob
    @Column(name = "id_content", columnDefinition = "BLOB")
    private byte[] idContent;

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
