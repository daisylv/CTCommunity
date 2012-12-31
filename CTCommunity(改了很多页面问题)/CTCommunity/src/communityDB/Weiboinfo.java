package communityDB;

// Generated 2012-11-24 18:02:17 by Hibernate Tools 3.4.0.CR1

import org.hns.bean.User;

/**
 * Weiboinfo generated by hbm2java
 */
public class Weiboinfo implements java.io.Serializable {

	private Integer userId;
	private String weiboId;
	private String accessToken;
	private String refreshToken;
	private String expireTime;
	private String weiboName;
	private String picpath;

	public Weiboinfo() {
	}

	public Weiboinfo(Integer userId, String weiboId, String accessToken,
			String weiboName) {
		this.userId = userId;
		this.weiboId = weiboId;
		this.accessToken = accessToken;
		this.weiboName = weiboName;
	}

	public Weiboinfo(Integer userId, String weiboId, String accessToken,
			String refreshToken, String expireTime, String weiboName) {
		this.userId = userId;
		this.weiboId = weiboId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expireTime = expireTime;
		this.weiboName = weiboName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWeiboId() {
		return this.weiboId;
	}

	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getWeiboName() {
		return this.weiboName;
	}

	public void setWeiboName(String weiboName) {
		this.weiboName = weiboName;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

}
