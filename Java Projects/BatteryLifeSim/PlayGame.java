import javax.swing.JOptionPane;

public class PlayGame {
	public static int timePlayingGames = 0;
	
	public static void playGame()
	{
		String inputString;
		int time;
		
		//Get user input for use time
		inputString = JOptionPane.showInputDialog("How many minutes will you be playing games?");
		
		//Check for valid input
		time = BatteryLifeSim.validateTime(inputString);
		
		//Check for adequate battery life
		if((time * 10) > ChargeBattery.batteryLife)
		{
			JOptionPane.showMessageDialog(null, "You do not have enough battery life to complete that action.\n\nBattery life: " + ChargeBattery.batteryLife + "%");
			return;
		}
		else
		{
			//Use battery and increment time spent watching video
			for (int i = 0; i < time; i++)
			{
				ChargeBattery.batteryLife = ChargeBattery.batteryLife - 10;
				timePlayingGames++;
			}
		}
	}
}
