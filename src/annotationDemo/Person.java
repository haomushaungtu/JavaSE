package annotationDemo;

@FirstAnnotation(height = 183)
public class Person {
	@FirstAnnotation(height = 162)
	private String police;

	private String personName;

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;

	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
