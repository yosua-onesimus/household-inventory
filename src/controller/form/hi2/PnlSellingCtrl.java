package controller.form.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import model.bo.hi2.HiConfigBo;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlSellingCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HiConfigBo configBo;
//</editor-fold>

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && configBo.recalculateSaldoProfit();
    }
}