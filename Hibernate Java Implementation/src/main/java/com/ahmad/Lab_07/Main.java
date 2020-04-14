package com.ahmad.Lab_07;

public class Main {
	public static void main(String[]args) {
		Person person1 = new Person(1,"John","Doe","Nust", "0336");
		Person person2 = new Person(2,"Tony","Stark","Stark", "0346");
		Person person3 = new Person(3,"Elon","Musk","Tesl", "0743");
		
		PersonDao handler = new PersonDao();
		
		handler.addPerson(person1);
		handler.addPerson(person2);
		handler.addPerson(person3);
		
		Person updated_person3 = new Person(3,"Elon","Musk","Tesla", "0743");
		
		handler.updatePerson(updated_person3);
		
		handler.getPerson(2);


		handler.deletePerson(2);
		
		handler.finalize();	

	}
}

