package tw.edu.ntub.imd.camping.banker.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class FormatException extends ProjectException {

    private static final long serialVersionUID = -2695664550392774922L;

    public FormatException(String format) {
        super(format + "格式錯誤");
    }

    @Override
    public String getErrorCode() {
        return "User - no data";
    }
}
