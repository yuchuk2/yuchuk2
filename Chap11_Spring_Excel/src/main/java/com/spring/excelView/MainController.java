package com.spring.excelView;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/excel")
	public String view() {
		
		return "home";
		
	}
	
	@RequestMapping("/downExcel")
	public ModelAndView downExcel() {
		
		List<Book> listBooks = new ArrayList<Book>();
		
		listBooks.add(new Book("스프링 프레임워크", "김말똥", "00001", "2012-05-21", 32000));
		listBooks.add(new Book("자바의 정석", "남궁운", "00002", "2017-07-11", 40000));
		listBooks.add(new Book("자바 기초", "김개똥", "00003", "2013-05-21", 32000));
		listBooks.add(new Book("자바 네트워킹", "이말똥", "00004", "2015-11-22", 20000));
		listBooks.add(new Book("JSP 프로그래밍", "고말똥", "00005", "2017-12-05", 30000));
		listBooks.add(new Book("스트럿츠", "홍말똥", "00006", "2018-03-04", 45000));
		listBooks.add(new Book("안드로이드 스튜디오", "박말똥", "00007", "2019-03-03", 35000));
		
		return new ModelAndView("excelView", "BookLists", listBooks);
	}
}







