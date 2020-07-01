import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        ArrayList<Integer> primeList = new ArrayList<>();
        primeList.add(2);

        outer: for (int i = 3; i < n; i += 2) {
            for (int prime: primeList) {
                if (i % prime == 0) {
                    //i is not prime, stop checking
                    continue outer;
                }
                if (prime > Math.sqrt(i)) break; //If no number under sqrt(i) was a divisor it's a prime
            }
            //It's prime
            primeList.add(i);
        }
        System.out.println(primeList);
        return primeList.size();
    }
}
