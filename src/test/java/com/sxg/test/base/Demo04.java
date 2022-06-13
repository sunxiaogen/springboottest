package com.sxg.test.base;

import java.io.IOException;

public class Demo04 {

    static Thread t1=null;
    static Thread t2=null;

    public static void main(String[] args) throws IOException {
        Animal a = new Animal();
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Excute b = new Excute();
        b.excute(a);
        b.excute(a1);
        b.excute(a2);
        System.out.println("=================");
        a.test();
        a1.test();
        a2.test();
        System.out.println("=================");
//        Excute b1 = new Excuteqwqqw();
//        b1.excute(a);
//        b1.excute(a1);
//        b1.excute(a2);
    }

    public static class Animal{
        public void test(){
            System.out.println("zhesidongwu");
        }
    }
    public static class Dog extends Animal{
        public void test(){
            System.out.println("zhesigou");
        }
    }
    public static class Cat extends Animal{
        public void test(){
            System.out.println("zhesimao");
        }
    }
    public static class Excute{

        public void excute(Animal a){
            System.out.println("animal");
        }
        public void excute(Dog b){
            System.out.println("dog");
        }
        public void excute(Cat c){
            System.out.println("cat");
        }

    }



}
class Excuteqwqqw{

    public void excute(Demo04.Animal a){
        System.out.println("animal12");
    }
    public void excute(Demo04.Dog b){
        System.out.println("dog12");
    }
    public void excute(Demo04.Cat c){
        System.out.println("cat12");
    }

}
