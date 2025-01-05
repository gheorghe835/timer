package timerApp;

public class PrinterTask {
    public static void main(String[] args) {
        System.out.println("  A Java application must be created with the Swing graphical user " +
                "\nenvironment. The application must start with a dialog with two options: Settings " +
                "\nand Close (shown in the picture)." +
                "\nClicking Close closes the application immediately. Clicking Settings opens the " +
                "\nfirst window, which should contain all the controls shown in the image below." +
                "\nAfter defining the time or within the defined time, the second window should " +
                "\nappear, whose background will change color, where the background color and the " +
                "\nspeed of change will depend on the settings in the first window.\n" +
                "\n" +
                "\nThe second window should be displayed after the time interval defined by the " +
                "\ntimer has expired. In the first case (onTime) - at the exactly set time (the form " +
                "\nHH:mm:ss), or in the second case (countdown) - after the chosen number of seconds " +
                "\n(the full positive number). Of course, one option disables the other.\n" +
                "\n" +
                "\nChoose color presents the palette for choosing the color, where after the color " +
                "\nis chosen, the color will be displayed in the label next to it. It is sufficient " +
                "\nto display the color in RGB format or to colorize the labels text. You can use " +
                "\none color of your choice or several. It is important that the chosen color " +
                "\nchanges to white or another color to get the blinking effect.\n" +
                "\n" +
                "\nThe drop-down list is used to choose the speed of color change in another " +
                "\nwindow. For minimum you can set 1000 milliseconds and for maximum you can set " +
                "\n5 seconds.\n" +
                "\n" +
                "\nThe Start Countdown key is used to start the timer, where all controls in the first " +
                "\nwindow become inactive except the Stop key. The entire application should close if the " +
                "\nClose(x) key is selected in the first window.\n" +
                "\nWhen the timer is active (while waiting for the second window to appear or while it is " +
                "\nbeing displayed), all controls in the first window are, apart from the Stop key, " +
                "\ndisabled.\n" +
                "\nClicking Stop stops the timer, the second window disappears and the controls in the " +
                "\nfirst window become accessible. \n" +
                "\n" +
                "\nNotes:\n" +
                "\nNote 1 - The Assignment must start with JOptionPane, as mentioned in the task, and " +
                "\nclicking on Settings opens a new form, which has a label and a button.\n" +
                "\n" +
                "\nThe label contains the current time, which is displayed in HH:mm:ss format and " +
                "\nchanges every second, i.e. Timer is activated immediately. The button is used for " +
                "\nchoosing the color for the given label" +
                "\nNote 2 - All the items in note 1, but the addition is that there is still a Stop button, " +
                "\nwhich can stop the Timer." +
                "\nNote 3 - Same functionality as note 2, but there is an additional button that can restart " +
                "\nthe clock. Also, the label has to change the color between the chosen red and the predefined " +
                "\ncolor (this happens every second, one second is the chosen color, the next second is red). " +
                "\nIt is assumed that the user will not choose red.");
    }
}
