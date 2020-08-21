package hwjava15_서울_8반_천창민;

import java.util.List;

public interface EmpMgr {
	
	void add(Employee b);
	List<Employee> search();
	List<Employee> search(String name);
	boolean update(int empNo, String dept);
	boolean delete(int empNo);
	
}
