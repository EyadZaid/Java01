package training.expires;

@FunctionalInterface
public interface KeyExtractor<T,K> {
    K getKey(T obj);
}
