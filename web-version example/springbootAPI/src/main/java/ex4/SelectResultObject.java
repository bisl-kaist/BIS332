package ex4;

public class SelectResultObject {
    private String NO;
    private String NAME;
    private String PHONE;

    public SelectResultObject(String NO, String NAME, String PHONE) {
        this.NO = NO;
	this.NAME = NAME;
	this.PHONE = PHONE;
    }

    public String getNO() {
	return NO;
    }

    public void set(String NO){
	this.NO = NO;
    }

    public String getNAME() {
	return NAME;
    }

    public void setNAME(String NAME){
	this.NAME = NAME;
    }

    public String getPHONE() {
	return PHONE;
    }

    public void setPHONE(String PHONE){
	this.PHONE = PHONE;
    }
}
