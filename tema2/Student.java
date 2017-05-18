import java.util.Vector;

public class Student {

	String name;
	String email;
	Vector<Project>Preferences ;
	boolean hasProject;
	Project allocatedProject;
	
	public Student(String name,String email){
		this.name= name;
		this.email = email;
		this.hasProject = false;
		this.Preferences = new Vector<Project>();
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public boolean getHasProject(){
		return hasProject;
	}
	
	public boolean setHasProject(boolean value){
		return this.hasProject=value;
	}
	
	public void setPreferences(Project ... projects){
		for (Project p : projects){
			this.Preferences.addElement(p);
		}
	
	}
	
	public String toString(){
		return this.name;
	}
	
	public String getPref(){
		String studentsPreferences =  new String("Studentul ");
		studentsPreferences += this.name;
		studentsPreferences += " prefera proiectele : ";
		for (Project p : this.Preferences){
			studentsPreferences += p.toString();
			studentsPreferences += " ";
		}
		studentsPreferences += "\n";
		return studentsPreferences;
	}
	
	public Vector<Project> getPreferences(){
		return Preferences;
	}
}
