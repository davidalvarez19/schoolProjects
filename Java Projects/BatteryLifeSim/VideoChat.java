import javax.swing.JOptionPane;

public class VideoChat {
	public static int timeVideoChatting = 0;
	
	public static void videoChat()
	{
		String inputString;
		int time;
		
		//Get user input for use time
		inputString = JOptionPane.showInputDialog("How many minutes will you be using video chat?");
		
		//Check for valid input
		time = BatteryLifeSim.validateTime(inputString);
		
		//Check for adequate battery life
		if (time > ChargeBattery.batteryLife)
		{
			JOptionPane.showMessageDialog(null, "You do not have enough battery life to complete that action.\n\nBattery life: " + ChargeBattery.batteryLife + "%");
			return;
		}
		else
		{
			//use battery and increment time spent video chatting
			ChargeBattery.batteryLife = ChargeBattery.batteryLife - time;
			timeVideoChatting += time;
		}
	}
}
