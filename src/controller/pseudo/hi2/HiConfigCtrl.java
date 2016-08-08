package controller.pseudo.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.util.PnlApplicationSettingCtrl;
import model.bo.hi2.HiConfigBo;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HiConfigCtrl extends PnlApplicationSettingCtrl {

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && new HiConfigBo().recalculateSalePrice();
    }
}