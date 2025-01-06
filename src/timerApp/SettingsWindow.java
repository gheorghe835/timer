package timerApp;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class SettingsWindow {
    private CountdownManager countdownManager;
    private JFrame settingsFrame;

    public SettingsWindow(){
        countdownManager = new CountdownManager();
        settingsFrame = new JFrame("  Settings");
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.setSize(400,300);
        settingsFrame.setLayout(new GridLayout(5, 2));

        setupUI();
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setVisible(true);
    }

    private void setupUI(){
        //Current time
        JLabel timeLabel = new JLabel("  Current tme:: ");
        JLabel currentTime = new JLabel();
        settingsFrame.add(timeLabel);
        settingsFrame.add(currentTime);

        new javax.swing.Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            currentTime.setText(sdf.format(new Date()));
        }).start();

        // Countdown input
        JLabel countdownLabel = new JLabel("  Coundown(sec)::");
        JTextField countdownField = new JTextField(String.valueOf(countdownManager.getCountdownValue()));
        settingsFrame.add(countdownLabel);
        settingsFrame.add(countdownField);

        //Choice of color
        JLabel colorLabel = new JLabel("  Choose Color:: ");
        JButton chooseColorButton = new JButton("  Select ");
        settingsFrame.add(colorLabel);
        settingsFrame.add(chooseColorButton);

        chooseColorButton.addActionListener(e -> countdownManager.chooseColor(settingsFrame));

        //Rate of color change
        JLabel speedLabel = new JLabel("  Color Change Speed (ms):: ");
        JComboBox<String> speedComboBox = new JComboBox<>(new String[]{"500","1000","2000","5000"});
        settingsFrame.add(speedLabel);
        settingsFrame.add(speedComboBox);

        //Start button
        JButton startButton = new JButton("  Start Countdown ");
        settingsFrame.add(startButton);

        startButton.addActionListener(e -> {
            try {
                int countdownValue = Integer.parseInt(countdownField.getText());
                int speed = Integer.parseInt((String) speedComboBox.getSelectedItem());
                countdownManager.startCountdown(countdownValue, speed, settingsFrame);
                Utils.disableControls(settingsFrame,false);
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(settingsFrame,"  Please enter a valid number.");
            }
        });

        //Stop button
        JButton stopButton = new JButton("  Stop coundown.");
        settingsFrame.add(stopButton);

        stopButton.addActionListener(e -> {
            countdownManager.stopCountdown();
            Utils.disableControls(settingsFrame,true);
        });




    }
}
