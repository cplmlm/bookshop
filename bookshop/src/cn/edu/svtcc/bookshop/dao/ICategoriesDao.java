package cn.edu.svtcc.bookshop.dao;
import java.util.List;
import cn.edu.svtcc.bookshop.entity.Categories;
public interface ICategoriesDao {
//得到图书的种类
public List<Categories> getCategories();
//添加图书的种类
public boolean addCategory(Categories c);
//修改图书的种类
public boolean updateCategory(Categories c);
}
