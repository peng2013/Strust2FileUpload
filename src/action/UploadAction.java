package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File upload;//��װ�ϴ��ļ��������
	private String uploadContentTypeString;//��װ�ϴ��ļ����͵�����
	private String uploadFileNameString;//��װ�ϴ��ļ���������
	//��װ�ϴ��ļ����ļ��������ԣ��ļ������֣��������ļ�·����
	private String filename;
	//��װ�ϴ��ļ������ڷ������е�·����ͨ����������
	private String uploadPathString;
	private String resultString;//��װ������������
	private String allowTypeString;//��װ�����ϴ����ļ����͵����ԣ�ͨ����������
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
	//�˶Ե�ǰ�ϴ��ļ��������Ƿ�����
	private boolean allowType(String contentType){
		//���Զ��ŷָ����ϴ��ļ����������ת����String����ɨ�����е��ļ����ͣ��Բ����Ƿ���ڵ�ǰ�ϴ��ļ�������
		String[] types=allowTypeString.split(",");
		for(String type:types){
			//��ǰ�ϴ��ļ������ͱ���������true
			if(contentType.equals(type.trim()))
				return true;
		}
		return false;//��ǰ�ļ�������������false
	}
	//�����ϴ��ļ�����
	@Override
	public String execute() throws Exception {
		//�˶Ե�ǰ�ϴ��ļ��������Ƿ�����
		if(!allowType(uploadContentTypeString)){
			resultString="�������ϴ������͵��ļ�";
		}
		else{
		String fn="";
		//������ļ���δ���룬��ʹ���ϴ��ļ����ļ�����Ϊ������������ļ���
		if(filename.equals("")){
			fn=uploadPathString+uploadFileNameString;//����ϴ��ļ���
		}else{
			fn=uploadPathString+filename;
			System.out.println("�ļ�·��"+fn);
		}
		//�������������ͬ�����ļ����������ʾ��Ϣ
		if(new File(fn).exists()){
			resultString="���ļ��Ѿ����ڣ���δ���ļ�ָ��һ���µ��ļ�����";
		}else{
			//�ļ������
			FileOutputStream fos=new FileOutputStream(fn);
			//�ļ�������
			InputStream iStream=new FileInputStream(upload);
			//ÿ�ζ�ȡ8K�ֽ�
			byte[] buffer=new byte[8192];
			int count=0;
			//ͨ��ѭ��ʵ���ļ��ϴ�
			while((count=iStream.read(buffer))>0){
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
			resultString="�ļ��ϴ��ɹ���";
			System.out.println("�ļ��ϴ��ɹ�"+resultString);
		}
	}
		return "result";
	}
	

}
