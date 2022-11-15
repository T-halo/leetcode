package course.class01;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author t_halo
 * @date 2022/11/16 0:03
 * <p>
 * 在一个有序数组中，找<=某个数最右侧的位置
 * * 如 1,2,4,5,6,7,7,8,8,9,10 中，找到 <= 7 最右侧的位置,找到的位置为6
 */
public class Code05_BSNearRight {

    private static int nearRight(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        int mid;
        while (l <= r) {
            //防止溢出
            mid = l + ((r - l) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(1, 1000);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int value = (int) ((100 + 1) * Math.random());
        System.out.println(value);
        System.out.println(nearRight(arr, value));
    }


}
