package training.expires;

public interface IKeyExtractor<T,K> {
    K getKey(T obj);
    void addItem(T value, K key);
}
