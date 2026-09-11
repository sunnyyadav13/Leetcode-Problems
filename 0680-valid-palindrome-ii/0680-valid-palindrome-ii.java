class Solution {
    boolean palindromicHelper(int i, int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i=0;
        int j= s.length()-1;

        while(i<j){

            if(s.charAt(i)!=s.charAt(j)){
            // use superpower of deletion
            // trying deleting either left or right and check
           return palindromicHelper(i,j-1,s) || palindromicHelper(i+1,j,s);
            }
            i++;
            j--;
        }
        return true;
    }
}