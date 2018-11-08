package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	/** 显示单个主题(主题+回帖列表) */
	public String show() throws Exception {
		
		return "show";
	}

	/** 发表新主题页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 发表新主题 */
	public String add() throws Exception {

		return "toShow"; // 转到新主题的显示页面
	}
}
