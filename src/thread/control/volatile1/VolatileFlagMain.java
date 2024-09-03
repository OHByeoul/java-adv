package thread.control.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        log("runFlag = "+myTask.runFlag);
        thread.start();

        log("runFlag를 false로 변경 시도");
        sleep(1000);
        myTask.runFlag = false;
        log("runFlag = "+myTask.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
//        boolean runFlag = true;
        volatile boolean runFlag = true; // volatile을 사용하면 캐시메모리에서 읽지 읺고 메인메모리에서 읽는다.
        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {

            }
            log("task 종료");

        }
    }

}
