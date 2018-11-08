package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	/** 列表 */
	public String list() throws Exception {
		
		return "list";
	}

	/** 显示单个板块(主题列表) */
	public String show() throws Exception {
		
		return "show";
	}

}
