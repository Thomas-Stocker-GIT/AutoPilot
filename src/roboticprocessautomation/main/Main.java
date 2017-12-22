/*
 * To change this license hea
der, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboticprocessautomation.main;

import roboticprocessautomation.commons.Keyboard;
import roboticprocessautomation.core.MicrosoftWindow;
import roboticprocessautomation.core.WindowFinder;


/**
 *
 * @author thost
 */
public class Main {
	

    public static void main(String[]args){
    	
    WindowFinder windowFinder = new WindowFinder();
    MicrosoftWindow notepad = windowFinder.findWindow("Untitled - Notepad");
    notepad.bringToFront();
    notepad.maximize();
    Keyboard.type("hello world!");
    System.out.println(notepad.getWindowTitle());
    
    
   
    
    }
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       
  
}
