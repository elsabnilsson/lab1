public interface Loading<T> {
    void load(T item);
    void open();
    void close();
    double distToObject(T item);
    default void unload() {};
    default void unload(T item) {};
}
