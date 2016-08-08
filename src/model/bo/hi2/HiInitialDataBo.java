package model.bo.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.datafile.CCDom;
import static cococare.common.CCLogic.isNull;
import java.util.ArrayList;
import java.util.List;
import model.mdl.hi.HouseholdInventoryModule;
import model.obj.hi2.HiOperator;
import model.obj.hi2.HiVoucherType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HiInitialDataBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean initInitialData() {
        boolean success = true;
        //
        CCDom dom = new CCDom();
        dom.read(getClass().getResourceAsStream("/resource/OperatorAndVoucherType.xml"));
        //
        List restorable = new ArrayList();
        List<HiOperator> operators = dom.readEntity(HiOperator.class);
        for (HiOperator operator : operators) {
            operator.setLogSaveTimes(0);
            if (isNull(HouseholdInventoryModule.INSTANCE.getCCHibernate().get(HiOperator.class, operator.getId()))) {
                restorable.add(operator);
            }
        }
        success &= HouseholdInventoryModule.INSTANCE.getCCHibernate().restore(restorable);
        //
        restorable.clear();
        List<HiVoucherType> voucherTypes = dom.readEntity(HiVoucherType.class);
        for (HiVoucherType voucherType : voucherTypes) {
            voucherType.setLogSaveTimes(0);
            if (isNull(HouseholdInventoryModule.INSTANCE.getCCHibernate().get(HiVoucherType.class, voucherType.getId()))) {
                restorable.add(voucherType);
            }
        }
        success &= HouseholdInventoryModule.INSTANCE.getCCHibernate().restore(restorable);
        //
        return success;
    }
//</editor-fold>
}