import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j= nums.length-1;

        int k = nums.length-1;

        int[] res = new int[nums.length];

        while(i<=j){
            int leftSq = nums[i]*nums[i];
            int rightSq = nums[j]*nums[j];

            if(rightSq>leftSq){
                res[k]= rightSq;
                j--;
            }
            else{
                res[k]= leftSq;
                i++;
            }

            k--;

        }

        return res;
    }
}