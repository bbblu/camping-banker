package tw.edu.ntub.imd.camping.banker.databaseconfig.dao.criteria.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class NotSingleResultException extends ProjectException {
    private static final long serialVersionUID = -8561931750445877118L;

    public NotSingleResultException(Class<?> entityClass) {
        super(entityClass.getSimpleName() + "查詢結果不為單一結果");
    }

    @Override
    public String getErrorCode() {
        return "Query - NotSingleResult";
    }
}
