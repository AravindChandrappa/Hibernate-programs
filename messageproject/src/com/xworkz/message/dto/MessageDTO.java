package com.xworkz.message.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="MESSAGE_TABLE")
public class MessageDTO implements Serializable {
	
	@Id
	/*@TableGenerator(name="auto", table="MESSAGE_TABLE",pkColumnName="ID",pkColumnValue="ID",allocationSize=1)*/
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	 private int mId;
	@Column(name="SENDER")
	 private String sender;
	@Column(name="RECIEVER")
	 private String reciever;
	@Column(name="MESSAGE")
	 private String messageBody;
	@Column(name="SENT")
	 private Date sent;
	 
	 public MessageDTO() {
		System.out.println("creatde :"+ this.getClass().getName());
	}

	public MessageDTO(String sender, String reciever, String delivered, Date sent) {
		//super();
		this.sender = sender;
		this.reciever = reciever;
		this.messageBody = delivered;
		this.sent = sent;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender=sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getSent() {
		return sent;
	}

	public void setSent(Date sent) {
		this.sent = sent;
	}

	@Override
	public String toString() {
		return "MessageDTO [mId=" + mId + ", sender=" + sender + ", reciever=" + reciever + ", delivered=" + messageBody
				+ ", sent=" + sent + "]";
	}
	 

}
