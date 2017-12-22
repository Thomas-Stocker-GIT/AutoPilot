package roboticprocessautomation.commons;

import java.awt.AWTException;
import java.awt.Robot;

public abstract class AbstractRobot {
	
	private static Robot bot = null;
	
	protected static Robot getRobot() {
		if(bot == null)
			try {
				bot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bot;
	}
}
