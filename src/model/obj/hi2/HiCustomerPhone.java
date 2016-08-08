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
@Table(name = "hi_customer_phones")
@CCTypeConfig(label = "Customer Phone", uniqueKey = "phone")
public class HiCustomerPhone extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", visible = false)
    private HiCustomer customer;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.PHONE_NUMBER, unique = true, requestFocus = true)
    private String phone;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public HiCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(HiCustomer customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
//</editor-fold>
}