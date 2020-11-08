//David Alvarez
//COP2552.0M1
//Project 3

import javax.swing.JOptionPane; 


public class BatteryLifeSim {
	public static String inputString;
	public static int userInt;
	
	//Get user input for desired action
	public static void getInput()
	{
		inputString = JOptionPane.showInputDialog("Press 1 to charge the battery\nPress 2 to video chat\nPress 3 to watch a video\nPress 4 to play a game\nPress 5 to exit");
		validateChoice(inputString);
	}
	
	//Validate user's activity choice
	public static void validateChoice(String uInput)
	{
		try {
			userInt = Integer.parseInt(inputString);
		} catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Invalid entry. Your choice must be in number format.");
			return;
		}
		
		if (userInt < 1 || userInt > 5)
		{
			JOptionPane.showMessageDialog(null, "Invalid entry. You must enter a whole number between 1 and 5.");
			return;
		}
	}
	
	//Validate user's time entry
	public static int validateTime(String inString)
	{
		boolean validInput = false;
		int time = 0;
		
		while(validInput == false)
		{
			try {
				time = Integer.parseInt(inString);
				validInput = true;
			} catch (NumberFormatException ex){
				inString = JOptionPane.showInputDialog("Invalid input. Enter minutes in number format:");
			}
		}
		
		return time;
	}
	
	//Process user selection and call appropriate method
	public static void activityChoice()
	{
		switch (userInt)
		{
		case 1:
			ChargeBattery.chargeBattery();
			break;
		case 2:
			VideoChat.videoChat();
			break;
		case 3:
			WatchVideo.watchVideo();
			break;
		case 4:
			PlayGame.playGame();
			break;
		case 5:
			ExitProgram.exitProgram();
			break;
		}
	}
	
	public void driver()
	{
		while (ChargeBattery.batteryLife > 0)
		{
			getInput();
			activityChoice();
		}
		
		ExitProgram.exitProgram();
	}
	
	public static void main(String[] args) {
		BatteryLifeSim obj = new BatteryLifeSim();
		
		obj.driver();

	}

}
