package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class DuplicateCreateException extends ProjectException {
    private static final long serialVersionUID = -8974225274790095159L;

    public DuplicateCreateException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "Create - Duplicate";
    }
}
