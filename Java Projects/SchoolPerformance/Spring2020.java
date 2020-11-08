import java.io.IOException;

public class Spring2020 {
	public static int[] springData = new int[SchoolPerformance.ARRAYSIZE];
	public static String inputFileName = "Spring2020Analytics.txt";
	public static int totalEnrolled;
	public static int totalCompleted;
	public static float percentCompleted;
	
	//process semester data
	private static void processSemester()
	{
		totalEnrolled = springData[1] + springData[26] + springData[51];
		totalCompleted = springData[2] + springData[27] + springData[52];
		percentCompleted = (float)totalCompleted/totalEnrolled;
	}
	
	//driver calls the order of method execution for the Spring2020 class
	public static void driver() throws IOException
	{
		SchoolPerformance.openInFile(inputFileName);
		SchoolPerformance.populateArray(springData);
		processSemester();
		//SchoolPerformance.processSemester(springData, totalEnrolled, totalCompleted, percentCompleted);
	}
}
