package thread.question;

import static util.MyLogger.log;

public class CounterThread extends Thread{
    public void run() {
        for(int i = 1; i<=5; i++) {
            try {
                log("thread run value: "+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
