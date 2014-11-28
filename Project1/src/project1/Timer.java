package project1;

import javax.swing.JOptionPane;

/**
 * Class use to counting the time needed to perform the function, used in the
 * assays.
 */
public class Timer implements Runnable {

    private int Time;
    private boolean Stop;

    public Timer() {
        Time = 0;
        Stop = false;
    }

    /**
     * Function counting time.
     */
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        while (!Stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage() +"Interrupted Exception in timer", "Error Message",JOptionPane.ERROR_MESSAGE);
            }
            Time++;
        }
    }

    /**
     * Function countdown begins operation.
     *
     * @param time int Set start time.
     */
    public void BeginTimer(int time) {
        Time = time;
    }

    /**
     * Function stoppeed counting operation.
     *
     * @param state Boolean pauses or resumes Timer.
     */
    public void Stopped(boolean state) {
        Stop = state;
    }

    /**
     * Function return the Time which is counting.
     *
     * @return int is actually time.
     */
    public int ReturnTime() {
        return Time;
    }

}
