package com.mytreasurearchive.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		
		   if (!itemList.isEmpty()) {
		        Random random = new Random();
		        int randomIndex = random.nextInt(itemList.size());
		        Item randomItem = itemList.get(randomIndex);
		        model.addAttribute("randomItem", randomItem);
		    }
		
		model.addAttribute("itemList",itemList);
		return "views/main";
	}
	//카테고리에 맞게 들고오기
	@GetMapping("/items/{category}")
	public String goCategory(@PathVariable("category") String category, Model model) {
		
		//카테고리에 맞는 List들고 와서 출력
		List<Item> itemList = mainService.getCategory(category);

		   if (!itemList.isEmpty()) {
		        Random random = new Random();
		        int randomIndex = random.nextInt(itemList.size());
		        Item randomItem = itemList.get(randomIndex);
		        model.addAttribute("randomItem", randomItem);
		    }
		model.addAttribute("itemList",itemList);
		return "views/main";
	}
	
	//추가 폼 가기
	@GetMapping("/addForm")
	public String goAddForm(){
		return "views/addForm";
	}
}
