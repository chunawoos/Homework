package hwjava15_서울_8반_천창민;

public class Employee {
	private int empNo;
	private String name;
	private String position;
	private String dept;
	
	public Employee() { }

	public Employee(int empNo, String name, String position, String dept) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.position = position;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("사원 번호(empNo) = ");
		builder.append(empNo);
		builder.append(", 이름(name) = ");
		builder.append(name);
		builder.append(", 직위(position) = ");
		builder.append(position);
		builder.append(", 부서(dept) = ");
		builder.append(dept);
		return builder.toString();
	}
	
	
}
