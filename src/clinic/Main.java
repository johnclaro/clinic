package clinic;

import java.util.*;


public class Main {
	
	public static String generateRandomName() {
		List<String> names = Arrays.asList(
				"Michael", "Christopher", "Jessica", "Matthew", "Ashley", "Jennifer", "Joshua", "Amanda", "Daniel", "David",
				"James", "Robert", "John", "Joseph", "Andrew", "Ryan", "Brandon", "Jason", "Justin", "Sarah",
				"William", "Jonathan", "Stephanie", "Brian", "Nicole", "Nicholas", "Anthony", "Heather", "Eric", "Elizabeth",
				"Adam", "Megan", "Melissa", "Kevin", "Steven", "Thomas", "Timothy", "Christina", "Kyle", "Rachel",
				"Laura", "Lauren", "Amber", "Brittany", "Danielle", "Richard", "Kimberly", "Jeffrey", "Amy", "Crystal",
				"Michelle", "Tiffany", "Jeremy", "Benjamin", "Mark", "Emily", "Aaron", "Charles", "Rebecca", "Jacob",
				"Stephen", "Patrick", "Sean", "Erin", "Zachary", "Jamie", "Kelly", "Samantha", "Nathan", "Sara",
				"Dustin", "Paul", "Angela", "Tyler", "Scott", "Katherine", "Andrea", "Gregory", "Erica", "Mary",
				"Travis", "Lisa", "Kenneth", "Bryan", "Lindsey", "Kristen", "Jose", "Alexander", "Jesse", "Katie",
				"Lindsay", "Shannon", "Vanessa", "Courtney", "Christine", "Alicia", "Cody", "Allison", "Bradley", "Samuel"
		);
		Random random = new Random();
		int randomNumber = random.nextInt(names.size());
		String name = names.get(randomNumber);
		return name;
	}
	
	public static String generateRandomCondition() {
		List<String> conditions = Arrays.asList(
				"Anthrax", "Bluetongue", "Campylobacteriosis", "Epizootic Ulcerative Syndrome", "Fowl Cholera",
				"Hendra Virus", "Infectious Laryngotracheitis", "Japanese Encephalitis", "Lumpy Jaw",
				"Mareks Disease", "Neospora Caninum", "Ovine Brucellosis", "Pestivirus", "Rabies",
				"Strangles", "Tick Fever", "White Spot Disease"
		);
		Random random = new Random();
		int randomNumber = random.nextInt(conditions.size());
		String condition = conditions.get(randomNumber);
		return condition;
	}
	
	public static Animal generateRandomAnimal() {
		Animal[] animals = Animal.values();
		Random random = new Random();
		int randomNumber = random.nextInt(animals.length);
		Animal animal = animals[randomNumber];
		return animal;
	}


	public static List<Employee> generateStaff() {
		List<Employee> staff = new ArrayList<Employee>();
		for (int index = 0; index < 30; index += 1) {
			Random random = new Random();
			String name = generateRandomName();
			int uid = index + 1;
			
			int maxSalary = 100000;
			int minSalary = 20000;
			int salary = random.nextInt(maxSalary - minSalary) + minSalary;

			Employee employee = new Employee(name, uid, salary);
			staff.add(employee);
		}
		return staff;
	}
	
	public static List<Pet> generatePets() {
		List<Pet> pets = new ArrayList<Pet>();
		for (int index = 0; index < 1000; index += 1) {
			Random random = new Random();
			String name = generateRandomName();
			
			int maxAge = 30;
			int minAge = 1;
			int age = random.nextInt(maxAge - minAge) + minAge;
			
			String condition = generateRandomCondition();
			Animal animal = generateRandomAnimal();
			Pet pet = new Pet(name, age, condition, animal);
			pets.add(pet);
		}
		return pets;
	}
	
	public static Hashtable<Integer, List<Pet>> generateTreatments(List<Employee> staff, List<Pet> pets) {
		Hashtable<Integer, List<Pet>> treatments = new Hashtable<Integer, List<Pet>>();
		for (Pet pet: pets) {
			Random random = new Random();
			int randomNumber = random.nextInt(staff.size());
			Employee randomEmployee = staff.get(randomNumber);
			int randomUID = randomEmployee.getUID();
			if (treatments.containsKey(randomUID)) {
				List<Pet> existingPets = treatments.get(randomUID);
				existingPets.add(pet);
				treatments.put(randomUID, existingPets);
			} else {
				List<Pet> newPet = new ArrayList<Pet>();
				newPet.add(pet);
				treatments.put(randomUID, newPet);
			}
		}
		return treatments;
	}
	
    public static void main(String[] args) {
        List<Employee> staff = generateStaff();
        List<Pet> pets = generatePets();
        Hashtable<Integer, List<Pet>> treatments = generateTreatments(staff, pets);
        
        Scanner command = new Scanner(System.in);
        
        boolean running = true;
        while(running){
        	System.out.println("==============================");
            System.out.println("Welcome to the clinic!");
        	System.out.println("==============================");
            System.out.println("1) List all staff");
            System.out.println("2) List all animals");
            System.out.println("3) Search for a specific member of staff by name");
            System.out.println("4) Search for a specific animal by name");
            System.out.println("5) List all the animals assigned to a member of medical staff");
            System.out.println("0) Exit");
            System.out.print("> ");
        
            switch(command.nextLine()) {
        
            case "1":
                for (Employee employee : staff) {
                	System.out.println(employee);
                }
                break;

            case "2":
                for (Pet pet : pets) {
                	System.out.println(pet);
                }
                break;
               
            case "3":
            	Scanner searchStaffName = new Scanner(System.in);
            	System.out.print("[Search for a specific member of staff by name] > ");
            	String staffName = searchStaffName.nextLine();
                for (Employee employee : staff) {
                	if (employee.getName().equals(staffName)) {
                		System.out.println(employee);
                	}
                }
                break;
                
            case "4":
            	Scanner searchAnimalName = new Scanner(System.in);
            	System.out.print("[Search for a specific animal by name] > ");
            	String animalName = searchAnimalName.nextLine();
                for (Pet pet : pets) {
                	if (pet.getName().equals(animalName)) {
                		System.out.println(pet);
                	}
                }
                break;
                
            case "5":
            	Scanner listAnimalsByStaffMember = new Scanner(System.in);
            	System.out.print("[List all the animals assigned to a member of medical staff -- Provide Staff Member UID] > ");
            	String staffUIDString = listAnimalsByStaffMember.nextLine();
            	int staffUID = Integer.parseInt(staffUIDString);
                List<Pet> treatedPets = treatments.get(staffUID);
                for (Pet treatedPet : treatedPets) {
                	System.out.println(treatedPet);
                }
                break;

            case "0":
                System.out.println("Goodbye!");
                running = false;
                break;

            default:
                System.out.println("Command not recognized!");
                break;
            }
        }
        command.close();
    }
}
