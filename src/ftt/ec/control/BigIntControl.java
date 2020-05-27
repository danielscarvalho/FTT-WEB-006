package ftt.ec.control;

import java.math.BigInteger;

public class BigIntControl {
	
	private BigInteger bigValueA;
	private BigInteger bigValueB;
	
	//Default constructor
	public BigIntControl() {
		
	}
	
	public BigIntControl(String a, String b) {
		this.setA(a);
		this.setB(b);
	}
	
	public void setA(String a) {
		this.bigValueA = new BigInteger(a);
	}
	
	public void setB(String b) {
		this.bigValueB = new BigInteger(b);
	}

	public String getSum() {
		return bigValueA.add(bigValueB).toString();
	}

}
