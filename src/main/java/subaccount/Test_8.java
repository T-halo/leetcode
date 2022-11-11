package subaccount;

/**
 * @author li yong
 * @date 2021/6/30 17:04
 * <p>
 * 所有小于10的素数的和是2 + 3 + 5 + 7 = 17。
 * <p>
 * 求所有小于两百万的素数的和。
 */
public class Test_8 {

    public static void main(String[] args) {
        System.out.println(count(2000000));
    }

    private static long count(int num) {
        long count = 0;
        for (int i = 0; i < num; i++) {
            boolean prime = isPrime(i);
            if (prime) {
                count += i;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if ((num & 1) == 0) {
            return false;
        }
        int x = (int) Math.sqrt(num);
        for (int i = 3; i <= x; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
