package model.mdl.hi;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static model.mdl.hi.HouseholdInventoryLanguage.*;
import cococare.common.CCLanguage;
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.swing.CFSwingMain;
import controller.form.hi.*;
import controller.form.hi2.PnlCustomerListCtrl;
import controller.form.hi2.PnlDepositListCtrl;
import controller.form.hi2.PnlOperatorListCtrl;
import controller.form.hi2.PnlSellingListCtrl;
import java.util.Arrays;
import model.bo.hi2.HiInitialDataBo;
import model.obj.hi.HiReport;
import model.obj.hi2.HiConfig;
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
        HiReport.setupReportFile(HiReport.Report.class);
    }

    @Override
    protected void _loadExternalSetting() {
        CCLanguage.init(false, HouseholdInventoryLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        HouseholdInventoryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        UtilConfigBo configBo = new UtilConfigBo();
        confAppl = configBo.loadConfAppl();
        confAppl.setUtilAdditionalSettingClass(Arrays.asList(
                HiConfig.class.getName()));
        return super._initInitialData()
                && configBo.saveConf(confAppl)
                && new HiInitialDataBo().initInitialData();
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(APPL_CODE, Unit, PnlUnitListCtrl.class);
        uae.reg(APPL_CODE, Item_Type, PnlItemTypeListCtrl.class);
        uae.reg(APPL_CODE, Item, PnlItemListCtrl.class);
        uae.reg(APPL_CODE, Item_Stock, PnlItemStockListCtrl.class);
        uae.reg(APPL_CODE, Report, PnlReportListCtrl.class);
        uae.reg(APPL_CODE, Customer, PnlCustomerListCtrl.class);
        uae.reg(APPL_CODE, Operator, PnlOperatorListCtrl.class);
        uae.reg(APPL_CODE, Deposit, PnlDepositListCtrl.class);
        uae.reg(APPL_CODE, Selling, PnlSellingListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent("Item & Stock", null, null);
        uae.addMenuChild(Unit, null, PnlUnitListCtrl.class);
        uae.addMenuChild(Item_Type, null, PnlItemTypeListCtrl.class);
        uae.addMenuChild(Item, null, PnlItemListCtrl.class);
        uae.addMenuChild(Item_Stock, null, PnlItemStockListCtrl.class);
        uae.addMenuChild(Report, null, PnlReportListCtrl.class);
        uae.addMenuParent("Phone & Voucher", null, null);
        uae.addMenuChild(Customer, null, PnlCustomerListCtrl.class);
        uae.addMenuChild(Operator, null, PnlOperatorListCtrl.class);
        uae.addMenuChild(Deposit, null, PnlDepositListCtrl.class);
        uae.addMenuChild(Selling, null, PnlSellingListCtrl.class);
    }

    @Override
    protected boolean _showHomeScreen() {
        return true;
    }

    public static void main(String[] args) {
        new HouseholdInventoryMain().showScreen();
    }
}