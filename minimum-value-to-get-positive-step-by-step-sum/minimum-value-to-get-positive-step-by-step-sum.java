class Solution {
    public int minStartValue(int[] nums) {
        int start = 1;
        int ans = 1;
        for(int i : nums) {
            start += i;
            if(start <= 0) {
                ans += Math.abs(start) + 1;
                start = 1;
            }
        }
        return ans;
    }
}