package timerApp;

import javax.swing.*;

public class TimerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "  Choose an option",
                    "  Option panel",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"  Settings","  Close"},
                    "  Settings"
            );

            if (choice == JOptionPane.YES_NO_OPTION){
                new SettingsWindow();//Opens the settings window
            }
            else {
                System.exit(0);
            }
        });
    }
}
