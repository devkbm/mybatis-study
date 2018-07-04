package com.like.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

	/**
	 * XML 파일의 id를 호출하여 SQL 실행하는 방법 
	 * 
	 */
	List<Map<String, String>> getUseXml();
	
	/**
	 * 어노테이션을 이용하여 직접 SQL을 실행하는 방법 
	 */
	@Select("SELECT 1 as num")
	List<Map<String, String>> getUseAnnotation();
	
	/**
	 * if
	 * choose when otherwise
	 * foreach
	 */
	List<Map<String, String>> getUseDynamicSql(Map<String, String> map);
}
