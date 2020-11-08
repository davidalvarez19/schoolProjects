import java.io.IOException;

public class Summer2020 {
	public static int[] summerData = new int[SchoolPerformance.ARRAYSIZE];
	public static String inputFileName = "Summer2020Analytics.txt";
	public static int totalEnrolled;
	public static int totalCompleted;
	public static float percentCompleted;
	
	//process semester data
	private static void processSemester()
	{
		totalEnrolled = summerData[1] + summerData[26] + summerData[51];
		totalCompleted = summerData[2] + summerData[27] + summerData[52];
		percentCompleted = (float)totalCompleted/totalEnrolled;
	}
	
	//driver calls the order of method execution for the Summer2020 class
	public static void driver() throws IOException
	{
		SchoolPerformance.openInFile(inputFileName);
		SchoolPerformance.populateArray(summerData);
		processSemester();
		//SchoolPerformance.processSemester(summerData, totalEnrolled, totalCompleted, percentCompleted);
	}
}
