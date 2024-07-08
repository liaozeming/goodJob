package practice.其他;

public class search {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        search search = new search();
        int search1 = search.search(nums, target);
        System.out.println(search1);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left > nums.length - 1 || nums[left] != target ? -1 : left;
    }
}
