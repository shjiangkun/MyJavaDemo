package Java8;

/**
 * 功能描述: 接口默认方法/接口静态方法
 * 作者: CRIC.JK
 * 时间: 2019-12-31 16:50
 */
public class InterfaceDefaultMethodDemo {
    public static void main(String[] args) {
        Greeter gt = new Greeter() {
        };
        gt.greeter("蒋坤");

        Greeter.greeter2("克而瑞");
    }


    /*
     * 功能描述: 从语法中可以看到，一个接口默认方法和普通的接口方法声明有两个不同点：
     * 1接口默认方法可以有具体实现
     * 2接口默认方法需要使用 default 关键字修饰。
     * 3一个接口可以有多个默认方法
     * 4一个类实现了多个具有同名的默认方法接口，最简单的方法就是类自己实现一个相同的方法或者调用相关接口的默认方法
     * 作者: jiangkun
     * 时间: 2019/12/31
     */
    interface Greeter {
        /*
        接口默认方法
         */
        default void greeter(String name) {
            System.out.println("你好," + name);
        }

        /*
        接口静态方法
        静态方法必须有自己的实现
         */
        public static void greeter2(String name) {
            System.out.println("你好，" + name);
        }
    }


}
