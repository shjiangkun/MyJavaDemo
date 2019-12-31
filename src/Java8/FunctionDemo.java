package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 功能描述: 方法引用
 * 作者: CRIC.JK
 * 时间: 2019-12-31 16:36
 */
public class FunctionDemo {
    public static void main(String[] args) {
        FunctionDemo tester = new FunctionDemo();
        tester.run();
    }

    /*
     * 功能描述: 方法名和类名之间不是使用点号 ( . ) 而是使用两个冒号 ::
     *提供的方法名必须包含类名，如果没有引入该类名，则需要使用全限定类名，也就是需要添加包名作为前缀
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    public void run() {
        List<String> list = Arrays.asList("Ram", "Shyam", "Kabir");
        list.forEach(System.out::println);
        list.forEach(this::lowerAndPrint);
        list.forEach(FunctionDemo::upperAndPrint);
    }

    public void lowerAndPrint(String s) {
        System.out.println(s.toLowerCase());
    }

    public static void upperAndPrint(String s) {
        System.out.println(s.toUpperCase());
    }
}
