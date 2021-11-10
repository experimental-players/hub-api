package Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JBody<T> {

	private Integer code;// 0 = success
	private String message;
	private Boolean show;
	private T body;

	public JBody(T body){
		this.code=Status.OK.code;
		this.message=Status.OK.target;
		this.body=body;

	}

	public JBody(Status status) {
		this.code=status.code;
		this.message=status.target;
	}

	public JBody(Integer code, String message, Boolean show) {
		this.code=code;
		this.message=message;
		this.show=show;
	}


	public JBody(Status status, T body) {
		this.code=status.code;
		this.message=status.target;
		this.body=body;
	}



}
