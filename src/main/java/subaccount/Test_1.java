package subaccount;

/**
 * @author Li Yong
 * @date 2021/6/18 14:42:09
 *
 * 最大质因数
 * 13195的所有质因数为5、7、13和29。
 * 600851475143最大的质因数是多少？
 *
 * 质因数：就是一个数的约数，并且是质数。
 */
public class Test_1 {

  public static void main(String[] args) {
    System.out.println(primeFactors(3L));
  }

  public static long primeFactors(long number) {
    //1不是质数
    if (number == 1) {
      return number;
    }
    //质数从2开始
    for (int i = 2; i < number; i++) {
      //如果这个数对 i 进行取余等于0，说明他能被这个数整除，不是质数
      if (number % i == 0) {
        //递归调用，继续寻找最大质数
        return primeFactors(number / i);
      }
    }
    return number;
  }

}
