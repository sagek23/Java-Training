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
			System.out.println("�ֹε�� ��ȣ�� �Է��ϼ��� !");
			System.out.print("ex)920112-1234567--> : ");
			String id = scan.nextLine();
			System.out.println(id);
			if (id.length() != 14) {  
				
				System.out.println("�ֹε�� ��ȣ�� �߸��Է��ϼ̽��ϴ� �ٽ� �Է����ּ���");
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
				System.out.println("�������� �ֹε�Ϲ�ȣ�Դϴ�");

			} else {  	
				System.out.println("�߸��� �ֹε�Ϲ�ȣ�Դϴ�");

			}

			while (true) { 

				System.out.print("�ٸ� �ֹι�ȣ�� Ȯ���Ͻðڽ��ϱ�? y/n : ");
				answer = scan.nextLine();

				while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) { 
																							
					System.out.print("�߸��Է��ϼ̽��ϴ� y/n: ");
					answer = scan.nextLine();
				}
				if (answer.equals("y")) {
					break;
				}
				if (answer.equals("n")) {
					System.out.println("�۾�����");
					return;
				}

			}

		}
	}
}
