package JavaGame;

public class Armor extends Item{
	
	
	
	public Armor(long identification, double maxProtection, String name, double weight) {
		
		this.setIdentification(identification);
		double temp  = maxProtection;
		if(temp<1||temp>100) {
			temp = 100;
		}
		this.maxProtection = temp;
		
		this.name  =  name;
		
		this.weight = weight;
		
		
	}
	
	
	
	
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}





	protected double weight;
	
	
	
	public long getIdentification() {
		return identification;
	}
	
	private boolean isPrime(int identification)
	{
		boolean temp = true;
		if(identification<0) return false;
		for(int i=2;i<=identification/2;i++)
		{
			if(identification%i == 0)
			{
				temp = false;
			}
		}
		return temp;
	}
	
	public int primeNumber(int identification)
	{
	
		if(identification>=3)
		{
			
			for(int i=identification;i>2;i--)
			{
				if(isPrime(i))
				{
					return i;
				}
				
			}
			
		}
		return identification;
		
	}
	

	
	private long identification;
	
	
	
	public double getProtection() {
		return protection;
	}
	
	public void changeArmorValue(double armor) {
		double temp = this.getProtection()*armor;
		if(temp>0) {
			if(temp<this.getMaxProtection()) {
				this.setProtection(temp);
			}
			else
			{
				this.setProtection(this.getMaxProtection());
			}
		}
		else
		{
			this.setProtection(0);
		}
		
	}

	public void setProtection(double protection) {
		if(protection<this.getMaxProtection()&&protection>0)this.protection = protection;
		else protection = this.getMaxProtection();
	}

	private double protection;
	
	
	
	
	
	public double getMaxProtection() {
		return maxProtection;
	}






	private final double maxProtection;
	
	
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
