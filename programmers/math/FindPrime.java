package programmers.math;

public class FindPrime {

    public int solution(int n) {
        boolean[] notPrime = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); ++i)
            for (int j = i * 2; j < notPrime.length; j += i)
                notPrime[j] = true;
        int count = 0;
        for (int i = 2; i <= n; ++i)
            if (!notPrime[i])
                count++;
        return count;
    }
}
