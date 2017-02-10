package demo.jmstemplate;

import java.io.Serializable;

public class Purchase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int poNum;
	private double poAmount;
	
	public int getPoNum() {
		return poNum;
	}
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	public double getPoAmount() {
		return poAmount;
	}
	public void setPoAmount(double poAmount) {
		this.poAmount = poAmount;
	}
	
	@Override
	public String toString() {
		return "Puchase [poNum=" + poNum + ", poAmount=" + poAmount + "]";
	}


}
