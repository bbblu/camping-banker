package tw.edu.ntub.imd.camping.banker.service;

import tw.edu.ntub.imd.camping.banker.databaseconfig.dto.Pager;

import java.util.List;
import java.util.Optional;

public interface BaseViewService<B, ID> {
    Optional<B> getById(ID id);

    List<B> searchAll();

    List<B> searchAll(Pager pager);

    List<B> searchByBean(B b);

    Optional<B> getByBean(B b);
}
