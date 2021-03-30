package training.expires;

@FunctionalInterface
public interface Action<R, T> {
    void apply(T arg);

}
