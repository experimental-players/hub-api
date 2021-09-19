package org.experimentalplayers.hubapi.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(Include.NON_NULL)
public class CollectionResponse {

	private String error;

	private Integer page;

	private Integer maxPage;

	private Integer limit;

	@Singular("result")
	private Collection<?> result;

}
