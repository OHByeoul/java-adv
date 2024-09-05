package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount{
    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: "+getClass().getSimpleName());
        //잔고가 출금액보다 적으면 진행하면 안됨

        synchronized (this) {
            log("[검증시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액 보다 많으면 진행
            log("[검증완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000);
            balance -= amount;

            log("[출금완료] 출금액: " + amount + ", 잔액: " + balance);
        }


        log("거래 종료");
        return false;
    }

    @Override
    public synchronized int getBalance() {
        return this.balance;
    }
}
