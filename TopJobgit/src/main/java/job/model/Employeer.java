package job.model;

public class Employeer {
	private String email;
	
	private String pwd;
	
	private String mobile;
	private String Registername;
	private      String Companyname;
	private String industryname;
	private String designation;
	private String type;
	private String GSTNO;

	private String officeAdrress;
	private String city;
	private String pin;
	private String country;
	private String officenumber;
	private String govid;
	private String empid;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRegistername() {
		return Registername;
	}
	public void setRegistername(String registername) {
		Registername = registername;
	}
	public String getCompanyname() {
		return Companyname;
	}
	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}
	public String getIndustryname() {
		return industryname;
	}
	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGSTNO() {
		return GSTNO;
	}
	public void setGSTNO(String gSTNO) {
		GSTNO = gSTNO;
	}
	public String getOfficeAdrress() {
		return officeAdrress;
	}
	public void setOfficeAdrress(String officeAdrress) {
		this.officeAdrress = officeAdrress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOfficenumber() {
		return officenumber;
	}
	public void setOfficenumber(String officenumber) {
		this.officenumber = officenumber;
	}
	public String getGovid() {
		return govid;
	}
	public void setGovid(String govid) {
		this.govid = govid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public Employeer(String email, String pwd, String mobile, String registername, String companyname,
			String industryname, String designation, String type, String gSTNO, String officeAdrress, String city,
			String pin, String country, String officenumber, String govid, String empid) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.mobile = mobile;
		Registername = registername;
		Companyname = companyname;
		this.industryname = industryname;
		this.designation = designation;
		this.type = type;
		this.GSTNO = gSTNO;
		this.officeAdrress = officeAdrress;
		this.city = city;
		this.pin = pin;
		this.country = country;
		this.officenumber = officenumber;
		this.govid = govid;
		this.empid = empid;
	}
	public Employeer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
