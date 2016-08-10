package controller.form.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import model.obj.hi.HiUnit;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlUnitListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return HiUnit.class;
    }
}