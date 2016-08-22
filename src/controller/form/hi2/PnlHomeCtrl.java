package controller.form.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.hi2.HiConfigBo;
import model.obj.hi2.HiConfig;
//</editor-fold>

public class PnlHomeCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HiConfigBo configBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return HiConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadHiConfig();
    }
}