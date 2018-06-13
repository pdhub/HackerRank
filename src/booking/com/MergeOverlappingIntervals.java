package booking.com;

import java.util.*;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        merge_overlapping_intervals();
    }

    static void merge_overlapping_intervals() {
        Scanner in = new Scanner(System.in);
        int numIntervals = in.nextInt();
        List<Interval> intervals = new ArrayList<Interval>();
        while (numIntervals-- > 0){
            int start = in.nextInt();
            int end = in.nextInt();
            intervals.add(new Interval(start, end));
        }
        mergeInterVals(intervals);
    }

    private static void mergeInterVals(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.getStart()-b.getStart());
        Stack<Interval> stack = new Stack<>();
        for (Interval curr : intervals){
            if (stack.isEmpty() || curr.getStart() > stack.peek().getEnd()){
                stack.push(curr);
            }
            if (stack.peek().getEnd() < curr.getEnd()){
                stack.peek().setEnd(curr.getEnd());
            }
        }

        System.out.println(stack.size());
        printStack(stack);
    }

    private static void printStack(Stack<Interval> stack) {
        if (!stack.isEmpty()) {
            Interval interval = stack.pop();
            printStack(stack);
            System.out.println(interval);
        }
        return;
    }

    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String
        toString() {
            return start + " " + end;
        }
    }
}
