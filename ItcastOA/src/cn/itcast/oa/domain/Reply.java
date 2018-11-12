package cn.itcast.oa.domain;

/**
 * 回复
 * 
 * @author Leo
 * @version 1.0v
 */
public class Reply extends Article {

	private static final long serialVersionUID = 1L;
	private Topic topic; // 所属的主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
