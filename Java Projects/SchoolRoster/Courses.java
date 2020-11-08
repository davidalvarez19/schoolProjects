public class Courses {
	protected static String courseNumber;
	protected static String courseName;
	
	public Courses(){}
	
	public Courses(String num, String name) {
		courseNumber = num;
		courseName = name;
	}
	
	public String getCourseNum()
	{
		return courseNumber;
	}
	
	public void setCourseNum(String num)
	{
		courseNumber = num;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public void setCourseName(String name) {
		courseName = name;
	}
}
