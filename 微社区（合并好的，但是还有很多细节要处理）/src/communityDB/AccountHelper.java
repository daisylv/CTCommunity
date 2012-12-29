package communityDB;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hns.bean.Community;
import org.hns.bean.User;
import weibo4j.http.AccessToken;
import weiboAction.weiboUtil;

/**
 * @author bjrara
 * */

public enum AccountHelper {
	INSTANCE;
	WeiboinfoHome accountTrans;
	Weiboinfo account;
	User user;
	boolean isWeiboUser = false;
	boolean hasSetUser = false;
	CommunityItemHome topicTrans;
	ItemreplyHome replyTrans;
	TopicinfoHome topicinfoTrans;
	NoticeHome noticeTrans;

	AccountHelper() {
		this.getAccountSession();
		this.getReplySession();
		this.getTopicSession();
		this.getTopicinfoSession();
		this.getNoticeSession();
	}

	private SessionFactory getAccountSession() {
		accountTrans = new WeiboinfoHome();

		return accountTrans.getSessionFactory();
	}

	private SessionFactory getTopicSession() {
		topicTrans = new CommunityItemHome();

		return topicTrans.getSessionFactory();
	}

	private SessionFactory getTopicinfoSession() {
		topicinfoTrans = new TopicinfoHome();

		return topicinfoTrans.getSessionFactory();
	}

	private SessionFactory getReplySession() {
		replyTrans = new ItemreplyHome();

		return replyTrans.getSessionFactory();
	}

	private SessionFactory getNoticeSession() {
		noticeTrans = new NoticeHome();

		return noticeTrans.getSessionFactory();
	}

	// Enum singleton - the preferred approach

	public Weiboinfo validation(AccessToken _accessToken) {
		// this.getAccountSession();
		this.isWeiboUser = true;
		this.hasSetUser = true;
		account = new Weiboinfo();
		user = new User();
		List<Weiboinfo> li = null;
		li = accountTrans.findByWeiboId(_accessToken.getUid());
		if (li.isEmpty()) {
			// not exist
			account.setAccessToken(_accessToken.getAccessToken());
			account.setWeiboId(_accessToken.getUid());
			account.setExpireTime(_accessToken.getExpireIn());
			weiboUtil weibo = new weiboUtil(_accessToken);
			weibo4j.model.User weiboUser = weibo.ShowUser();
			account.setUserId(1);
			account.setWeiboName(weiboUser.getName());
			account.setPicpath(weiboUser.getAvatarLarge());
			accountTrans.persist(account);
		} else {
			account = li.get(0);// unique value
			user.setUserId(account.getUserId());
			user.setUsername(account.getWeiboName());
			user.setSinaId(Integer.parseInt(account.getWeiboId()));
			user.setUsername(account.getWeiboName());
		}

		// if access token expired
		if (account.getAccessToken() != _accessToken.getAccessToken()) {
			accountTrans.modifyAccessToken(account.getUserId(),
					account.getAccessToken());
		}

		return account;
	}

	public User getUser() {
		if (!isWeiboUser && !hasSetUser) {
			user = new User();
			int userId = (Integer) ServletActionContext.getRequest()
					.getSession().getAttribute("userid");
			String username = ServletActionContext.getRequest().getSession()
					.getAttribute("username").toString();
			user.setUsername(username);
			user.setUserId(userId);
		}

		return user;
	}

	public Weiboinfo getAccountInfo() {

		return account;
	}

	public CommunityItem saveTopic(String _tpTitle, String _tpContent,
			int _communityId) {
		// this.getTopicSession();
		this.getUser();
		CommunityItem topic = new CommunityItem();
		topic.setTopicId(1);
		topic.setCommunityId(_communityId);
		topic.setTpContent(_tpContent);
		topic.setTpTitle(_tpTitle);
		topic.setUserId(user.getUserId());
		topic.setCreateTime(new Date());
		int topicId = topicTrans.save(topic);
		topic.setTopicId(topicId);
		this.saveTopicinfo(topic);
		return topic;
	}

	public Topicinfo saveTopicinfo(CommunityItem _topic) {
		Topicinfo topicinfo = new Topicinfo();
		CommunityItem topic = _topic;

		topicinfo.setAuthor(user.getUsername());
		topicinfo.setTopicId(topic.getTopicId());
		topicinfo.setUpdateTime(topic.getCreateTime());
		topicinfo.setHitNum(0);
		topicinfo.setReplyNum(0);
		topicinfoTrans.persist(topicinfo);

		return topicinfo;
	}

	public boolean deleteTopic(int _topicId) {
		CommunityItem topic = this.selectCommunityItemByTopicId(_topicId);
		topicTrans.delete(topic);

		return true;
	}

