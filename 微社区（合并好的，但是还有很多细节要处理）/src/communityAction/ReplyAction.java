package communityAction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.bean.FileInfo;
import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;
import communityDB.CommunityItem;
import communityDB.Itemreply;
import communityDB.Topicinfo;

public class ReplyAction extends ActionSupport {
	/**
	 * @author bjrara
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public static final String FAILURE = "failure";
	CommunityItem topic = new CommunityItem();
	Topicinfo topicinfo = new Topicinfo();
	private List<Itemreply> replies;
	private String author = null;
	
	public String execute() {
		request = ServletActionContext.getRequest();
		AccountHelper helper = AccountHelper.INSTANCE;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		author = request.getParameter("owner");
		topic = helper.selectCommunityItemByTopicId(topicId);
		replies = helper.selectByTimeline(topicId);
		if(replies!=null){
			for(int i=0; i<replies.size(); ++i){
				replyerlist.add(UserHibDao.getuser(replies.get(i).getUserId()));
			}
		}
		topicinfo = helper.selectTopicinfoByTopicId(topicId).get(0);
		System.out.println(topicinfo.getAuthor());

		if (request.getParameter("page") != null) {
			setPager();
		} else {
			beginItem = 0;
			endItem = beginItem + 4;// 4
			maxItem = replies.size() - 1;
			if (endItem >= maxItem + 1) {
				endItem = maxItem;
			}
			cuP = 1;
		}

		return SUCCESS;
	}

	public String addReply() {
		request = ServletActionContext.getRequest();
		AccountHelper helper = AccountHelper.INSTANCE;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		topic = helper.selectCommunityItemByTopicId(topicId);
		String rpContent = request.getParameter("rpContent");
		String rpPic = "/CTCommunity/upload/" + this.uploadPic();
		if (rpContent != null && rpContent != "") {
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			System.out.println(topicId + "..." + replyId);
			if (helper.saveReply(rpContent, topicId, replyId, rpPic) == null) {
				return FAILURE;
			}
		}
		replies = helper.selectByTimeline(topicId);
		return SUCCESS;
	}

	public String deleteReply() {
		request = ServletActionContext.getRequest();
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		AccountHelper helper = AccountHelper.INSTANCE;
		if (!helper.deleteReply(replyId))
			return FAILURE;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		topic = helper.selectCommunityItemByTopicId(topicId);
		replies = helper.selectByTimeline(topicId);
		return SUCCESS;
	}
	
	private static final int BUFFER_SIZE = 16 * 1024;
	FileInfo fileInfo = new FileInfo();
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	@SuppressWarnings("deprecation")
	public String uploadPic() {
		String currentFileName = generateFileName(this.getUploadFileName());
		String dstPath = ServletActionContext.getRequest().getRealPath(
				"/upload")
				+ "\\" + currentFileName;
		fileInfo.setDoc(this.upload);
		fileInfo.setDocFileName(this.uploadFileName);
		fileInfo.setDocContentType(this.uploadContentType);
		fileInfo.setTargetdir(ServletActionContext.getRequest().getRealPath(
				"/upload")
				+ "\\");
		fileInfo.setTargetfilename(currentFileName);

		File dstFile = new File(dstPath);
		copy(this.upload, dstFile);
		
		return fileInfo.getTargetfilename();
	}

	private static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	private synchronized String generateFileName(String filename) {
		int position = filename.lastIndexOf(".");
		String ext = filename.substring(position);
		return System.nanoTime() + ext;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @author daisy
	 */

	int topicId;
	int beginItem;
	int cuP;
	int endItem;
	int maxItem;
	int pg;
	
	public void setPager() {

		pg = Integer.parseInt(ServletActionContext.getRequest().getParameter(
				"page"));
		cuP = Integer.parseInt(ServletActionContext.getRequest().getParameter(
				"cuPage"));

		if (pg == -1) {
			--cuP;
		}
		if (pg == 1) {
			++cuP;
		}
		if (cuP <= 0) {
			cuP = 1;
		}
		beginItem = 5 * (cuP - 1);// 0
		endItem = beginItem + 4;// 4
		maxItem = replies.size() - 1;
		if (endItem >= maxItem + 1) {
			endItem = maxItem;
		}
	}
	
	public CommunityItem getTopic() {
		return topic;
	}

	public void setTopic(CommunityItem topic) {
		this.topic = topic;
	}

	public List<Itemreply> getReplies() {
		return replies;
	}

	public void setReplies(List<Itemreply> replies) {
		this.replies = replies;
	}

	public Topicinfo getTopicinfo() {
		return topicinfo;
	}

	public void setTopicinfo(Topicinfo topicinfo) {
		this.topicinfo = topicinfo;
	}

	public void setBeginItem(int beginItem) {
		this.beginItem = beginItem;
	}

	public int getBeginItem() {
		return beginItem;
	}

	public void setCuP(int cuP) {
		this.cuP = cuP;
	}

	public int getCuP() {
		return cuP;
	}

	public void setEndItem(int endItem) {
		this.endItem = endItem;
	}

	public int getEndItem() {
		return endItem;
	}

	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}

	public int getMaxItem() {
		return maxItem;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getPg() {
		return pg;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getTopicId() {
		return topicId;
	}

	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}

}