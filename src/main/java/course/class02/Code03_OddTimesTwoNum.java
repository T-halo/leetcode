package course.class02;

/**
 * @author t_halo
 * @date 2022/11/21 22:12
 * <p>
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 * <p>
 * 和上题一样，有两种方法
 * 1、使用 hash 表，将每个数和它对应出现的次数put进表中，然后遍历hash表，对2取余，找出这两个数
 * <p>
 * 2、使用异或方法，
 * 在所有元素异或后，剩下a^b
 * 通过a^b的最右边1，来区分相同位置为0的数和为1的数
 * 然后分别异或找出一个数
 */
public class Code03_OddTimesTwoNum {

    private static void printOddTimesNum(int[] arr) {
        //假设两个奇数次数分别是a和b
        int tmp = 0;
        for (int i : arr) {
            //结束后，tmp=a^b
            tmp ^= i;
        }
        //取tmp最右位的1，由于a^b，所以最右位1位置上 a和b肯定不相同
        //-tmp = (~tmp + 1)
        //假设 tmp：00011000 ~tmp: 11100111 -tmp：11101000
        //rightOne = 00001000
        //通过 rightOne 来区分 a 和 b
        int rightOne = tmp & (-tmp);
        int num1 = 0;
        for (int j : arr) {
            if ((j & rightOne) == 0) {
                num1 ^= j;
            }
        }
        int num2 = tmp ^ num1;
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 4, 6, 6, 3, 5, 5, 5, 7};
        printOddTimesNum(arr);
    }
}
