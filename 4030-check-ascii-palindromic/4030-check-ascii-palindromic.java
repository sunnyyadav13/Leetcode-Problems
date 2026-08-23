class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        // conversion in binary string
        for (char c : s.toCharArray()) {
            int ascii = (int) c;

            int i = 7;
            while(i>=0){
                sb.append((ascii >> i) & 1); 
                // right shift and then extract single bit
                i--;
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}