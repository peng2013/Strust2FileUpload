package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreAction extends ActionSupport {
	/*
	 * 在Action中使用了三个属性封装文件信息：

      File类型的XXX属性，与表单的File控件的name属性一样，用于封装File控件对应的文件内容

      String类型的xxxFileName属性，该属性名称由前面的File类型属性和FileName组合，是固定的语法，是封装File控件对应文件的文件名

      String类型的XXXContentType属性，同样由xxx属性和ContentType组合而成，是固定语法，封装File控件对应文件的文件类型
	 */
	private File[] upload;//封装上传文件域的属性
	private String[] uploadContentType;//封装上传文件类型的属性
	private String[]uploadFileName;//封装上传文件名的属性
	//封装上传文件保存在服务器的路径
	private String uploadPathString;
	private String resultString;//封装处理结果的属性
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
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
	//执行逻辑业务
	@Override
	public String execute() throws Exception {
		try{
		//依次上传每一个文件
		for(int i=0;i<upload.length;i++){
			//得到上传文件保存在服务器的文件名
			uploadPathString="D:\\upload";
			//String fn=uploadPathString+uploadFileNameStrings[i];
			FileOutputStream fos=new FileOutputStream(getUploadPathString()+"\\"+this.getUploadFileName()[i]);
			//System.out.println("filename="+uploadFileNameStrings[i]+"fn="+fn);
			InputStream iStream=new FileInputStream(getUpload()[i]);
			byte[] buffer=new byte[8129];//每次读取8K字节
			int count=0;
			while((count=iStream.read(buffer))>0){
				System.out.println("再写");
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
		}
		resultString="文件上传成功！";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	

}
