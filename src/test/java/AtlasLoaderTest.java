import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class AtlasLoaderTest {


    private AtlasLoader loader;
    private Class<?>    loadedClass;
    private Class<?>    loadedObject;
    @BeforeEach
    public void loadResources(){
        this.loader=new AtlasLoader();
        this.loadedClass=null;
        this.loadedObject=null;
    }

    @Test
    @DisplayName("Load Class Simple Operation")

    public void loadClassTest() throws ClassNotFoundException{
        loader.loadClass("TestClass");

    }

    @Test
    @DisplayName("Load Class Simple Operation with null")
    public void loadClassWithNullTest() throws ClassNotFoundException{
        assertThrows(NullPointerException.class,()->{loader.loadClass(null);});
    }
    @Test

    public void removeClass() throws ClassNotFoundException{
        Class<TestClass> t=(Class<TestClass>) loader.loadClass("TestClass");
        String s=t.getName();

        WeakReference<Class> weakReference=new WeakReference<>(t);
        t=null;
        assertTrue(loader.removeClass(s,true));
        loader=null;

        //while(weakReference.get()!=null){System.gc();} due to simplistic SingleClassLoader(witch simply calls its parent) the class cannot be freed from parent classloader
        //assertNull(weakReference.get());
    }
    @Test
    public void removeClassTest(){
        assertFalse(loader.removeClass("bo"));
    }
}
