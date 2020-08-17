package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class MethodNotSupportedException extends ProjectException {
    private static final long serialVersionUID = -2975508047034591530L;

    public MethodNotSupportedException(String url, String methodName, Throwable cause) {
        super(url + " 不支援此方法：" + methodName.toUpperCase(), cause);
    }

    @Override
    public String getErrorCode() {
        return "Http - MethodNotAllowed";
    }
}
