package programmercarl.array;

//二分查找
public class Binary_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = left;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5};
        int target = 5;
        Binary_Search binarySearch = new Binary_Search();
        int search = binarySearch.search(nums, target);
        System.out.println(search);
    }
}
