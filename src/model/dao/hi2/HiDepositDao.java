package model.dao.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseDouble;
import model.mdl.hi.HouseholdInventoryDao;
import model.obj.hi2.HiDeposit;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HiDepositDao extends HouseholdInventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HiDeposit.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public double sumAmount() {
        hql.start().
                select("SUM(amount)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}