package JavaGame;

public class Weapon extends Item{

	
	public Weapon(double weight, String name)
	{
		while(!this.isValidLastId(Weapon.getLastIdentification()))
		{
			lastIdentification++;
		}
		this.identification = this.generateId(Weapon.getLastIdentification());
		
		
		if(this.isValidWeight(weight)) this.weight = weight;
		else this.weight = 20;
		this.name  =  name;
	}
	
	
	
	
	public long getIdentification() {
		return identification;
	}

	public boolean isValidId(long identification)
	{
		return (identification%3==0 && identification>0 &&identification != Weapon.getLastIdentification());
	}
	
	public long generateId(long identification) {
		while(!this.isValidId(identification))
		{
			identification++;
		}
		Weapon.setLastIdentification(identification);
		return identification;
	}
	

	private final long identification;
	
	
	
	
	
	
	
	public static long getLastIdentification() {
		return lastIdentification;
	}
	
	public boolean isValidLastId(long identification) {
		
		return identification%3==0 && identification > 0;
		
	}

	public static void setLastIdentification(long lastIdentification) {
		Weapon.lastIdentification = lastIdentification;
	}


	private static long lastIdentification;
	
	
	
	
	
	
	public double getWeight() {
		return weight;
	}
	
	public boolean isValidWeight(double weight)
	{	
		return weight>0;
	}


	private final double weight;
	
	
	
	
	
	public int getDamage() {
		return damage;
	}


	public boolean isValidDamage(int damage)
	{
		return damage<=this.getMaxDamage() && damage>=1 && damage%7==0;
	}

	public void setDamage(int damage) {
		assert this.isValidDamage(damage): "The damage input is invalid";
		this.damage = damage;
	}


	private int damage;
	
	
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public boolean isValidMaxDamage(int maxDamage) {
		return maxDamage >=1 && maxDamage >= this.getDamage();
	}

	

	public void setMaxDamage(int maxDamage) {
		assert this.isValidMaxDamage(maxDamage): "The maximum damage needs to be higher than 1";
		this.maxDamage = maxDamage;
	}


	private int maxDamage;
	
	
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
