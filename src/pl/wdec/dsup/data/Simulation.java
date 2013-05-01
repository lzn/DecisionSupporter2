package pl.wdec.dsup.data;

import java.math.BigDecimal;

public class Simulation {
	public BigDecimal cash;
	public BigDecimal credit;
	public BigDecimal credit_payments; 
	
	public Simulation(BigDecimal cash, BigDecimal credit, BigDecimal credit_payments) {
		this.cash=cash;
		this.credit=credit;
		this.credit_payments=credit_payments;
	}
}
