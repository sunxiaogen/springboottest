package com.sxg.test.base;

public class StaticInnerClassTest {
    private String name;
    private static int age;
    public void run(){}
    public static void go(){}
    //外部类访问静态内部类
    public void test(){
        StaticInnerClass sic = new StaticInnerClass(); //静态的内部类不需要依赖外部类，所以不用this
        sic.name = "tom";
        sic.test1("jack");
        StaticInnerClass.age=10;
        StaticInnerClass.test2("xixi");
    }
    private static class StaticInnerClass{
        private String name;
        private static int age;
        public void test1(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(StaticInnerClass.age);
            System.out.println(StaticInnerClassTest.age);
            //System.out.println(StaticInnerClassTest.this.name);静态类不能访问非静态属性
            StaticInnerClassTest.go();
            //StaticInnerClassTest.this.run();静态类不能访问非静态方法
        }
        public static void test2(String name){
            //只能访问自己和外部类的静态属性和方法
            System.out.println(name);
            //System.out.println(this.name);静态方法里面连自己类的非静态属性都不能访问
            System.out.println(StaticInnerClass.age);
            System.out.println(StaticInnerClassTest.age);
//            System.out.println(StaticInnerClassTest.this.name);静态方法不能访问非静态属性
            StaticInnerClassTest.go();
            //StaticInnerClassTest.this.run();静态方法不能访问非静态方法
        }
    }
}
