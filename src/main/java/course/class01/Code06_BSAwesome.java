package course.class01;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author t_halo
 * @date 2022/11/17 22:33
 * <p>
 * 局部最小值，找到一个区间内的最小值，相邻的两个数不相等，其两边的数都大于它
 * 如[3,6,4,3,7,9,2,5,1]中，位置处于0,3,6,8的数都是区间最小值
 * <p>
 * 当区间内数字趋势有变化时，该区间内必有一个转折点，即极值，就是说左边呈下降趋势，而右边呈上升趋势时，该区间内必有一个最小值
 * 通过比较两边的大小趋势，可以找出有最小值的区间，由于这种性质，可以使用二分法
 *
 * 最大时间复杂度：O(log n)
 */
public class Code06_BSAwesome {

    private static int getLessIndex(int[] arr) {
        int index = -1;
        //判断临界条件
        if (arr == null || arr.length == 0) {
            return index;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        //当上述条件都不满足时，最左边趋势下降，最右边趋势升高，说明区间最小值只会在中间
        int l = 1;
        int r = arr.length - 2;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        //循环条件不满足只会是l=r，所以返回l和r都一样
        return l;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(getLessIndex(arr));
    }

}