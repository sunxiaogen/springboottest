package com.sxg.test.base;

public class MemberInnerClassTest {
    private String name;
    private static int age;
    public void run(){}
    public static void go(){}
    public class MemberInnerClass{
        private String name;
        //内部类访问外部类
        public void test(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(MemberInnerClassTest.this.name);
            System.out.println(MemberInnerClassTest.age);
            MemberInnerClassTest.this.run();
            MemberInnerClassTest.go();
        }
    }
    //外部类访问成员内部类
    //成员内部类的对象要 依赖于外部类的对象的存在
    public void test(){
        //MemberInnerClass mic = MemberInnerClassTest.this.newMemberInnerClass();
        //MemberInnerClass mic = this.new MemberInnerClass();
        MemberInnerClass mic = new MemberInnerClass();
        mic.name = "tom";
        mic.test("hua");
    }
    public static void main(String[] args) {
        //MemberInnerClass mic = new MemberInnerClass();这个是不行的，this是动态的。
        //所以要使用要先创建外部类对象，才能使用
        MemberInnerClassTest out = new MemberInnerClassTest();
        MemberInnerClass mic = out.new MemberInnerClass();
        //如果内部类是private,则不能访问，只能铜鼓内部方法来调用内部类
        mic.name="jik";
        mic.test("kkk");
        out.test();
    }
}
