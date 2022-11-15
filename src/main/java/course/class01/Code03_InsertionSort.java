package course.class01;

import java.util.Arrays;


/**
 * @author t_halo
 * @date 2022/11/12 21:33
 * <p>
 * 插入排序
 * <p>
 * 保证0-i内的元素有序，讲第i+1的元素依次与i到0的元素相比
 * 如果比其小（大），插入该有序序列位置，使0-i+1内的元素有序
 * <p>
 * 时间复杂度：最坏情况下为 O(n^2)
 */
public class Code03_InsertionSort {

    private static void insertionSort(int[] arr) {
        //先进行临界条件判断
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
        0-0 本来就有序，跳过，从1开始，循环次数-1
        0-1 进行排序
        0-2 进行排序
        0-n-1 进行排序
         */
        for (int i = 1; i < arr.length; i++) {
            /*
            当下标小于0时，说明已经到尽头，该序列已经有序，停止这一轮排序
            因为前面一个区间已经有序，如果后一个元素大于前一个元素，说明当前区间序列已经有序
             */
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int j1) {
//        int tmp = arr[j];
//        arr[j] = arr[j1];
//        arr[j1] = tmp;
        arr[j] = arr[j] ^ arr[j1];
        arr[j1] = arr[j] ^ arr[j1];
        arr[j] = arr[j] ^ arr[j1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 9, 2, 8, 7, 0};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
