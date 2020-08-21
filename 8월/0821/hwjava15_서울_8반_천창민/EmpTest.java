package hwjava15_서울_8반_천창민;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class EmpTest {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		EmpMgrImpl dao = EmpMgrImpl.getInstance();

		while(flag) {
			System.out.println("<<<<<<사원 관리>>>>>>");
			System.out.println("1.입력 2.전체 목록 3.직원 검색(직원명)"); 
			System.out.println("4.부서 변경 5.직원 삭제 6.종료");
			System.out.print("==>번호 : ");
			int no = Integer.parseInt(in.readLine());
			System.out.println();
			
			switch(no) {
			case 1: {
				System.out.print("사번 : "); int empNo = Integer.parseInt(in.readLine());
				System.out.print("직원명 : "); String name = in.readLine();
				System.out.print("직위 : "); String position = in.readLine();
				System.out.print("부서 : "); String dept = in.readLine();
				
				Employee emp = new Employee(empNo, name, position, dept);
				dao.add(emp);
				} break;
			case 2: {
				printAllEmployees(dao.search());
				} break;
			case 3: {
				System.out.print("직원명 : "); String name = in.readLine();
				printAllEmployees(dao.search(name));
				} break;
			case 4: {
				System.out.print("사번 : "); int empNo = Integer.parseInt(in.readLine());
				System.out.print("부서 : "); String dept = in.readLine();
				
				if(dao.update(empNo, dept))
					System.out.println("##정상적으로 부서를 변경하였습니다.");
				else
					System.err.println("##부서를 변경하지 못했습니다.");
				} break;
			case 5: {
				System.out.print("사번 : "); int empNo = Integer.parseInt(in.readLine());
				if(dao.delete(empNo))
					System.out.println("##정상적으로 해당 직원을 삭제하였습니다.");
				else
					System.err.println("##해당 직원을 삭제하지 못했습니다. 다시 한번 확인하기 바랍니다.");
				} break;
			case 6: 
				flag = false;
			}
		}
	}

	private static void printAllEmployees(List<Employee> list) {
		System.out.println("▣직원 목록▣");
		for(Employee e : list) {
			System.out.println(e);
		}
	}

}
