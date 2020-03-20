package com.ssm.util;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
@Component
public class CacheUtil {
	@Resource
	private StringRedisTemplate redisTemplate;//redis操作模板 
	
	
	public void put(String key,String value) {
		if (key==null || "".equals(key)) {
			return;  
		} 
		redisTemplate.opsForHash().put(key,key, value); 
		
	}
 
	
	public void put(String key, Object value) {
		if (key==null || "".equals(key)) {
			return;
		}
		redisTemplate.opsForHash().put(key,key, new Gson().toJson(value));
		
	}
 
	
	public <T> T get(String key, Class<T> className) {
		Object obj = redisTemplate.opsForHash().get(key, key);
		if(obj == null){
			return null;
		}
		return new Gson().fromJson(""+obj, className);
	}
 
	
	public String get(String key) {
		Object obj = redisTemplate.opsForHash().get(key, key);
		if(obj == null){
			return null;
		}else{
			return String.valueOf(obj);
		}
	}
	


}
