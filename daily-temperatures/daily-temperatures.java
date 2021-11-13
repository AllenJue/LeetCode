class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()] < cur) {
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}