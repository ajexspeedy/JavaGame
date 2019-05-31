package rpg4;

import java.util.HashMap;

public class Monster extends Entity{
	
	public Monster(double maxProtection)
	{
		if(maxProtection>0) {
			this.maxProtection = maxProtection;
		}
		else
		{
			this.maxProtection = 10;
		}
		
		// Randomly generates whether a Monster has or hasn't got an anchorpoint
		
		boolean checkAnchors[] = new boolean[Anchors.values().length];
		
		for(int i=0;i<checkAnchors.length;i++) {
			double temp  = Math.random();
			if(temp<=0.5) {
				
				checkAnchors[i] = false;
				
			}
			else
			{
				checkAnchors[i] = true;
				listOfItems.put(Anchors.values()[i], null);
			}
		}
		
		
		// Randomly generates whether a Monster gets an element on a given anchorpoint
		for(int i=0;i<this.getListOfItems().size();i++) {
			double temp  = Math.random();
			if(temp<=0.5&&checkAnchors[i]==true) {
				this.getListOfItems().put(Anchors.values()[i], Monster.randomItems[(int)temp*10]);
			}
		}
	}

	public Monster(String name, int damage, int maxDamage, int maxHitpoints, double monsterProtection, double maxProtection, double strength, double speed) {
		
		if(this.canAcceptName(name)) {
			this.name = name;
		}
		
		if(this.isValidMaxDamage(maxDamage)) {
			this.maxDamage = maxDamage;
		}
		
		if(this.isValidDamage(damage)) {
			this.damage = damage;
		}
		

		if(this.canAcceptMaxHitpoints(maxHitpoints)) {
			this.maxHitpoints = maxHitpoints;
			this.hitpoints = maxHitpoints;
		}
		
		if(maxProtection>0) {
			this.maxProtection = maxProtection;
		}
		else
		{
			this.maxProtection = 10;
		}
		
		if(monsterProtection<this.maxProtection) {
			this.monsterProtection = monsterProtection;
		}
		else
		{
			this.monsterProtection = this.maxProtection;
			
		}
		
		if(strength >0) {
			this.strength = strength;
		}
		else
		{
			this.strength = 2;
		}
		
		// Randomly generates whether a Monster has or hasn't got an anchorpoint
		
		boolean checkAnchors[] = new boolean[Anchors.values().length];
		for(int i=0;i<checkAnchors.length;i++) {
			double temp  = Math.random();
			if(temp<=0.5) {
				
				checkAnchors[i] = false;
				
			}
			else
			{
				checkAnchors[i] = true;
				
				this.listOfItems.put(Anchors.values()[i], null);
			}
		}
		
		
		// Randomly generates whether a Monster gets an element on a given anchorpoint
		for(int i=0;i<this.getListOfItems().size();i++) {
			double temp  = Math.random();
			if(temp<=0.5&&checkAnchors[i]==true) {
				this.getListOfItems().put(Anchors.values()[i], Monster.randomItems[(int)temp*10]);
			}
		}
		if(speed>0) {
			this.speed = speed;
		}
		
		
	}
	
	
	
	public HashMap<Anchors, Item> getListOfItems() {
		return listOfItems;
	}




	private HashMap<Anchors, Item> listOfItems = new HashMap<Anchors, Item>();
	
	
	
	public void fillItemTable(Item item1,  Item item2, Item item3, Item item4, Item item5)
	{
		randomItems[0] = item1;
		randomItems[1] = item2;
		randomItems[2] = item3;
		randomItems[3] = item4;
		randomItems[4] = item5;
	}
	
	
	private static Item[] randomItems = new Item[5];
	
	
	
	//
	public double getCapacity() {
		return capacity;
	}
	
