package com.spring.excelView;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Book> listBooks = (List<Book>)model.get("BookLists");
		
		// HSSF 클래스 : 스프레드 시트를 읽는 방법을 제공함. xls 스프레드 시트를 작성, 수정,
		//             읽기 및 쓰기 기능을 제공하는 클래스.
		HSSFSheet sheet = workbook.createSheet("자바책");
		sheet.setDefaultColumnWidth(20);  // 셀의 크기 지정(폭 지정)
		
		// 폰트 만들기
		HSSFFont font = workbook.createFont();
		font.setFontName("맑은고딕");  // 글꼴
		
		// 셀 스타일 지정
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.BLACK.index);
		style.setFont(font);
		
		// 타이틀 행(row)를 추가
		HSSFRow title = sheet.createRow(0);
		
		title.createCell(0).setCellValue("제목");
		title.getCell(0).setCellStyle(style);
		
		title.createCell(1).setCellValue("저자");
		title.getCell(1).setCellStyle(style);
		
		title.createCell(2).setCellValue("ISBN");
		title.getCell(2).setCellStyle(style);
		
		title.createCell(3).setCellValue("출판일");
		title.getCell(3).setCellStyle(style);
		
		title.createCell(4).setCellValue("가격");
		title.getCell(4).setCellStyle(style);
		
		// 책의 정보를 저장
		int rowCnt = 1;
		
		for(Book book : listBooks) {
			HSSFRow row = sheet.createRow(rowCnt++);
			row.createCell(0).setCellValue(book.getSubject());
			row.createCell(1).setCellValue(book.getAuthor());
			row.createCell(2).setCellValue(book.getIsbn());
			row.createCell(3).setCellValue(book.getPublishDate());
			row.createCell(4).setCellValue(book.getPrice());
		}
		
	}

}




