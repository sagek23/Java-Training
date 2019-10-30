import java.util.Scanner;

class IdConfirm {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);

		int d = 2;  
		int sum =0;  
		int temp = 0; 
		String answer = "";

		while (true) {
			sum = 0;  
			temp = 0; 
			d=2;     
			System.out.println("주민등록 번호를 입력하세요 !");
			System.out.print("ex)920112-1234567--> : ");
			String id = scan.nextLine();
			System.out.println(id);
			if (id.length() != 14) {  
				
				System.out.println("주민등록 번호를 잘못입력하셨습니다 다시 입력해주세요");
				System.out.print("ex)920112-1234567--> : ");
				id = scan.nextLine();

			}
			for (int i = 0; i < id.length() - 1; i++) {  

				if (d == 10) {
					d = 2;     
				}
				if (i == 6) { 
					continue;
				}
				temp = Integer.parseInt(id.charAt(i) + ""); 

				sum += d * temp; 

				d++;

			}

			int b = 11 - (sum % 11);   	
			int c = Integer.parseInt(id.charAt(13) + "");  

			if (c == b) {  
				System.out.println("정상적인 주민등록번호입니다");

			} else {  	
				System.out.println("잘못된 주민등록번호입니다");

			}

			while (true) { 

				System.out.print("다른 주민번호도 확인하시겠습니까? y/n : ");
				answer = scan.nextLine();

				while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) { 
																							
					System.out.print("잘못입력하셨습니다 y/n: ");
					answer = scan.nextLine();
				}
				if (answer.equals("y")) {
					break;
				}
				if (answer.equals("n")) {
					System.out.println("작업종료");
					return;
				}

			}

		}
	}
}
