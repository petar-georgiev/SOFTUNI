package softuni.exam.util;

public interface ValidationUtil {
    <E> boolean isValid(E entity);
    // <E> Set<ConstraintViolation<E>> violation(E entity);
}
