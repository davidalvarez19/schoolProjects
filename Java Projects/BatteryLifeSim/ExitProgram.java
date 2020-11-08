import javax.swing.JOptionPane;

public class ExitProgram {
	public static void exitProgram()
	{
		JOptionPane.showMessageDialog(null, String.format("Thank you for using BatteryLifeSim\n\nTotal time spent:\nCharging%24d\nVideo Chat%20d\nWatching video%12d\nPlaying games%14d\nBattery remaining%7d", ChargeBattery.timeCharging, VideoChat.timeVideoChatting, WatchVideo.timeWatchingVideo, PlayGame.timePlayingGames, ChargeBattery.batteryLife));
		System.exit(0);
	}
}
