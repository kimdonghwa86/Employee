package com.hybrid.model.busapi;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ServiceResult")
public class ServiceResult {

	MsgHeader msgHeader;
	MsgBody msgBody;

	public MsgHeader getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(MsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}

	public MsgBody getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(MsgBody msgBody) {
		this.msgBody = msgBody;
	}
	
	
}
