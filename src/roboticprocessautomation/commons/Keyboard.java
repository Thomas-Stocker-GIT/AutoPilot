package roboticprocessautomation.commons;

import java.awt.event.KeyEvent;

public class Keyboard extends AbstractRobot {
	
	public static void type(int i)
	  {
		getRobot().delay(40);
	    getRobot().keyPress(i);
	    getRobot().keyRelease(i);
	  }
	
	public static void type(int i, int keyDelay)
	  {
		getRobot().delay(keyDelay);
	    getRobot().keyPress(i);
	    getRobot().keyRelease(i);
	  }

	  public static void type(String s)
	  {
	     type(s, 2);
	  }
	  
	  public static void type(String s, int keyDelay)
	  {
	    byte[] bytes = s.getBytes();
	    for (byte b : bytes)
	    {
	      int code = b;
	      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
	      if (code > 96 && code < 123) code = code - 32;
	      getRobot().delay(keyDelay);
	      getRobot().keyPress(code);
	      getRobot().keyRelease(code);
	    }
	  }
	  
	  public static void copy() {
		 copy(200);
	  }
	  
	  public static void copy(int keyDelay) {
		  try {
		  getRobot().keyPress(KeyEvent.VK_CONTROL);
		  Thread.sleep(keyDelay); 
		  getRobot().keyPress(KeyEvent.VK_C); 
		  Thread.sleep(keyDelay); 
		  getRobot().keyRelease(KeyEvent.VK_C); 
		  Thread.sleep(keyDelay); 
		  getRobot().keyRelease(KeyEvent.VK_CONTROL); 
		  Thread.sleep(keyDelay);
		  }
		  catch(Exception ex) {
			  System.out.println(ex.toString());
		  }
	  }
	  
	  public static void paste() {
		 paste(200);
	  }
	  
	  public static void paste(int keyDelay) {
		  try {
			  getRobot().keyPress(KeyEvent.VK_CONTROL);
			  Thread.sleep(keyDelay); 
			  getRobot().keyPress(KeyEvent.VK_V); 
			  Thread.sleep(keyDelay); 
			  getRobot().keyRelease(KeyEvent.VK_V); 
			  Thread.sleep(keyDelay); 
			  getRobot().keyRelease(KeyEvent.VK_CONTROL); 
			  Thread.sleep(keyDelay);
			  }
			  catch(Exception ex) {
				  System.out.println(ex.toString());
			  }
	  }

}
