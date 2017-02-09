package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreAction extends ActionSupport {
	/*
	 * ��Action��ʹ�����������Է�װ�ļ���Ϣ��

      File���͵�XXX���ԣ������File�ؼ���name����һ�������ڷ�װFile�ؼ���Ӧ���ļ�����

      String���͵�xxxFileName���ԣ�������������ǰ���File�������Ժ�FileName��ϣ��ǹ̶����﷨���Ƿ�װFile�ؼ���Ӧ�ļ����ļ���

      String���͵�XXXContentType���ԣ�ͬ����xxx���Ժ�ContentType��϶��ɣ��ǹ̶��﷨����װFile�ؼ���Ӧ�ļ����ļ�����
	 */
	private File[] upload;//��װ�ϴ��ļ��������
	private String[] uploadContentType;//��װ�ϴ��ļ����͵�����
	private String[]uploadFileName;//��װ�ϴ��ļ���������
	//��װ�ϴ��ļ������ڷ�������·��
	private String uploadPathString;
	private String resultString;//��װ������������
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
	//ִ���߼�ҵ��
	@Override
	public String execute() throws Exception {
		try{
		//�����ϴ�ÿһ���ļ�
		for(int i=0;i<upload.length;i++){
			//�õ��ϴ��ļ������ڷ��������ļ���
			uploadPathString="D:\\upload";
			//String fn=uploadPathString+uploadFileNameStrings[i];
			FileOutputStream fos=new FileOutputStream(getUploadPathString()+"\\"+this.getUploadFileName()[i]);
			//System.out.println("filename="+uploadFileNameStrings[i]+"fn="+fn);
			InputStream iStream=new FileInputStream(getUpload()[i]);
			byte[] buffer=new byte[8129];//ÿ�ζ�ȡ8K�ֽ�
			int count=0;
			while((count=iStream.read(buffer))>0){
				System.out.println("��д");
				fos.write(buffer,0,count);
			}
			fos.close();
			iStream.close();
		}
		resultString="�ļ��ϴ��ɹ���";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	

}
