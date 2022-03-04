import java.lang.ref.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryHeap {

    public static void main(String[] args)  {

        executeWeakReference();
        executePhantomReference();
    }


    private static void printAvailableMemory(){

        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("Total Memory: " + heapSize + " Max Memory: " + heapMaxSize + " Free Memory: " + heapFreeSize);
    }

    public static void executeWeakReference(){
        System.out.println("Executing Weak Reference Sample");
        final ReferenceQueue<TextView> referenceQueue = new ReferenceQueue<>();

        TextView[] textViews = new TextView[5];
        Arrays.setAll(textViews, n -> new TextView());

        System.out.println("Data collection: ");
        System.out.println(Arrays.toString(textViews));

        Executor<TextView> executor = new Executor<>(referenceQueue, textViews);

        printAvailableMemory();

        Arrays.fill(textViews, null);
        System.out.println("Clearing references: ");
        System.out.println(Arrays.toString(textViews));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try(executor.thread){
            System.out.println("aliveFirst is dying " + executor.thread.aliveFirst);
            System.out.println("aliveMid is dying " + executor.thread.aliveMid);
            System.out.println("aliveLast is dying " + executor.thread.aliveLast);
        }
        catch (Exception ignored){

        }
        finally {
            System.gc();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After GC Computed");
        printAvailableMemory();


        Thread referenceQueueThread = new Thread(() -> {
            Reference<? extends TextView> reference;
            while((reference = referenceQueue.poll()) != null) {
                System.out.println(reference.get());
            }
        });

        referenceQueueThread.start();
    }

    public static void executePhantomReference(){

        System.out.println("Executing Phantom Reference Sample");

        final ReferenceQueue<TextView> referenceQueue = new ReferenceQueue<>();

        ArrayList<PhantomTextView> phantomReferences = new ArrayList<>();
        ArrayList<TextView> textViews = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            TextView textView = new TextView();
            textViews.add(textView);
            phantomReferences.add(new PhantomTextView(textView, referenceQueue));
        }


        printAvailableMemory();

        System.out.println("Data collection: ");
        System.out.println(textViews);

        textViews = null;

        System.gc();


        try {
            Thread.sleep(1000);

            System.out.println("After GC Computed");
            printAvailableMemory();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(PhantomTextView phantomTextView : phantomReferences){
            System.out.println(phantomTextView.isEnqueued());
        }

        Thread referenceQueueThread = new Thread(() -> {
            Reference<? extends TextView> reference;
            try {
                reference = referenceQueue.remove();
                while(reference != null) {
                    System.out.println("Reference " + reference.get());
                    reference = referenceQueue.remove();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        referenceQueueThread.start();

    }

    // Inner class
    static class AsyncTask extends Thread implements AutoCloseable {

        public TextView aliveFirst;
        public TextView aliveMid;
        public TextView aliveLast;

        public List<WeakReference<TextView>> weakReferences = new ArrayList<>();

        private AtomicInteger attempts = null;

        public AsyncTask(ReferenceQueue<? super TextView> referenceQueue, TextView... textView){
            int i = 0;
            for(TextView ref : textView){
                ref.setId(i++);
                weakReferences.add(0, new WeakReference<>(ref, referenceQueue));
            }

            aliveFirst = weakReferences.get(4).get();
            aliveMid = weakReferences.get(2).get();
            aliveLast = weakReferences.get(0).get();

            attempts = new AtomicInteger(i-1);
        }

        @Override
        public void run() {

            while(attempts.getAndDecrement() > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(weakReferences.get(attempts.get()).get() == null) {
                    System.out.println("Stopped by Garbage Collector");
                    break;
                }

                System.out.println("Periodically execute: " + weakReferences.get(attempts.get()).get());
            }
        }

        @Override
        public void close() throws Exception {
            aliveFirst = null;
            aliveMid = null;
            aliveLast = null;
        }
    }
}



class Executor <T extends TextView> {

    public final MemoryHeap.AsyncTask thread;

    public Executor(ReferenceQueue<? super TextView> referenceQueue, T... textViews){
        thread = new MemoryHeap.AsyncTask(referenceQueue, textViews);
        thread.start();
    }
}

class TextView {
    private int id = 0;

    @Override
    public String toString() {
        return "My hashCode is: " + this.hashCode() + " id: " + id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class PhantomTextView extends PhantomReference<TextView> {
    public PhantomTextView(TextView referent, ReferenceQueue<? super TextView> q) {
        super(referent, q);
    }
}

class Printer {
    public Printer(){

    }
    public void printAvailableMemory(){

        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase
        // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("Total Memory: " + heapSize + " Max Memory: " + heapMaxSize + " Free Memory: " + heapFreeSize);
    }
}
