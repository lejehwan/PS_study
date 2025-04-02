class Solution {
    public boolean canJump(int[] nums) {
        int jump = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= jump) {
                jump = Math.max(jump, i + nums[i]);
            } else {
                return false;
            }
        }
        return nums.length - 1 <= jump;
    }
}