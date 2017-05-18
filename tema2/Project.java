import java.util.*;
public class Project {
	String name;
	int capacity;
	Vector<Student> Preferences ;
	Vector<Student> allocatedStudents;
	public int studentsAllocated;
	
	public Project (String name , int capacity){
		this.name=name;
		this.capacity = capacity;
		this.Preferences = new Vector<Student>();
		this.allocatedStudents = new Vector<Student>();
		studentsAllocated = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public void setPreferences(Student ...students ){
		for (Student s : students){
			this.Preferences.addElement(s);
		}
	
	}
	
	public String toString(){
		return this.name;
	}
	
	public void printPreferences(){
		System.out.printf("Proiectul %s are asociat studentii : " , this.name);
		for (Student s : this.Preferences){
			System.out.printf(" %s, ",s.toString());
		}
		System.out.println();
	}
	
	public String getPref(){
		String preferableProjects =  new String("Proiectul ");
		preferableProjects += this.name;
		preferableProjects += " are asociat studentii : ";
		for (Student s : this.Preferences){
			preferableProjects += s.toString();
			preferableProjects += ", ";
		}
		preferableProjects += "\n";
		return preferableProjects;
	}
	
	
	public Vector<Student> getPreferences(){
		return this.Preferences;
	}
	
	public Vector<Student> getAllocatedStudents(){
		return this.allocatedStudents;
	}
	
	public void setAllocatedStudents(Student s1, Student s2){
		this.allocatedStudents.set(this.allocatedStudents.indexOf(s1), s2);
	}
	
}
