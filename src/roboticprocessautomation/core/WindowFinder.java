package roboticprocessautomation.core;

import java.util.List;

import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class WindowFinder {

	private User32 user32 = null;
	final int length = 512;
	
	
	public WindowFinder() {
		user32 = User32.INSTANCE;
	}

	private WinDef.HWND findWindowInternal(String title, int maxTimeInMilliseconds) {
		WinDef.HWND hwnd = null;
		long startTime = System.currentTimeMillis(); 
		while(hwnd==null||(System.currentTimeMillis()-startTime)<maxTimeInMilliseconds)
		{
			 hwnd = user32.FindWindow (null, title);
		}		
		return hwnd;
	}
	
	public MicrosoftWindow findWindow(String title) {
		return new MicrosoftWindow(findWindowInternal(title, 5000));
	}
	
	public MicrosoftWindow findWindow(String title, int maxTimeInMIlliseconds) {
		return new MicrosoftWindow(findWindowInternal(title, maxTimeInMIlliseconds));
	}
	
	public List<MicrosoftWindow> findAllWindows() {
		List<DesktopWindow> desktopWindows =WindowUtils.getAllWindows(true);
		List<MicrosoftWindow> windows = new java.util.ArrayList<MicrosoftWindow>();
		desktopWindows.forEach(desktopWindow-> windows.add(new MicrosoftWindow(desktopWindow.getHWND())));
		return windows;
	}
	
	
	
}
