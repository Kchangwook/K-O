package project.dto;

/** 현재 수강 신청 내역을 저장하기 위한 클래스 */
public class Present {

	/* 변수 */
	private String id;
	private int lectureNum;
	
	/* 생성자 */
	public Present() {}
	
	public Present(String id, int lectureNum) {
		super();
		this.id = id;
		this.lectureNum = lectureNum;
	}
	
	/* 접근자, 수정자 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLectureNum() {
		return lectureNum;
	}
	public void setLectureNum(int lectureNum) {
		this.lectureNum = lectureNum;
	}
	
	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Present [id=");
		builder.append(id);
		builder.append(", lectureNum=");
		builder.append(lectureNum);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Present
