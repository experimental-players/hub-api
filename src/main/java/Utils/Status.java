package Utils;


public enum Status {

	/*OK*/
	OK(0, "OK"),
	/*ERROR*/
	NOT_FOUND(-1,"NOT FOUND");

	public final int code;
	public final String target;

	Status(int code, String target){
		this.code = code;
		this.target = target;
	}

	public int getCode(){return code;}

	public String getTarget(){return target;}

}
