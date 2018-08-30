package POJO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public class TaaUser implements Serializable {

    private String phone;
    private String city;
    private String district;
    private String country;
    private Object rate;
    private String birthofdate;
    private Integer personId;
    private User person;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public String getBirthofdate() {
        return birthofdate;
    }

    public void setBirthofdate(String birthofdate) {
        this.birthofdate = birthofdate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
