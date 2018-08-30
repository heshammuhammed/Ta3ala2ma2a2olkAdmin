package POJO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public class Report implements Serializable{

    private Integer reportId;
    private String msg;
    private String title;
    private String type;
    private String reportDate;
    private Integer checked;
    private Integer action;
    private TaaUser personId;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public TaaUser getPersonId() {
        return personId;
    }

    public void setPersonId(TaaUser personId) {
        this.personId = personId;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}