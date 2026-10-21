class Solution {
    public int numPrimeArrangements(int n) {
        int mod = 1000000007;

        int primeCount = 0;

        // Count prime numbers from 1 to n

        for (int i = 2; i <= n; i++) {

            if (isPrime(i)) {

                primeCount++;

            }

        }

        int nonPrimeCount = n - primeCount;

        // Calculate factorials

        long primeFact = 1;

        long nonPrimeFact = 1;

        for (int i = 2; i <= primeCount; i++) {

            primeFact = (primeFact * i) % mod;

        }

        for (int i = 2; i <= nonPrimeCount; i++) {

            nonPrimeFact = (nonPrimeFact * i) % mod;

        }

        return (int) ((primeFact * nonPrimeFact) % mod);
    }
     private boolean isPrime(int num) {

        if (num < 2) {

            return false;

        }

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                return false;

            }

        }

        return true;

    }
}