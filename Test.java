import java.util.Scanner;

public class Test {

    public static void main4(String[] args) {
        String num1 = "Hello";
        String num2 = "He" + new String("llo");
        System.out.println(num1 == num2);// false
    }
    //问题：有一组数，对于其中任意两个数组，
    // 若前面一个大于后面一个数字，则这两个数字组成一个逆序对，
    // 请设计一个高效的算法，计算给定数组中的逆序对个数

    // 方法一: 逐个遍历, 复杂度O(n^2)
    public static class AntiOrder {
        public static int count(int[] A, int n) {
            int sum = 0;
            if(n < 2) {
                return sum;
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++ ) {
                    if (A[i] > A[j]) {
                        sum = sum + 1;
                    }
                }
            }
            return sum;
        }

        public static void main3(String[] args) {
            int[] A = {1,2,3,4,5,6,7,0};
            int n = 8;
            System.out.println(count(A, n));// 7
        }
    }
    // 方法二: 利用归并排序中的归并过程对逆序对进行计数，复杂度O(nlgn)


    public static void main2(String[] args) {
        //有这样一道智力题：
        // “某商店规定：三个空汽水瓶可以换一瓶汽水。
        // 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是 5 瓶
        // 方法如下：先用 9 个空瓶子换 3 瓶汽水，喝掉 3 瓶满的，喝完以后 4个空瓶子，用 3个再换一瓶，
        // 喝掉这瓶满的，这时候剩 2 个空瓶子。
        // 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
        // 问题: 如果小张手上有 n 个空汽水瓶，最多可以换多少瓶汽水喝？
        // 输入: 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（1 <= n <= 100），表示小张手上的空汽水瓶数。
        // n = 0表示输入结束，程序不应当处理这一行。
        // 输出: 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();// 空汽水瓶数
            int count = 0;// 已喝的汽水瓶数
            if (n > 0) {
                while (n > 1) {
                    count = count + n / 3;
                    n = n % 3 + n / 3;
                    if (n == 2) {
                        n++;
                    }
                }
                System.out.println(count);
            }
        }
        sc.close();
    }

    public static void main1(String[] args) {
        int[] A = {1, 2, 3, 5, 4, 6, 7, 8, 0};
        int n = 10;
        System.out.println(count(A, n));
    }

    public static int count(int[] A, int n) {
        if (n > 5000) {
            System.out.println("数组过大,请重新输入");
        }
        if (n != A.length) {
            System.out.println("A 与 n 不匹配, 请重新输入");
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                count++;
            }
        }
        return count;
    }
}

/*
class Person {
    private String name = "person";
}
class Child extends Person {
    Person p = new Child();
    public int age = 10;

    public static void main(String[] args) {
        System.out.println(p.name);// 编译错误
    }
}*/

class Base {
    public String str = "B";
}
class Dance extends Base {
    public static String dance(String s){
        String str2 = "D";
        return str2;
    }

    public static void main(String[] args) {
        System.out.println(dance("C"));// D
    }
}