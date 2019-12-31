package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:集合遍历 forEach() 方法
 * 作者: CRIC.JK
 * 时间: 2019-12-31 17:00
 */
public class ForEachDemo {
    public static void main(String[] args) {
        Arrays.asList("你好", "蒋坤", "上海").forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>() {
            {
                put("A", 10);
                put("A", 10);
                put("B", 20);
                put("C", 30);
                put("D", 40);
                put("E", 50);
                put("F", 60);
            }
        };
        map.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        map.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });

        Arrays.asList("你好", "简单教程", "简单编程")
                .stream()
                .filter(s -> s.contains("简单"))
                .forEach(System.out::println);

    }
}
