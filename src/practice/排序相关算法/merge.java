package practice.排序相关算法;

public class merge {
    public static void main(String[] args) {
        int[] temp = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        merge merge = new merge();
        merge.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    private void sort(int[] array) {
        array= mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(array, left, mid);
        int[] rightArray = mergeSort(array, mid + 1, right);
        int[] tempArray = new int[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                tempArray[k++] = leftArray[i++];
            } else {
                tempArray[k++] = leftArray[j++];
            }
        }
        while (i < leftArray.length) {
            tempArray[k++] = leftArray[i++];
        }
        while (j < leftArray.length) {
            tempArray[k++] = leftArray[j++];
        }
        return tempArray;
    }
}
