package example.jms.domain;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable {

	public String getDate() {
		return new Date().toString();
	}

	public String getAmount() {
		return "$ 1024.99";
	}

	public String getReason() {
		return "Because it was there!";
	}

	@Override
	public String toString() {
		return "Purchase [Date=" + getDate() + ", Amount=" + getAmount() + ", Reason=" + getReason()
				+ "]";
	}
}
