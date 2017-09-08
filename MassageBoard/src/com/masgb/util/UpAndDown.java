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
	 //�ϴ��ļ�·��
		if(!ServletFileUpload.isMultipartContent(request)){  //����ǲ��Ƕ�ý���ļ�
			try {
				response.getWriter().append("���ļ����Ƕ�ý���ļ�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();   
		factory.setSizeThreshold(MEMORY_THRESHOLD);      //�����ļ��ϴ��ڴ��С
		factory.setRepository(new File(bashpath)); //�����ļ�����ʱĿ¼4		
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
	//bashPath�������ļ�·��,fileName,�ļ���	
	 request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ��ȡ�����ļ�·��
		// ��ȡӦ��// ��ȡ��Ҫ�����ļ�������λ��
		// ��ȡ�û�Ҫ��������ļ�����
		// ���� �ļ����·�� ���û�Ҫ��·�� ���� ����·��
		Path fullPath = Paths.get(basePath + "/" + fileName);//·����Դ
		System.out.print(fullPath);
		if(fileName!=null&&Files.exists(fullPath)) {
			String encodedFileName = URLEncoder.encode(fileName,"UTF-8");// �������ļ������� �������������޷�����ʹ�õ�����
			// ���÷���ͷ��
			response.setHeader("content-disposition", "attachment; filename="+encodedFileName);// ������Ӧ��Ϣ��Ĵ���ʽ(���� include ���� attachment)
			//response.setHeader("content-disposition", "include; filename="+encodedFileName);// ������Ӧ��Ϣ��Ĵ���ʽ(���� include ���� attachment)
			Files.copy(fullPath, response.getOutputStream());// �����ļ��������
			return true;
		}
		return false;
 }
}
