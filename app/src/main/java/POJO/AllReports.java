package POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 5/23/2018.
 */

public class AllReports implements Serializable {

    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}