import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//handle file management to populate arrays and sort them
public class FileManagement{
	public static File inFile;
	public static Scanner inFileScanner;
	private final int numSections = 3;
	
	public FileManagement() {}
	
	//open input file
	public static void openInFile(String fileName) throws IOException
	{
		inFile = new File(fileName);
		inFileScanner = new Scanner(inFile);
	
		if(!inFile.exists())
		{
			//display an error message
			System.out.println("The file " + fileName + " does not exist.");
		}
	}
	
	//read through course input file and initialize variables and arrays with data
	public void readCourseFile()
	{
		String input;
		
		Courses.courseNumber = inFileScanner.nextLine();
		Courses.courseName = inFileScanner.nextLine();
		input = inFileScanner.nextLine();
		Sections section = new Sections();
		
		for (int i = 0; i < numSections; i++)
		{
			section = new Sections(inFileScanner.nextLine(), inFileScanner.nextLine(), inFileScanner.nextLine(), inFileScanner.nextLine(), inFileScanner.nextLine(), inFileScanner.nextLine());
			CourseInfo.courseList.add(section);
			input = inFileScanner.nextLine();
		}
	}
	
	//read through student enrollment file and add data to relevant array
	public void readStudentFile()
	{
		String studentId;
		String section;
		
		while(inFileScanner.hasNextLine()) {
			studentId = inFileScanner.nextLine();
			section = inFileScanner.nextLine();
			
			if (section.equals("0M1"))
				CourseInfo.roster0M1.add(studentId);
			else if (section.equals("001"))
				CourseInfo.roster001.add(studentId);
			else
				CourseInfo.rosterEM1.add(studentId);
		}
	}
	
	//sort student arrays
	public void sortArrays()
	{
		Collections.sort(CourseInfo.roster001);
		Collections.sort(CourseInfo.roster0M1);
		Collections.sort(CourseInfo.rosterEM1);
	}
	
	public void closeFile()
	{
		inFileScanner.close();
	}
	
	public void fileMgmtDriver() throws IOException
	{
		openInFile("CourseInfo.txt");
		readCourseFile();
		openInFile("StudentRegistration.txt");
		readStudentFile();
		closeFile();
		sortArrays();
	}
}
