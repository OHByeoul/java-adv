package thread.question;

import static util.MyLogger.log;

public class ServeralThreadMain {
    public static void main(String[] args) {
//        ThreadA threadA = new ThreadA();
//        ThreadB threadB = new ThreadB();
//        threadA.start();
//        threadB.start();
        Thread threadA = new Thread(new RunnableAB("A", 1000),"AAA");
        Thread threadB = new Thread(new RunnableAB("B", 500), "BBB");
        threadA.start();
        threadB.start();
    }

    static class RunnableAB implements Runnable {
        private String content;
        private int sleep;

        public RunnableAB(String content, int sleep) {
            this.content = content;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            while(true) {
                log(": " + content);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    static class ThreadA extends Thread {
        public void run() {
            while (true) {
                log(": A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class ThreadB extends Thread {
        public void run() {
            while (true) {
                log(": B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
