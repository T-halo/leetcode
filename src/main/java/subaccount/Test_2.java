package subaccount;

/**
 * @author Li Yong
 * @date 2021/6/18 15:52:46
 *
 * 最大回文数
 * 回文数就是从前往后和从后往前读都一样的数。
 * 由两个2位数相乘得到的最大回文乘积是 9009 = 91 × 99。
 * 找出由两个3位数相乘得到的最大回文乘积。
 */
public class Test_2 {

  public static void main(String[] args) {
    System.out.println(maxPalindrome());
  }

  public static int maxPalindrome() {
    int num = 0;
    for (int i = 999; i > 99; i--) {
      for (int j = 999; j > 99; j--) {
        int product = i * j;
        //做回文数判断
        if (product > num && isPalindrome(product)) {
          num = product;
        }
      }
    }
    return num;
  }

  private static boolean isPalindrome(int num) {
    int bitCount = 0;
    int[] bitNum = new int[10];
    while (num != 0) {
      //将目标数的每一位分别存入数组中，方便进行比较
      //从个位开始存入数组
      bitNum[bitCount++] = num % 10;
      //出去目标数的最后一位
      num /= 10;
    }
    //由于是两边一起进行比较，所以只用比较数组大小的一半
    for (int i = 0; i < bitCount >> 1; i++) {
      if (bitNum[i] != bitNum[bitCount - i - 1]) {
        return false;
      }
    }
    return true;
  }
}
