package vo;

public class Qna {
	private int qunNo;
	private String customerId;
	private String qnaTitle;
	private String qnaContent;
	private String qnaAnswer;
	private String createDate;
	private String updateDate;
	public int getQunNo() {
		return qunNo;
	}
	public void setQunNo(int qunNo) {
		this.qunNo = qunNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Qna [qunNo=" + qunNo + ", customerId=" + customerId + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaAnswer=" + qnaAnswer + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	
}
