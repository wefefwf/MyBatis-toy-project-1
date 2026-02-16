package com.mytreasurearchive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytreasurearchive.domain.Item;
import com.mytreasurearchive.mapper.MainMapper;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mainMapper;
	//전체 리스트 들고오기
	public List<Item> itemList(){
		return mainMapper.itemList();
	};
}
