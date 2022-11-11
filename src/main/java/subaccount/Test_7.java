package subaccount;

/**
 * @author li yong
 * @date 2021/6/30 15:03
 * <p>
 * 毕达哥拉斯三元组是三个自然数a < b < c组成的集合，并满足
 * <p>
 * a^2 + b^2 = c^2
 * <p>
 * 例如，3^2 + 4^2 = 9 + 16 = 25 = 5^2。
 * <p>
 * 有且只有一个毕达哥拉斯三元组满足 a + b + c = 1000。求这个三元组的乘积abc。
 */
public class Test_7 {

    public static void main(String[] args) {
        System.out.println(pythagorean(1000));
    }

    private static int pythagorean(int sum) {
        //因为根据毕达哥拉斯三元组的特性
        //可以认为是一个直角三角形的三条边
        //认为a为直角三角形的最短边，且不能等于b边，否则c会变成一个无理数——sqrt(2(a^2))，因此a边只能小于三分之一的
        for (int a = 1; a < sum / 3; a++) {
            //b需要比a大，且不能比c大，因此必须小于——和减去a的一半——(sum-a)>>1
            for (int b = a + 1; b < (sum - a) >> 1; b++) {
                int c = sum - a - b;
                if (b < c && (a * a + b * b == c * c)) {
                    return a * b * c;
                }
            }
        }
        return -1;
    }

}
