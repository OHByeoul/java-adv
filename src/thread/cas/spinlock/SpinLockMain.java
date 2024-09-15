package thread.cas.spinlock;

import static util.MyLogger.log;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                spinLock.lock();
                log("비즈니스 로직 실행");
                spinLock.unlock();
//                spinLockBad.lock();
//                // critical section
//                log("비즈니스 로직 실행");
//                spinLockBad.unlock();

            }
        };

        Thread thread = new Thread(task, "Thread-1");
        Thread thread2= new Thread(task, "Thread-2");

        thread.start();
        thread2.start();
    }
}
