package com.example.study.actions;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.example.study.entities.MyFile;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/file")
public class FileAction extends ActionSupport {
	//上传文件集合
	public File file;
	//上传文件名集合
	public String fileName;
	
	public InputStream inputStream;
//	public InputStream getInputStream() {
//		return inputStream;
//	}

	public Integer courseId;
	private String studentId;
	private Integer homeworkId;
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Map<String,Object> data;

	public Map<String, Object> getData() {
		return data;
	}
	
	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setfileName(String fileName) {
		this.fileName = fileName;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Action(value="uploadfile",results=@Result(type="json"))
	public String uploadFile() throws FileNotFoundException, IOException {
		try {
			data=new HashMap<String, Object>();
			
			InputStream in = new FileInputStream(file);
			String dir = ServletActionContext.getRequest().getRealPath("/courseFiles/"+courseId);  //资源存储路径

			File uploadFile = new File(dir, fileName);  //上传文件
			File courseFile= new File(dir);  //课程文件目录
			if(!courseFile.isDirectory()){
				courseFile.mkdir();
			}
			OutputStream out = new FileOutputStream(uploadFile);

			byte[] buffer = new byte[1024 * 1024];

			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			data.put("status", true);
			return SUCCESS;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		} catch (IOException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		}

	}
	
	@Action(value="uploadHomework",results=@Result(type="json"))
	public String uploadHomework() throws FileNotFoundException, IOException {
		try {
			data=new HashMap<String, Object>();
			
			InputStream in = new FileInputStream(file);
			String dir = ServletActionContext.getRequest().getRealPath("/homework/teacher/"+courseId);  //资源存储路径

			File uploadFile = new File(dir, fileName);  //上传文件
			File courseFile= new File(dir);  //课程文件目录
			if(!courseFile.isDirectory()){
				courseFile.mkdir();
			}
			OutputStream out = new FileOutputStream(uploadFile);

			byte[] buffer = new byte[1024 * 1024];

			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			String relativePath = "/homework/teacher/"+courseId+"/"+fileName;
			data.put("resourceLocation", relativePath);
			return SUCCESS;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		} catch (IOException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		}

	}
	@Action(value="uploadResource",results=@Result(type="json"))
	public String uploadResource() throws FileNotFoundException, IOException {
		try {
			data=new HashMap<String, Object>();
			
			InputStream in = new FileInputStream(file);
			String dir = ServletActionContext.getRequest().getRealPath("/resource/"+courseId);  //资源存储路径

			File uploadFile = new File(dir, fileName);  //上传文件
			File courseFile= new File(dir);  //课程文件目录
			if(!courseFile.isDirectory()){
				courseFile.mkdir();
			}
			OutputStream out = new FileOutputStream(uploadFile);

			byte[] buffer = new byte[1024 * 1024];

			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			String relativePath = "/resource/"+courseId+"/"+fileName;
			data.put("resourcePath", relativePath);
			return SUCCESS;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		} catch (IOException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		}

	}
	@Action(value="submitHomework",results=@Result(type="json"))
	public String submitHomework() throws FileNotFoundException, IOException {
		try {
			data=new HashMap<String, Object>();
			
			InputStream in = new FileInputStream(file);
//			//父文件夹
//			String parentDir = ServletActionContext.getRequest().getRealPath("/homework/student/"+homeworkId);
//			File parentFile = new File(parentDir);
//			if(!parentFile.isDirectory())
//			{
//				parentFile.mkdir();
//			}
			String dir = ServletActionContext.getRequest().getRealPath("/homework/student/"+homeworkId);  //资源存储路径

			File uploadFile = new File(dir, fileName);  //上传文件
			File courseFile= new File(dir);  //课程文件目录
			if(!courseFile.isDirectory()){
				courseFile.mkdirs();
			}
			OutputStream out = new FileOutputStream(uploadFile);

			byte[] buffer = new byte[1024 * 1024];

			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			// /homework/student/homeworkId/studentId/fileName
			String relativePath = "/homework/student/"+homeworkId+"/"+fileName;
			data.put("filePath", relativePath);
			return SUCCESS;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		} catch (IOException ex) {
			ex.printStackTrace();
			data.put("status", false);
			return SUCCESS;
		}

	}
	
	//得到课程文件夹下的所有资源
	@Action(value="getResourcesByCourseId",results=@Result(type="json"))
	public String courseFile(){
		String dir = ServletActionContext.getRequest().getRealPath("/courseFiles/"+courseId);  //资源存储路径
		File courseFile= new File(dir);
		File[] fList=courseFile.listFiles();
		List<MyFile> files=new ArrayList<MyFile>();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		for(int i=0;i<fList.length;i++){
			if(fList[i].isFile()){
				System.out.println(fList[i].getName());
				System.out.println(fList[i].lastModified());
				files.add(new MyFile(fList[i].getName(),df.format(new Date(fList[i].lastModified())),courseId));
			}
		}
		data=new HashMap<String, Object>();
		
		data.put("data", files);
		return SUCCESS;
		
	}
	//打包下载
	@Action(value="downloadPackage",results=@Result(type="stream",params={"contentType","application/octet-stream","inputName","inputStream","contentDispostion","attachment;filename=\"qwe.txt\"","bufferSize","4096"}))
	public String downloadPackage(){
		String dir = ServletActionContext.getRequest().getRealPath("/homework/student/"+ homeworkId); 
		String zipFilePath=ServletActionContext.getRequest().getRealPath("/zip/"+username+".zip");
		File parentFile = new File(dir);
		File[] files= parentFile.listFiles();
		ZipFileUtil.compressFiles2Zip(files, zipFilePath);
		data = new HashMap<String, Object>();
		data.put("path", zipFilePath);
		inputStream =ServletActionContext.getServletContext().getResourceAsStream("/zip/"+username+".zip");
		return SUCCESS;
	}
	
}
