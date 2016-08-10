package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import controller.form.hi.PnlItemListCtrl;
import controller.form.hi.PnlItemTypeListCtrl;
import controller.form.hi.PnlUnitListCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HouseholdInventoryMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "household-inventory";
        APPL_CODE = "household-inventory";
        APPL_NAME = "household-inventory";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        HouseholdInventoryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(APPL_CODE, "Unit", PnlUnitListCtrl.class);
        uae.reg(APPL_CODE, "Item Type", PnlItemTypeListCtrl.class);
        uae.reg(APPL_CODE, "Item", PnlItemListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent("Item & Stock", null, null);
        uae.addMenuChild("Unit", null, PnlUnitListCtrl.class);
        uae.addMenuChild("Item Type", null, PnlItemTypeListCtrl.class);
        uae.addMenuChild("Item", null, PnlItemListCtrl.class);
    }

    @Override
    protected boolean _showHomeScreen() {
        return true;
    }

    public static void main(String[] args) {
        new HouseholdInventoryMain().showScreen();
    }
}