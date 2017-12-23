package edu.mallsystem.bean;

import java.util.List;

/**
 * ��ҳ��
 * @author Administrator
 *
 */
public class PageBean {
	private int cpage = 1;		//��ǰҳ,Ĭ�ϵ�1ҳ
	private int showNum = 12;	//ÿҳ����������,Ĭ��5��
	private int allPage = 0;	//��ҳ��
	private int allNum = 0;		//����������
	
	private List result;		//ÿҳҪ��ʾ������

	public PageBean() {
		super();
	}

	public PageBean(int cpage, int showNum, int allPage, int allNum, List result) {
		this.cpage = cpage;
		this.showNum = showNum;
		this.allPage = allPage;
		this.allNum = allNum;
		this.result = result;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getAllNum() {
		return allNum;
	}

	//���������������ķ���
	public void setAllNum(int allNum) {
		this.allNum = allNum;
		//���֪�������������Ϳ��Լ�����ҳ��
		if(this.allNum%this.showNum==0){
			this.allPage = this.allNum/this.showNum;
		}else{
			this.allPage = this.allNum/this.showNum+1;
		}
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}
	
}
