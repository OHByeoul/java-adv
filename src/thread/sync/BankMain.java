package thread.sync;

import static util.MyLogger.log;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV1 bankAccountV1 = new BankAccountV1(1000);
        Thread t1 = new Thread(new WithdrawTask(bankAccountV1, 800), "t1");

        t1.start();
        Thread t2 = new Thread(new WithdrawTask(bankAccountV1, 800), "t2");
        t2.start();

        t1.join();
        t2.join();

        log("최종 잔액: "+bankAccountV1.getBalance());
    }
}
