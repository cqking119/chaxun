package entity;

import java.util.List;

/**
 * Created by Malu on 2017-05-23.
 */
public class ResultInfoNew {
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    private  long total;
    private List<?> rows;
}
