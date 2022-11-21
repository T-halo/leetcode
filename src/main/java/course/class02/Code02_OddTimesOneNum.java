package course.class02;

/**
 * @author t_halo
 * @date 2022/11/21 21:49
 * <p>
 * 在一个数组中，有一个数出现了奇数次，其他数出现偶数次，打印出该数
 * <p>
 * 有两种方法
 * 1、使用 hash 表，将每个数和它对应出现的次数put进表中，然后遍历hash表，对2取余，找出该数
 * <p>
 * 2、使用异或的特性，0^n=n,n^n=0,且满足交换律和结合律
 * 出现偶数次的数最后异或都会变为0，而奇数次的最后异或会剩下来。
 */
public class Code02_OddTimesOneNum {

    private static int printOneOddTimesNum(int[] arr) {
        int num = 0;
        for (int j : arr) {
            num ^= j;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 4, 6, 6, 3, 5, 5, 5};
        int num = printOneOddTimesNum(arr);
        System.out.println(num);
    }

}
