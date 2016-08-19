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
@Table(name = "hi_deposits")
@CCTypeConfig(label = "Deposit", uniqueKey = "code")
public class HiDeposit extends CCEntity {

    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "[yyyy]/[MM]/[dd]/00", unique = true, requestFocus = true)
    private String code;
    @Column(name = "date_")
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.DATE)
    private Date date = new Date();
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT)
    private Double amount = 0d;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
//</editor-fold>
}