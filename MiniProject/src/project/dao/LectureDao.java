package project.dao;

/** Lecture Table과 연동하기 위한 클래스 */
public class LectureDao {

	/* 변수 */
	private static LectureDao instance = null;
	
	/* 생성자 */
	private LectureDao() {}
	
	/* 접근자 */
	public static LectureDao getInstance() {
		
		if(instance == null)
			instance = new LectureDao();
		
		return instance;
		
	}//end of getInstance
	
	/* 함수 */

	
}//end of LectureDao
