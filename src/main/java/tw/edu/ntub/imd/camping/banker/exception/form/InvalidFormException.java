package tw.edu.ntub.imd.camping.banker.exception.form;

import lombok.Getter;
import org.springframework.validation.FieldError;
import tw.edu.ntub.birc.common.exception.ProjectException;

@Getter
public class InvalidFormException extends ProjectException {
    private static final long serialVersionUID = -2978682095640248993L;

    public InvalidFormException(FieldError error) {
        super(error.getDefaultMessage());
    }

    @Override
    public String getErrorCode() {
        return "FormValidation - Invalid";
    }
}
