package job.model;

public class Schemes {
	private String schemeid;
	private String schemename;
	private int duration;
	private String descrips;
	private int fee;
	public String getSchemeid() {
		return schemeid;
	}
	public void setSchemeid(String schemeid) {
		this.schemeid = schemeid;
	}
	public String getSchemename() {
		return schemename;
	}
	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescrips() {
		return descrips;
	}
	public void setDescrips(String descrips) {
		this.descrips = descrips;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Schemes(String schemeid, String schemename, int duration, String descrips, int fee) {
		super();
		this.schemeid = schemeid;
		this.schemename = schemename;
		this.duration = duration;
		this.descrips = descrips;
		this.fee = fee;
	}
	public Schemes() {
		super();
	}


}
