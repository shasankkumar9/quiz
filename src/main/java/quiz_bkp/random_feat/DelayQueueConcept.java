//package random_feat;
//
//import java.util.concurrent.DelayQueue;
//
//public class DelayQueueConcept {
//    public static void main(String[] args) throws InterruptedException {
//        final DelayQueue<DelayedEvent> delayQueue = new DelayQueue<>();
//        final long timeFirst = System.currentTimeMillis() + 10000;
//        delayQueue.offer(new DelayedEvent(timeFirst, "1"));
//        System.out.println("Done");
//        System.out.println(delayQueue.take().msg());
//    }
//
//}
