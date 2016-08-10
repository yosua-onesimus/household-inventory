package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import cococare.database.CCHibernateFilter;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class HouseholdInventoryDao extends CCHibernateDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected CCHibernate getCCHibernate() {
        return HouseholdInventoryModule.INSTANCE.getCCHibernate();
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return HouseholdInventoryModule.INSTANCE.getFilters();
    }
//</editor-fold>
}