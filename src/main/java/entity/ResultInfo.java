package entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmnl on 16-7-8.
 * 返回数据
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultInfo {

    /**
     * 状态
     */
    private Integer errorCode;

    /**
     * 信息
     */
    private String info;

    /**
     * 数据
     */
    private Map<String, Object> datas;

    public ResultInfo() {
        success();
    }

    public void success(){
        this.errorCode = 0;
        this.info = "操作成功";
    }

    public void faild(){
        this.errorCode = 1;
        this.info = "操作失败";
    }

    public void faild(String info){
        this.errorCode = 1;
        this.info = info;
    }

    public void faild(Integer status, String info){
        this.errorCode = status;
        this.info = info;
    }

    public void addDatas(String key, Object object){
        if(this.datas == null){
            this.datas = new HashMap<>();
        }
        this.datas.put(key, object);
    }

    public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

	@Override
	public String toString() {
		return "ResultInfo [errorCode=" + errorCode + ", info=" + info
				+ ", datas=" + datas + "]";
	}
    
}
