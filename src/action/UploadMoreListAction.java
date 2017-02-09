package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreListAction extends ActionSupport {
	private List<File> upload;//封装上传文件域属性
	private List<String>uploadContentType;//封装上传文件类型的属性
	private List<String>uploadFileName;//封装上传文件名的属性
	//封装上传文件保存在服务器的路径，通过参数设置
	private String uploadPath;
	private String result;
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String execute() throws Exception {
		//循环处理所有上传文件
		for(int i=0;i<uploadFileName.size();i++){
			//获得保存子啊服务端的上传文件名
			uploadPath="D://upload//";
			String fn=uploadPath+uploadFileName.get(i);
			System.out.println("fn="+fn);
		//创建文件按输出流对象]
			FileOutputStream fos=new FileOutputStream(fn);
			//创建文件上传输入流对象
			InputStream iStream=new FileInputStream(upload.get(i));
			byte[]buffer=new byte[8192];
			int count=0;
			//通过循环实现上传文件
			while((count=iStream.read(buffer))>0){
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
		}
		result="文件上传成功!";
		return "result";
	}
	
	
	

}
