package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreListAction extends ActionSupport {
	private List<File> upload;//��װ�ϴ��ļ�������
	private List<String>uploadContentType;//��װ�ϴ��ļ����͵�����
	private List<String>uploadFileName;//��װ�ϴ��ļ���������
	//��װ�ϴ��ļ������ڷ�������·����ͨ����������
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
		//ѭ�����������ϴ��ļ�
		for(int i=0;i<uploadFileName.size();i++){
			//��ñ����Ӱ�����˵��ϴ��ļ���
			uploadPath="D://upload//";
			String fn=uploadPath+uploadFileName.get(i);
			System.out.println("fn="+fn);
		//�����ļ������������]
			FileOutputStream fos=new FileOutputStream(fn);
			//�����ļ��ϴ�����������
			InputStream iStream=new FileInputStream(upload.get(i));
			byte[]buffer=new byte[8192];
			int count=0;
			//ͨ��ѭ��ʵ���ϴ��ļ�
			while((count=iStream.read(buffer))>0){
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
		}
		result="�ļ��ϴ��ɹ�!";
		return "result";
	}
	
	
	

}
