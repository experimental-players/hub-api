package org.experimentalplayers.hubapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "projects")
public class Project {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id_proj")
    private UUID id;

    @Column(name = "codename")
    private String codename;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "description")
    private String description;

    @Column(name = "url_logo")
    private String urlLogo;

    @Column(name = "url_bg")
    private String urlBg;

    @Column(name = "url_github")
    private String urlGit;

    @Column(name = "color")
    private String color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cat")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Project that = (Project) o;

        return Objects.equals(id, that.id);
    }

}