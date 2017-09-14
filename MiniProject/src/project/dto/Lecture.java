package project.dto;

import java.util.Date;

/** 강좌 정보 입력받기 위한 클래스 */
public class Lecture {

	/* 변수 */
	private int lectureNum;
	private String lectureName;
	private String lectureTeacher;
	private Date lectureStartDate;
	private Date lectureEndDate;
	private Date lectureStartTime;
	private Date lectureEndTime;
	private String lectureContent;
	private String LectureStudent;
	private	String lectureDay;
	private int lectureMaxNum;
	private int lecturePrice;
	private String lectureAddress;
	private String lectureCompany;
	private Date lectureReceiptStart;
	private Date lectureReceiptEnd;
	private String lectureReceiptMethod;
	
	/* 접근자,수정자 */
	public int getLectureNum() {
		return lectureNum;
	}


	public void setLectureNum(int lectureNum) {
		this.lectureNum = lectureNum;
	}


	public String getLectureName() {
		return lectureName;
	}


	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}


	public String getLectureTeacher() {
		return lectureTeacher;
	}


	public void setLectureTeacher(String lectureTeacher) {
		this.lectureTeacher = lectureTeacher;
	}


	public Date getLectureStartDate() {
		return lectureStartDate;
	}


	public void setLectureStartDate(Date lectureStartDate) {
		this.lectureStartDate = lectureStartDate;
	}


	public Date getLectureEndDate() {
		return lectureEndDate;
	}


	public void setLectureEndDate(Date lectureEndDate) {
		this.lectureEndDate = lectureEndDate;
	}


	public Date getLectureStartTime() {
		return lectureStartTime;
	}


	public void setLectureStartTime(Date lectureStartTime) {
		this.lectureStartTime = lectureStartTime;
	}


	public Date getLectureEndTime() {
		return lectureEndTime;
	}


	public void setLectureEndTime(Date lectureEndTime) {
		this.lectureEndTime = lectureEndTime;
	}


	public String getLectureContent() {
		return lectureContent;
	}


	public void setLectureContent(String lectureContent) {
		this.lectureContent = lectureContent;
	}


	public String getLectureStudent() {
		return LectureStudent;
	}


	public void setLectureStudent(String lectureStudent) {
		LectureStudent = lectureStudent;
	}


	public String getLectureDay() {
		return lectureDay;
	}


	public void setLectureDay(String lectureDay) {
		this.lectureDay = lectureDay;
	}


	public int getLectureMaxNum() {
		return lectureMaxNum;
	}


	public void setLectureMaxNum(int lectureMaxNum) {
		this.lectureMaxNum = lectureMaxNum;
	}


	public int getLecturePrice() {
		return lecturePrice;
	}


	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}


	public String getLectureAddress() {
		return lectureAddress;
	}


	public void setLectureAddress(String lectureAddress) {
		this.lectureAddress = lectureAddress;
	}


	public String getLectureCompany() {
		return lectureCompany;
	}


	public void setLectureCompany(String lectureCompany) {
		this.lectureCompany = lectureCompany;
	}


	public Date getLectureReceiptStart() {
		return lectureReceiptStart;
	}


	public void setLectureReceiptStart(Date lectureReceiptStart) {
		this.lectureReceiptStart = lectureReceiptStart;
	}


	public Date getLectureReceiptEnd() {
		return lectureReceiptEnd;
	}


	public void setLectureReceiptEnd(Date lectureReceiptEnd) {
		this.lectureReceiptEnd = lectureReceiptEnd;
	}


	public String getLectureReceiptMethod() {
		return lectureReceiptMethod;
	}


	public void setLectureReceiptMethod(String lectureReceiptMethod) {
		this.lectureReceiptMethod = lectureReceiptMethod;
	}

	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lecture [lectureNum=");
		builder.append(lectureNum);
		builder.append(", lectureName=");
		builder.append(lectureName);
		builder.append(", lectureTeacher=");
		builder.append(lectureTeacher);
		builder.append(", lectureStartDate=");
		builder.append(lectureStartDate);
		builder.append(", lectureEndDate=");
		builder.append(lectureEndDate);
		builder.append(", lectureStartTime=");
		builder.append(lectureStartTime);
		builder.append(", lectureEndTime=");
		builder.append(lectureEndTime);
		builder.append(", lectureContent=");
		builder.append(lectureContent);
		builder.append(", LectureStudent=");
		builder.append(LectureStudent);
		builder.append(", lectureDay=");
		builder.append(lectureDay);
		builder.append(", lectureMaxNum=");
		builder.append(lectureMaxNum);
		builder.append(", lecturePrice=");
		builder.append(lecturePrice);
		builder.append(", lectureAddress=");
		builder.append(lectureAddress);
		builder.append(", lectureCompany=");
		builder.append(lectureCompany);
		builder.append(", lectureReceiptStart=");
		builder.append(lectureReceiptStart);
		builder.append(", lectureReceiptEnd=");
		builder.append(lectureReceiptEnd);
		builder.append(", lectureReceiptMethod=");
		builder.append(lectureReceiptMethod);
		builder.append("]");
		return builder.toString();
	}

	/* 생성자 */
	public Lecture() {}
	public Lecture(int lectureNum, String lectureName, String lectureTeacher, Date lectureStartDate,
			Date lectureEndDate, Date lectureStartTime, Date lectureEndTime, String lectureContent,
			String lectureStudent, String lectureDay, int lectureMaxNum, int lecturePrice, String lectureAddress,
			String lectureCompany, Date lectureReceiptStart, Date lectureReceiptEnd, String lectureReceiptMethod) {
		super();
		this.lectureNum = lectureNum;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lectureStartDate = lectureStartDate;
		this.lectureEndDate = lectureEndDate;
		this.lectureStartTime = lectureStartTime;
		this.lectureEndTime = lectureEndTime;
		this.lectureContent = lectureContent;
		LectureStudent = lectureStudent;
		this.lectureDay = lectureDay;
		this.lectureMaxNum = lectureMaxNum;
		this.lecturePrice = lecturePrice;
		this.lectureAddress = lectureAddress;
		this.lectureCompany = lectureCompany;
		this.lectureReceiptStart = lectureReceiptStart;
		this.lectureReceiptEnd = lectureReceiptEnd;
		this.lectureReceiptMethod = lectureReceiptMethod;
	}
	
}//end of Lecture
