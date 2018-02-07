package com.fastscripts.view;

import javax.swing.UIManager;

import com.fastscripts.view.mainjframe.MainJFrame;
import com.fastscripts.view.mainjframe.MainJFrameController;


public class ViewDriver {
    
    @SuppressWarnings("unused")
	public ViewDriver() 
    {
       try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }
       catch (Exception e) {
         e.printStackTrace();
       }
        MainJFrame mainJFrame = new MainJFrame();
        MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);   
    }
    
 public static void main(String[] args) {
   new ViewDriver();
 }
    
}