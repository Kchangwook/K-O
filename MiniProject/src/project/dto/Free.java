package project.dto;

/** 자유게시판을 저장하기 위한 클래스 */
public class Free {

	/* 변수 */
	private int freeNum;
	private String freeName;
	private String freeContent;
	private String id;
	
	/* 생성자 */
	public Free() {}
	public Free(int freeNum, String freeName, String freeContent, String id) {
		super();
		this.freeNum = freeNum;
		this.freeName = freeName;
		this.freeContent = freeContent;
		this.id = id;
	}
	
	/* 접근자, 수정자 */
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
	public String getFreeName() {
		return freeName;
	}
	public void setFreeName(String freeName) {
		this.freeName = freeName;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Free [freeNum=");
		builder.append(freeNum);
		builder.append(", freeName=");
		builder.append(freeName);
		builder.append(", freeContent=");
		builder.append(freeContent);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Free
