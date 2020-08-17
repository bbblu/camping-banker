package tw.edu.ntub.imd.camping.banker.exception.form;

public class InvalidFormNumberFormatException extends InvalidRequestFormatException {

    private static final long serialVersionUID = -9009550606073857832L;

    public InvalidFormNumberFormatException(NumberFormatException e) {
        super(e.getMessage().substring(18) + "不能轉換成數字");
    }
}
