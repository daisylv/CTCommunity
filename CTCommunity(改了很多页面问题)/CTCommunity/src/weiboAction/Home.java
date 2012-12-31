package weiboAction;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author bjrara
 * */

public class Home extends ActionSupport{
	
	public static final String FAILURE = "failure";
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception {
        return SUCCESS;
    }
}