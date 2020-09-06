//单例模式之饿汉模式
//天生就是线程安全

//通过final修饰类，必然有人定义该类的子类来构造对象
public class SingletonStarve{
    //保存仅有的一个对象
    private static final SingletonStarve instance;

    //静态代码块，一开始就初始化
    static{
        instance = new SingletonStarve();
    }

    //如果需要该类对象，只能使用这个instance指向的对象
    public static SingletonStarve getInstance(){
        return instance;
    }

    //让构造函数为private，这样该类就不会被实例化，减少误用
    private SingletonStarve(){};
}