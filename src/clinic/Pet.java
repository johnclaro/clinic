package clinic;


public class Pet {
	
	private String name, condition;
	private int age;
	private Animal animal;
	
	public Pet(String name, int age, String condition, Animal animal) {
		this.name = name;
		this.age = age;
		this.condition = condition;
		this.animal = animal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode()) + "[name='" + this.name + "',age=" + this.age + ",condition='" + this.condition + "',animal=" + this.animal + "]";
	}
}
