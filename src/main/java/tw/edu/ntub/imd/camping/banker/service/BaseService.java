package tw.edu.ntub.imd.camping.banker.service;

public interface BaseService<B, ID> extends BaseViewService<B, ID> {
    @SuppressWarnings("UnusedReturnValue")
    B save(B b);

    void update(ID id, B b);

    void delete(ID id);
}
