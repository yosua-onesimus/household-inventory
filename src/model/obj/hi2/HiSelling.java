package model.obj.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "hi_sellings")
@CCTypeConfig(label = "Selling", uniqueKey = "code")
public class HiSelling extends CCEntity {

    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "[yyyy]/[MM]/[dd]/00", unique = true, requestFocus = true)
    private String code;
    @Column(name = "date_")
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.DATE)
    private Date date = new Date();
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "@customer.name-@phone")
    private HiCustomerPhone customerPhone;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "@operator.name-@nominal")
    private HiVoucherType voucherType;
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT)
    private Double purchasePrice = 0d;
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT)
    private Double salePrice = 0d;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT)
    private Double amountPaid = 0d;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HiCustomerPhone getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(HiCustomerPhone customerPhone) {
        this.customerPhone = customerPhone;
    }

    public HiVoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(HiVoucherType voucherType) {
        this.voucherType = voucherType;
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

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
//</editor-fold>
}