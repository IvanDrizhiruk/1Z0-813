package ua.pd.oracle;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Generics {

    public static void main(String[] args) {
        //Producer Extends Consumer Super (PECS)
        wildcards();
        wildcardsExtendsUpper();
        wildcardsSuperLower();
    }

    private static void wildcards() {
        List<Integer> listInteger = new ArrayList<>();
        List<Float> listFloat = new ArrayList<>();
        List<?> listWildcard = new ArrayList<>();

//      listWildcard.add(new Integer(1)); // Error
//      listWildcard.add(new Float(1.0F)); // Error
//      listWildcard.add(new Object()); // Error
        listWildcard = listInteger; // Error
        listWildcard = listFloat; // Error

        System.out.println(listWildcard);
    }

    private static void wildcardsExtendsUpper() {
        List<Integer> listInteger = new ArrayList<>();
        List<Float> listFloat = new ArrayList<>();
        listFloat.add(1.0F);
        List<Object> listObject = new ArrayList<>();
        List<? extends Number> listExtendsNum = new ArrayList<>();
//      listExtendsNum.add(new Integer(1)); //Error
//      listExtendsNum.add(new Object()); //Error

        listExtendsNum = listInteger; // OK
        listExtendsNum = listFloat; // OK
//      listExtendsNum = listObject; // Error

        Number n = listExtendsNum.iterator().next();

        System.out.println(listExtendsNum);
        System.out.println(n);
    }

    private static void wildcardsSuperLower() {
        List<Integer> listInteger = new ArrayList<>();
        List<Object> listObject = new ArrayList<>();
        listObject.add("Obj");
        List<? super Number> listSuperNum = new ArrayList<>();
        listSuperNum.add(new Integer(1)); // OK
        listSuperNum.add(new Float(1.0F)); // OK

//      listSuperNum = listInteger; // Error!
        listSuperNum = listObject; // OK

        Object n = listSuperNum.iterator().next();

        System.out.println(listSuperNum);
        System.out.println(n);
    }
}
