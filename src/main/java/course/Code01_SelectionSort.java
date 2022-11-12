package course;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 将所选择的元素下标作为临时变量的值，依次与后面的元素进行比较，如果遇到比其更小（大）的
 * 将临时变量替换为该值的下标，再继续向后比较，直至最后一个元素
 * 此时将临时变量下标对应元素与该轮选择的元素进行替换
 * <p>
 * 时间复杂度为 O(n^2)
 */
public class Code01_SelectionSort {

    private static void selectionSort(int[] arr) {
        //先判断临界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
        0-N-1 找到最小值，放到0位置上
        1-n-1 找到最小值，放到1位置上
        i-n-1 找到最小值，放到i位置上
         */
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //i-n-1 找到最小值下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        if (i != minIndex) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 6, 7, 8, 9, 4, 2, 6};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
