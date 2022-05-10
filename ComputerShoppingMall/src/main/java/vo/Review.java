package vo;

public class Review {
	private int reviewNo;
	private int orderNo;
	private String reviewTitle;
	private String review;
	private int starScore;
	private String createDate;
	private String updateDate;
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", orderNo=" + orderNo + ", reviewTitle=" + reviewTitle + ", review="
				+ review + ", starScore=" + starScore + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getStarScore() {
		return starScore;
	}
	public void setStarScore(int starScore) {
		this.starScore = starScore;
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
}