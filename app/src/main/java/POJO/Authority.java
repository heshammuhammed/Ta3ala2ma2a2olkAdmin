package POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public class Authority implements Serializable {

    private Integer authorityId;
    private String name;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
