package workday;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayReduction {
    public static void main(String[] args) {
        int input[] = {1,2,3,4};
        System.out.println(reductionCost(input));
    }

    static int reductionCost(int[] num) {
//        Arrays.sort(num);
//        List<Integer> l = Arrays.asList(num);
//        Integer[] copy = (Integer[])l.toArray();
//        int minPos = 0;
//        int sum = 0;
//        while (minPos + 1 < copy.length){
//            int tempSum = copy[minPos] + copy[minPos+1];
//            sum += tempSum;
//            List l2 = Arrays.asList(copy);
//            copy = (Integer[])l2.toArray();
//        }
//        return sum;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num.length; i++) {
            pq.add(num[i]);
        }
        Integer sum = 0;
        while (pq.size() > 1){
            Integer num1 = pq.poll();
            Integer num2 = pq.poll();
            System.out.println("Adding "+num1+" and "+num2);
            int temp = num1 + num2;
            sum += temp;
            pq.add(temp);
        }
        return sum;
    }
}
