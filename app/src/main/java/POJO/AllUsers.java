package POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 5/23/2018.
 */

public class AllUsers implements Serializable {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}