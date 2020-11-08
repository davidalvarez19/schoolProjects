import javax.swing.JOptionPane;

public class ChargeBattery {
	public static int batteryLife = 100;
	public static int timeCharging = 0;
	
	public static void chargeBattery()
	{
		String inputString;
		int time = 0;
		
		//Check if battery is full
		if (batteryLife == 100)
		{
			JOptionPane.showMessageDialog(null, "Your battery is already full");
			return;
		}
		
		//Get user input for charging time
		inputString = JOptionPane.showInputDialog("How many minutes would you like to charge?");
		
		//Check for valid input
		time = BatteryLifeSim.validateTime(inputString);
		
		//Check for excessive charging
		if (time > (100 - batteryLife))
		{
			JOptionPane.showMessageDialog(null, "Your battery will be full after " + (100 - batteryLife) + " minutes. Charging.");
		}
		
		//Charge battery
		for (int i = 0; i < time; i++)
		{
			if (batteryLife < 100)
			{
				batteryLife++;
				timeCharging++;
			}
			else
			{
				return;
			}
		}
	}
}
