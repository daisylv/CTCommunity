package communityAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
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
	int topicId;
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getTopicId() {
		return topicId;
	}
	int beginItem;
	int cuP;
	int endItem;
	int maxItem;
	int pg;
	
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
	
public void setPager(){
		
		pg =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		cuP =  Integer.parseInt(ServletActionContext.getRequest().getParameter("cuPage"));
		
		if(pg==-1){
			--cuP;
		}
		if(pg==1){
			++cuP;
		}
		if(cuP<=0){
			cuP=1;
		}
		beginItem = 5*(cuP-1);//0
		endItem = beginItem+4;//4
		maxItem = replies.size()-1;
		if(endItem>=maxItem+1){
			endItem = maxItem;
		}
	}
	
	public String execute() {
		request = ServletActionContext.getRequest();
		AccountHelper helper = AccountHelper.INSTANCE;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
 		topic = helper.selectCommunityItemByTopicId(topicId);
		replies = helper.selectByTimeline(topicId);
		topicinfo = helper.selectTopicinfoByTopicId(topicId).get(0);
		System.out.println(topicinfo.getAuthor());
		
		if(ServletActionContext.getRequest().getParameter("page")!=null){
			setPager();
		}else{
			beginItem = 0;
			endItem = beginItem+4;//4
			maxItem = replies.size()-1;
			if(endItem>=maxItem+1){
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
		if(rpContent != null && rpContent != "") {
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			System.out.println(topicId + "..." + replyId);
			if (helper.saveReply(rpContent, topicId, replyId) == null) {
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
		if(!helper.deleteReply(replyId))
			return FAILURE;
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		topic = helper.selectCommunityItemByTopicId(topicId);
		replies = helper.selectByTimeline(topicId);
		return SUCCESS;
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

}