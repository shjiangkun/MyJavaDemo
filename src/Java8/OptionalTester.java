package Java8;

import java.util.Optional;

/**
 * 功能描述: 可空类型
 * 作者: CRIC.JK
 * 时间: 2020-01-02 10:10
 */
public class OptionalTester {
    public static void main(String[] args) {
        Integer v1 = null;
        Integer v2 = 2;
        Optional<Integer> a = Optional.ofNullable(v1);
        Optional<Integer> b = Optional.of(v2);
        System.out.println(sum(a, b));
    }

    /*
     * 功能描述: 累加函数
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        Integer v1 = a.orElse(0);
        Integer v2 = b.get();
        return v1 + v2;
    }

}
