package cn.edu.svtcc.bookshop.dao;
import java.util.List;
import cn.edu.svtcc.bookshop.entity.Categories;
public interface ICategoriesDao {
//�õ�ͼ�������
public List<Categories> getCategories();
//���ͼ�������
public boolean addCategory(Categories c);
//�޸�ͼ�������
public boolean updateCategory(Categories c);
}
