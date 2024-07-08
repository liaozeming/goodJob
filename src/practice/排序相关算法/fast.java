package practice.排序相关算法;

public class fast {
    public static void main(String[] args) {
        int[] temp = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        fast fast = new fast();
        fast.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    private void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        // 哨兵
        int temp = array[end];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (left < right && array[left] <= temp) {
                left++;
            }
            while (right > left && array[right] >= temp) {
                right--;
            }
            if (left < right) {
                int pre = array[left];
                array[left] = array[right];
                array[right] = pre;
            }
        }
        array[end] = array[left];
        array[left] = temp;
        // 左右排序
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }
}
