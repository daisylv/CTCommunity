package weibo4j;

import java.util.List;
import weibo4j.http.ImageItem;
import weibo4j.model.Emotion;
import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class Timeline extends Weibo{

	/*----------------------------��ȡ�ӿ�----------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 6235150828015082132L;

	/**
	 * �������µĹ���΢��
	 * 
	 * @return list of statuses of the Public Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/public_timeline">statuses/public_timeline
	 *      </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getPublicTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/public_timeline.json"));
	}

	/**
	 * �������µĹ���΢��
	 * 
	 * @param count
	 *            ��ҳ���صļ�¼������Ĭ��Ϊ20��
	 * @param baseApp
	 *            �Ƿ����ȡ��ǰӦ�÷�������Ϣ��0Ϊ���У�1Ϊ����Ӧ�á�
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/public_timeline">statuses/public_timeline
	 *      </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getPublicTimeline(int count, int baseApp) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/public_timeline.json", new PostParameter[] {
						new PostParameter("count", count),
						new PostParameter("base_app", baseApp) }));

	}

	/**
	 * ��ȡ��ǰ��¼�û���������ע�û�������20��΢����Ϣ��
	 * ���û���¼ http://weibo.com ���ڡ��ҵ���ҳ���п�����������ͬ��
	 * This method calls
	 * http://api.t.sina.com.cn/statuses/friends_timeline.format
	 * 
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/statuses/friends_timeline">
	 *      statuses/friends_timeline </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getFriendsTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL") + "statuses/friends_timeline.json"));

	}

	/**
	 * ��ȡ��ǰ��¼�û���������ע�û�������΢����Ϣ��<br/>
	 * ���û���¼ http://weibo.com ���ڡ��ҵ���ҳ���п�����������ͬ��
	 * 
	 * @param paging
	 *            ��ط�ҳ����
	 * @param ��������ID��0��ȫ����1��ԭ����2��ͼƬ��3����Ƶ��4�����֣�Ĭ��Ϊ0��
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/statuses/friends_timeline">
	 *      statuses/friends_timeline </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getFriendsTimeline(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/friends_timeline.json",
				new PostParameter[] {
						new PostParameter("base_app", baseAPP.toString()),
						new PostParameter("feature", feature.toString()) },
				paging));
		}
	/**
	 * ��ȡ��ǰ��¼�û���������ע�û�������20��΢����Ϣ��
	 * ���û���¼ http://weibo.com ���ڡ��ҵ���ҳ���п�����������ͬ��
	 * This method calls
	 * http://api.t.sina.com.cn/statuses/friends_timeline.format
	 * 
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/statuses/friends_timeline/ids">
	 *      statuses/friends_timeline/ids </a>
	 * @since JDK 1.5
	 */
	public JSONObject getFriendsTimelineIds() throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "statuses/friends_timeline/ids.json").asJSONObject();

	}
	public JSONObject getFriendsTimelineIds(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/friends_timeline/ids.json",
				new PostParameter[] {
						new PostParameter("base_app", baseAPP.toString()),
						new PostParameter("feature", feature.toString()) },
				paging).asJSONObject();
		}
	/**
	 * ��ȡ��ǰ��¼�û���������ע�û�������΢����Ϣ��<br/>
	 * ���û���¼ http://weibo.com ���ڡ��ҵ���ҳ���п�����������ͬ��
	 * 
	 * @return list of status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/statuses/home_timeline">
	 *      statuses/home_timeline </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getHomeTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/home_timeline.json"));

	}

	/**
	 * ��ȡ��ǰ��¼�û���������ע�û�������΢����Ϣ��<br/>
	 * ���û���¼ http://weibo.com ���ڡ��ҵ���ҳ���п�����������ͬ��
	 * 
	 * @param paging
	 *            ��ط�ҳ����
	 * @param ��������ID
	 *            ��0��ȫ����1��ԭ����2��ͼƬ��3����Ƶ��4�����֣�Ĭ��Ϊ0��
	 * @return list of the Friends Timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a href="http://open.weibo.com/wiki/2/Statuses/home_timeline">
	 *      statuses/home_timeline </a>
	 * @since JDK 1.5
	 */
	public StatusWapper getHomeTimeline(Integer baseAPP, Integer feature,
			Paging paging) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL") + "statuses/home_timeline.json",
						new PostParameter[] {
								new PostParameter("base_app", baseAPP.toString()),
								new PostParameter("feature", feature.toString()) },
						paging));
	}

	/**
	 * ��ȡĳ���û����·����΢���б�
	 * 
	 * @return list of the user_timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/user_timeline">statuses/user_timeline</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getUserTimeline() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/user_timeline.json"));
	}
	public StatusWapper getUserTimelineByUid(String uid) throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/user_timeline.json",new PostParameter[]{
			new PostParameter("uid", uid)
		}));
	}
	public StatusWapper getUserTimelineByName(String screen_name) throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/user_timeline.json",new PostParameter[]{
			new PostParameter("screen_name", screen_name)
		}));
	}
	/**
	 * ��ȡĳ���û����·����΢���б�
	 * 
	 * @param uid
	 *            ��Ҫ��ѯ���û�ID��
	 * @param screen_name
	 *            ��Ҫ��ѯ���û��ǳơ�
	 * @param count
	 *            ��ҳ���صļ�¼������Ĭ��Ϊ50��
	 * @param page
	 *            ���ؽ����ҳ�룬Ĭ��Ϊ1��
	 * @param base_app
	 *            �Ƿ�ֻ��ȡ��ǰӦ�õ����ݡ�0Ϊ���������ݣ���1Ϊ�ǣ�����ǰӦ�ã���Ĭ��Ϊ0��
	 * @param feature
	 *            ��������ID��0��ȫ����1��ԭ����2��ͼƬ��3����Ƶ��4�����֣�Ĭ��Ϊ0��
	 * @return list of the user_timeline
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/user_timeline">statuses/user_timeline</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getUserTimelineByUid(String uid, Paging page,
			Integer base_app, Integer feature) throws WeiboException {
		return Status.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")	+ "statuses/user_timeline.json",
						new PostParameter[] {
								new PostParameter("uid", uid),
								new PostParameter("base_app", base_app.toString()),
								new PostParameter("feature", feature.toString()) },
						page));
	}
	public StatusWapper getUserTimelineByName(String screen_name, Paging page,Integer base_app, Integer feature) throws WeiboException {
		return Status.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")	+ "statuses/user_timeline.json",
						new PostParameter[] {
								new PostParameter("screen_name", screen_name),
								new PostParameter("base_app", base_app.toString()),
								new PostParameter("feature", feature.toString()) },
						page));
	}
	/**
	 * ��ȡĳ���û����·����΢���б�ID
	 * 
	 * @return user_timeline IDS
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/user_timeline">statuses/user_timeline</a>
	 * @since JDK 1.5
	 */
	public JSONObject getUserTimelineIdsByUid(String uid) throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"statuses/user_timeline/ids.json",new PostParameter[]{
			new PostParameter("uid", uid)
		}).asJSONObject();
	}
	public JSONObject getUserTimelineIdsByName(String screen_name) throws WeiboException{
		return client.get(WeiboConfig.getValue("baseURL")+"statuses/user_timeline/ids.json",new PostParameter[]{
			new PostParameter("screen_name", screen_name)
		}).asJSONObject();
	}
	/**
	 * ��ȡָ��΢����ת��΢���б�
	 * 
	 * @param id
	 *            ��Ҫ��ѯ��΢��ID
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost_timeline">statuses/repost_timeline</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostTimeline(String id) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/repost_timeline.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * ��ȡָ��΢����ת��΢���б�
	 * 
	 * @param id
	 *            ��Ҫ��ѯ��΢��ID
	 * @param count
	 *            ��ҳ���صļ�¼������Ĭ��Ϊ50
	 * @param page
	 *            ���ؽ����ҳ�룬Ĭ��Ϊ1
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost_timeline">statuses/repost_timeline</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostTimeline(String id, Paging page)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "statuses/repost_timeline.json",
				new PostParameter[] { new PostParameter("id", id) }, page));
	}
	/**
	 * ��ȡָ��΢����ת��΢���б�
	 * 
	 * @param id
	 *            ��Ҫ��ѯ��΢��ID
	 * @return ids
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost_timeline/ids">statuses/repost_timeline/ids</a>
	 * @since JDK 1.5
	 */
	public JSONObject getRepostTimelineIds(String id) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/repost_timeline/ids.json",
				new PostParameter[] { new PostParameter("id", id) }).asJSONObject();
	}
	/**
	 * ��ȡ��ǰ�û�����ת����΢���б�
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost_by_me">statuses/repost_by_me</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostByMe() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/repost_by_me.json"));
	}

	/**
	 * ��ȡ��ǰ�û�����ת����΢���б�
	 * 
	 * @param page
	 *            ���ؽ����ҳ�룬Ĭ��Ϊ1
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost_by_me">statuses/repost_by_me</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getRepostByMe(Paging page) throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/repost_by_me.json",null, page));
	}

	/**
	 * ��ȡ���µ��ᵽ��¼�û���΢���б���@�ҵ�΢��
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/mentions">statuses/mentions</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getMentions() throws WeiboException {
		return Status.constructWapperStatus(client.get(WeiboConfig
				.getValue("baseURL") + "statuses/mentions.json"));
	}

	/**
	 * ��ȡ���µ��ᵽ��¼�û���΢���б���@�ҵ�΢��
	 * 
	 * @param count
	 *            ��ҳ���صļ�¼������Ĭ��Ϊ50��
	 * @param page
	 *            ���ؽ����ҳ�룬Ĭ��Ϊ1��
	 * @param filter_by_author
	 *            ����ɸѡ���ͣ�0��ȫ����1���ҹ�ע���ˡ�2��İ���ˣ�Ĭ��Ϊ0��
	 * @param filter_by_source
	 *            ��Դɸѡ���ͣ�0��ȫ����1������΢����2������΢Ⱥ��Ĭ��Ϊ0��
	 * @param filter_by_type
	 *            ԭ��ɸѡ���ͣ�0��ȫ��΢����1��ԭ����΢����Ĭ��Ϊ0��
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/mentions">statuses/mentions</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getMentions(Paging page, Integer filter_by_author,
			Integer filter_by_source, Integer filter_by_type)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions.json",
				new PostParameter[] {
						new PostParameter("filter_by_author", filter_by_author.toString()),
						new PostParameter("filter_by_source", filter_by_source.toString()),
						new PostParameter("filter_by_type", filter_by_type.toString()) }, page));
	}
	/**
	 * ��ȡ���µ��ᵽ��¼�û���΢��ID�б���@�ҵ�΢��
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/mentions/ids">statuses/mentions/ids</a>
	 * @since JDK 1.5
	 */
	public JSONObject getMentionsIds() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "statuses/mentions/ids.json").asJSONObject();
	}
	public JSONObject getMentionsIds(Paging page, Integer filter_by_author,
			Integer filter_by_source, Integer filter_by_type)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/mentions/ids.json",
				new PostParameter[] {
						new PostParameter("filter_by_author", filter_by_author.toString()),
						new PostParameter("filter_by_source", filter_by_source.toString()),
						new PostParameter("filter_by_type", filter_by_type.toString()) }, page).asJSONObject();
	}
	/**
	 * ��ȡ˫���ע�û�������΢�� 
	 * 
	 * @return list of Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/bilateral_timeline">statuses/bilateral_timeline</a>
	 * @since JDK 1.5
	 */
	public StatusWapper getBilateralTimeline() throws WeiboException{
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL")+"statuses/bilateral_timeline.json"));
	}
	public StatusWapper getBilateralTimeline(Integer base_app,Integer feature) throws WeiboException{
		return Status.constructWapperStatus(client.get(WeiboConfig.getValue("baseURL")+"statuses/bilateral_timeline.json",
				new PostParameter[]{
			new PostParameter("base_app", base_app),
			new PostParameter("feature",feature)
		}));
	}
	/**
	 * ����΢��ID��ȡ����΢������
	 * 
	 * @param id
	 *            ��Ҫ��ȡ��΢��ID��
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/show">statuses/show</a>
	 * @since JDK 1.5
	 */
	public Status showStatus(String id) throws WeiboException {
		return new Status(client.get(WeiboConfig.getValue("baseURL")
				+ "statuses/show.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * ͨ��΢��ID��ȡ��MID
	 * 
	 * @param id
	 *            ��Ҫ��ѯ��΢��ID������ģʽ�£��ð�Ƕ��ŷָ�����಻����20����
	 * @param type
	 *            ��ȡ���ͣ�1��΢����2�����ۡ�3��˽�ţ�Ĭ��Ϊ1��
	 * @return Status's mid
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/querymid">statuses/querymid</a>
	 * @since JDK 1.5
	 */
	public JSONObject QueryMid(Integer type, String id) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "statuses/querymid.json",
				new PostParameter[] { new PostParameter("id", id),
						new PostParameter("type", type.toString()) }).asJSONObject();
	}	
	/**
	 * ͨ��΢��ID��ȡ��MID
	 * 
	 * @param id
	 *            ��Ҫ��ѯ��΢��ID������ģʽ�£��ð�Ƕ��ŷָ�����಻����20����
	 * @param type
	 *            ��ȡ���ͣ�1��΢����2�����ۡ�3��˽�ţ�Ĭ��Ϊ1��
	 * @param is_batch
	 *            �Ƿ�ʹ������ģʽ��0����1���ǣ�Ĭ��Ϊ0��
	 * @return Status's mid
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/querymid">statuses/querymid</a>
	 * @since JDK 1.5
	 */
	public JSONObject QueryMid(Integer type, String id,int is_batch) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "statuses/querymid.json",
				new PostParameter[] { new PostParameter("id", id),
						new PostParameter("type", type.toString()),
						new PostParameter("is_batch", is_batch)}).asJSONObject();
	}
	/**
	 * ͨ��΢��MID��ȡ��ID
	 * 
	 * @param mid
	 *            true string ��Ҫ��ѯ��΢��MID������ģʽ�£��ð�Ƕ��ŷָ�����಻����20��
	 * @param type
	 *            ��ȡ���ͣ�1��΢����2�����ۡ�3��˽�ţ�Ĭ��Ϊ1��
	 * @return Status's id
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/queryid">statuses/queryid</a>
	 * @since JDK 1.5
	 */
	public JSONObject QueryId(String mid, Integer type,int isBase62) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/queryid.json",
				new PostParameter[] { new PostParameter("mid", mid),
						new PostParameter("type", type.toString()),
						new PostParameter("isBase62", isBase62)}).asJSONObject();
	}

	/**
	 * ͨ��΢��MID��ȡ��ID
	 * 
	 * @param mid
	 *            true string ��Ҫ��ѯ��΢��MID������ģʽ�£��ð�Ƕ��ŷָ�����಻����20��
	 * @param type
	 *            ��ȡ���ͣ�1��΢����2�����ۡ�3��˽�ţ�Ĭ��Ϊ1��
	 * @param is_batch
	 *            �Ƿ�ʹ������ģʽ��0����1���ǣ�Ĭ��Ϊ0��
	 * @param inbox
	 *            ����˽����Ч����MID����Ϊ˽��ʱ�ô˲�����0�������䡢1���ռ��䣬Ĭ��Ϊ0 ��
	 * @param isBase62
	 *            MID�Ƿ���base62���룬0����1���ǣ�Ĭ��Ϊ0��
	 * @return Status's id
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/queryid">statuses/queryid</a>
	 * @since JDK 1.5
	 */
	public JSONObject QueryId(String mid, Integer type, Integer isBatch,Integer isBase62) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "statuses/queryid.json",
				new PostParameter[] { new PostParameter("mid", mid),
						new PostParameter("type", type.toString()),
						new PostParameter("is_batch", isBatch.toString()),
						new PostParameter("isBase62", isBase62.toString()) }).asJSONObject();
	}



	/**
	 * ���췵������΢��ת�����΢���б�
	 * 
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/hot/repost_daily">statuses/hot/repost_daily</a>
	 * @since JDK 1.5
	 */
	public JSONArray getRepostDaily() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "statuses/hot/repost_daily.json").asJSONArray();
	}
	/**
	 * ���ܷ�������΢��ת�����΢���б�
	 * 
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/hot/repost_daily">statuses/hot/repost_daily</a>
	 * @since JDK 1.5
	 */
	public JSONArray getRepostWeekly() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "statuses/hot/repost_weekly.json").asJSONArray();
	}
	/**
	 * ���췵������΢�����۰��΢���б�
	 * 
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/hot/repost_daily">statuses/hot/repost_daily</a>
	 * @since JDK 1.5
	 */
	public JSONArray getCommentsDaily() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "statuses/hot/comments_daily.json").asJSONArray();
	}
	/**
	 * ���ܷ�������΢�����۰��΢���б�
	 * 
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/hot/repost_daily">statuses/hot/repost_daily</a>
	 * @since JDK 1.5
	 */
	public JSONArray getCommentsWeekly() throws WeiboException {
		return client.get(WeiboConfig
				.getValue("baseURL") + "statuses/hot/comments_weekly.json").asJSONArray();
	}

	/**
	 * ת��һ����΢��
	 * 
	 * @param id
	 *            Ҫת����΢��ID
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost">statuses/repost</a>
	 * @since JDK 1.5
	 */
	public Status Repost(String id) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/repost.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * ת��һ��΢��
	 * 
	 * @param id
	 *            Ҫת����΢��ID
	 * @param status
	 *            ��ӵ�ת���ı���������URLencode�����ݲ�����140�����֣�������Ĭ��Ϊ��ת��΢����
	 * @param is_comment
	 *            �Ƿ���ת����ͬʱ�������ۣ�0����1�����۸���ǰ΢����2�����۸�ԭ΢����3�������ۣ�Ĭ��Ϊ0
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/repost">statuses/repost</a>
	 * @since JDK 1.5
	 */
	public Status Repost(String id, String status, Integer is_comment)
			throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL") + "statuses/repost.json", new PostParameter[] {
				new PostParameter("id", id),
				new PostParameter("status", status),
				new PostParameter("is_comment", is_comment.toString()) }));
	}

	/**
	 * ����΢��IDɾ��ָ��΢��
	 * 
	 * @param id
	 *            ��Ҫɾ����΢��ID
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/destroy">statuses/destroy</a>
	 * @since JDK 1.5
	 */
	public Status Destroy(String id) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/destroy.json",
				new PostParameter[] { new PostParameter("id", id) }));
	}

	/**
	 * ����һ����΢��
	 * 
	 * @param status
	 *            Ҫ������΢���ı����ݣ�������URLencode�����ݲ�����140������
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/update">statuses/update</a>
	 * @since JDK 1.5
	 */
	public Status UpdateStatus(String status) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/update.json",
				new PostParameter[] { new PostParameter("status", status) }));
	}

	/**
	 * ����һ����΢��
	 * 
	 * @param status
	 *            Ҫ������΢���ı����ݣ�������URLencode�����ݲ�����140������
	 * @param lat
	 *            γ�ȣ���Ч��Χ��-90.0��+90.0��+��ʾ��γ��Ĭ��Ϊ0.0��
	 * @param long ���ȣ���Ч��Χ��-180.0��+180.0��+��ʾ������Ĭ��Ϊ0.0��
	 * @param annotations
	 *            Ԫ���ݣ���Ҫ��Ϊ�˷��������Ӧ�ü�¼һЩ�ʺ����Լ�ʹ�õ���Ϣ��ÿ��΢�����԰���һ�����߶��Ԫ���ݣ�
	 *            ������json�ִ�����ʽ�ύ���ִ����Ȳ�����512���ַ����������ݿ����Զ�
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/update">statuses/update</a>
	 * @since JDK 1.5
	 */
	public Status UpdateStatus(String status, Float lat, Float longs,
			String annotations) throws WeiboException {
		return new Status(client.post(WeiboConfig.getValue("baseURL")
				+ "statuses/update.json", new PostParameter[] {
				new PostParameter("status", status),
				new PostParameter("lat", lat.toString()),
				new PostParameter("long", longs.toString()),
				new PostParameter("annotations", annotations) }));
	}

	/**
	 * �ϴ�ͼƬ������һ����΢��
	 * 
	 * @param status
	 *            Ҫ������΢���ı����ݣ�������URLencode�����ݲ�����140������
	 * @param pic
	 *            Ҫ�ϴ���ͼƬ����֧��JPEG��GIF��PNG��ʽ��ͼƬ��СС��5M��
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/upload">statuses/upload</a>
	 * @since JDK 1.5
	 */
	public Status UploadStatus(String status, ImageItem item)
			throws WeiboException {
		return new Status(client.multPartURL(
				WeiboConfig.getValue("baseURL") + "statuses/upload.json",
				new PostParameter[] { new PostParameter("status", status)},
				item));
	}
	
	/**
	 * �ϴ�ͼƬ������һ����΢��
	 * 
	 * @param status
	 *            Ҫ������΢���ı����ݣ�������URLencode�����ݲ�����140������
	 * @param pic
	 *            Ҫ�ϴ���ͼƬ����֧��JPEG��GIF��PNG��ʽ��ͼƬ��СС��5M��
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/upload">statuses/upload</a>
	 * @since JDK 1.5
	 */
	public Status UploadPicStatus(String status, ImageItem item)
			throws WeiboException {
		return new Status(client.multPartURL(
				WeiboConfig.getValue("baseURL") + "statuses/upload_url_text.json",
				new PostParameter[] { new PostParameter("status", status)},
				item));
	}

	/**
	 * �ϴ�ͼƬ������һ����΢��
	 * 
	 * @param status
	 *            Ҫ������΢���ı����ݣ�������URLencode�����ݲ�����140������
	 * @param pic
	 *            Ҫ�ϴ���ͼƬ����֧��JPEG��GIF��PNG��ʽ��ͼƬ��СС��5M��
	 * @param lat
	 *            γ�ȣ���Ч��Χ��-90.0��+90.0��+��ʾ��γ��Ĭ��Ϊ0.0��
	 * @param long ���ȣ���Ч��Χ��-180.0��+180.0��+��ʾ������Ĭ��Ϊ0.0��
	 * @return Status
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/statuses/upload">statuses/upload</a>
	 * @since JDK 1.5
	 */
	public Status UploadStatus(String status, ImageItem item, Float lat,
			Float longs) throws WeiboException {
		return new Status(client.multPartURL(
				WeiboConfig.getValue("baseURL") + "statuses/upload.json",
				new PostParameter[] { new PostParameter("status", status),
						new PostParameter("lat", lat.toString()),
						new PostParameter("long", longs.toString()) }, item));
	}

	/**
	 * ��ȡ΢���ٷ��������ϸ��Ϣ
	 * 
	 * @return Emotion
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a href="http://open.weibo.com/wiki/2/emotions">emotions</a>
	 * @since JDK 1.5
	 */
	public List<Emotion> getEmotions() throws WeiboException {
		return Emotion.constructEmotions(client.get(WeiboConfig
				.getValue("baseURL") + "emotions.json"));
	}

	/**
	 * ��ȡ΢���ٷ��������ϸ��Ϣ
	 * 
	 * @param type
	 *            �������face����ͨ���顢ani��ħ�����顢cartoon���������飬Ĭ��Ϊface
	 * @param language
	 *            �������cnname�����塢twname�����壬Ĭ��Ϊcnname
	 * @return Emotion
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.0
	 * @see <a href="http://open.weibo.com/wiki/2/emotions">emotions</a>
	 * @since JDK 1.5
	 */
	public List<Emotion> getEmotions(String type, String language)
			throws WeiboException {
		return Emotion.constructEmotions(client.get(
				WeiboConfig.getValue("baseURL") + "emotions.json",
				new PostParameter[] { 
					new PostParameter("type", type),
					new PostParameter("language", language) }));
	}

}
