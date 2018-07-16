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
	 * <if test="statement"></if>
	 */
	List<Map<String, String>> getUseDynamicSql1(Map<String, String> map);
	
	/**
	 * <choose>
	 * 	<when test="condition">
	 * 	<otherwise>
	 *  </otherwise>
	 * </choose>
	 * 
	 */
	List<Map<String, String>> getUseDynamicSql2(Map<String, String> map);
	
	/**
	 * <foreach item="array" index="index" collection="list" open="(" separator="," close=")">
	 * </foreach>
	 */
	List<Map<String, String>> getUseDynamicSql3(List<String> userList);
	
}
