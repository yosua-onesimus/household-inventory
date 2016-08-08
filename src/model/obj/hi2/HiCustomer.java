package model.obj.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.AccessValue;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "hi_customers")
@CCTypeConfig(label = "Customer", uniqueKey = "name", parameter = true)
public class HiCustomer extends CCEntity {

    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(visible = false)
    private String address;
    @Column(length = 32)
    @CCFieldConfig(type = Type.EMAIL, unique = true)
    private String email;
    @Column(length = 32)
    @CCFieldConfig(unique = true)
    private String facebook;
    /**
     * plus:receivable<br/>
     * minus:payable
     */
    @CCFieldConfig(accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT)
    private Double balance = 0d;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE}, mappedBy = "customer")
    @CCFieldConfig(visible2 = false, onDelete = OnDelete.CASCADE)
    private List<HiCustomerPhone> customerPhones;
    @CCFieldConfig(accessValue = AccessValue.METHOD, maxLength = Short.MAX_VALUE, visible = true, visible2 = false)
    transient private String phones;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<HiCustomerPhone> getCustomerPhones() {
        return customerPhones;
    }

    public void setCustomerPhones(List<HiCustomerPhone> customerPhones) {
        this.customerPhones = customerPhones;
    }

    public String getPhones() {
        if (isNull(phones)) {
            phones = "";
            for (HiCustomerPhone customerPhone : customerPhones) {
                phones += (phones.isEmpty() ? "" : "\n") + customerPhone.getPhone();
            }
        }
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
//</editor-fold>
}