package tw.edu.ntub.imd.camping.banker.exception;

import org.springframework.http.converter.HttpMessageNotReadableException;
import tw.edu.ntub.birc.common.exception.ProjectException;

public class NullRequestBodyException extends ProjectException {

    private static final long serialVersionUID = -4771794836777794188L;

    public NullRequestBodyException(HttpMessageNotReadableException cause) {
        super("RequestBody為null", cause);
    }

    @Override
    public String getErrorCode() {
        return "Http - NullRequestBody";
    }
}
