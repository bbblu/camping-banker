package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.BaseViewDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dto.Pager;
import tw.edu.ntub.imd.camping.banker.service.transformer.BeanEntityTransformer;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseViewServiceImpl<B, E, ID extends Serializable> implements BaseViewService<B, ID> {
    private final BaseViewDAO<E, ID> baseDAO;
    private final BeanEntityTransformer<B, E> transformer;

    public BaseViewServiceImpl(BaseViewDAO<E, ID> d, BeanEntityTransformer<B, E> transformer) {
        Assert.notNull(d, "baseDAO不能為null");
        Assert.notNull(d, "transformer不能為null");
        this.baseDAO = d;
        this.transformer = transformer;
    }

    @Override
    public Optional<B> getById(ID id) {
        return baseDAO.findById(id).map(transformer::transferToBean);
    }

    @Override
    public List<B> searchAll() {
        return transformer.transferToBeanList(baseDAO.findAll());
    }

    @Override
    public List<B> searchAll(Pager pager) {
        PageRequest pageRequest = PageRequest.of(pager.getPage(), pager.getCount());
        return transformer.transferToBeanList(baseDAO.findAll(pageRequest).getContent());
    }

    @Override
    public List<B> searchByBean(B b) {
        List<E> eList = baseDAO.findAll(Example.of(transformer.transferToEntity(b)));
        return transformer.transferToBeanList(eList);
    }

    @Override
    public Optional<B> getByBean(B b) {
        Optional<E> optional = baseDAO.findOne(Example.of(transformer.transferToEntity(b)));
        return optional.map(transformer::transferToBean);
    }
}
