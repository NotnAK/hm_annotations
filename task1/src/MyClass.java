public class MyClass {
    @Test(a = 2, b = 5)
    public void test(int a, int b){
        System.out.println("a + b = " + a + " + " + b + " = " + (a+b));
    }
}
