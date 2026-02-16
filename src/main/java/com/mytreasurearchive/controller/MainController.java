package com.mytreasurearchive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mytreasurearchive.domain.Item;
import com.mytreasurearchive.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	//메인 페이지 가기
	//전체 리스트 들고오기
	@GetMapping({"/","","/mytreasurearchive","/main"})
	public String goMain(Model model){
		
		List<Item> itemList = mainService.itemList();
		model.addAttribute("itemList",itemList);
		return "/views/main";
	}

}
