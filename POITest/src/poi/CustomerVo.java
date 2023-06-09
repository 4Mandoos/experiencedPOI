package poi;

public class CustomerVo {

	private String custId; // 고객ID
	private String custPassword; // 고객 비밀번호
	private String custName; // 고객명
	private String custEmail; // 고객이메일
	private String custTelno; // 고객전화번호

	public CustomerVo(String custId, String custPassword, String custName, String custEmail, String custTelno) {
		super();
		this.custId = custId;
		this.custPassword = custPassword;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custTelno = custTelno;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustTelno() {
		return custTelno;
	}

	public void setCustTelno(String custTelno) {
		this.custTelno = custTelno;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID : " + custId);
		sb.append(", NAME : " + custName);
		sb.append(", EMAIL : " + custEmail);
		sb.append(", TELNO : " + custTelno);
		return sb.toString();
	}
}
