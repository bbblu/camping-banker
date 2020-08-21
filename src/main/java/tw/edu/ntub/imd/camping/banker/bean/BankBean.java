package tw.edu.ntub.imd.camping.banker.bean;

import lombok.Data;
import tw.edu.ntub.imd.camping.banker.databaseconfig.enumerate.BankType;

@Data
public class BankBean {
    private String id;
    private BankType type;
    private String name;

    public String getTypeName() {
        return type.name;
    }
}
