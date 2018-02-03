package ua.pd.oracle;

import java.util.function.*;

public class P11MethodReferences {

    public static class Mega {

        private Mega() {
            System.out.println("Mega has created.");
        }
        private Mega(String megaString) {
            System.out.println("Mega has created." + megaString);
        }

        public static String go() {
            System.out.println("Mega go!");

            return "go";
        }

        public String goTo(String goTo) {
            System.out.println("Mega goTo " + goTo);

            return "goTo";
        }
    }

    public static void main(String[] args) {
        System.out.println("***** staticReference *****");
        staticReference();
        System.out.println("***** referenceFromType *****");
        referenceFromType();
        System.out.println("***** referenceFromObject *****");
        referenceFromObject();
        System.out.println("***** constructorReference *****");
        constructorReference();
    }

    private static void staticReference() {
        Runnable run = Mega::go;

        run.run(); //println => Mega go!
    }

    private static void referenceFromType() {
        BiFunction<Mega, String, String> goTo1 = Mega::goTo;
        BiConsumer<Mega, String> goTo2 = Mega::goTo;

        String goTo1Res = goTo1.apply(new Mega(), "Ho ho ho"); // println => Mega goTo Ho ho ho!
        System.out.println("goTo1Res: " + goTo1Res);              // and return goTo

        goTo2.accept(new Mega(), "Ho ho ho"); // println => Mega goTo Ho ho ho!
    }

    private static void referenceFromObject() {
        Mega mega = new Mega();

        Function<String, String> goTo1 = mega::goTo;
        Consumer<String> goTo2 = mega::goTo;

        String goTo1Res = goTo1.apply("Ho ho ho"); // println => Mega goTo Ho ho ho!
        System.out.println("goTo1Res: " + goTo1Res);              // and return goTo

        goTo2.accept("Ho ho ho"); // println => Mega goTo Ho ho ho!
    }

    private static void constructorReference() {
        Supplier<Mega> creator1 = Mega::new;
        Function<String, Mega> creator2 = Mega::new;
        Runnable notCreator = Mega::new;

        Mega newInstance1 = creator1.get(); // println => Mega has created.
                                            // And return new instance of Mega
        Mega newInstance2 = creator2.apply("Hurrah!!!"); // println => Mega has created. Hurrah!!!
                                                            // And return new instance of Mega
        notCreator.run(); // just create and print => Mega has created
                          // does not return instance
    }
}
