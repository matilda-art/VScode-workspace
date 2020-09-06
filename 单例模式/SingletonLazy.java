//单例模式：涉及一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建
//这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象

//单例模式之懒汉模式
//使用volatile和synchronized和双重判断来保证懒汉模式的线程安全

//懒汉模式——线程不安全
//最基本的实现方式，但是不支持多线程，因为没有加锁synchronized，所以严格意义上不算单例模式
public class Singleton{
    private static Singleton instance = null;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

//懒汉模式——线程安全 
//采用双锁机制，安全且在多线程情况下能保持高性能
public class SingletonLazy{
    //创建一个变量，使用volatile修饰
    private static volatile SingletonLazy instance = null;

    //获取唯一可用的对象，使用双重判断和synchronized
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized(SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    //让构造函数为private，这样该类就不会被实例化
    private SingletonLazy(){}
}