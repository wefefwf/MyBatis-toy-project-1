package com.mytreasurearchive.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {


	    private Long id;     
	    private String category;    // movie / song / food
	    private String title;  
	    private String reason;     
	    
	    // 기획안의 extra 필드들
	    private String extra1;     
	    private String extra2;     
	    
	    private LocalDateTime createdAt; // 작성일
	    
	    private String image; //이미지 경로 
}
