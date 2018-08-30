package POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public class SubCategory implements Serializable {

    private Integer subCatId;
    private String subCatName;
    private String description;

    public Integer getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }

    public String getSubCatName() {
        return subCatName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
