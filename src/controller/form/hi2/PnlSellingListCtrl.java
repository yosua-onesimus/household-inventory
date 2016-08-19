package controller.form.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import model.obj.hi2.HiSelling;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlSellingListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getClass() {
        return _getClassBySwingView();
    }

    @Override
    protected Class _getEntity() {
        return HiSelling.class;
    }
}