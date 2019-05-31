package rpg4;

import java.util.ArrayList;
import java.util.List;

public class Backpack extends Item{
	
	
	
	public Backpack(double capacity,String name)
	{
		
		this.Identification = this.getLastId()+1;
		this.setLastId(this.getIdentification());
		this.capacity = capacity;
		
		this.name  =  name;
	}
	
	public long getIdentification() {
		return Identification;
	}

	private final long Identification;
	
	
	
	
	public long getLastId() {
		return lastId;
	}

	public void setLastId(long lastId) {
		this.lastId = lastId;
	}

	private long lastId = 0;
	
	
	

	public List<Item> getContent() {
		return content;
	}
	
	public Item getItemFromBackpack(long identification) throws Exception
	{
		try {
		for(int i=0;i<this.getContent().size();i++) {
			if(this.getContent().get(i) instanceof Backpack) {
				Backpack tempBackpack = (Backpack) this.getContent().get(i);
				tempBackpack.getItemFromBackpack(identification);
			}
			if(this.getContent().get(i).getIdentification()==identification) {
				return this.getContent().get(i);
			}
		}
		throw new Exception("No item matching the ID present");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void addItem(Item item) {
		
		try {
			if(!this.isValidWeight(item)) {
				
				throw new Exception("You're character can't carry anymore");
			}
			else if(!this.canCarry(item)) {
				System.out.println("Item not added: not enough capacity");
			}
			else
			{
				this.getContent().add(item);
				this.setWeight(this.getWeight()+item.getWeight());
				this.getHolder().setUsedCapacity(item.getWeight()+this.getHolder().getUsedCapacity());
			}
		}
			
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public boolean isValidWeight(Item item) {
		
		return this.getHolder().getCapacity()>=this.getHolder().getUsedCapacity()+item.getWeight();
		
	}
	
	
	public boolean validCapacity() {
		return this.getCapacity()>=this.getWeight();
	}
	
	public boolean canCarry(Item item) {
		

		return this.getWeight()+item.getWeight()<=this.getCapacity();
		
	}
	
	public void removeItem(Item item) {
		
		this.getContent().remove(item);
		this.setWeight(this.getWeight()-item.getWeight());
		this.getHolder().setUsedCapacity(this.getHolder().getUsedCapacity()-item.getWeight());
		
	}

	private void setContent(List<Item> content) {
		this.content = content;
	}
	

	private List<Item> content = new ArrayList<Item>();
	
	
	
	
	public double getBackpackWeight() {
		return backpackWeight;
	}
	
	

	private void setBackpackWeight(double backpackWeight) {
		this.backpackWeight = backpackWeight;
	}

	private double backpackWeight;
	
	
	
	public double getCapacity() {
		return capacity;
	}

	
	private final double capacity;
	
	
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
