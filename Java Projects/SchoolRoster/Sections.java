
public class Sections extends Courses {
	public String sectionNumber;
	public String instructorName;
	public String instructorId;
	public String classDay;
	public String classTime;
	public String campusRoom;
	
	public Sections() {}
	
	public Sections(String secNum, String name, String id, String day, String time, String room) {
		sectionNumber = secNum;
		instructorName = name;
		instructorId = id;
		classDay = day;
		classTime = time;
		campusRoom = room;
	}
}