	public boolean deleteTopicinfo(int _topicId) {
		Topicinfo topicinfo = this.selectTopicinfoByTopicId(_topicId).get(0);
		topicinfoTrans.delete(topicinfo);

		return true;
	}

	public List<CommunityItem> selectTopicsByCommunityId(int _communityId) {
		List<CommunityItem> li = topicTrans.findByCommunityId(_communityId);

		return li;
	}

	public List<Topicinfo> selectTopicinfoByTopicId(int _topicId) {
		List<Topicinfo> li = topicinfoTrans.findByTopicId(_topicId);

		return li;
	}

	public CommunityItem selectCommunityItemByTopicId(int _topicId) {
		// this.getTopicSession();
		// order by update time
		CommunityItem item = topicTrans.findById(_topicId);
		
		return item;
	}

	public Itemreply saveReply(String _rpContent, int _topicId, int _targetId) {
		// this.getReplySession();
		this.getUser();
		Notice tp_notice = new Notice();
		String url = "localhost:8080/CTCommunity/communityAction/Reply.action?topicId=";
		Itemreply reply = new Itemreply();
		CommunityItem topic = this.selectCommunityItemByTopicId(_topicId);

		reply.setCommunityId(topic.getCommunityId());
		reply.setTopicId(topic.getTopicId());
		reply.setRpContent(_rpContent);
		reply.setUserId(user.getUserId());
		reply.setUsername(user.getUsername());

		if (user.getUserId() != topic.getUserId()) {
			tp_notice.setTopicUrl(url + _topicId);
			tp_notice.setTpTitle(topic.getTpTitle());
			tp_notice.setNoticed(1);
			tp_notice.setFromUsername(user.getUsername());
			tp_notice.setToUserId(topic.getUserId());
			tp_notice.setTopicId(_topicId);
			noticeTrans.persist(tp_notice);
		}

		if (_targetId > 0) {
			reply.setTargetId(_targetId);

			Itemreply target = this.selectByReplyId(_targetId);
			if (user.getUserId() != target.getUserId()) {
				Notice rp_notice = new Notice();
				rp_notice.setTopicUrl(url + _topicId);
				rp_notice.setTpTitle(topic.getTpTitle());
				rp_notice.setNoticed(1);
				rp_notice.setFromUsername(user.getUsername());
				rp_notice.setToUserId(target.getUserId());
				rp_notice.setTopicId(_topicId);
				rp_notice.setReplyId(_targetId);
				noticeTrans.persist(rp_notice);
			}
		}

		reply.setCreateTime(new Date());
		replyTrans.persist(reply);

		Topicinfo topicinfo = this.selectTopicinfoByTopicId(_topicId).get(0);
		System.out.println(topicinfo);
		topicinfo.setUpdateTime(reply.getCreateTime());
		topicinfo.setReplier(reply.getUsername());
		topicinfo.setReplyNum(topicinfo.getReplyNum() + 1);
		topicinfoTrans.merge(topicinfo);

		return reply;
	}

	public boolean deleteReply(int _replyId) {
		// this.getReplySession();
		Itemreply reply = this.selectByReplyId(_replyId);
		int topicId = reply.getTopicId();
		replyTrans.delete(reply);

		Topicinfo topicinfo = this.selectTopicinfoByTopicId(topicId).get(0);
		System.out.println(topicinfo);
		topicinfo.setUpdateTime(reply.getCreateTime());
		topicinfo.setReplier(reply.getUsername());
		topicinfo.setReplyNum(topicinfo.getReplyNum() - 1);
		topicinfoTrans.merge(topicinfo);
		return true;
	}

	public Itemreply selectByReplyId(int _replyId) {
		Itemreply item = replyTrans.findById(_replyId);

		return item;
	}

	public List<Itemreply> selectByTimeline(int _topicId) {
		List<Itemreply> li = replyTrans.findByTopicId(_topicId);
		// Collections.reverse(li);
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getTargetId() == null) {
			} else {
				Itemreply target = this
						.selectByReplyId(li.get(i).getTargetId());
				String content = li.get(i).getRpContent();
				if (target == null) {
					content = content + "\r\n转发:" + li.get(i).getUsername()
							+ "的留言:" + "内容被删除";
				} else {
					content = content + "\r\n转发:" + li.get(i).getUsername()
							+ "的留言:" + target.getRpContent();
				}
				li.get(i).setRpContent(content);
			}
		}

		return li;
	}

	public List<Notice> selectUncheckedNotices(Integer _userId) {
		List<Notice> li = noticeTrans.findUncheckedNotices(_userId);
		for(int i = 0; i < li.size(); i++) {
			Notice notice = li.get(i);
			notice.setNoticed(0);
			noticeTrans.merge(notice);
		}
		return li;
	}
}