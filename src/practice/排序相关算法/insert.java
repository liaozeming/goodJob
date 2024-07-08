package practice.排序相关算法;

public class insert {
    public static void main(String[] args) {
        int[] temp = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        insert insert = new insert();
        insert.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");

        }
    }

    private void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pre = i - 1;
            int temp = array[i];
            while (pre >= 0 && array[pre] > temp) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = temp;
        }
    }
}
