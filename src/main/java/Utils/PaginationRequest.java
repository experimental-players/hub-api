package Utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class PaginationRequest {

    int limit;
    int offset;
    String orderBy;
    String direction = "ASC"; //ASC / DESC
}