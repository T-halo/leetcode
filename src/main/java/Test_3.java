import java.util.Scanner;

/**
 * @author li yong
 * @date 2021/6/28 17:46
 * <p>
 * 2520是最小的能够被1到10整除的数。
 * <p>
 * 最小的能够被1到20整除的正数是多少？
 */
public class Test_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int num = smallestMultiple(i);
        System.out.println(num);
    }

    private static int smallestMultiple(int num) {
        int product = num * (num - 1);      //1到n的最小公倍数也是n*(n-1)的倍数
        int m = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            m = product * i;        //通过不断将n*(n-1)扩大，寻找能同时被1到n整除的数
            for (int j = 2; j <= num; j++) {
                if (m % j != 0) {       //如果余数不为0，说明当前倍数不能被j整除
                    break;
                }
                if (j == num) {
                    return m;       //找到1到n的最小公倍数
                }
            }
        }
        return m;
    }
}
