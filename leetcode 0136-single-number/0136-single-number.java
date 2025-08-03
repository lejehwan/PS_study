class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.remove(num);
            else map.put(num, num);
        }

        return map.keySet().iterator().next();
    }
}