package Utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.experimentalplayers.hubapi.models.Project;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
public class Specifications {

    public static Sort orderingProperty(Project project){
        Sort properties = null;


        // In ogni caso ordino per cognome e nome
        if (properties == null) {
            properties = Sort.by("codename").and(Sort.by("fullname"));
        } else
            properties.and(Sort.by("codename").and(Sort.by("fullname")));

        return properties;
    }

}
