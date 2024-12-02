package neetcode.courses.dsa.factorial.onebranch;

public class OneBranchFactorial {

    // We can use recursion to compute n!
    // time complexity: O(n)
    // space complexity: O(n)
    public static int factorial(int n) {
        // Base case: n = 0 or 1
        if (n <= 1) {
            return 1;
        }

        // Recursive case: n! = n * (n - 1)!
        return n * factorial(n-1);
    }

    public static int iterativeFactorial(int n) {
        int res = 1;

        while (n > 1) {
            res = res * n;
            n--;
        }

        return res;
    }
}