package thread.control;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = "+mainThread);
        log("mainThread.threadId = "+mainThread.threadId());
        log("mainThread.threadPriority = "+mainThread.getPriority());
        log("mainThread.threadThreadGroup = "+mainThread.getThreadGroup());

    }
}
