package roboticprocessautomation.core;

import java.awt.Rectangle;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class MicrosoftWindow implements IWindow {

	private WinDef.HWND myHwnd = null;
	private User32 user32 = null;
	private static final int MAX_TITLE_LENGTH = 1024;
	
	public MicrosoftWindow(WinDef.HWND hwnd) {
		setHwnd(hwnd);
		user32 = User32.INSTANCE;
	}
	
	public String getWindowTitle() {
		 char[] buffer = new char[MAX_TITLE_LENGTH * 2];
	     user32.GetWindowText(myHwnd, buffer, MAX_TITLE_LENGTH);
	     return Native.toString(buffer);
	}
	
	public WinDef.HWND getHwnd() {
		return myHwnd;
	}
	
	public void setHwnd(WinDef.HWND hwnd) {
		myHwnd = hwnd;
	}
	
	public void bringToFront() {

		System.out.println("SetForeground: "+user32.SetForegroundWindow(myHwnd));
		user32.SetFocus(myHwnd);
	}
	
	public void maximize() {
		user32.ShowWindow(myHwnd, WinUser.SW_MAXIMIZE);
	}
	
	public void minimize() {
		user32.ShowWindow(myHwnd, WinUser.SW_MINIMIZE);
	}
	
	public Rectangle getRectangle() {
		WinDef.RECT myRectangle = new WinDef.RECT();
		 user32.GetWindowRect(myHwnd, myRectangle);
		 return null;			 
	}
}
