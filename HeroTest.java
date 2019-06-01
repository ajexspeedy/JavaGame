package JavaGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class HeroTest {
	
	

	
	
	private Hero hero1, hero2;
	
	@Before
	public void setUpImmutableFixtures() throws Exception
	{
		hero1 = new Hero("Tim",15,18.00,12.00);
		hero2 = new Hero("Tam",10,12.00,12);
	}
	
	
	@Test
	public void constructor_legalCase() throws Exception
	{
		Hero hero = new Hero("Tem",11,20D,12.00);
		assertEquals("Tem",hero.getName());
		assertEquals(30,hero.getMaxHitpoints());
		assertEquals(20D, hero.getStrength(),0);
		
		
	}
	
	@Test(expected = AssertionError.class)
	public void constructor_illegalCase() throws Exception
	{
		Hero hero = new Hero("Tem",-1,20D,12.00);
		assertEquals("Tem",hero.getName());
		assertEquals(0,hero.getMaxHitpoints());
		assertEquals(20D, hero.getStrength(),0);
	}
	
	//Method deathblow() needs to be set public in order to test
/*	@Test
	public void deathblow_legalCase() {
		hero1.deathblow(hero2);
		assertEquals(0,hero2.getHitpoints());
		
	}
*/	
	@Test
	public void isHit_returnFalse() {
		assertFalse(hero1.isHit(20));
	}
	
	
	//Depending on if you enter true or false in your scanner you get true or false returned
	
	@Test
	public void collectTreasure() {
		Weapon tempWeapon = new Weapon(30,"Test");
		
		
		//assertFalse(hero1.takeTreasure(tempWeapon));
		//assert(hero1.takeTreasure(tempWeapon));
		
		
		
		
	}
	
	
	
	
	
	
}
