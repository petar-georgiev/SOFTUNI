package softuni.exam.instagraphlite.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.util.ValidationUtil;

import javax.validation.*;


@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }


    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }

//    @Override
//    public <E> Set<ConstraintViolation<E>> violation(E entity) {
//        return validator.validate(entity);
//    }


}
