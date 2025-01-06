package timerApp;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static void disableControls(JFrame frame,boolean enabled){
        for (Component component:
             frame.getContentPane().getComponents()) {
            if (!(component instanceof JLabel)){
                component.setEnabled(enabled);
            }
        }
    }
}
