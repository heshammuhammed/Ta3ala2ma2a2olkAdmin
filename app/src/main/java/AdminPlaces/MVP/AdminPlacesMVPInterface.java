package AdminPlaces.MVP;

import java.util.HashMap;
import java.util.List;

import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;


/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public interface AdminPlacesMVPInterface {

    interface View {
        void ShowCategories(List<SubCategory> subCatCollection);
    }

    interface Presenter {
        void setData();
        void deleteMainCategory(SubCategory subCategory);
        void addMainCategory (AddCategory addCategory);
    }
}