import javax.swing.JOptionPane;

//display dialog output
public class Display {
	
	public void showDialogOutput (){
		JOptionPane.showMessageDialog(null, Courses.courseNumber + " - " + Courses.courseName + "\nSection:  " 
				+ CourseInfo.courseList.get(0).sectionNumber + "\n\nInstructor: " + CourseInfo.courseList.get(0).instructorName 
				+ "\nDay/Time: " + CourseInfo.courseList.get(0).classDay + " " + CourseInfo.courseList.get(0).classTime
				+ "\nCampus/Room: " + CourseInfo.courseList.get(0).campusRoom + "\n\nStudent Roster\n" 
				+ CourseInfo.roster001.get(0) + "\n" + CourseInfo.roster001.get(1) + "\n" + CourseInfo.roster001.get(2), 
				"Section 001", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, Courses.courseNumber + " - " + Courses.courseName + "\nSection:  " 
				+ CourseInfo.courseList.get(1).sectionNumber + "\n\nInstructor: " + CourseInfo.courseList.get(1).instructorName 
				+ "\nDay/Time: " + CourseInfo.courseList.get(1).classDay + " " + CourseInfo.courseList.get(1).classTime
				+ "\nCampus/Room: " + CourseInfo.courseList.get(1).campusRoom + "\n\nStudent Roster\n" 
				+ CourseInfo.roster0M1.get(0) + "\n" + CourseInfo.roster0M1.get(1) + "\n" + CourseInfo.roster0M1.get(2)
				+ "\n" + CourseInfo.roster0M1.get(3), "Section 001", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, Courses.courseNumber + " - " + Courses.courseName + "\nSection:  " 
				+ CourseInfo.courseList.get(2).sectionNumber + "\n\nInstructor: " + CourseInfo.courseList.get(2).instructorName 
				+ "\nDay/Time: " + CourseInfo.courseList.get(2).classDay + " " + CourseInfo.courseList.get(2).classTime
				+ "\nCampus/Room: " + CourseInfo.courseList.get(2).campusRoom + "\n\nStudent Roster\n" 
				+ CourseInfo.rosterEM1.get(0) + "\n" + CourseInfo.rosterEM1.get(1) + "\n" + CourseInfo.rosterEM1.get(2), 
				"Section 001", JOptionPane.INFORMATION_MESSAGE);
	}
}
