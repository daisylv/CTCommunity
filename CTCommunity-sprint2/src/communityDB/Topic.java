package communityDB;

import communityDB.Userinfo;

// Generated 2012-11-25 23:47:23 by Hibernate Tools 3.4.0.CR1

/**
 * Topic generated by hbm2java
 */
public class Topic implements java.io.Serializable {

	private Integer topicId;
	private Userinfo userinfo;
	private int communityId;
	private String tpContent;
	private String tpPic;
	private String tpTitle;

	public Topic() {
	}

	public Topic(Userinfo userinfo, int communityId, String tpTitle) {
		this.userinfo = userinfo;
		this.communityId = communityId;
		this.tpTitle = tpTitle;
	}

	public Topic(Userinfo userinfo, int communityId, String tpContent,
			String tpPic, String tpTitle) {
		this.userinfo = userinfo;
		this.communityId = communityId;
		this.tpContent = tpContent;
		this.tpPic = tpPic;
		this.tpTitle = tpTitle;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public int getCommunityId() {
		return this.communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getTpContent() {
		return this.tpContent;
	}

	public void setTpContent(String tpContent) {
		this.tpContent = tpContent;
	}

	public String getTpPic() {
		return this.tpPic;
	}

	public void setTpPic(String tpPic) {
		this.tpPic = tpPic;
	}

	public String getTpTitle() {
		return this.tpTitle;
	}

	public void setTpTitle(String tpTitle) {
		this.tpTitle = tpTitle;
	}

}
