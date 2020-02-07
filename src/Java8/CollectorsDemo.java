package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 收集器
 * @Author: CRIC.JK
 * @CreateTime: 2019-12-31 15:24
 */
public class CollectorsDemo {
    public static void main(String[] args) {
        AveragingDoubleExample();
        CollectingAndThenExample();
        CountingExample();
        JoiningExample();
        MaxByMinByExample();
        SummingIntExample();
        ToListExample();
    }

    /**
     * 流中的所有元素视为 double 类型并计算他们的平均值
     * 同样方法还有averagingInt,averagingLong，只是视作元素类型不同
     */
    public static void AveragingDoubleExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.averagingDouble(d -> d));
        System.out.println(result);
    }

    /**
     * 它可接受两个参数，第一个参数用于 reduce 操作，而第二参数用于 map 操作
     * 先把流中的所有元素传递给第二个参数，然后把生成的集合传递给第一个参数来处理
     */
    static void CollectingAndThenExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(v -> v), s -> s * 2));
        System.out.println(result);
    }

    /*
     * 功能描述:统计流中元素的个数
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    static void CountingExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        long result = list.stream().collect(Collectors.counting());
        System.out.println(result);
    }

    /*
     * 功能描述:方法用某个指定的拼接字符串把所有元素拼接成一个字符串，并添加可选的前缀和后缀
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    static void JoiningExample() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        String result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
    }

    /*
     * 功能描述:计算流中所有元素的最大值和最小值
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    static void MaxByMinByExample() {
        List<Integer> list = Arrays.asList(30, 10, 20, 65);
        list.stream().collect(Collectors.minBy((i1, i2) -> i1 >= i2 ? 1 : -1)).ifPresent(integer -> System.out.println(integer));
        list.stream().collect(Collectors.maxBy((i1, i2) -> i1 >= i2 ? 1 : -1)).ifPresent(integer -> System.out.println(integer));
    }

    /*
     * 功能描述:将流中的所有元素视为 int 类型，并计算所有元素的总和
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    static void SummingIntExample() {
        List<Integer> list = Arrays.asList(30, 10, 20, 35);
        int result = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(result);
    }

    /*
     * 功能描述: 将流中的所有元素导出到一个列表
     *toSet(),toMap()都是差不多类似的功能
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    static void ToListExample() {
        List<String> list = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));
    }


}
