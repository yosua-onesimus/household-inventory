package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.hi.HiItem;
import model.obj.hi.HiItemStock;
import model.obj.hi.HiItemType;
import model.obj.hi.HiUnit;
import model.obj.hi2.HiCustomer;
import model.obj.hi2.HiCustomerPhone;
import model.obj.hi2.HiDeposit;
import model.obj.hi2.HiOperator;
import model.obj.hi2.HiSelling;
import model.obj.hi2.HiVoucherType;
import model.obj.hi3.HiMovie;
import model.obj.hi3.HiMovieTag;
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
        //
        hibernate.addAnnotatedClass(HiCustomer.class);
        hibernate.addAnnotatedClass(HiCustomerPhone.class);
        //
        hibernate.addAnnotatedClass(HiOperator.class);
        hibernate.addAnnotatedClass(HiVoucherType.class);
        hibernate.addAnnotatedClass(HiDeposit.class);
        hibernate.addAnnotatedClass(HiSelling.class);
        //
        hibernate.addAnnotatedClass(HiMovieTag.class);
        hibernate.addAnnotatedClass(HiMovie.class);
    }
//</editor-fold>
}