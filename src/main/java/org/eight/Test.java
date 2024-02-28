package org.eight;

import javax.xml.bind.SchemaOutputResolver;

public class Test {
    public static void main(String[] args) {
        String str = new String("abc");
        String str2 = new String("abc");
        System.out.println(str == str2);       //false
        System.out.println(str.equals(str2));  //true

        int i = 1;
        int j = 1;
        System.out.println(i == j);  //true

        Integer value= new Integer(1);
        Integer value2 = new Integer(1);
        System.out.println(value == value2);       //false
        System.out.println(value.equals(value2));  //true

        StringBuffer sb = new StringBuffer("dfg");
        StringBuffer sb2 = new StringBuffer("dfg");
        System.out.println(sb == sb2);        //false
        System.out.println(sb.equals(sb2));   //false

        Integer value3= new Integer(130);
        Integer value4 = new Integer(130);
        System.out.println(value3 == value4);       //false
        System.out.println(value3.equals(value4));  //true

        Integer v1 = 130;
        Integer v2 = 130;
        System.out.println(v1 == v2);

        Integer v3 = 120;
        Integer v4 = 120;
        System.out.println(v3 == v4);

        Integer v5= new Integer(120);
        Integer v6 = new Integer(120);
        System.out.println(v5 == v6);       //false
    }

}
