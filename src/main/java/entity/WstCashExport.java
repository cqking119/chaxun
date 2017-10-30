package entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Malu on 2017-07-14.
 */
public class WstCashExport {



    private  String cltname ;
    private BigDecimal totalbeforemonthamount;
    private BigDecimal totalcansweepbalance;

    public String getCltname() {
        return cltname;
    }

    public void setCltname(String cltname) {
        this.cltname = cltname;
    }

    public BigDecimal getTotalbeforemonthamount() {
        return totalbeforemonthamount;
    }

    public void setTotalbeforemonthamount(BigDecimal totalbeforemonthamount) {
        this.totalbeforemonthamount = totalbeforemonthamount;
    }

    public BigDecimal getTotalcansweepbalance() {
        return totalcansweepbalance;
    }

    public void setTotalcansweepbalance(BigDecimal totalcansweepbalance) {
        this.totalcansweepbalance = totalcansweepbalance;
    }

    public String getCancashsweepratemean() {
        return cancashsweepratemean;
    }

    public void setCancashsweepratemean(String cancashsweepratemean) {
        this.cancashsweepratemean = cancashsweepratemean;
    }

    public BigDecimal getTotalcurrencymoneybalance() {
        return totalcurrencymoneybalance;
    }

    public void setTotalcurrencymoneybalance(BigDecimal totalcurrencymoneybalance) {
        this.totalcurrencymoneybalance = totalcurrencymoneybalance;
    }

    public String getCashsweepratemean() {
        return cashsweepratemean;
    }

    public void setCashsweepratemean(String cashsweepratemean) {
        this.cashsweepratemean = cashsweepratemean;
    }

    public BigDecimal getBeforemonthamount() {
        return beforemonthamount;
    }

    public void setBeforemonthamount(BigDecimal beforemonthamount) {
        this.beforemonthamount = beforemonthamount;
    }

    public BigDecimal getCansweepbalance() {
        return cansweepbalance;
    }

    public void setCansweepbalance(BigDecimal cansweepbalance) {
        this.cansweepbalance = cansweepbalance;
    }

    public String getCancashsweeprate() {
        return cancashsweeprate;
    }

    public void setCancashsweeprate(String cancashsweeprate) {
        this.cancashsweeprate = cancashsweeprate;
    }

    public BigDecimal getCurrencymoneybalance() {
        return currencymoneybalance;
    }

    public void setCurrencymoneybalance(BigDecimal currencymoneybalance) {
        this.currencymoneybalance = currencymoneybalance;
    }

    public String getCashsweeprate() {
        return cashsweeprate;
    }

    public void setCashsweeprate(String cashsweeprate) {
        this.cashsweeprate = cashsweeprate;
    }

    private String cancashsweepratemean;
    private BigDecimal totalcurrencymoneybalance;
    private String cashsweepratemean;
    private BigDecimal beforemonthamount;
    private  BigDecimal cansweepbalance;
    private String cancashsweeprate;
    private BigDecimal currencymoneybalance;
    private String cashsweeprate;





}
