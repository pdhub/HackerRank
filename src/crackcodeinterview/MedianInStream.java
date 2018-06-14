package crackcodeinterview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {

    private static void addNumber(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
        /*Number comes
        * if both buckets empty
        *   add to max bucket
        * else if buckets are equal ?
        *   ask to stay under min bucket
        *       if can stay under min bucket, i.e ele > than min.peek()
        *           add to min bucket and max eats from min bucket
        *       else
        *           goes under max bucket
        * else
        *   ask to stay under max bucket
        *       if can stay under max bucket, i.e ele < max.peek()
        *           adds to max bucket, min eats from max bucket
        *       else
        *           adds to min bucket*/

    }

    private static void reBalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        PriorityQueue<Integer> lowerHeap = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> higherHeap = minHeap.size() < maxHeap.size() ? maxHeap : minHeap;
        if (higherHeap.size() - lowerHeap.size() >= 2){
            lowerHeap.add(higherHeap.poll());
        }
    }

    private static void findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == maxHeap.size())
            System.out.println(((double)maxHeap.peek()+minHeap.peek())/2);
        else
            System.out.println((double)maxHeap.peek());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = {12,
                4,
                5,
                3,
                8,
                7};
//        for (int i = 0; i < n; i++) {
//            int aItem = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//            a[i] = aItem;
//        }
        findRunningMean(a);
        //scanner.close();
    }

    public static void findRunningMean(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            addNumber(minHeap, maxHeap, arr[i]);
            //reBalance(minHeap, maxHeap);
            findMedian(minHeap, maxHeap);
        }
    }

}
