package job.model;

public class Mail {
	
	private String recipients;
	private String subject;
	private String body;
	
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Mail(String recipients, String subject, String body) {
		super();
		this.recipients = recipients;
		this.subject = subject;
		this.body = body;
		
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
