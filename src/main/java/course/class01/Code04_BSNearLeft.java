package course.class01;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author t_halo
 * @date 2022/11/15 22:54
 * <p>
 * 在一个有序数组中，找>=某个数最左侧的位置
 * 如 1,2,4,5,6,7,7,8,8,9,10 中，找到 >= 7 最左侧的位置,找到的位置为5
 */
public class Code04_BSNearLeft {

    private static int nearLeft(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        int mid;
        //因为存在只有一个数的情况，所以l=r时也需要进行判断
        while (l <= r) {
            //防止溢出
            mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                //因为需要找出最左的位置
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(20, 1000);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int value = (int) ((100 + 1) * Math.random());
        System.out.println(nearLeft(arr, value));
    }

}
