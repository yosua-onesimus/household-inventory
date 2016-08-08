package model.obj.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "hi_voucher_types")
@CCTypeConfig(label = "Voucher Type", uniqueKey = "@operator.name-@nominal", parameter = true)
public class HiVoucherType extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name", requestFocus = true)
    private HiOperator operator;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String nominal;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT)
    private Double purchasePrice = 0d;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT)
    private Double salePrice = 0d;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public HiOperator getOperator() {
        return operator;
    }

    public void setOperator(HiOperator operator) {
        this.operator = operator;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
//</editor-fold>
}