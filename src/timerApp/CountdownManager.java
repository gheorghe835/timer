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

    public void chooseColor(JFrame parentFrame) {
        Color color = JColorChooser.showDialog(parentFrame, "Choose Color", chooseColor);
        if (color != null) {
            chooseColor = color;
        }
    }

    public void startCountdown(int countdownValue, int speed, JFrame parentFrame) {
        this.countdownValue = countdownValue;

        if (colorChangingFrame == null) {
            colorChangingFrame = new JFrame("Color Changing Window");
            colorChangingFrame.setSize(400, 400);
            colorChangingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            colorChangingFrame.setVisible(true);
        }


        new javax.swing.Timer(speed, e -> {
            if (CountdownManager.this.countdownValue > 0) {
                CountdownManager.this.countdownValue--;
                toggleBackgroundColor();
            } else {
                ((javax.swing.Timer) e.getSource()).stop();
                Utils.disableControls(parentFrame, true);
            }
        }).start();

        // Disabling the controls
        Utils.disableControls(parentFrame, false);

        countdownTimer = new javax.swing.Timer(speed, e -> {
            if (this.countdownValue > 0) {
                this.countdownValue--;
                toggleBackgroundColor();
            } else {
                countdownTimer.stop();
                // We activate controls after the count is complete
                Utils.disableControls(parentFrame, true);
            }
        });
        countdownTimer.start();
    }

    public void stopCountdown() {
        if (countdownTimer != null) {
            countdownTimer.stop();
        }
        if (colorChangingFrame != null) {
            colorChangingFrame.dispose();
            colorChangingFrame = null;
        }
    }

    private void toggleBackgroundColor() {
        SwingUtilities.invokeLater(() -> {
            if (toggleColor) {
                colorChangingFrame.getContentPane().setBackground(chooseColor);
            } else {
                colorChangingFrame.getContentPane().setBackground(Color.WHITE);
            }
            toggleColor = !toggleColor;
        });
    }
}