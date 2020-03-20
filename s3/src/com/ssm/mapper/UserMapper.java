package com.ssm.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssm.entity.User;

public interface UserMapper {
//	public List<User> findAll();

	public void add(User user);

	public void updateById(User user);

	public int deleteById(Integer id);

	public User selectById(Integer id);
	
	public User selectByName(String name);
	
	public User loginByNameAndPassword(User user );
	
	public int selectCount();
	
	public List<User> findByPage(HashMap<String,Object> map);


}
