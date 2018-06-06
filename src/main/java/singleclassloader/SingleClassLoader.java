package main.singleclassloader;

import main.singleclassloader.error.AlreadyLoadedClassException;

public class SingleClassLoader extends ClassLoader {
    Class<?> singleClass                =null;
    boolean haveAlreadyLoadClass        =false;
    boolean resolveFlag                 =false;

    public SingleClassLoader(boolean resolveFlag) {
        this.resolveFlag = resolveFlag;
    }

    public Class<?> getSingleClass() {

        return singleClass;
    }

    public SingleClassLoader() {
        this(null);
    }

    public SingleClassLoader(ClassLoader classLoader) {
        super(null);
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        try{
            super.findSystemClass(s);
        }catch (ClassNotFoundException e){;}
        return super.loadClass(s,resolveFlag);

    }

    @Override
    protected Class<?> findClass(String s) throws ClassNotFoundException {
        if(haveAlreadyLoadClass) throw new AlreadyLoadedClassException();
        singleClass= super.findClass(s);
        return singleClass;
    }

}
