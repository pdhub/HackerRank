package audiblesse;

import java.util.HashSet;
import java.util.Set;

public class SumOfPairs {
    public static void main(String[] args) {
        int[] a = {1, 3, 46, 1, 3, 9};
        long k = 47;
        System.out.println(numberOfPairs(a, k));
    }

    static int numberOfPairs(int[] a, long k) {
        int count = 0;
        Set<Long> set = new HashSet<>();
        Set<Pair> res = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(k-a[i])) {
                res.add(new Pair(a[i], (int)(k-a[i])));
            }
            else
                set.add((long)a[i]);
        }
        return res.size();
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

//            if (x != pair.x) return false;
//            return y == pair.y;
            if ((x == pair.x && y == pair.y) ||
            (x == pair.y && y == pair.x))
                    return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
