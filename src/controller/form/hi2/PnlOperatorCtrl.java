package controller.form.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultWithChildCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlOperatorCtrl extends PnlDefaultWithChildCtrl {

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen2("Voucher Type", "operator", new PnlVoucherTypeListCtrl());
    }
}