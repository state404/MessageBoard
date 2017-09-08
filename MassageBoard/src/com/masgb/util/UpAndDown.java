package com.masgb.util;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpAndDown {
	   private static final int MEMORY_THRESHOLD=1024*1024*3;
	     private static final int MAX_FILE_SIZE=1024*1024*40;
	     private static final int MAX_REQUEST_SIZE=1024*1024*50;
	     public static String getparamter(Map<String,String> map,String key){
	    	 if(map.containsKey(key))
	    	 {
	    		 return map.get(key); 
	    	 }
	    	 else
	    	 {
	    		 return null;
	    	 }
	     }
 public static Map<String,String> upload(String bashpath,HttpServletRequest request, HttpServletResponse response){
	 //上传文件路径
		if(!ServletFileUpload.isMultipartContent(request)){  //检测是不是多媒体文件
			try {
				response.getWriter().append("该文件不是多媒体文件");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();   
		factory.setSizeThreshold(MEMORY_THRESHOLD);      //设置文件上传内存大小
		factory.setRepository(new File(bashpath)); //设置文件的临时目录4		
		ServletFileUpload up=new ServletFileUpload(factory);
		up.setFileSizeMax(MAX_FILE_SIZE);
		up.setHeaderEncoding("utf-8");
		up.setSizeMax(MAX_REQUEST_SIZE);
		Map<String,String> param = new HashMap<String, String>(); 
		File updir=new File(bashpath);
		if(!updir.exists()){
			updir.mkdir();
		}
		
	 List<FileItem> list;
	try {
		list = up.parseRequest(request);
		  if(list!=null){
			  String strs=null;
			  int cnt=1;
			  for(FileItem item:list){
				 
					  if(item.isFormField()){
						  String string=new String(item.getString().getBytes("ISO-8859-1"),"utf-8");
						  System.out.println(string);
						  param.put(item.getFieldName(),string);
					  }else{
						  String filename=item.getName();
						  if(cnt==1)
						  {
							  strs=filename;
						  }
						  else
						  {
							  strs=strs+" "+filename;
						  }
						  cnt++;
						  if(strs.equals(""))
						  {
							  param.put(item.getFieldName(), null);
						  }
						  else
						  {
							  param.put(item.getFieldName(), strs);
							  String filePath=bashpath+File.separator+filename;
							  File storePath=new File(filePath);
							  item.write(storePath);
						  }
					  }
				  }
			  
			  return param;
		  }
	} catch (FileUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
 }
 public static  boolean  download(String basePath,String fileName,HttpServletRequest request, HttpServletResponse response) throws Exception{
	//bashPath，下载文件路径,fileName,文件名	
	 request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取下载文件路径
		// 获取应用// 获取需要配置文件的下载位置
		// 获取用户要求的下载文件名字
		// 根据 文件存放路径 及用户要求路径 生成 完整路径
		Path fullPath = Paths.get(basePath + "/" + fileName);//路径资源
		System.out.print(fullPath);
		if(fileName!=null&&Files.exists(fullPath)) {
			String encodedFileName = URLEncoder.encode(fileName,"UTF-8");// 对中文文件名进行 否则会出现中文无法正常使用的问题
			// 设置返回头信
			response.setHeader("content-disposition", "attachment; filename="+encodedFileName);// 设置响应消息体的处理方式(内联 include 附件 attachment)
			//response.setHeader("content-disposition", "include; filename="+encodedFileName);// 设置响应消息体的处理方式(内联 include 附件 attachment)
			Files.copy(fullPath, response.getOutputStream());// 复制文件到输出流
			return true;
		}
		return false;
 }
}
