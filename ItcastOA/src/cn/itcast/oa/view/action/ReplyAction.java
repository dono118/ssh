package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	/** 发表新回复的页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 发表新回复 */
	public String add() throws Exception {

		return "toTopicShow"; // 转到新回复所在主题的显示页面
	}
}
