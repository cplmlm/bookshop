package cn.edu.svtcc.bookshop.dao;

import cn.edu.svtcc.bookshop.entity.Users;

public interface IUserDao {
	//�õ���¼���û���������
public Users doLogin(String name,String pwd);
//����û�
public boolean addUser(Users u);

}
