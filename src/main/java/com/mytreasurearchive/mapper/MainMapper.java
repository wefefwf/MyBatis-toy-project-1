package com.mytreasurearchive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mytreasurearchive.domain.Item;

@Mapper
public interface MainMapper {

	//전체 리스트
	List<Item> itemList();
	
	//카테고리 리스트
	List<Item> getCategory(@Param("category")String category);
}
