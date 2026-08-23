class Solution {

    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> primeCount = new HashMap<>();

        int left = 0;
        int differentPrimes = 0;
        int answer = 0;
        int right = 0;
        while (right < nums.length) {

            ArrayList<Integer> factors = getPrimeFactors(nums[right]);

            for (int prime : factors) {
                int count = primeCount.getOrDefault(prime, 0);

                if (count == 0) {
                    differentPrimes++;
                }

                primeCount.put(prime, count + 1);
            }

            while (differentPrimes > k) {

                ArrayList<Integer> leftFactors =
                        getPrimeFactors(nums[left]);

                for (int prime : leftFactors) {

                    int count = primeCount.get(prime) - 1;

                    if (count == 0) {
                        primeCount.remove(prime);
                        differentPrimes--;
                    } else {
                        primeCount.put(prime, count);
                    }
                }

                left++;
            }
            answer = Math.max(answer, right - left + 1);
            
            right++;
        }

        return answer;
    }

    private ArrayList<Integer> getPrimeFactors(int number) {

        ArrayList<Integer> factors = new ArrayList<>();

        for (int divisor = 2; divisor * divisor <= number; divisor++) {

            if (number % divisor == 0) {

                factors.add(divisor);
                while (number % divisor == 0) {
                    number /= divisor;
                }
            }
        }

        
        if (number > 1) {
            factors.add(number);
        }

        return factors;
    }
}