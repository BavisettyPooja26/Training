package model;

public class Feedback {

	private int feedid;
	private String feedmsg,feedname;
	public Feedback() {
		super();
	}
	@Override
	public String toString() {
		return "Feedback [feedid=" + feedid + ", feedmsg=" + feedmsg + ", feedname=" + feedname + "]";
	}
	public Feedback(int feedid, String feedmsg, String feedname) {
		super();
		this.feedid = feedid;
		this.feedmsg = feedmsg;
		this.feedname = feedname;
	}
	public int getFeedid() {
		return feedid;
	}
	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}
	public String getFeedmsg() {
		return feedmsg;
	}
	public void setFeedmsg(String feedmsg) {
		this.feedmsg = feedmsg;
	}
	public String getFeedname() {
		return feedname;
	}
	public void setFeedname(String feedname) {
		this.feedname = feedname;
	}
	
}
