package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class NotAvailableException extends ProjectException {

    private static final long serialVersionUID = -2100714167283525326L;

    public NotAvailableException() {
        super("資料不存在");
    }

    @Override
    public String getErrorCode() {
        return "User - no available";
    }
}
