package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.hi.HiItem;
import model.obj.hi.HiItemStock;
import model.obj.hi.HiItemType;
import model.obj.hi.HiUnit;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HouseholdInventoryModule extends CCHibernateModule {

    public static HouseholdInventoryModule INSTANCE = new HouseholdInventoryModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //parameter
        hibernate.addAnnotatedClass(HiUnit.class);
        hibernate.addAnnotatedClass(HiItemType.class);
        hibernate.addAnnotatedClass(HiItem.class);
        hibernate.addAnnotatedClass(HiItemStock.class);
    }
//</editor-fold>
}