package rpg4;
import java.util.HashMap;
import java.util.Scanner;




public class Hero extends Entity{
	
	/**
	 * Basic constructor for the class Hero
	 */
	
	public Hero()
	{
		this.fighting = false;
		Hero.protection = standardProtection;
		
		
		for(int i=0;i<listOfItems.values().size();i++) {
			listOfItems.put(Anchors.values()[i], null);
		}
		
		
	}
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 * @param name
	 * 		The name of a hero
	 * @param maxhitpoints
	 * 		The maximum hitpoints
	 * @param strength
	 * 		The strength of a hero
	 * @throws Exception
	 */
	
	public Hero(String name, int hitpoints ,double strength, double speed) throws Exception
	{
		this.fighting = false;
		if(this.isValidNumber(strength))
		{
			this.strength = strength;
			this.strengthCapacity();
		}
		this.maxHitpoints = 30;
		
			try
			{
				if(!this.canAcceptName(name))
				{
					throw new Exception("Wrong input name");
				}
				this.name = name;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			for(int i=0;i<listOfItems.values().size();i++) {
				listOfItems.put(Anchors.values()[i], null);
			}
			
			if(!this.isValidNumber(strength))
			{
				this.strength = 1.00;
			}
		else
		{
			this.strength = strength;
		}
		
			assert (this.smallerHitpoints(hitpoints)) : "Wrong input hitpoints";
			this.hitpoints = hitpoints;
			 
			
		
		this.hitpoints = this.maxHitpoints;
		
		if(speed>0) {
			this.speed = speed;
		}
		
		
	}
	
	
	public HashMap<Anchors, Item> getListOfItems() {
		return listOfItems;
	}


	private HashMap<Anchors, Item> listOfItems = new HashMap<Anchors, Item>();
	
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
		tempStrength -= 21;
		
		int strengthCap = this.getHighCapacity()[tempStrength];
		
		for(int i=0;i<temp;i++) {
			
			strengthCap *= 4;
		}
		
		return (strengthCap);
		
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


	

		


	
	
	
	/**
	 * 
	 * @param protection
	 * @return returns whether temp minus the parameter greater then or equal is to 0
	 * 
	 */

	public boolean isHit(int protection)
	{
		int temp = (int) (Math.random()*20);
		
		return temp>=protection;
	}
	
	/**
	 * 
	 * @param hero
	 * 		The hero that recieves the hit
	 * Calculates how much hp u gain from killing a hero
	 */
	
	private void heal() {
		double temp =  (Math.random()*100);
		this.setHitpoints(this.getHitpoints() + ((this.getMaxHitpoints()-this.getHitpoints())* (int)(temp/100)));
		
		
	}
	
	private void deathblow(Entity entity)
	{
			
		
		entity.setHitpoints(0);
		
		
		this.collectTreasure(entity);
		heal();
	}
	
	private void collectTreasure(Entity entity) {
		for(int i=0;i<entity.getListOfItems().size();i++) {
					
					if(this.takeTreasure(entity.getListOfItems().get(Anchors.values()[i]))) {
						this.pickUpItem(entity.getListOfItems().get(Anchors.values()[i]));
						
					}
					
				}

	}
	

		
		

	
	public boolean takeTreasure(Item item) {
		if(item == null) {
			System.out.println("Geen items");
			return false;
		}
		else
		{
		System.out.println("Take item: "+item.getName()+"?");
		Scanner scanner = new Scanner(System.in);
			if(scanner.nextLine().equalsIgnoreCase("yes")) {
				System.out.println("pickup");
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * 
	 * @param hero
	 * 		The hero that recieves the hit
	 * @pre Checks if the hero is hit
	 */
	
	public void hit(Entity entity)
	{
		
		// If the entity is wearing armor on it's body, the protection value is added to your hero
		int tempProtection = 0;
		if(entity instanceof Hero) {
			Hero tempHero = (Hero) entity;
			if(tempHero.getListOfItems().get(Anchors.BODY) instanceof Armor) {
				Armor tempArmor = (Armor)listOfItems.get(Anchors.BODY);
				tempProtection += (int) tempArmor.getProtection();
			}
			tempProtection += entity.getProtection();
		}
		else if(entity instanceof Monster) {
			Monster tempMonster = (Monster) entity;
			tempProtection += tempMonster.getMonsterProtection();
		}
	
		
		// If the hero has a weapon equipped in its hand(s), the damage value is added to your hero
		if(this.isHit(tempProtection))
		{
			double tempStrength = 0;
			
			System.out.println("Ouch");
			if(listOfItems.get(Anchors.LEFTHAND) instanceof Weapon ) {
				Weapon tempWeapon = (Weapon)listOfItems.get(Anchors.LEFTHAND);
				tempStrength += tempWeapon.getDamage();
			}
			if(listOfItems.get(Anchors.RIGHTHAND) instanceof Weapon ) {
				Weapon tempWeapon = (Weapon)listOfItems.get(Anchors.RIGHTHAND);
				tempStrength += tempWeapon.getDamage();
			}
			tempStrength += this.getStrength();
			
			if(entity.getHitpoints()-((tempStrength-10)/2) <= 0 )
			{
				
				deathblow(entity);
				
				
			}
			else
			{
				entity.setHitpoints((int)(entity.getHitpoints()-((tempStrength-10)/2)));
				
			}
		}
		else
		{
			System.out.println("Mis");
			
		}
	}
	
	
	
	
	public void pickUpItem(Item item)
	{
		if(this.getCapacity()-this.getUsedCapacity()>=item.getWeight()) {
			int temp = 0;
			Entity entity = (Entity) this;
			
			for(int i=0;i<this.getListOfItems().size();i++) {
				
				if(listOfItems.get(Anchors.values()[i]) instanceof Armor) {
					
					temp++;
					
					
				}
			}
			
				if(this.getListOfItems().get(Anchors.BODY) == null&&item instanceof Armor&&temp<=2) {
					
					this.equipArmor(item);
					item.setHolder(entity);
					System.out.println("Can pickup armor");
				}
				else if(this.getListOfItems().get(Anchors.LEFTHAND) == null&&item instanceof Weapon) {
					this.equipWeapon(item, Anchors.LEFTHAND);
					System.out.println("Can equip weapon (L)");
					item.setHolder(entity);
				}
				else if(this.getListOfItems().get(Anchors.RIGHTHAND) == null&&item instanceof Weapon){
					this.equipWeapon(item, Anchors.RIGHTHAND);
					System.out.println("Can equip weapon (R)");
					item.setHolder(entity);
				}
				else
				{
					
				
				for(int i=0;i<listOfItems.values().size();i++) {
				// If you have 2 pieces of armor on your hero, the loop stops and prevents you from picking it up
					if(temp>=2&&item instanceof Armor) {
						System.out.println("Oh oh");
						break;
					}
					if(listOfItems.get(Anchors.values()[i]) == null) {
						System.out.println("okay");
							listOfItems.put(Anchors.values()[i], item);
							this.setUsedCapacity(this.getUsedCapacity()+item.getWeight());
							
							item.setHolder(entity);
							break;
						}
					
						
					}
				System.out.println("You don't have any room left");
				}
 			}
			else
			{
				System.out.println("You can't carry anymore: "+this.getUsedCapacity());
				
			}
	
		}
		
	
	
	public void dropItem(Item item)
	{
	
		listOfItems.remove(listOfItems.values(),  item);
		this.setUsedCapacity(this.getUsedCapacity()-item.getWeight());
		item.setHolder(null);
		
	}
	
	
	
	public void tradeItems(Item item, Hero hero)
	{
		
			
			
		this.dropItem(item);	
		hero.pickUpItem(item);
		
				
	}
	
	// private methods only accessed by pickUpItems() and tradeItems()
	private void equipWeapon(Item item, Anchors hand) {
		listOfItems.put(hand, item);
	}
	
	private void equipArmor(Item item) {
		listOfItems.put(Anchors.BODY, item);
	
	}
	
	// Unequips armor and puts it onto another anchorpoint
	public void unEquipArmor() {
		Item temp = listOfItems.get(Anchors.BODY);
		for(int i=0;i<listOfItems.size();i++) {
			if(Anchors.values()[i] == null) {
				listOfItems.put(Anchors.BACK, null);
				listOfItems.put(Anchors.values()[i], temp);
				break;
				
			}
			
		}
	}
	
	public void switchArmor(Armor armor) {
		this.unEquipArmor();
		this.equipArmor(armor);
		
	}

	
		


	
	

}
