package thread.sync;

import static util.MyLogger.log;

public class BankMain4 {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV4 bankAccountV4 = new BankAccountV4(1000);
        Thread t1 = new Thread(new WithdrawTask(bankAccountV4, 800), "t1");

        t1.start();
        Thread t2 = new Thread(new WithdrawTask(bankAccountV4, 800), "t2");
        t2.start();

        t1.join();
        t2.join();

        log("최종 잔액: "+bankAccountV4.getBalance());
    }
}
