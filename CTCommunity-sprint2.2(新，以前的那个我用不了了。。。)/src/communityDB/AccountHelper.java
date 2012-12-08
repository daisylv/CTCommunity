package communityDB;

import org.hibernate.SessionFactory;

import weibo4j.http.AccessToken;

	/**
	 * @author bjrara
	 * */

public enum AccountHelper{
	INSTANCE;
	UserinfoHome accountTrans;
	Userinfo account;
	TopicHome topicTrans;
	Topic topic;

	private SessionFactory getAccountSession(){
		accountTrans = new UserinfoHome();
		return accountTrans.getSessionFactory();
	}
	
	// Enum singleton - the preferred approach
	
	public Userinfo validation(AccessToken _accessToken){
		this.getAccountSession();
		account = new Userinfo();
		account = accountTrans.findByWeiboId(_accessToken.getUid()).get(0);//unique value
		if(account.getWeiboId() == null){
			//not exist
			account.setAccessToken(_accessToken.getAccessToken());
			account.setWeiboId(_accessToken.getUid());
			account.setExpireTime(_accessToken.getExpireIn());
			accountTrans.persist(account);
		}
		
		//if access token expired
		if(account.getAccessToken() != _accessToken.getAccessToken()){
			accountTrans.modifyAccessToken(account.getUserId(), account.getAccessToken());
		}
		
		return account;
	}
	
	private SessionFactory getTopicSession(){
		topicTrans = new TopicHome();
		return topicTrans.getSessionFactory();
	}
	
	public boolean saveTopic(String _tpTitle, String _tpContent){
		this.getTopicSession();
		Topic topic = new Topic();
		topic.setCommunityId(0);
		topic.setTpContent(_tpContent);
		topic.setTpTitle(_tpTitle);
		topic.setUserinfo(this.account);
		topicTrans.persist(topic);
		return true;
	}
}