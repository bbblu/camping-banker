package tw.edu.ntub.imd.camping.banker.exception.form;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class InvalidRequestFormatException extends ProjectException {
    private static final long serialVersionUID = -4049218755883243050L;

    public InvalidRequestFormatException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "FormValidation - Invalid";
    }
}
