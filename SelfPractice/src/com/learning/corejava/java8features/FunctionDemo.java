import java.util.function.*;


/**
    interface Function<T,R> {
        public R apply(T t);
    }
*/

class FunctionDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> f = t->t*t;
        System.out.println(f.apply(5));
    }
}