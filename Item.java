package rpg4;

public abstract class Item {
	
	public Item() {
		
	}
	
	public Entity getHolder() {
		return holder;
	}




	public void setHolder(Entity holder) {
		this.holder = holder;
	}


	private Entity holder;
	
	
	public double getWeight() {
		return weight;
	}
	
	public boolean isValidWeight(double weight)
	{
		return weight>0;
	}

	public void setWeight(double weight) {
		if(this.isValidWeight(weight)) {
			this.weight = weight;
		}
		
	}

	private double weight;

	
	
	public long getIdentification() {
		return identification;
	}

	public void setIdentification(long identification) {
		this.identification = identification;
	}


	private long identification;
	
	
	
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
