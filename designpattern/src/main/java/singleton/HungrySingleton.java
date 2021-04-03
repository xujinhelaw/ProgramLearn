package singleton;

public class HungrySingleton {
    private static final HungrySingleton SINGLETON = new HungrySingleton();

    private HungrySingleton(){
    }

    public static HungrySingleton getSingleton(){
        return SINGLETON;
    }
}
