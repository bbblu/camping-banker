package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class NoBalanceException extends ProjectException {
    private static final long serialVersionUID = -704759120086000320L;

    public NoBalanceException() {
        super("信用卡餘額不足");
    }

    @Override
    public String getErrorCode() {
        return "CreditCard - NoBalance";
    }
}
