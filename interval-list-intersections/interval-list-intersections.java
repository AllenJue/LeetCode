class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Queue<int[]> intervalFirst = new LinkedList<>();
        for(int[] interval : firstList) {
            intervalFirst.offer(interval);
        }
        List<int[]> temp = new ArrayList<>();
        // go while there are possible intersections
        for(int i = 0; i < secondList.length && !intervalFirst.isEmpty(); i++) {
            int start = secondList[i][0];
            int end = secondList[i][1];
            // clean buffer
            while(!intervalFirst.isEmpty() && intervalFirst.peek()[1] < start) {
                intervalFirst.poll();
            }

            while(!intervalFirst.isEmpty() && intervalFirst.peek()[1] >= start && intervalFirst.peek()[1] <= end) {
                int startIntersection = Math.max(intervalFirst.peek()[0], start);
                int endIntersection = Math.min(intervalFirst.peek()[1], end);
                temp.add(new int[] {startIntersection, endIntersection});
                intervalFirst.poll();
            }
            if(!intervalFirst.isEmpty() && (intervalFirst.peek()[0] <= end && intervalFirst.peek()[0] >= start || (start >= intervalFirst.peek()[0] && end <= intervalFirst.peek()[1]))) {
                int startIntersection = Math.max(intervalFirst.peek()[0], start);
                int endIntersection = Math.min(intervalFirst.peek()[1], end);
                temp.add(new int[] {startIntersection, endIntersection});
            }
        }
        int[][] ans = new int[temp.size()][2];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}