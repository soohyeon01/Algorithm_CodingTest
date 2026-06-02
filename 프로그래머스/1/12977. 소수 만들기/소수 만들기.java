/**
 * 세개의 숫자를 더해 소수가 되는 경우의 수를 구함
 */

class Solution {
    public int solution(int[] nums) {

        int answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPrime(int sum) {

        // 1이면 소수 -> 세 개의 숫자의 합은 항상 3이상

        for (int i = 2; i * i <= sum; i++) {
            // 약수가 존재하면 false
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}