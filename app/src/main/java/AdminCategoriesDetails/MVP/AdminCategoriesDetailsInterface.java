package AdminCategoriesDetails.MVP;

import java.util.List;

import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;

/**
 * Created by HeshamMuhammed on 5/29/2018.
 */

public interface AdminCategoriesDetailsInterface {


    interface View {
        void ShowSubCategories(List<SubCategory> subCatCollection);
    }

    interface Presenter {
        void setData(String name);
        void deleteMainCategory(SubCategory subCategory);
        void addMainCategory (AddCategory addCategory);
    }
}