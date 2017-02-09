package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File upload;//封装上传文件域的属性
	private String uploadContentTypeString;//封装上传文件类型的属性
	private String uploadFileNameString;//封装上传文件名的属性
	//封装上传文件新文件名的属性（文件名部分，不包含文件路径）
	private String filename;
	//封装上传文件保存在服务器中的路径，通过参数设置
	private String uploadPathString;
	private String resultString;//封装处理结果的属性
	private String allowTypeString;//封装允许上传的文件类型的属性，通过参数设置
	public String getAllowTypeString() {
		return allowTypeString;
	}
	public void setAllowTypeString(String allowTypeString) {
		this.allowTypeString = allowTypeString;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentTypeString() {
		return uploadContentTypeString;
	}
	public void setUploadContentTypeString(String uploadContentTypeString) {
		this.uploadContentTypeString = uploadContentTypeString;
	}
	public String getUploadFileNameString() {
		return uploadFileNameString;
	}
	public void setUploadFileNameString(String uploadFileNameString) {
		this.uploadFileNameString = uploadFileNameString;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUploadPathString() {
		return uploadPathString;
	}
	public void setUploadPathString(String uploadPathString) {
		this.uploadPathString = uploadPathString;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	//核对当前上传文件的类型是否被允许
	private boolean allowType(String contentType){
		//将以逗号分隔的上传文件允许的类型转换成String数组扫描所有的文件类型，以查找是否存在当前上传文件的类型
		String[] types=allowTypeString.split(",");
		for(String type:types){
			//当前上传文件的类型被允许，返回true
			if(contentType.equals(type.trim()))
				return true;
		}
		return false;//当前文件不被允许，返回false
	}
	//处理上传文件请求
	@Override
	public String execute() throws Exception {
		//核对当前上传文件的类型是否被允许
		if(!allowType(uploadContentTypeString)){
			resultString="不允许上传该类型的文件";
		}
		else{
		String fn="";
		//如果新文件名未输入，则使用上传文件的文件名作为服务器保存的文件名
		if(filename.equals("")){
			fn=uploadPathString+uploadFileNameString;//获得上传文件名
		}else{
			fn=uploadPathString+filename;
			System.out.println("文件路径"+fn);
		}
		//如果服务器存在同名的文件，则输出提示信息
		if(new File(fn).exists()){
			resultString="该文件已经存在，请未该文件指定一个新的文件名！";
		}else{
			//文件输出流
			FileOutputStream fos=new FileOutputStream(fn);
			//文件输入流
			InputStream iStream=new FileInputStream(upload);
			//每次读取8K字节
			byte[] buffer=new byte[8192];
			int count=0;
			//通过循环实现文件上传
			while((count=iStream.read(buffer))>0){
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
			resultString="文件上传成功！";
			System.out.println("文件上传成功"+resultString);
		}
	}
		return "result";
	}
	

}
