package pl.wdec.dsup.data;

import java.math.BigDecimal;

import pl.wdec.dsup.types.GmPrefDefault;

public class GameProperties {
	
	
	public GameProperties() {
		this.fixedAssets = new BigDecimal(GmPrefDefault.FIXED_ASSET);
		this.maxCredit =  new BigDecimal(GmPrefDefault.MAX_CREDIT);
		this.cash =  new BigDecimal(GmPrefDefault.CASH);
		this.debt =  new BigDecimal(GmPrefDefault.DEBT);
		this.depreciation =  new BigDecimal(GmPrefDefault.DEPRECIATION);
		this.fixedCosts =  new BigDecimal(GmPrefDefault.FIXED_COSTS);
		this.acntInterestRate =  Double.parseDouble(GmPrefDefault.ACNT_INTEREST_RATE)/100;
		this.creditInterestRate =  Double.parseDouble(GmPrefDefault.CREDIT_INTEREST_RATE)/100;
		this.taxRate =  Double.parseDouble(GmPrefDefault.TAX_RATE)/100;
		this.resalesRate =  Double.parseDouble(GmPrefDefault.RESALES_RATE)/100;
		this.maxProdCapacity =  Integer.parseInt(GmPrefDefault.MAX_PROD_CAPACITY);
		this.minQuality =  Integer.parseInt(GmPrefDefault.MIN_QUALITY);
		this.maxQuality = Integer.parseInt(GmPrefDefault.MAX_QUALITY);
	}
	public GameProperties(BigDecimal fixedAssets, BigDecimal maxCredit,
			BigDecimal cash, BigDecimal debt, BigDecimal depreciation,
			BigDecimal fixedCosts, Double acntIntegererestRate,
			Double creditIntegererestRate, Double taxRate, Double resalesRate,
			Integer maxProdCapacity, Integer minQuality, Integer maxQuality) {
		this.fixedAssets = fixedAssets;
		this.maxCredit = maxCredit;
		this.cash = cash;
		this.debt = debt;
		this.depreciation = depreciation;
		this.fixedCosts = fixedCosts;
		this.acntInterestRate = acntIntegererestRate;
		this.creditInterestRate = creditIntegererestRate;
		this.taxRate = taxRate;
		this.resalesRate = resalesRate;
		this.maxProdCapacity = maxProdCapacity;
		this.minQuality = minQuality;
		this.maxQuality = maxQuality;
	}
	/*
	 * majatek trwaly firmy
	 * */
	public BigDecimal fixedAssets;
	/*
	 * maksymalny kredyt
	 */
    public BigDecimal maxCredit;	
    /*
     * Ilosc gotowki
     */
    public BigDecimal cash;
    /*
     * Zadluzenie
     */
    public BigDecimal debt;
    /*
     * Amortyzacja
     */
    public BigDecimal depreciation;
    /*
     * Koszty stałe
     */
    public BigDecimal fixedCosts;
    /*
     * Oprocentowanie konta, od 0.00 do 1.00
     */
    public Double acntInterestRate;
    /*
     * Oprocentowanie kredytu od 0.00 do 1.00
     */
    public Double creditInterestRate;
    /*
     * Stawka podatku od 0.00 do 1.00
     */
    public Double taxRate;
    /*
     * Niesprzedane produkty skupowane za (od 0.00 do 1.00)
     */
    public Double resalesRate;
    
    /*
     * Maksymalna zdolność produkcyjna
     */
    public Integer maxProdCapacity;
    
    /*
     * Minimalna jakość produktu
     */
	public Integer minQuality;
	/*
	 * Maksymalna jakość produktu
	 */
	public Integer maxQuality;
	
	
	public BigDecimal getFixedAssets() {
		return fixedAssets;
	}
	public void setFixedAssets(BigDecimal fixedAssets) {
		this.fixedAssets = fixedAssets;
	}
	public BigDecimal getMaxCredit() {
		return maxCredit;
	}
	public void setMaxCredit(BigDecimal maxCredit) {
		this.maxCredit = maxCredit;
	}
	public BigDecimal getCash() {
		return cash;
	}
	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}
	public BigDecimal getDebt() {
		return debt;
	}
	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}
	public BigDecimal getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(BigDecimal depreciation) {
		this.depreciation = depreciation;
	}
	public BigDecimal getFixedCosts() {
		return fixedCosts;
	}
	public void setFixedCosts(BigDecimal fixedCosts) {
		this.fixedCosts = fixedCosts;
	}
	public Double getAcntInterestRate() {
		return acntInterestRate;
	}
	
	public Double getAcntInterestRateProc() {
		return acntInterestRate*100;
	}
	public void setAcntInterestRate(Double acntIntegererestRate) {
		this.acntInterestRate = acntIntegererestRate;
	}
	
	public Double getCreditIntegererestRate() {
		return creditInterestRate;
	}
	
	public Double getCreditIntegererestRateProc() {
		return creditInterestRate*100;
	}
	
	public void setCreditIntegererestRate(Double creditIntegererestRate) {
		this.creditInterestRate = creditIntegererestRate;
	}
	
	public Double getTaxRate() {
		return taxRate;
	}
	public Double getTaxRateProc() {
		return taxRate*100;
	}
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	public Double getResalesRate() {
		return resalesRate;
	}
	public Double getResalesRateProc() {
		return resalesRate*100;
	}
	public void setResalesRate(Double resalesRate) {
		this.resalesRate = resalesRate;
	}
	public Integer getMaxProdCapacity() {
		return maxProdCapacity;
	}
	public void setMaxProdCapacity(Integer maxProdCapacity) {
		this.maxProdCapacity = maxProdCapacity;
	}
	public Integer getMinQuality() {
		return minQuality;
	}
	public void setMinQuality(Integer minQuality) {
		this.minQuality = minQuality;
	}
	public Integer getMaxQuality() {
		return maxQuality;
	}
	public void setMaxQuality(Integer maxQuality) {
		this.maxQuality = maxQuality;
	}
	
}
