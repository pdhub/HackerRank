package workday2;

public class OddDivisors {
    public static void main(String[] args) {
        int[] numbers = {21,11,7};
        System.out.println(countSum(numbers));
    }

    static long countSum(int[] numbers) {
        long sum = 0;
        for(int num : numbers){
            sum += oddDivisorSum(num);
        }
        return sum;
    }

    private static long oddDivisorSum(int n) {
        int res = 1;
        while (n % 2 == 0)
            n = n / 2;

        for (int i = 3; i <= Math.sqrt(n); i++) {
            int curr_sum = 1;
            int curr_term = 1;
            while (n % i == 0) {
                n = n / i;
                curr_term *= i;
                curr_sum += curr_term;
            }
            res *= curr_sum;
        }
        if (n >= 2)
            res *= (1 + n);

        return res;
    }
}

