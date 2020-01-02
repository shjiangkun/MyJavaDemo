package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 功能描述: Stream流的操作示例
 * 作者: CRIC.JK
 * 时间: 2020-01-02 10:35
 */
public class StreamTest {
    public static void main(String[] args) {
        streamCreate();
        filterTest();
        mapTest();
        flatMapTest();
        distinctAndSortTest();
        //limit可用于从首个元素开始截取N个元素，组成新流返回。
        //skip表示放弃N个元素，将剩余元素组成新流返回。
        //forEach就是遍历操作，针对流中的每个元素做最后的操作。
        //toArray有两个方法，一个是无参方法，一个有参方法。无参方法返回的只能是Object[]数组类型，而有参方法，可以指定结果数组类型，此乃二者区别。
        //reduce归纳总结
        //max\min得出流中最大\最小的元素，为避免null返回，这里使用Optional来封装返回值
        //count返回流中元素个数
        //anyMatch用于校验流中的元素，只要有一个满足规则，则返回true，全不满足，返回false
        //allMatch只有全部满足规则才能返回true，只要有一个不满足则返回false
        //noneMatch只有所有元素都不满足规则的情况下返回true，否则返回false。
        //findFirst主要用于获取流中的第一个元素，如果流无序，那么可能返回任意一个
        //findAny主要用于获取流中的任一元素
    }

    /*
     * 功能描述:流生成的方式
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    public static void streamCreate() {
        //通过数组生成流
        int[] ints = {1, 2, 3, 4, 5};
        IntStream s1 = Arrays.stream(ints);
        Stream s2 = Stream.of("111", "222", "333");
        String[] ss = {"111", "222", "333"};
        Stream s3 = Arrays.stream(ss);

        //通过构建器生成流
        Stream s4 = Stream.builder().add("123").add("456").build();

        //通过集合生成流
        List<String> lists = Arrays.asList("1", "2", "3", "4");
        Stream s5 = lists.stream();
        Stream s6 = lists.parallelStream();//并行流

        //创建无限流
        Stream.generate(() -> "number" + new Random().nextInt()).limit(100).forEach(System.out::println);
        Stream.iterate(1, n -> n * 2).limit(10).forEach(System.out::println);
    }

    /*
     * 功能描述:filter方法是过滤器方法，针对的是流中所有元素，满足条件的元素将会被保留以组成新的流
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    static void filterTest() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "asdaa", "3e3e3e", "2321eew", "212121121");
        System.out.println("filterTest");
        list.stream().filter(n -> n.length() > 4).peek(System.out::println).collect(Collectors.toList());
    }

    /*
     * 功能描述:map方法可以理解为函数，需要针对流中的每个元素执行，然后将执行的结果组成新的流返回
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    static void mapTest() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "asdaa", "3e3e3e", "2321eew", "212121121");
        System.out.println("mapTest");
        list.stream().map(n -> "@" + n).collect(Collectors.toList()).forEach(System.out::println);
    }

    /*
     * 功能描述:flatMap和map还是有点关系的，都是针对流中的每一个元素进行操作，将结果组成新流，
     * 不过flatMap含有一层扩展之意，就是当流中元素包含子元素的时候，通过该方法，
     * 获取到元素的子元素，并将子元素组成新流返回
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    static void flatMapTest() {
        List<String> list = Arrays.asList("123", "456", "789", "1101", "asdaa", "3e3e3e", "2321eew", "212121121");
        System.out.println("flatMapTest");
        list.stream()
                .filter(e -> e.length() > 5 && e.length() < 7)
                .peek(System.out::println)
                .map(e -> e.split(""))// 将每个字符串元素分解为字符数组
                .flatMap(Arrays::stream)//将每个字符数组并转化为流
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /*
     * 功能描述:distinct方法用于去重,
     * sorted表示对流中的元素进行排序，需要使用Conparable和Comparator
     * 作者: CRIC.JK
     * 时间: 2020/1/2
     */
    static void distinctAndSortTest() {
        List<String> list = Arrays.asList("123", "123", "789", "123", "asdaa", "123", "2321eew", "212121121");
        System.out.println("distinctAndSortTest");
        list.stream().distinct().peek(System.out::println).toArray();
        System.out.println("----自然顺序:");
        list.stream().sorted().peek(System.out::println).collect(Collectors.toList());
        System.out.println("----指定顺序:");
        list.stream().sorted((a, b) -> a.length() - b.length()).peek(System.out::println).collect(Collectors.toList());
    }

}
