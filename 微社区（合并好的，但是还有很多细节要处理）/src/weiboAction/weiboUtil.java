package weiboAction;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.http.ImageItem;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

/**
 * @author bjrara
 * */

public class weiboUtil {

	private AccessToken accessToken = null;

	public weiboUtil(AccessToken _accessToken) {
		accessToken = _accessToken;
	}

	public String getAccessToken() {
		String token = accessToken.getAccessToken();
		return token;
	}

	public String getUid() {
		String uid = accessToken.getUid();
		return uid;
	}
	
	public User ShowUser(){
		Users um = new Users();
		String access_token = this.getAccessToken();
		um.client.setToken(access_token);
		try {
			User user = um.showUserById(this.getUid());
			Log.logInfo(user.toString());
			return user;
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Status> getFriendsTimeline() {
		List<Status> statuses = null;
		String access_token = this.getAccessToken();
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			StatusWapper statusWapper = tm.getFriendsTimeline();
			statuses = statusWapper.getStatuses();
			System.out.println(statuses.get(0));
		} catch (WeiboException e) {
			e.printStackTrace();
		}

		return statuses;
	}

	public boolean updateStatus(String _s_status) {
		String access_token = this.getAccessToken();
		String s_status = _s_status;
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			tm.UpdateStatus(s_status);
			return true;
		} catch (WeiboException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sendProductInfoStatus() {
		String s_status = "我刚在blabla社区溜达了一圈，大家也来看看吧！";
		if(this.upload(s_status, "d:/logo.jpg")){
			return true;
		}
		return false;
	}

	private boolean upload(String _s_status, String picURL) {
		try {
			try {
				byte[] content = readFileImage(picURL);
				System.out.println("content length:" + content.length);
				ImageItem pic = new ImageItem("pic", content);
				String s = java.net.URLEncoder.encode(_s_status, "utf-8");
				Timeline tl = new Timeline();
				tl.client.setToken(this.getAccessToken());// access_token
				Status status = tl.UploadStatus(s, pic);

				System.out.println("Successfully upload the status to ["
						+ status.getText() + "].");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception ioe) {
			System.out.println("Failed to read the system input.");
		}
		return true;
	}

	public static byte[] readFileImage(String filename) throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream(filename));
		int len = bufferedInputStream.available();
		byte[] bytes = new byte[len];
		int r = bufferedInputStream.read(bytes);
		if (len != r) {
			bytes = null;
			throw new IOException("读取文件不正确");
		}
		bufferedInputStream.close();
		return bytes;
	}

}