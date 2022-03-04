import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.IntConsumer;


class Main {
    public static void main(String[] args) {

        int n = 2;

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        StringBuilder stringBuilder = new StringBuilder();

        IntConsumer intConsumer = stringBuilder::append;

        Thread A = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread B = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread C = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for(int i = 1; i <= n; i++){
            A.run();
            if(i % 2 == 0)
                B.run();
            else
                C.run();
        }

        System.out.println(stringBuilder);

    }
}
class ZeroEvenOdd {

    private final ReentrantLock zeroLock = new ReentrantLock();
    private int count = 1;

    public ZeroEvenOdd(int n) {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);
        zeroLock.lock();
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        if(count % 2 == 0)
            printNumber.accept(count);
        count++;
        zeroLock.unlock();
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {

        if(count % 2 != 0)
            printNumber.accept(count);
        count++;
        zeroLock.unlock();
    }
}