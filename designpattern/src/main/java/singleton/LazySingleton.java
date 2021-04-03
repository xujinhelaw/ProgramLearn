package singleton;

public class LazySingleton {
    private static LazySingleton SINGLETON;

    private LazySingleton(){
    }

    synchronized public static LazySingleton getSingleton(){
        if(SINGLETON == null){
            SINGLETON = new LazySingleton();
        }
        return SINGLETON;
    }
}
