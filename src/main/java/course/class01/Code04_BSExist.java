package course.class01;

/**
 * @author t_halo
 * @date 2022/11/15 22:12
 * <p>
 * 在一个有序数组中，找某个数是否存在
 * <p>
 * 由于是有序数组，可以使用二分法来快速找到是否存在该数
 *
 * 时间复杂度为 O(logn)
 */
public class Code04_BSExist {

    private static boolean exist(int[] arr, int num) {
        //先进行临界条件判断
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        //当不满足条件时，说明两边界已经相遇，退出循环
        while (l < r) {
            //假如数组大小有两十亿，用(l + r) >> 1计算中间值时，可能l + r会溢出
            mid = l + ((r - l) >> 1);
            if (arr[mid] > num) {
                r = mid - 1;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return arr[l] == num;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 7, 8, 9, 11, 15};
        int num = 10;
        System.out.println(exist(arr, num));
    }

}
