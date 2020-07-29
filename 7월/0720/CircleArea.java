

public class CircleArea {

	public static void main(String[] args) {
		int radius = 5;
		
		float area = 0;
		
		area = (float) (Math.pow(radius, 2)* Math.PI);
		
		for(int i = 0 ; i< radius; i++) {
			System.out.println("반지름이 " + radius +"Cm인 원의 넓이는 " +area + "Cm2입니다.");
		}
	}
}
