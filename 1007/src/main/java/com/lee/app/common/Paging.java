package com.lee.app.common;

public class Paging {
	
	// ������� 
		private int pageSize; // (�� �������� ���̴�)�Խñۼ�  
		private int firstPageNum; // ù��° ��������ȣ - �����ڱ��� (��ü) 
		private int prevPageNum; // ���������� ��ȣ 
		private int startPageNum; // ���������� (����¡�׺� ����) - ����� ����
		private int thisPageNum; // ������ ��ȣ - ����������(�ε���)
		private int endPageNum; //������ ������ (����¡�׺� ����)  - ����� ����
		private int nextPageNum; // ���� ������ ��ȣ 
		private int finalPageNum; //������ ������ ��ȣ - �����ڱ��� (��ü)
		private int totalPostCnt; // �Խñ� ��ü�� 
		private boolean isFirst; // ��ư ��������
		private boolean isLast; // ��ư ��������
		
		
		// Getter & Setter 
		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getFirstPageNum() {
			return firstPageNum;
		}

		public void setFirstPageNum(int firstPageNum) {
			this.firstPageNum = firstPageNum;
		}

		public int getPrevPageNum() {
			return prevPageNum;
		}

		public void setPrevPageNum(int prevPageNum) {
			this.prevPageNum = prevPageNum;
		}

		public int getStartPageNum() {
			return startPageNum;
		}

		public void setStartPageNum(int startPageNum) {
			this.startPageNum = startPageNum;
		}

		public int getThisPageNum() {
			return thisPageNum;
		}

		public void setThisPageNum(int thisPageNum) {
			this.thisPageNum = thisPageNum;
		}

		public int getEndPageNum() {
			return endPageNum;
		}

		public void setEndPageNum(int endPageNum) {
			this.endPageNum = endPageNum;
		}

		public int getNextPageNum() {
			return nextPageNum;
		}

		public void setNextPageNum(int nextPageNum) {
			this.nextPageNum = nextPageNum;
		}

		public int getFinalPageNum() {
			return finalPageNum;
		}

		public void setFinalPageNum(int finalPageNum) {
			this.finalPageNum = finalPageNum;
		}

		public int getTotalPost() {
			return totalPostCnt;
		}

		public void setTotalPost(int totalPostCnt) {
			this.totalPostCnt = totalPostCnt;
		}
		public boolean isFirst() {
			return isFirst;
		}

		public void setFirst(boolean isFirst) {
			this.isFirst = isFirst;
		}

		public boolean isLast() {
			return isLast;
		}

		public void setLast(boolean isLast) {
			this.isLast = isLast;
		}

		public Paging(int pageSize, int thisPageNum, int totalPostCnt) { // �� �������� ���� ����Ʈ����, ���� ������ �ѹ�, ��ü ������(datas.size)
			this.pageSize = pageSize;
			if(thisPageNum==0) {
				this.thisPageNum = 1;
			}else {
				this.thisPageNum = thisPageNum;
			}
			if(totalPostCnt==0) {
				return;
			}else {
				this.totalPostCnt = totalPostCnt;
			}
		}

		// paging �޼��� 
		public void makePaging() {
			// �ִ� ������ �� ����
			this.finalPageNum = (this.totalPostCnt-1)/this.pageSize+1; 

			// ���������� ��ȿ�� üũ , ������ ���������� ������������ ũ��, �������������� ����, 0���� �۰ų� ������ 1�������� ����
			if(this.thisPageNum>this.finalPageNum) {
				this.setThisPageNum(this.finalPageNum);
			}
			if(this.thisPageNum<=0) {
				this.thisPageNum=1;
			}

			this.isFirst = this.thisPageNum==1?true:false; //���������� (��ü)   
			this.isLast = this.thisPageNum==finalPageNum?true:false; //������������(��ü)

			int blockLastPageNum = this.finalPageNum; // ����� ������ �������� ���ڸ� ���� ������ �������� �ѹ��� �ʱ�ȭ
			this.setFirstPageNum(1); // ù��° ������ ��ȣ 
			int blockStartPageNum = this.firstPageNum; // ����� ù��° �������� ���ڸ� ���� ó�� �������� �ѹ��� �ʱ�ȭ
			int pagesPerBlock = 5;							// �Ѻ��� �ִ� ������ ��
			int mod = this.finalPageNum % pagesPerBlock;	// mod == �������� ���� ���� ������ ��
			if(this.finalPageNum - mod >= this.thisPageNum) {	// ���࿡ ���� �������� ������ ������ ������ ������ �ʴ´ٸ�
				blockLastPageNum = (int) (Math.ceil((float)this.thisPageNum / pagesPerBlock) * pagesPerBlock); // Math.ceil 
				blockStartPageNum = blockLastPageNum - (pagesPerBlock - 1);
			} else { 
				blockStartPageNum = (int) (Math.ceil((float)this.thisPageNum / pagesPerBlock) * pagesPerBlock)
						- (pagesPerBlock - 1);
			}

			if (blockLastPageNum>this.finalPageNum) { 
				blockLastPageNum=this.finalPageNum;
			}
			
			this.setStartPageNum(blockStartPageNum); // ����������(����¡�׺����)
			this.setEndPageNum(blockLastPageNum);    // �� ������(����¡�׺����)
			this.setFinalPageNum(this.finalPageNum);
		}
		// toString

		@Override
		public String toString() {
			return "Paging [pageSize=" + pageSize + ", firstPageNum=" + firstPageNum + ", prevPageNum=" + prevPageNum
					+ ", startPageNum=" + startPageNum + ", thisPageNum=" + thisPageNum + ", endPageNum=" + endPageNum
					+ ", nextPageNum=" + nextPageNum + ", finalPageNum=" + finalPageNum + ", totalPostCnt=" + totalPostCnt
					+ ", isFirst=" + isFirst + ", isLast=" + isLast + "]";
		}
	
}


