package cn.edu.svtcc.bookshop.dao;

import cn.edu.svtcc.bookshop.entity.Users;

public interface IUserDao {
	//得到登录的用户名和密码
public Users doLogin(String name,String pwd);
//添加用户
public boolean addUser(Users u);

}
