package model.bo.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.datafile.CCDom;
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
        CCDom dom = new CCDom();
        dom.read(getClass().getResourceAsStream("/resource/OperatorAndVoucherType.xml"));
        return HouseholdInventoryModule.INSTANCE.getCCHibernate().restore(dom.readEntity(HiOperator.class))
                && HouseholdInventoryModule.INSTANCE.getCCHibernate().restore(dom.readEntity(HiVoucherType.class));
    }
//</editor-fold>
}