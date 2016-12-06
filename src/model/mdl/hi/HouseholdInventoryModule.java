package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateModule;
import java.util.Arrays;
import java.util.List;
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
    protected List<Class> _getAnnotatedClasses() {
        return (List) Arrays.asList(
                //parameter
                HiUnit.class,
                HiItemType.class,
                HiItem.class,
                HiItemStock.class,
                //
                HiCustomer.class,
                HiCustomerPhone.class,
                //
                HiOperator.class,
                HiVoucherType.class,
                HiDeposit.class,
                HiSelling.class,
                //
                HiMovieTag.class,
                HiMovie.class);
    }
//</editor-fold>
}