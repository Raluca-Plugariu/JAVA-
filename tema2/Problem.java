import java.util.*;

public class Problem {

	int numberOfStudents;
	int numberOfProjects;
	Vector<Student> totalStudents;
	Vector<Project> totalProjects;

	public Vector<Student> unalocattedStudents;

	// Constructor of this class
	public Problem(int numberofStudents, int numberOfProjects) {
		if (numberOfProjects < 0 || numberofStudents < 0) {
			System.out.println("Bad arguments to Problem constructor");
			System.exit(0);
		} else {
			this.numberOfStudents = numberofStudents;
			this.numberOfProjects = numberOfProjects;
			totalStudents = new Vector<Student>();
			totalProjects = new Vector<Project>();
			unalocattedStudents = new Vector<Student>(totalStudents);
		}
	}

	public void setStudents(Student... students) {
		for (Student s : students) {
			this.totalStudents.addElement(s);
		}
	}

	public void setProjects(Project... projects) {
		for (Project p : projects) {
			this.totalProjects.addElement(p);
		}
	}

	public Vector<Student> getTotalStudents() {
		return this.totalStudents;
	}

	public Vector<Project> getTotalProjects() {
		return this.totalProjects;
	}

	public String toString() {
		String problemStatus = new String();
		for (Student s : totalStudents) {
			problemStatus += s.getPref();
		}
		for (Project p : totalProjects) {
			problemStatus += p.getPref();
		}
		return problemStatus;
	}

	public static void main(String[] args) {

		Problem problem = new Problem(4, 3);

		Student s1 = new Student("S1", "s1@info.uaic.ro");
		Student s2 = new Student("S2", "s2@info.uaic.ro");
		Student s3 = new Student("S3", "s3@info.uaic.ro");
		Student s4 = new Student("S4", "s4@info.uaic.ro");

		Project p1 = new Project("P1", 2);
		Project p2 = new Project("P2", 1);
		Project p3 = new Project("P3", 1);

		s1.setPreferences(p1, p2, p3);
		s2.setPreferences(p1, p3, p2);
		s3.setPreferences(p1);
		s4.setPreferences(p3, p2, p1);

		p1.setPreferences(s3, s1, s2, s4);
		p2.setPreferences(s1, s2, s3, s4);
		p3.setPreferences(s4, s3, s1, s2);

		problem.setStudents(s1, s2, s3, s4);
		problem.setProjects(p1, p2, p3);

		System.out.println(problem);

		System.out.println();

		System.out.println("Gale Shapley Algorithm : ");

		GaleShapley g = new GaleShapley();
		System.out.println(g.GaleShapleyAlgorithm(problem));

	}

}
