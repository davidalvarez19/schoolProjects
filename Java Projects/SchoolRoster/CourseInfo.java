//David Alvarez
//COP2552.0M1
//Read in from files to populate info about courses,
//sections, and student enrollment. Output that
//information in dialog boxes.

import java.io.IOException;
import java.util.ArrayList;

public class CourseInfo {
	
	static ArrayList<Sections> courseList = new ArrayList<>();
	static ArrayList<String> roster001 = new ArrayList<>();
	static ArrayList<String> roster0M1 = new ArrayList<>();
	static ArrayList<String> rosterEM1 = new ArrayList<>();
	
	public void driver() throws IOException
	{
		FileManagement fM = new FileManagement();
		
		fM.fileMgmtDriver();
		
		Display display = new Display();
		
		display.showDialogOutput();
		
//		for (int i = 0; i < courseList.size(); i++)
//		{
//			System.out.println(courseList.get(i).sectionNumber + " " + courseList.get(i).instructorName + " " + courseList.get(i).instructorId + " " + courseList.get(i).classDay + " " + courseList.get(i).classTime + " " + courseList.get(i).campusRoom);
//		}
		
		//System.out.println("roster size: " + roster001.size());
//		for (int i = 0; i < roster001.size(); i++)
//		{
//			System.out.println(roster001.get(i));
//		}
	}
	
	public static void main(String[] args) throws IOException{
		CourseInfo obj = new CourseInfo();
		
		obj.driver();
	}
	
}
