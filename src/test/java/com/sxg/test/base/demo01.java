package com.sxg.test.base;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class demo01 {
    public static void main(String[] args) {
        demo01 demo = new demo01();
        demo.test07();

    }

    public void test(){
        int i =0;
        while (i<100){
            i++;
            if(1%10==0){
                System.out.println();
                System.out.print("i为："+i);
                continue;
            }
            System.out.print(i);
        }
    }

    /**
     * 9x9
     */
    public void test01(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*"+j +"="+i*j +"\t");
            }
            System.out.println();
        }
    }

    /**
     * 三角形
     */
    public void  test02(){
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j >i ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 递归 5！5的阶乘 5*4*3*2*1
     * @param i
     * @return
     */
    public int test03(int i){
        if(i==1){
            return 1;
        }else {
            return i*test03(i-1);
        }
    }

    /**
     * Arrays
     * @return
     */
    public int test04(){
        int [] numbers ={1,2,3,4,5,6,66,14,9};
        int sum =0;
        for (int number : numbers) {
            sum =sum+number;
        }
        System.out.println(sum);
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);//对指定的 int 型数组按数字升序进行排序
        Arrays.fill(numbers,2,4,100);//将2到4索引的元素替换为100
        System.out.println(Arrays.toString(numbers));
        return sum;
    }

    /**
     * 冒泡排序
     */
    public void test05(){
        int [] numbers ={7,2,99,4,1,3,55,77,22,13};
        int min = numbers[0];
        for (int i = 1; i < numbers.length-1; i++) {
            if(min > numbers[i]){
                min =numbers[i];
            }
        }
        System.out.println(min);
        int a =0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if(numbers[j] > numbers[j+1]){
                    a= numbers[j];
                    numbers[j] =numbers[j+1];
                    numbers[j+1] =a;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }


    public void test06(){
        int a =10;
        int b = new Integer(15);
        Integer c =new Integer(20);
        Map map = new HashMap();
        map.put("a","sxg");
        setValue(a,b,c,map);
        System.out.println(a); //10       值传递
        System.out.println(b); //15
        System.out.println(c);//20
        System.out.println(map);//{a=sxg, b=zr}    引用传递

    }
    public void setValue(int a,int b,Integer c,Map map){
        a=100;
        b=5000;
        c=99;
        map.put("b","zr");
    }

    public  void test07(){
        Integer a =100;
        Integer b =100;
        System.out.println(a==b);

        a=200;
        b=200;
        System.out.println(a==b);

    }


}
