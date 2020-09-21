//单例模式之枚举
//实现单例模式的最佳方法，更简洁，自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化

public enum SingletonEnum {
    INSTANCE;
    public void xx() {
    }
}
