package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("Start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread thread1 = new Thread(sumTask1, "theard-1");
        Thread thread2 = new Thread(sumTask2, "theard-2");

        thread1.start();
        thread2.start();

        // 스레드가 종료될 때까지 대기
        log("join(1000) - main 스레드가 thread1 종료때까지 1초 대기");
        thread1.join(1000);
        log("main 스레드 대기 완료");


        log("task1.result = "+sumTask1.result);
        log("task2.result = "+sumTask2.result);
        int sumAll = sumTask1.result + sumTask2.result;
        log("sumAll = "+sumAll);

        log("End");

    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업완료 result = "+result);
        }
    }

}
