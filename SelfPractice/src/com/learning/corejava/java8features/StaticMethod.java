interface Interf {
    public static void m1() {
        System.out.println("m1 method");
    }
    
}

class Test implements Interf {
    
    public static void main(String[] args) { 
    
        Interf.m1();
        m1();
        Test.m1();

        Test t = new Test();
        t.m1();
    }
}

