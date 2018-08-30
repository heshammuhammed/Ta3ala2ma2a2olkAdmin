package POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public class MainCategory implements Serializable{

    private Integer mainCategoriesId;
    private String catName;
    private List<SubCategory> subCatCollection = null;


    public Integer getMainCategoriesId() {
        return mainCategoriesId;
    }

    public void setMainCategoriesId(Integer mainCategoriesId) {
        this.mainCategoriesId = mainCategoriesId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<SubCategory> getSubCatCollection() {
        return subCatCollection;
    }

    public void setSubCatCollection(List<SubCategory> subCatCollection) {
        this.subCatCollection = subCatCollection;
    }
}
