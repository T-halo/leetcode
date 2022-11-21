package course.class02;

/**
 * @author t_halo
 * @date 2022/11/19 23:43
 * <p>
 * 如何不使用额外变量交换两个数
 *
 * 由于 0^n=n,n^n=0，且异或满足交换律和结合律
 */
public class Code01_Swap {

    public static void main(String[] args) {
        int a = 6;
        int b = 10;

        //如果在类似数组中进行交换，两个数的下标不能一样，否则会将该位置置0
        a = a ^ b;
        b = a ^ b;  //b = (a ^ b) ^ b = a
        a = a ^ b;  //a = (a ^ b) ^ a = b
        System.out.println(a + " " + b);
    }
}
