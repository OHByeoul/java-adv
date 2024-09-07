package thread.sync;

import static util.MyLogger.log;

public class BankMain5 {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV5 bankAccountV5 = new BankAccountV5(1000);
        Thread t1 = new Thread(new WithdrawTask(bankAccountV5, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(bankAccountV5, 800), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log("최종 잔액: "+bankAccountV5.getBalance());
    }
}
