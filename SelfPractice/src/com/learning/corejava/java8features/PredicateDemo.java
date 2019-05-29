import java.util.function.*;
class PredicateDemo {

    public static void main(String[] args) {
        
        Predicate<Integer> p = i->i%2==0;
        Predicate<String> p1 = s->s.length() > 5;
        System.out.println(p.test(10));
        System.out.println(p.test(15));
        System.out.println("String Length is :" + p1.test("abc"));
        
    }
}