package ua.pd.oracle;

import java.util.function.Function;

public class Lambda {

    private int number = 10;

    public static void main(String[] args) {
        new Lambda().go();
    }

    public void go() {
        Function<Integer, Integer> f = x -> x * 2 * this.number;

        System.out.println(f.apply(5));
    }
}
