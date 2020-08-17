package tw.edu.ntub.imd.camping.banker.databaseconfig.dao.criteria.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class WhereRestrictionExistException extends ProjectException {
    private static final long serialVersionUID = -858755924347255234L;

    public WhereRestrictionExistException() {
        super("條件已存在，此方法會覆蓋先前設定的條件");
    }

    @Override
    public String getErrorCode() {
        return "DAO - ConditionExistError";
    }
}
