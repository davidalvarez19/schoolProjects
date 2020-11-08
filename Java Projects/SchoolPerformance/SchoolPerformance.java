//David Alvarez
//COP2552.0M1
//Process data from input file to determine aggregate
//values of performance and demographic information
//by academic year 
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SchoolPerformance {
	//Declare variables
	public static final int ARRAYSIZE = 75;
	private static final int NUMCATEGORIES = 24;
	private static final int NUMGENDERS = 3;
	private static final int NUMRACES = 8;
	
	private static File inFile;					
	private static Scanner inFileScanner;		
	
	private PrintWriter writeOut = null;
	private DecimalFormat formatter = new DecimalFormat("###.0%");
	
	private static int[] program3624Totals = new int[NUMCATEGORIES];
	private static int[] program5651Totals = new int[NUMCATEGORIES];
	private static int[] program6635Totals = new int[NUMCATEGORIES];
	private static int[] calendarYearTotals = new int[NUMCATEGORIES];
	/* array[0]  = total enrolled					array[12] = total native american enrolled
	 * array[1]  = total completed					array[13] = total native hawaiian enrolled
	 * array[2]  = total female enrolled			array[14] = total not reported enrolled
	 * array[3]  = total male enrolled				array[15] = total white enrolled
	 * array[4]  = total unknown enrolled			array[16] = total asian completed
	 * array[5]  = total female completed			array[17] = total black completed
	 * array[6]  = total male completed				array[18] = total hispanic completed
	 * array[7]  = total unknown completed			array[19] = total multiracial completed
	 * array[8]  = total asian enrolled				array[20] = total native american completed
	 * array[9]  = total black enrolled				array[21] = total native hawaiian completed
	 * array[10] = total hispanic enrolled			array[22] = total not reported completed
	 * array[11] = total multiracial enrolled		array[23] = total white completed */
	
	private static float[] yearlyPercentCompleted = new float[NUMCATEGORIES / 2];
	/* array[0]  = percent completed
	 * array[1]  = percent female
	 * array[2]  = percent male
	 * array[3]  = percent unknown
	 * array[4]  = percent asian
	 * array[5]  = percent black
	 * array[6]  = percent hispanic
	 * array[7]  = percent multiracial
	 * array[8]  = percent native american
	 * array[9]  = percent native hawaiian
	 * array[10] = percent not reported
	 * array[11] = percent white */
	
	//open input file and create scanner object
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
	
	//populate semester arrays
	public static void populateArray(int[] data)
	{
		for(int i = 0; i < ARRAYSIZE; i++)
		{
			data[i] = inFileScanner.nextInt();
		}
	}
	
	/**This doesn't work because I can't pass by reference**/
//	public static void processSemester(int[] data, int totalEnrolled, int totalCompleted, float percentCompleted)
//	{
//		totalEnrolled = data[1] + data[26] + data[51];
//		totalCompleted = data[2] + data[27] + data[52];
//		percentCompleted = (float)totalCompleted/totalEnrolled;
//	}
	
	//populate program, calendar year, and percent completed arrays
	public void processAggregate()
	{
		for (int i = 0; i < NUMCATEGORIES; i++) //populate program and calendar year arrays
		{
			program3624Totals[i] = Fall2019.fallData[i + 1] + Spring2020.springData[i + 1] + Summer2020.summerData[i + 1];
			program5651Totals[i] = Fall2019.fallData[i + 26] + Spring2020.springData[i + 26] + Summer2020.summerData[i + 26];
			program6635Totals[i] = Fall2019.fallData[i + 51] + Spring2020.springData[i + 51] + Summer2020.summerData[i + 51];
			calendarYearTotals[i] = program3624Totals[i] + program5651Totals[i] + program6635Totals[i];
		}
		
		yearlyPercentCompleted[0] = (float)calendarYearTotals[1] / calendarYearTotals[0]; //populate array with total percent completed
		
		for (int i = 0; i < NUMGENDERS; i++)	//populate array with percent complete by gender
		{
			yearlyPercentCompleted[i + 1] = (float)calendarYearTotals[i + 5] / calendarYearTotals[i + 2];
		}
		
		for (int i = 0; i < NUMRACES; i++)		//populate array with percent complete by race
		{
			yearlyPercentCompleted[i + 4] = (float)calendarYearTotals[i + 16] / calendarYearTotals[i + 8];
		}
	}
	
	//write aggregate and program totals to Analytics2019.txt
	private void fileOutput() throws IOException
	{
		writeOut = new PrintWriter("C:\\SFC\\COP2552\\Project4\\Analytics2019.txt");
		
		writeOut.println("Academic Year 2019");
		
		for (int i = 0; i < calendarYearTotals.length; i++)
			writeOut.println(calendarYearTotals[i]);
		
		writeOut.println("Program 3624");
		
		for (int i = 0; i < program3624Totals.length; i++)
			writeOut.println(program3624Totals[i]);
		
		writeOut.println("Program 5651");
		
		for (int i = 0; i < program5651Totals.length; i++)
			writeOut.println(program5651Totals[i]);
		
		writeOut.println("Program 6635");
		
		for (int i = 0; i < program6635Totals.length; i++)
			writeOut.println(program6635Totals[i]);
	}
	
	//display dialog boxes with student performance information
	private void dialogOutput()
	{
		String yearCompleters = formatter.format(yearlyPercentCompleted[0]);
		String fallCompleters = formatter.format(Fall2019.percentCompleted);
		String springCompleters = formatter.format(Spring2020.percentCompleted);
		String summerCompleters = formatter.format(Summer2020.percentCompleted);
		String femaleCompleters = formatter.format(yearlyPercentCompleted[1]);
		String maleCompleters = formatter.format(yearlyPercentCompleted[2]);
		String unknownCompleters = formatter.format(yearlyPercentCompleted[3]);
		String asianCompleters = formatter.format(yearlyPercentCompleted[4]);
		String blackCompleters = formatter.format(yearlyPercentCompleted[5]);
		String hispanicCompleters = formatter.format(yearlyPercentCompleted[6]);
		String multiracialCompleters = formatter.format(yearlyPercentCompleted[7]);
		String naCompleters = formatter.format(yearlyPercentCompleted[8]);
		String nhCompleters = formatter.format(yearlyPercentCompleted[9]);
		String nrCompleters = formatter.format(yearlyPercentCompleted[10]);
		String whiteCompleters = formatter.format(yearlyPercentCompleted[11]);
		

		JOptionPane.showMessageDialog(null, String.format("Santa Fe College\nAcademic Year 2019-2020\nProgram codes: 3624, 5651, 6635\n\nAggregate total number of students enrolled:%50d\nAggregate total number of student completers:%46d\n\nAggregate percentage of students completing for the academic year: %s\n\nPercentage of students completing Fall 2019:%52s\nPercentage of students completing Spring 2020:%46s\nPercentage of students completing Summer 2020:%42s", calendarYearTotals[0], calendarYearTotals[1], yearCompleters, fallCompleters, springCompleters, summerCompleters), "Calendar Year Aggregates", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, String.format("Santa Fe College\nAcademic Year 2019-2020\nProgram code: 3624\n\nTotal enrolled:%38d\nTotal completed:%34d\nFemale enrolled:%34d\nMale enrolled:%39d\nUnknown enrolled:%30d\nFemale completed:%29d\nMale completed:%34d\nUnknown completed:%25d\nAsian enrolled:%37d\nBlack enrolled:%37d\nHispanic enrolled:%31d\nMultiracial enrolled:%29d\nNative American enrolled:%18d\nNative Hawaiian enrolled:%20d\nNot reported enrolled:%25d\nWhite enrolled:%36d\nAsian completed:%32d\nBlack completed:%32d\nHispanic completed:%26d\nMultiracial completed:%24d\nNative American completed:%14d\nNative Hawaiian completed:%15d\nNot reported completed:%20d\nWhite completed:%33d\n", program3624Totals[0], program3624Totals[1], program3624Totals[2], program3624Totals[3], program3624Totals[4], program3624Totals[5], program3624Totals[6], program3624Totals[7], program3624Totals[8], program3624Totals[9], program3624Totals[10], program3624Totals[11], program3624Totals[12], program3624Totals[13], program3624Totals[14], program3624Totals[15], program3624Totals[16], program3624Totals[17], program3624Totals[18], program3624Totals[19], program3624Totals[20], program3624Totals[21], program3624Totals[22], program3624Totals[23]), "Program Totals", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, String.format("Santa Fe College\nAcademic Year 2019-2020\nProgram code: 5651\n\nTotal enrolled:%38d\nTotal completed:%34d\nFemale enrolled:%34d\nMale enrolled:%39d\nUnknown enrolled:%30d\nFemale completed:%29d\nMale completed:%34d\nUnknown completed:%25d\nAsian enrolled:%37d\nBlack enrolled:%37d\nHispanic enrolled:%31d\nMultiracial enrolled:%29d\nNative American enrolled:%18d\nNative Hawaiian enrolled:%20d\nNot reported enrolled:%25d\nWhite enrolled:%36d\nAsian completed:%32d\nBlack completed:%32d\nHispanic completed:%26d\nMultiracial completed:%24d\nNative American completed:%14d\nNative Hawaiian completed:%15d\nNot reported completed:%20d\nWhite completed:%33d\n", program5651Totals[0], program5651Totals[1], program5651Totals[2], program5651Totals[3], program5651Totals[4], program5651Totals[5], program5651Totals[6], program5651Totals[7], program5651Totals[8], program5651Totals[9], program5651Totals[10], program5651Totals[11], program5651Totals[12], program5651Totals[13], program5651Totals[14], program5651Totals[15], program5651Totals[16], program5651Totals[17], program5651Totals[18], program5651Totals[19], program5651Totals[20], program5651Totals[21], program5651Totals[22], program5651Totals[23]), "Program Totals", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, String.format("Santa Fe College\nAcademic Year 2019-2020\nProgram code: 5651\n\nTotal enrolled:%38d\nTotal completed:%34d\nFemale enrolled:%34d\nMale enrolled:%39d\nUnknown enrolled:%30d\nFemale completed:%29d\nMale completed:%34d\nUnknown completed:%25d\nAsian enrolled:%37d\nBlack enrolled:%37d\nHispanic enrolled:%31d\nMultiracial enrolled:%29d\nNative American enrolled:%18d\nNative Hawaiian enrolled:%20d\nNot reported enrolled:%25d\nWhite enrolled:%36d\nAsian completed:%32d\nBlack completed:%32d\nHispanic completed:%26d\nMultiracial completed:%24d\nNative American completed:%14d\nNative Hawaiian completed:%15d\nNot reported completed:%20d\nWhite completed:%33d\n", program6635Totals[0], program6635Totals[1], program6635Totals[2], program6635Totals[3], program6635Totals[4], program6635Totals[5], program6635Totals[6], program6635Totals[7], program6635Totals[8], program6635Totals[9], program6635Totals[10], program6635Totals[11], program6635Totals[12], program6635Totals[13], program6635Totals[14], program6635Totals[15], program6635Totals[16], program6635Totals[17], program6635Totals[18], program6635Totals[19], program6635Totals[20], program6635Totals[21], program6635Totals[22], program6635Totals[23]), "Program Totals", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, String.format("Santa Fe College\nAcademic Year 2019-2020\nProgram codes: 3624, 5651, 6635\n\nAggregate values for:\n\nFemale completers:%31s\nMale completers:%36s\nUnknown completers:%28s\n\nAsian completers:%35s\nBlack completers:%35s\nHispanic completers:%30s\nMultiracial completers:%27s\nNative American completers:%16s\nNative Hawaiian completers:%17s\nNot reported completers:%23s\nWhite completers:%36s", femaleCompleters, maleCompleters, unknownCompleters, asianCompleters, blackCompleters, hispanicCompleters, multiracialCompleters, naCompleters, nhCompleters, nrCompleters, whiteCompleters),"Aggregates by Population", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//close files
	private void closeFiles()
	{
		writeOut.close();
	}
	
	//driver calls the order of method execution
	private void driver() throws IOException		
	{
		Fall2019.driver();
		Spring2020.driver();
		Summer2020.driver();
		processAggregate();
		fileOutput();
		closeFiles();
		dialogOutput();
	}
	
	/**********************Main*******************************/
	public static void main(String[] args) throws IOException{

		SchoolPerformance obj = new SchoolPerformance();
		
		obj.driver();

	}

}
