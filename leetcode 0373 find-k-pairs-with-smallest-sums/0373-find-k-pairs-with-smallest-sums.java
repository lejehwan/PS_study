class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        while (!minHeap.isEmpty() && k -- > 0) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            answer.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return answer;
    }
}