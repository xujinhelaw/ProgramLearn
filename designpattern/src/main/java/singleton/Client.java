package singleton;

public class Client {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getSingleton();
        HungrySingleton hungrySingletonNew = HungrySingleton.getSingleton();
        LazySingleton lazySingleton = LazySingleton.getSingleton();
        LazySingleton lazySingletonNew = LazySingleton.getSingleton();
        System.out.println(hungrySingleton);
        System.out.println(hungrySingletonNew);
        System.out.println(lazySingleton);
        System.out.println(lazySingletonNew);
    }
}
