package timerApp;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class CountdownManager {
   private Timer countdownTimer;
   private int countdownValue = 10;
   private Color chooseColor = Color.BLUE;
   private JFrame colorChangingFrame;
   private boolean toggleColor = true;

    public int getCountdownValue() {
        return countdownValue;
    }

    public void chooseColor(JFrame parentFrame){
        Color color = JColorChooser.showDialog(parentFrame,"  Choose Color",chooseColor);
        if (color != null){
            chooseColor = color;
        }
    }

    public void startCountdown(int countdownValue,int speed, JFrame parenrFrame){
        this.countdownValue = countdownValue;

        if (colorChangingFrame == null){
            colorChangingFrame = new JFrame("  Color Changig Window");
            colorChangingFrame.setSize(400,400);
            colorChangingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            colorChangingFrame.setVisible(true);
        }

        countdownTimer = new Timer();
        countdownTimer.scheduleAtFixeRate(new TimerTask(){
            @Override
            public void run() {
                if (CountdownManager.this.countdownValue > 0) {
                    CountdownManager.this.countdownValue--;
                    toggleBackgroundColor();
                } else {
                    countdownTimer.cancel();
                    Utils.disableControls(parentFrame, true);
                }
            }
        }, 0, speed);
    }

    public void stopCountdown(){
        if (countdownTimer != null){
            countdownTimer.cancel();
        }
        if (colorChangingFrame != null){
            colorChangingFrame.dispose();
            colorChangingFrame = null;
        }
    }

    public void toggleBackgroundColor(){
        SwingUtilities.invokeLater(() -> {
            if (toggleColor){
                colorChangingFrame.getContentPane().setBackground(chooseColor);
            }
            else {
                colorChangingFrame.getContentPane().setBackground(Color.WHITE);
            }
            toggleColor = !toggleColor;
        });
    }
}
