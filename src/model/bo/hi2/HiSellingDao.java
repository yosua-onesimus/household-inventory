package model.bo.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseDouble;
import model.mdl.hi.HouseholdInventoryDao;
import model.obj.hi2.HiSelling;
//</editor-fold>

public class HiSellingDao extends HouseholdInventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HiSelling.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public double sumPurchasePrice() {
        hql.start().
                select("SUM(purchasePrice)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }

    public double sumProfit() {
        hql.start().
                select("SUM(salePrice)-SUM(purchasePrice)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}