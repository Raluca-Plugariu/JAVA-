import java.util.*;

public class GaleShapley {

	public Student highestRanked(Project p, Student s1, Student s2) {
		if (p.getPreferences().indexOf(s1) < p.getPreferences().indexOf(s2)) {
			return s1;
		} else
			return s2;
	}

	public boolean isHigherRanked(Project p, Student s1, Student s2) {
		if (p.getPreferences().indexOf(s1) < p.getPreferences().indexOf(s2)) {
			return true;
		}
		return false;
	}

	private Student getLowestRanked(Project p) {
		Student lowestRanked = p.getAllocatedStudents().firstElement();
		for(Student s : p.getAllocatedStudents() ){
			if(p.getPreferences().indexOf(s) > p.getPreferences().indexOf(lowestRanked)){
				lowestRanked = s;
			}
		}
		return lowestRanked;
			
	}

	public boolean replaceHigherRanked(Student s, Project p,  Map<String, String> match) {

		if (p.getPreferences().contains(s)==true && isHigherRanked(p, s, getLowestRanked(p)) == true) {
			getLowestRanked(p).setHasProject(false);
			match.remove(getLowestRanked(p).toString());
			p.setAllocatedStudents(getLowestRanked(p), s);
			match.put(s.toString(), p.toString());
			s.setHasProject(true);
			return true;
		}
		return false;
	}

	public boolean isProjectFree(Project p) {
		if (p.getCapacity() > p.studentsAllocated) {
			return true;
		} else
			return false;
	}

	public void findmatch(Student s, Map<String, String> match) {
		for (Project p : s.getPreferences()) {
			if (isProjectFree(p) == true) {
				match.put(s.getName(), p.getName());
				s.setHasProject(true);
				p.allocatedStudents.addElement(s);
				p.studentsAllocated++;
				break;
				
			}
		}
		if (s.getHasProject() == false) {
			
			for (Project p : s.getPreferences()) {
				if(replaceHigherRanked(s, p, match) == true){
					
					break;
				}
			}
		}
	}

	public boolean allStudentsHaveProject(Vector<Student> students) {
		for (Student s : students) {
			if (s.getHasProject() == false) {
				return false;
			}
		}
		return true;
	}

	public Map<String, String> GaleShapleyAlgorithm(Problem problem) {
		Map<String, String> stableMatch = new HashMap<String, String>();

		 while (allStudentsHaveProject(problem.getTotalStudents()) == false) {
		for (int i = 0; i < problem.getTotalStudents().size(); i++) {
			if ((problem.getTotalStudents().elementAt(i).getHasProject()) == false) {
				findmatch(problem.getTotalStudents().elementAt(i), stableMatch);
			}
		}
		 }
		return stableMatch;
	}

}
