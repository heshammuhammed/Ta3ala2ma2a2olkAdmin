package POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 6/11/2018.
 */

public class CustomerService implements Serializable {

    private String service;
    private String joinDate;
    private String expDate;
    private Integer personId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
