package singleton;

/*Singleton "Lazy Holder" */

public class SingletonLazyHolder {
    private static class InstaceHolder{
        public static SingletonLazyHolder instacia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstacia(){
        return InstaceHolder.instacia;
    }
}
