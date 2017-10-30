package entity;

/**
 * Created by Malu on 2017-05-17.
 */
public class pageinfoma {
    public String getCltno() {
        return cltno;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setCltno(String cltno) {
        this.cltno = cltno;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    private  String cltno;
    private  Integer page;
    private  Integer rownum;

}
