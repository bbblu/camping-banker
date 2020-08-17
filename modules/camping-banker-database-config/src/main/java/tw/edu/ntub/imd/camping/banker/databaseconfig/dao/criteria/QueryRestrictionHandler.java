package tw.edu.ntub.imd.camping.banker.databaseconfig.dao.criteria;

import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.criteria.restriction.WhereRestriction;

import javax.annotation.Nonnull;

public interface QueryRestrictionHandler<S> {
    QueryRestrictionHandler<S> add(@Nonnull WhereRestriction<S> predicateSupplier);
}
