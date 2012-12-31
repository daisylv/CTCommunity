package communityAction;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;
import communityDB.Notice;

public class NoticeAction extends ActionSupport {
	/**
	 * @author bjrara
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public static final String FAILURE = "failure";
	private List<Notice> noticeList;

	public String execute() {

		return SUCCESS;
	}

	public String checkNotice() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		Integer userId = (Integer) request.getSession().getAttribute("userid");
		this.response.setCharacterEncoding("utf-8");

		if (userId == null) {
		} else {
			AccountHelper helper = AccountHelper.INSTANCE;
			noticeList = helper.selectUncheckedNotices(userId);
			try {
				System.out.println("list" + noticeList.get(0).getNoticeId());
				response.getWriter().print(1);
				request.getSession().setAttribute("noticeList", noticeList);
			} catch (Exception e) {
				try {
					response.getWriter().print(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	/*	if (noticeList == null)
			try {
				response.getWriter().print(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				response.getWriter().print(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	*/

		return null;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

}