package com.example.study.actions;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.example.study.entities.MyFile;
import com.opensymphony.xwork2.ActionSupport;



@ParentPackage("mypackage")
@Namespace("/file")
public class FileAction3 extends ActionSupport {
	//上传文件集合
	public File upFile;
	//上传文件名集合
	public String fileFileName;

	public String courseId;
	
	public Map<String,Object> data;

	public Map<String, Object> getData() {
		return data;
	}


	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
	//文件批量下载
	public String downFileName;
	public String[] fileNames;
	public InputStream inputStream;
	public String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public InputStream getInputStream() {
		return inputStream;
	}
	public String getDownFileName() throws UnsupportedEncodingException {
		downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		return downFileName;
	}


	
	@Action(value="downloadcoursefile",results=@Result(type="stream",params={"contentType","application/octet-stream","inputName","inputStream","contentDispostion","attachment;filename=\"qwe.txt\"","bufferSize","4096"}))
	public String downloadcoursefile(){
		String dir = ServletActionContext.getRequest().getRealPath("/courseFiles/"+1); 
		String zipFilePath=ServletActionContext.getRequest().getRealPath("/zip/"+userName+".zip");
		File[] files=new File[fileNames.length];
		for(int i=0;i<files.length;i++){
			files[i]=new File(dir, fileNames[i]);
		}
		ZipFileUtil.compressFiles2Zip(files, zipFilePath);
		inputStream =ServletActionContext.getServletContext().getResourceAsStream("/zip/"+userName+".zip");
		return SUCCESS;
	}
	
	@Action(value="try",results=@Result(type="json"))
	public String gwgw() throws FileNotFoundException, IOException{
		String filePath=ServletActionContext.getRequest().getRealPath("/excel/qwe.xlsx");
		XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
		XSSFSheet sheet = wookbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < rows; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				//获取学号
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(row.getCell(0).getStringCellValue());
				System.out.println(row.getCell(1).getStringCellValue());
				System.out.println(row.getCell(2).getStringCellValue());
			}
		}
		return SUCCESS;
	}

	
}
