public class Solution {
    
    // 메인 메서드: 방식 선택
    public int[] searchRange(int[] nums, int target) {
        // return arrayBinarySearchRange(nums, target);
        return binarySearchRange(nums, target);
    }

    public int[] binarySearchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int[] arrayBinarySearchRange(int[] nums, int target) {
        int index = java.util.Arrays.binarySearch(nums, target);
        if (index < 0) return new int[]{-1, -1};

        int left = index;
        int right = index;
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }
}
