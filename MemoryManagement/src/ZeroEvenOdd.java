import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private final int n;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);
    private final AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i++)
        {
            while(!atomicBoolean.get())
                wait();

            printNumber.accept(0);

            atomicBoolean.set(false);

            notifyAll();
        }


    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i++)
        {

            while((atomicInteger.get() % 2 != 0 || atomicBoolean.get()) && atomicInteger.get() <= n)
                wait();

            if(atomicInteger.get() > n){
                notifyAll();
                return;
            }

            atomicBoolean.set(true);

            printNumber.accept(atomicInteger.getAndIncrement());

            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i++)
        {
            while((atomicInteger.get() % 2 == 0 || atomicBoolean.get()) && atomicInteger.get() <= n)
                wait();

            if(atomicInteger.get() > n){
                notifyAll();
                return;
            }

            atomicBoolean.set(true);

            printNumber.accept(atomicInteger.getAndIncrement());

            notifyAll();
        }
    }
}