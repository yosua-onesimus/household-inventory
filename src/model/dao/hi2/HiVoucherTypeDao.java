package model.dao.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.hi.HouseholdInventoryDao;
import model.obj.hi2.HiVoucherType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HiVoucherTypeDao extends HouseholdInventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HiVoucherType.class;
    }
//</editor-fold>
}