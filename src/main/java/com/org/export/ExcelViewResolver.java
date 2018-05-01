//package com.org.export;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.web.servlet.view.document.AbstractXlsView;
//
//public class ExcelViewResolver extends AbstractXlsView{
//
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		String[] columns = {"id","name","author"};
//
//		String[] value = {"1","Java","Danis Rich"};
//		
//		List<Sheet> sheets = new  ArrayList<>(); 
//		
//		for(int i=0; i<3; i++) {
//			sheets.add(workbook.createSheet("Sheet " + i));
//		}
//		for(int i=0; i<3; i++) {
//			Row row = sheets.get(0).createRow(i);
//			for(int j = 0; j < columns.length; j++) {
//				
//	           row.createCell(0)
//	            .setCellValue(columns[j]);
//	           
//	           row.createCell(1)
//	           .setCellValue(value[j]);
//	        }
//		}
//		
//		OutputStream stream = new FileOutputStream("Book-c.xlsx");
//		workbook.write(stream);
//		stream.close();
//	}
//
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
