package rpg4;

import java.util.HashMap;

public abstract class Entity {
	


	public HashMap<Anchors, Item> getListOfItems() {
		return listOfItems;
	}




	private HashMap<Anchors, Item> listOfItems = new HashMap<Anchors, Item>();
	
	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * 			name that gets checked
	 * @return Returns true if the given name is valid
	 * 		   It needs to start with a capital letter followed by either a letter, a whitespace or max 2 apostrophes
	 */
	
	public boolean canAcceptName(String name)
	{
		return(name.matches("[A-Z][\\w\\s]*\'{0,1}[\\w\\s]*\'{0,1}[\\w\\s]*"));
	}

	
	
	/**
	 * 
	 * @param name
	 * 			new value for the variable name
	 * @throws Exception
	 * @post Sets the name of the Hero to the given parameter if it is a valid name
	 *
	 * 
	 */

	public void setName(String name) throws Exception{
		try
		{
			if(!this.canAcceptName(name))
			{
			
				throw new Exception("Exception: input name is invalid");	
				
			}
			this.name = name;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	/**
	 * Variable registering the name of your Hero
	 * 	 
	*/

	protected String name;

	

	
	
	public boolean isFighting() {
		return fighting;
	}


	/**
	 * 
	 * @param fighting
	 * 		fighting that either gets set to true or false
	 */

	public void setFighting(boolean fighting) {
		this.fighting = fighting;
	}


	/**
	 * Temporary variable registering if the Hero is fighting or not
	 */

	protected boolean fighting;
	
	/**
	 * 
	 * @param maxHitpoints
	 * 		The given maxHitpoints to be checked
	 * 
	 * 
	 * @return Returns true if the maxHitpoints are than 0
	 */
	
	public int getMaxHitpoints() {
		return maxHitpoints;
	}
	

	public boolean canAcceptMaxHitpoints(int maxHitpoints)
	{
		return(maxHitpoints > 0);
	}
	
	/**
	 * Sets the maxHitpoints of the hero to the given maxHitpoints
	 * @param maxHitpoints
	 * 		  The maximum amount of Hitpoints your Hero can have
	 * @pre The given maxHitpoints need to be valid using the method canAcceptMaxHitpoints()
	 */
	
	public void setMaxHitpoints(int maxHitpoints) {
		assert canAcceptMaxHitpoints(maxHitpoints): "Invalid maxHitpoints";
			this.maxHitpoints = maxHitpoints;
			
	}
	

	/**
	 * Variable registering the maximum hitpoints
	 */
	
	protected int maxHitpoints;
	
	/**
	 * 
	 * @return Returns the hitpoints of the hero
	 */
	
	public int getHitpoints() {
		return hitpoints;
	}
	
	/**
	 * 
	 * @param maxHitpoints
	 * 			The maximum amount of Hitpoints your Hero can have
	 * @param hitpoints
	 * 			The given variable to be checked
	 * @return returns true if the hitpoints are less then or equal to the maxHitpoints
	 */
	
	public boolean smallerHitpoints(int hitpoints)
	{
		return(hitpoints <= this.getMaxHitpoints()&&hitpoints>=0);
	}
	

	/**
	 * 
	 * @param hitpoints
	 * 	      The actual amount of hitpoints your Hero has 
	 * @pre The given hitpoints need to be valid using the method smallerHitpoints()
	 * 		If your hero is not fighting, the amount gets rounded down to a prime number using the function  primeNumber()
	 * 
	 */
	
	

	public void setHitpoints(int hitpoints) {
	
		if(!this.isFighting())
		{
			hitpoints = primeNumber(hitpoints);
		}	
		
	assert smallerHitpoints(hitpoints):"The hitpoints need to be smaller than the maxHitpoints";
	this.hitpoints = hitpoints;
		
		
	}
	
	private boolean isPrime(int hitpoints)
	{
		boolean temp = true;
		for(int i=2;i<=hitpoints/2;i++)
		{
			if(hitpoints%i == 0)
			{
				temp = false;
			}
		}
		return temp;
	}

	/**
	 * 
	 * @param hitpoints
	 * 			The given hitpoints to be checked
	 * @return Returns a prime number using the function isPrime() to round down the given hitpoints to a prime number
	 */
	
	public int primeNumber(int hitpoints)
	{
	
		if(hitpoints>=3)
		{
			
			for(int i=hitpoints;i>2;i--)
			{
				if(isPrime(i))
				{
					return i;
				}
				
			}
			
		}
		return hitpoints;
		
	}
	

	/**
	 * Variable registering the maximum hitpoints
	 */

	protected int hitpoints;
	
	
	

	/**
	 * 
	 *  Static variable registering the average strength of all Heroes
	 */


	public final static double averageStrength = 10.00;
	
	/**
	 * 
	 * @return Returns the strength of the given Hero
	 */
	
	public double getStrength() {
		return strength;
	}
	



	protected double strength;
	
	
	/**
	 * 
	 * @return Returns the capacity
	 */
	
	public double getCapacity() {
		return capacity;
	}
	
	/**
	 * Method used to set the capacity in correlation to the strength of a Hero
	 * @throws Exception
	 * @post Sets the capacity to 0
	 */
	
	private void setCapacity(double capacity) {
		
	}



	
	protected double capacity;
	
	
	
	
	public double getUsedCapacity() {
		return usedCapacity;
	}

	
	public void setUsedCapacity(double usedCapacity)
	{
		
	}


	protected double usedCapacity; 
	
	

	
	
	/**
	 * 
	 * @return returns the variable protection
	 */
	
	
	public int getProtection() {
		return Entity.protection;
	}

	/**
	 * 
	 * @param protection
	 * 		The new value for the variable protection
	 * @post the parameter needs to be a positive integer
	 * 
	 * Setter for the variable protection
	 */
	
	public void setProtection(int protection) {
		if(protection>0)Entity.protection = protection;
	}

	/**
	 * Variable registering the protection of a Hero
	 */

	protected static int protection = 10;
	
	/**
	 * 
	 * @return returns the variable standardProtection
	 */
	
	public static int getStandardProtection() {
		return standardProtection;
	}

	/**
	 * 
	 * @param standardProtection
	 * 		THe new value for the variable standardProtection
	 * @pre The parameter needs to be positive
	 * 
	 * Setter for the variable standardProtection
	 */

	public static void setStandardProtection(int standardProtection) {
		if(standardProtection>0)Entity.standardProtection = standardProtection;
	}
	
	/**
	 * Static variable registering the standardProtection of the Hero
	 */


	public static int standardProtection = 10;

	public void clearItems(Entity entity) throws Exception
	{
		
			if(entity instanceof Hero) {
				((Hero) entity).getListOfItems().clear();
			}
			else
			{
				((Monster) entity).getListOfItems().clear();
			}
		
	}
	
	public void hit(Entity entity) throws Exception{
		
		
	}

	
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}




	protected double speed;
	
	
	
	

}
