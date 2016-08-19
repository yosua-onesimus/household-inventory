package model.bo.hi2;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCMath.round;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilConfigDao;
import java.util.List;
import model.dao.hi2.HiDepositDao;
import model.dao.hi2.HiVoucherTypeDao;
import model.obj.hi2.HiConfig;
import model.obj.hi2.HiVoucherType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class HiConfigBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigDao configDao;
    private HiVoucherTypeDao voucherTypeDao;
    private HiDepositDao depositDao;
    private HiSellingDao sellingDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized HiConfig loadHiConfig() {
        return configDao.loadHash(HiConfig.class);
    }

    public synchronized boolean saveConf(Object object) {
        return configDao.saveHash(object);
    }

    public synchronized boolean recalculateSaldo() {
        HiConfig config = loadHiConfig();
        config.setSaldo(depositDao.sumAmount() - sellingDao.sumPurchasePrice());
        return saveConf(config);
    }

    public synchronized boolean recalculateSaldoProfit() {
        HiConfig config = loadHiConfig();
        config.setSaldo(depositDao.sumAmount() - sellingDao.sumPurchasePrice());
        config.setProfit(sellingDao.sumProfit());
        return saveConf(config);
    }

    public synchronized boolean recalculateSalePrice() {
        HiConfig config = loadHiConfig();
        List<HiVoucherType> voucherTypes = voucherTypeDao.getListUnlimited();
        for (HiVoucherType voucherType : voucherTypes) {
            voucherType.setSalePrice(round(voucherType.getPurchasePrice() + config.getMinimalProfit(), config.getSalePriceRound()));
        }
        return voucherTypeDao.saveOrUpdate(voucherTypes);
    }
//</editor-fold>
}