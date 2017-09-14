package project.dto;

/** FAQ를 저장하기 위한 클래스 */
public class FAQ {

	/* 변수 */
	private int FAQNum;
	private String FAQName;
	private String FAQContent;
	
	/* 생성자 */
	public FAQ() {}
	public FAQ(int fAQNum, String fAQName, String fAQContent) {
		super();
		FAQNum = fAQNum;
		FAQName = fAQName;
		FAQContent = fAQContent;
	}
	
	/* 접근자, 수정자 */
	public int getFAQNum() {
		return FAQNum;
	}
	public void setFAQNum(int fAQNum) {
		FAQNum = fAQNum;
	}
	public String getFAQName() {
		return FAQName;
	}
	public void setFAQName(String fAQName) {
		FAQName = fAQName;
	}
	public String getFAQContent() {
		return FAQContent;
	}
	public void setFAQContent(String fAQContent) {
		FAQContent = fAQContent;
	}
	
	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FAQ [FAQNum=");
		builder.append(FAQNum);
		builder.append(", FAQName=");
		builder.append(FAQName);
		builder.append(", FAQContent=");
		builder.append(FAQContent);
		builder.append("]");
		return builder.toString();
	}
	
}//end of FAQ
