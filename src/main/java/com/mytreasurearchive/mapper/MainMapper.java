package com.mytreasurearchive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mytreasurearchive.domain.Item;

@Mapper
public interface MainMapper {

	List<Item> itemList();
}
