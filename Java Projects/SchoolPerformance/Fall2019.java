import java.io.IOException;

public class Fall2019 {
	public static int[] fallData = new int[SchoolPerformance.ARRAYSIZE];
	public static String inputFileName = "Fall2019Analytics.txt";
	public static int totalEnrolled;
	public static int totalCompleted;
	public static float percentCompleted;
	
	//process semester data
	private static void processSemester()
	{
		totalEnrolled = fallData[1] + fallData[26] + fallData[51];
		totalCompleted = fallData[2] + fallData[27] + fallData[52];
		percentCompleted = (float)totalCompleted/totalEnrolled;
	}
	
	//driver calls the order of method execution for the Fall2019 class
	public static void driver() throws IOException
	{
		SchoolPerformance.openInFile(inputFileName);
		SchoolPerformance.populateArray(fallData);
		processSemester();
		//SchoolPerformance.processSemester(fallData, totalEnrolled, totalCompleted, percentCompleted);
	}
}
