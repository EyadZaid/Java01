package training.expires;

@FunctionalInterface
public interface BiFunc <A, B, R>{
    R apply(A a, B b);
}
