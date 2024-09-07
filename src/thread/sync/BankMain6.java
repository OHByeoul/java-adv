package thread.sync;

import static util.MyLogger.log;

public class BankMain6 {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV6 bankAccountV6 = new BankAccountV6(1000);
        Thread t1 = new Thread(new WithdrawTask(bankAccountV6, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(bankAccountV6, 800), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log("최종 잔액: "+bankAccountV6.getBalance());
    }
}
