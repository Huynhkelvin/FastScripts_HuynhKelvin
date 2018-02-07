package com.fastscripts.view.utilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Utils {

	/**
	 * Centers the window
	 * @param comp
	 */
    public static void centerWindow(Component comp) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension frameSize = comp.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    comp.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);
  }

    /**
     * API to show error message 
     * @param e
     */
    public static void showErrorMessage(Exception e) {
        MessageDialog msgDlg = new MessageDialog("Error",
                                                 e.getMessage() != null ?
                                                 e.getMessage() : "Error occurred");
        Utils.centerWindow(msgDlg);
        e.printStackTrace();
        msgDlg.setModal(true);

     }
}
