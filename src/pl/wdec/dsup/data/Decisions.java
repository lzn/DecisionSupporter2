package pl.wdec.dsup.data;

public class Decisions
{
	public Decisions(int quantity, int quality, double price, Point point)
	{
		this.quantity = quantity;
		this.quality = quality;
		this.price = price;
		this.point = point;
	}
	
	public Point point;
	public int quantity;
	public int quality; //
	public double price;
	
	@Override
	public String toString() {
		return "Decision: " + " risk=["+point.risk+ "] cash=[" + point.cash +
				"] quanity=["+quantity+"] quality=[" + quality + "] price=["+price+"]";
	}
}
