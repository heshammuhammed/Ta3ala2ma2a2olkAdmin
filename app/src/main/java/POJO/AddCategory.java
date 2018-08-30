package POJO;

import java.io.Serializable;

/**
 * Created by HeshamMuhammed on 6/2/2018.
 */

public class AddCategory implements Serializable{

    private Integer mainCategoriesId;
    private String subCatName;
    private String description;

    public Integer getMainCategoriesId() {
        return mainCategoriesId;
    }

    public void setMainCategoriesId(Integer mainCategoriesId) {
        this.mainCategoriesId = mainCategoriesId;
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
