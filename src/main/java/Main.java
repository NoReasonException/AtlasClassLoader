import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InterruptedException,ClassNotFoundException,IllegalAccessException,InstantiationException,NoSuchMethodException,InvocationTargetException
    {
        AtlasLoader loader=new AtlasLoader();
        Class e=loader.loadClass("TestClass");
        Object o = e.newInstance();
        Method d=o.getClass().getMethod("hey");
        d.invoke(o);

        o=null;
        d=null;
        String p=e.getName();

        e=null;
        System.gc();
        loader.removeClass(p);//remove from memory
        System.gc();

    }
}