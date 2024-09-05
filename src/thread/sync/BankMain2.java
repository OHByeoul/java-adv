package thread.sync;

import static util.MyLogger.log;

public class BankMain2 {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV2 bankAccountV2 = new BankAccountV2(1000);
        Thread t1 = new Thread(new WithdrawTask(bankAccountV2, 800), "t1");

        t1.start();
        Thread t2 = new Thread(new WithdrawTask(bankAccountV2, 800), "t2");
        t2.start();

        t1.join();
        t2.join();

        log("최종 잔액: "+bankAccountV2.getBalance());
    }
}
