package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class DebitedException extends ProjectException {
    private static final long serialVersionUID = -1345721519556862211L;

    public DebitedException() {
        super("此交易已扣款完成");
    }

    @Override
    public String getErrorCode() {
        return "Transaction - Debited";
    }
}
