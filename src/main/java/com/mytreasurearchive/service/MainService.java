package com.mytreasurearchive.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mytreasurearchive.domain.Item;
import com.mytreasurearchive.mapper.MainMapper;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mainMapper;
	
	//파일 저장 경로
	@Value("${file.upload-dir}")
	private String uploadPath;	
	
	//전체 리스트 들고오기
	public List<Item> itemList(){
		return mainMapper.itemList();
	};
	
	//카테고리 리스트 들고오기
	public List<Item> getCategory(String category){
		return mainMapper.getCategory(category);
	}
	
	//글 추가
	public void add(Item item, MultipartFile file) throws Exception {

	    if(file != null && !file.isEmpty()) {

	        File parent = new File(uploadPath);
	        if(!parent.exists()) parent.mkdirs();

	        UUID uid = UUID.randomUUID();
	        String extension =
	            StringUtils.getFilenameExtension(file.getOriginalFilename());

	        //저장명 만들기
	        String saveName = uid.toString() + "." + extension;

	        // 1. 파일 만들어서 경로 바꾸기
	        File savedFile = new File(parent, saveName);
	        file.transferTo(savedFile);

	        
	        // 2. DB에는 파일명만 저장
	        item.setImage(saveName);
	    }

	    // 3. mapper insert 실행
	    mainMapper.add(item);
	}

	//제거 
	public void delete(long id){
		mainMapper.delete(id);
	}
	
	//게시글 하나 가져오기
	public Item getItem(long id){
		return mainMapper.getItem(id);
	}
}
