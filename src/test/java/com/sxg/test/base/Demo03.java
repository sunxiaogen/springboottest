package com.sxg.test.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("com.sxg.test.base.demo01");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        demo01 o = (demo01) c1.newInstance();
        System.out.println(o);
        o.test01();
        Method test02 = c1.getDeclaredMethod("test02");
        test02.invoke(o);
        List<String> strings = castList(null, String.class);
        System.out.println(strings);


    }

    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
