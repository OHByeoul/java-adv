thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV3 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printer1 = new Thread(printer, "printer");
        printer1.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("프린터할 문서 입력. 종료 (q): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                printer1.interrupt();
                break;
            }

            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();


        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String poll = jobQueue.poll();
                log("출력 시작 : "+poll+", 대기 문서: "+jobQueue);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
                log("출력 완료");
            }
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }

}
