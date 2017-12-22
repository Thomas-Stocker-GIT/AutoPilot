package roboticprocessautomation.commons;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Mouse extends AbstractRobot {
	
	private static Robot bot = null;
	

	public static void doClick(int x, int y, int event) {		
		
		  getRobot().mouseMove(x, y);
		  getRobot().mousePress(event);
		  getRobot().mouseRelease(event);
		 
	}
	
	public static void select(Point p1, Point p2) {
		drag(p1.x, p1.y);
		drop(p2.x, p2.y);
	}
	
	public static void leftClick(int x, int y) {		
		System.out.println("Mouse do left click on "+x+"; "+y);
		 doClick(x, y, InputEvent.BUTTON1_DOWN_MASK);	 
	}
	
	
	public static void doubleClick(int x, int y) {		
		System.out.println("Mouse do double click on "+x+"; "+y);
		doClick(x, y, InputEvent.BUTTON1_DOWN_MASK);
		doClick(x, y, InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public static void rightClick(int x, int y) {		
		System.out.println("Mouse do right click on "+x+"; "+y);
		doClick(x, y, InputEvent.BUTTON3_DOWN_MASK);
		 
	}
	
	
	
	public static void scroll( int ticks) {		
		  System.out.println("Mousewheel scroll "+ticks);
		  Point currLocation = getLocation();
		  leftClick(currLocation.x, currLocation.y);
		  getRobot().mouseWheel(ticks);	 
	}
	
	public static void drag(int x, int y) {		
		System.out.println("Mouse drag from "+x+"; "+y);
		 getRobot().mouseMove(x, y);
		 getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 
	}
	
	public static void drop(int x, int y) {		
		
		System.out.println("Mouse drop on "+x+"; "+y);
		 getRobot().mouseMove(x, y);
		 getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 
	}
	
	public static void move(int x, int y) {		
		
		  System.out.println("Mouse move to "+x+"; "+y);
		  getRobot().mouseMove(x, y);
		 
	}
	
	public static Point getLocation() {
		Point location = MouseInfo.getPointerInfo().getLocation();
		System.out.println("Mouse location: "+location.x+"; "+location.y);
		return location;
	}
	
}