	/**
	 * Method used to set the capacity in correlation to the strength of a Hero
	 * @throws Exception
	 * @post Sets the capacity to 0
	 */
	
	
	public void strengthCapacity() throws Exception{
		try
		{
			if(!this.isValidNumber(this.getStrength()))
			{
				this.setCapacity(0);
				throw new Exception("Invalid strength");
			}
		
			switch((int)(this.getStrength()))
			{
			// 0
			
			
			
			// 1 - 10
			
			case 1: case 2: case 3: case 4:case 5:case 6:case 7:case 8:case 9:case 10:
				this.setCapacity(this.getStrength()*10);
			break;
			
			//  11 - 20
			case 11: this.setCapacity(this.getHighCapacity()[0]);
			break;
			case 12: this.setCapacity(this.getHighCapacity()[1]);
			break;
			case 13: this.setCapacity(this.getHighCapacity()[2]);
			break;
			case 14: this.setCapacity(this.getHighCapacity()[3]);
			break;
			case 15: this.setCapacity(this.getHighCapacity()[4]);
			break;
			case 16: this.setCapacity(this.getHighCapacity()[5]);
			break;
			case 17: this.setCapacity(this.getHighCapacity()[6]);
			break;
			case 18: this.setCapacity(this.getHighCapacity()[7]);
			break;
			case 19: this.setCapacity(this.getHighCapacity()[8]);
			break;
			case 20: this.setCapacity(this.getHighCapacity()[9]);
			break;
			
			// 21-..
			
			default: this.setCapacity(highCapacity());
					
			break;
			
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean isValidNumber(double strength)
	{
		return strength >0;
	}
	
	
	/**
	 * 
	 * @return Calculates then returns the capacity when the strength is equal to or greater than 21.00
	 */
	
	
	public double highCapacity()
	{
		int temp = 1;
		int tempStrength = (int) this.getStrength();
		while(tempStrength>=31)
		{
			 tempStrength = tempStrength-10;
			 temp++;
		}
		tempStrength = tempStrength-10;
		
		return (this.getHighCapacity()[(tempStrength-1)*(4*temp)]);
		
	}
	
	/**
	 * 
	 * @param capacity
	 * 			The new value for the variable capacity
	 * 
	 * 		  Private setter for the variable capacity
	 */

	private void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Variable registering the capacity of a given Hero
	 */

	
	protected double capacity;
	
	
	
	
	public double getUsedCapacity() {
		return usedCapacity;
	}
	public void setUsedCapacity(double usedCapacity) {
		this.usedCapacity = usedCapacity;
	}


	protected double usedCapacity; 
	
	
	/**
	 * 
	 * @return Returns the List highCapacity
	 */


	public int[] getHighCapacity() {
		return highCapacity;
	}



	/**
	 * ArrayList registering the high capacities of a given Hero
	 */
	
//	protected List<Double> highCapacity = new ArrayList<Double>();
	
	protected final int[] highCapacity = new int[]{115,130,150,175,200,230,260,300,350,400};

	
	
	
	
	
	public boolean canAcceptName(String name)
	{
		return(name.matches("[A-Z][\'\\w\\s]*"));
	}

	
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
	
	public void hit(Entity entity) throws Exception
	{
		int currentHitpoints = calculateHitpoints(this.getHitpoints());
		if(isHit(entity, currentHitpoints)) {
			System.out.println("ouch");
			int damage = calculateDamage();
			// Potentially picks up items if it dealt the killing blow
			if(entity.getHitpoints()-damage>=0) {
				entity.setHitpoints(entity.getHitpoints()-damage);
				entity.clearItems(entity);
			}
			else
			{
				entity.setHitpoints(entity.getHitpoints()-damage);
				this.takeItems(entity);
				entity.clearItems(entity);
			}
			
		}
		else
		{
			System.out.println("Mis");
		}
		
			
	}
	
	public void takeItems(Entity entity)
	{
		if(entity instanceof Hero)
		{
			Hero tempEntity = (Hero) entity;
			for(int i=0;i<tempEntity.getListOfItems().size();i++) {
				double temp = Math.random();
				if(temp<0.25) {
					this.pickUpItem(tempEntity.getListOfItems().get(Anchors.values()[i]));
				}
				else if(temp<0.5) {
					this.pickUpItem(tempEntity.getListOfItems().get(Anchors.values()[i]));
				
					this.dropItem(this.getListOfItems().get(Anchors.values()[i]));
				}
				
			}
		}
		else
		{
			Monster tempEntity = (Monster) entity;
			for(int i=0;i<tempEntity.getListOfItems().size();i++) {
				double temp = Math.random();
				if(temp<0.25) {
					this.pickUpItem(tempEntity.getListOfItems().get(Anchors.values()[i]));
				}
				else if(temp<0.5) {
					this.pickUpItem(tempEntity.getListOfItems().get(Anchors.values()[i]));
				
					this.dropItem(this.getListOfItems().get(Anchors.values()[i]));
				}
			}
		}
		

	}

	
	
	public int calculateHitpoints(int hitpoints)
	{
		double temp = Math.random()*100;
		if(hitpoints>=(temp)) {
			return (int)temp;
		}
		else
		{
			return hitpoints;
		}
	}
	
	public boolean isHit(Entity entity, int currentHitpoints) {
		
		return (currentHitpoints>=entity.getProtection());
	}
	
	public int calculateDamage()
	{
		return (int)(this.getDamage() + ((this.getStrength()-5)/3));
	}
	
	public void pickUpItem(Item item)
	{
		
		if(this.getCapacity()-this.getUsedCapacity()>=item.getWeight()) {
			
			
			
				
					
				
				for(int i=0;i<listOfItems.values().size();i++) {
				
					if(this.getListOfItems().get(Anchors.values()[i]) == null) {
						
							listOfItems.put(Anchors.values()[i], item);
							this.setUsedCapacity(this.getUsedCapacity()+item.getWeight());
							item.setHolder(this);
							break;
						}
						
					}
				
 			}
		else
		{
			System.out.println("You can't carry anymore");
		}
	
	}
	
	
	
	public void dropItem(Item item)
	{
	
		listOfItems.remove(listOfItems.values(),  item);
		this.setUsedCapacity(this.getUsedCapacity()-item.getWeight());
		item.setHolder(null);
		
	}
	
	public void tradeItems(Item item, Monster monster)
	{
		this.dropItem(item);
		monster.pickUpItem(item);
	}	
	
	public double getMonsterProtection() {
		return monsterProtection;
	}
	

	
	public void setMonsterProtection(double monsterProtection) {
		if(protection<this.getMaxProtection()&&protection>0)this.monsterProtection = monsterProtection;
		else monsterProtection = this.getMaxProtection();
	}

	private double monsterProtection;
	
	
	
	
	
	public double getMaxProtection() {
		return maxProtection;
	}






	private final double maxProtection;

	

	
	
}
