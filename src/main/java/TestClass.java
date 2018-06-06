public class TestClass {
    public void hey(){
        System.out.println("H");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("FINAL");
    }
}
