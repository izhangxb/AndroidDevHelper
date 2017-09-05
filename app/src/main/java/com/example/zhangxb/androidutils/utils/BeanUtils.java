package com.example.zhangxb.androidutils.utils;

import java.lang.reflect.Method;

/**
 * @Description: 复制一个bean的属性给另一个，要求属性的名称相同
 * @Author: carl
 * @Date: 2015/12/25
 */
public class BeanUtils {

    private BeanUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * @param srcObj1 被复制的对象
     * @param desObj2 复制的目标对象
     * @return 目标bean, 如果为null则复制不正确
     * @throws Exception 反射异常
     */
    public static Object CopyProprities(Object srcObj1, Object desObj2) {
        if (srcObj1 == null) {
            System.out.print("srcObj is null1");
            return null;
        }
        if (desObj2 == null) {
            System.out.print("desObj2 is null1");
            return null;
        }
        Method[] method1 = srcObj1.getClass().getMethods();
        Method[] method2 = desObj2.getClass().getMethods();
        //srcObj1属性的get方法名
        String methodName1;
        //srcObj1的属性名
        String methodFix1;
        //desObj2属性的set方法名
        String methodName2;
        //desObj2的属性名
        String methodFix2;
        for (Method aMethod1 : method1) {
            methodName1 = aMethod1.getName();
            methodFix1 = methodName1.substring(3, methodName1.length());
            if (methodName1.startsWith("get")) {
                for (Method aMethod2 : method2) {
                    methodName2 = aMethod2.getName();
                    methodFix2 = methodName2.substring(3, methodName2.length());
                    if (methodName2.startsWith("set")) {
                        if (methodFix2.equals(methodFix1)) {
                            Object[] objs1 = new Object[0];
                            Object[] objs2 = new Object[1];
                            try {
                                objs2[0] = aMethod1.invoke(srcObj1, objs1);//激活obj1的相应的get的方法，objs1数组存放调用该方法的参数,此例中没有参数，该数组的长度为0
                                aMethod2.invoke(desObj2, objs2);//激活obj2的相应的set的方法，objs2数组存放调用该方法的参数
                            } catch (Exception e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return desObj2;
    }
}
