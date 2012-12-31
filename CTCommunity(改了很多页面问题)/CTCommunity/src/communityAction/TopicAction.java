package communityAction;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;
import communityDB.CommunityItem;
import communityDB.Topicinfo;

public class TopicAction extends ActionSupport {
	/**
	 * @author bjrara
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public static final String FAILURE = "failure";
	private CommunityItem communityItem = new CommunityItem();
	private List<CommunityItem> topics;
	private Topicinfo topicinfo;
	private int communityId;

	public String execute() {
		request = ServletActionContext.getRequest();
		String s_communityId = request.getParameter("communityId");
		AccountHelper helper = AccountHelper.INSTANCE;
		communityId = Integer.parseInt(s_communityId);
		topics = helper.selectTopicsByCommunityId(communityId);
		Collections.reverse(topics);
		for (int i = 0; i < topics.size(); i++) {
			CommunityItem topic = topics.get(i);
			topicinfo = helper.selectTopicinfoByTopicId(topic.getTopicId()).get(0);
			topic.setTopicinfo(topicinfo);
		}
		return SUCCESS;
	}

	public String addTopic() {
		request = ServletActionContext.getRequest();
		String tpTitle = request.getParameter("tpTitle");
		String tpContent = request.getParameter("tpContent");
		communityItem.setTpTitle(tpTitle);
		communityItem.setTpContent(tpContent);
		String s_communityId = request.getParameter("communityId");
		AccountHelper helper = AccountHelper.INSTANCE;
		communityId = Integer.parseInt(s_communityId);
		CommunityItem topic = helper.saveTopic(tpTitle, tpContent, communityId);
		if (topic == null)
			return FAILURE;
		else
			return SUCCESS;
	}

	public String deleteTopic() {
		request = ServletActionContext.getRequest();
		String s_communityId = request.getParameter("communityId");
		AccountHelper helper = AccountHelper.INSTANCE;
		communityId = Integer.parseInt(s_communityId);
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		if (!helper.deleteTopic(topicId))
			return FAILURE;
		return SUCCESS;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public CommunityItem getCommunityItem() {
		return communityItem;
	}

	public void setCommunityItem(CommunityItem communityItem) {
		this.communityItem = communityItem;
	}

	public List<CommunityItem> getTopics() {
		return topics;
	}

	public void setTopics(List<CommunityItem> topics) {
		this.topics = topics;
	}
	
	public Topicinfo getTopicinfo() {
		return topicinfo;
	}

	public void setTopicinfo(Topicinfo topicinfo) {
		this.topicinfo = topicinfo;
	}

}