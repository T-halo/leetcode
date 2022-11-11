package subaccount;

/**
 * @author li yong
 * @date 2021/6/29 11:38
 * <p>
 * 列出前6个素数，它们分别是2、3、5、7、11和13。我们可以看出，第6个素数是13。
 * <p>
 * 第10,001个素数是多少？
 */
public class Test_5 {

    public static void main(String[] args) {
        int i = first10001_num(10001);
        System.out.println(i);
    }

    private static int first10001_num(int num) {
        //素数是从2开始，循环直接从2开始计算
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isPrimeNumber(i)) {
                num--;
                if (num == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean isPrimeNumber(long x) {
        //如果小于2则不是素数
        if (x < 2) {
            return false;
        }
        //2是最小的素数
        if (x == 2) {
            return true;
        }
        //如果 x&1 == 0，则该数为偶数，肯定能被2整除，不是素数
        if ((x & 1) == 0) {
            return false;
        }
        // 因为如果它不是质数，那么它一定可以表示成两个数（除了1和它本身）相乘
        // 这两个数必然有一个小于等于它的平方根。只要找到小于或等于的那个就行了
        int max = (int) Math.sqrt(x);
        for (int i = 3; i <= max; i += 2) {
            //如果余数等于0，则该数不是质数
            if ((x % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
