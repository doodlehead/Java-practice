import java.util.*;

public class CountPrimes {
    //V1: Check all the number below to see if they're prime
    //Runtime: 361 ms
    //Memory Usage 44.7 MB
    public int countPrimesV1(int n) {
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
        return primeList.size();
    }

    //V2:
    //Runtime: 14 ms
    //Memory usage: 38.2 MB
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        //1 = not prime, 0 = prime
        byte[] primeList = new byte[n];
        primeList[0] = 0b1;
        primeList[1] = 0b1;
        int primeCount = 0;

        for (int i = 2; i < primeList.length; i++) {
            if (primeList[i] == 0b0) {
                primeCount++;
                //Mark the multiples of i as not-prime
                for (int p = 2; p * i < n; p++) {
                    primeList[p * i] = 0b1;
                }
            }
            //Ignore i if it's not prime
        }
        return primeCount;
    }
}
