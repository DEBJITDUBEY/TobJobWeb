package job.model;

import java.util.Date;

public class Jobseaker {
	private String name ;
	private String email ;
	private String password ;
	private Date Date_of_birth ;
	private String  gender ;
	private String Mobile_no ;
	private String gov_proof_id ;
	private String id_details  ;
	private String city ;
	private String state ;
	private String zip;
	private String country ;
	private String class_x_y_board ;
	private String class_x_year ;
	private String class_x_marks ;
	private String class_xii_board ;
	private String class_xii_year ;
	private String class_xii_mark ;
	private String graduate_uni ;
	private String graduate_colname ;
	private String graduate_year ;
	private String graduate_mark ;
	private String graduate_branch ;
	private String other_board ;
	private String other_name ;
	private String other_year ;
	private String other_marks ;
	private String other_salary ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_of_birth() {
		return Date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		Date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}
	public String getGov_proof_id() {
		return gov_proof_id;
	}
	public void setGov_proof_id(String gov_proof_id) {
		this.gov_proof_id = gov_proof_id;
	}
	public String getId_details() {
		return id_details;
	}
	public void setId_details(String id_details) {
		this.id_details = id_details;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getClass_x_y_board() {
		return class_x_y_board;
	}
	public void setClass_x_y_board(String class_x_y_board) {
		this.class_x_y_board = class_x_y_board;
	}
	public String getClass_x_year() {
		return class_x_year;
	}
	public void setClass_x_year(String class_x_year) {
		this.class_x_year = class_x_year;
	}
	public String getClass_x_marks() {
		return class_x_marks;
	}
	public void setClass_x_marks(String class_x_marks) {
		this.class_x_marks = class_x_marks;
	}
	public String getClass_xii_board() {
		return class_xii_board;
	}
	public void setClass_xii_board(String class_xii_board) {
		this.class_xii_board = class_xii_board;
	}
	public String getClass_xii_year() {
		return class_xii_year;
	}
	public void setClass_xii_year(String class_xii_year) {
		this.class_xii_year = class_xii_year;
	}
	public String getClass_xii_mark() {
		return class_xii_mark;
	}
	public void setClass_xii_mark(String class_xii_mark) {
		this.class_xii_mark = class_xii_mark;
	}
	public String getGraduate_uni() {
		return graduate_uni;
	}
	public void setGraduate_uni(String graduate_uni) {
		this.graduate_uni = graduate_uni;
	}
	public String getGraduate_colname() {
		return graduate_colname;
	}
	public void setGraduate_colname(String graduate_colname) {
		this.graduate_colname = graduate_colname;
	}
	public String getGraduate_year() {
		return graduate_year;
	}
	public void setGraduate_year(String graduate_year) {
		this.graduate_year = graduate_year;
	}
	public String getGraduate_mark() {
		return graduate_mark;
	}
	public void setGraduate_mark(String graduate_mark) {
		this.graduate_mark = graduate_mark;
	}
	public String getGraduate_branch() {
		return graduate_branch;
	}
	public void setGraduate_branch(String graduate_branch) {
		this.graduate_branch = graduate_branch;
	}
	public String getOther_board() {
		return other_board;
	}
	public void setOther_board(String other_board) {
		this.other_board = other_board;
	}
	public String getOther_name() {
		return other_name;
	}
	public void setOther_name(String other_name) {
		this.other_name = other_name;
	}
	public String getOther_year() {
		return other_year;
	}
	public void setOther_year(String other_year) {
		this.other_year = other_year;
	}
	public String getOther_marks() {
		return other_marks;
	}
	public void setOther_marks(String other_marks) {
		this.other_marks = other_marks;
	}
	public String getOther_salary() {
		return other_salary;
	}
	public void setOther_salary(String other_salary) {
		this.other_salary = other_salary;
	}
	public Jobseaker(String name, String email, String password, Date date_of_birth, String gender, String mobile_no,
			String gov_proof_id, String id_details, String city, String state, String zip, String country,
			String class_x_y_board, String class_x_year, String class_x_marks, String class_xii_board,
			String class_xii_year, String class_xii_mark, String graduate_uni, String graduate_colname,
			String graduate_year, String graduate_mark, String graduate_branch, String other_board, String other_name,
			String other_year, String other_marks, String other_salary) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		Date_of_birth = date_of_birth;
		this.gender = gender;
		Mobile_no = mobile_no;
		this.gov_proof_id = gov_proof_id;
		this.id_details = id_details;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.class_x_y_board = class_x_y_board;
		this.class_x_year = class_x_year;
		this.class_x_marks = class_x_marks;
		this.class_xii_board = class_xii_board;
		this.class_xii_year = class_xii_year;
		this.class_xii_mark = class_xii_mark;
		this.graduate_uni = graduate_uni;
		this.graduate_colname = graduate_colname;
		this.graduate_year = graduate_year;
		this.graduate_mark = graduate_mark;
		this.graduate_branch = graduate_branch;
		this.other_board = other_board;
		this.other_name = other_name;
		this.other_year = other_year;
		this.other_marks = other_marks;
		this.other_salary = other_salary;
	}
	public Jobseaker() {
		super();
		// TODO Auto-generated constructor stub
	}

}
