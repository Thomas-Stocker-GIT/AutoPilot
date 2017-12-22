package roboticprocessautomation.core;

import java.awt.Rectangle;

public interface IWindow {

	public String getWindowTitle();
	
	public void bringToFront();
	
	public void maximize();
	
	public void minimize();
	
	public Rectangle getRectangle();
	
}