package lesson003.onclass;

public class QuickSelect extends Common {
    public static void main(String[] args) {
        //int[] nums = new int[] {3, 1, 2, 5, 0, 9, 4, 7, 6};
        int[] nums = new int[] {30, 10, 20, 50, 0, 90, 40, 70, 60};
        int k = 8;
        int result = quickSelect(nums, k);
    }

    private static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, k,0, nums.length - 1);
    }

    private static int quickSelect(int[] nums, int k, int left, int right) {
        int pivot = nums[getRandomNumber(left, right)];
        int pivotIndex = dutchFlagPartition(nums, pivot);
        if(pivotIndex == k) {
            return pivot;
        }
        if(pivotIndex > k) {
            return quickSelect(nums, k, left, pivotIndex);
        }
        return quickSelect(nums, k, pivotIndex, right);
    }
}
