package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV5 implements BoundedQueue {
    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while (queue.size() == max) {
                log("put 큐가 꽉 참 / 생산자 대기");
                try {
                    producerCondition.await();
                    log("put 생산자가 꽉 참");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("put 생산자 데이터 저장 consumerCondition.signal() 호출");
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("큐에 데이터가 없음 소비자 대기");
                try {
                    consumerCondition.await();
                    log("take 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("take 소비자 데이터 획득 producerCondition.signal()호출");
            producerCondition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
