package controller.form.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.hi2.HiConfigBo;
import model.obj.hi2.HiVoucherType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlSellingCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HiConfigBo configBo;
    private CCBandBox txtVoucherType;
    private JTextField txtPurchasePrice;
    private JTextField txtSalePrice;
    private JTextField txtAmountPaid;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(txtVoucherType, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doTxtVoucherType();
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && configBo.recalculateSaldoProfit();
    }

    private void _doTxtVoucherType() {
        HiVoucherType voucherType = txtVoucherType.getObject();
        if (isNotNull(voucherType)) {
            txtPurchasePrice.setText(formatNumber(voucherType.getPurchasePrice()));
            txtSalePrice.setText(formatNumber(voucherType.getSalePrice()));
            txtAmountPaid.setText(formatNumber(voucherType.getSalePrice()));
        }
    }
}