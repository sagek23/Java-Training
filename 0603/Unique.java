class  Unique
{
	public static void main(String[] args) 
	{
		String [] menu = {"�ʹ�", "�ʹ�", "���", "��ġ�", "������ġ", "���", "�ʹ�"};
		String menu2[] = new String[menu.length];
		menu2[0] = menu[0];
		int n = 1;
		for (int i=1;i<menu.length ;i++ )
		{	
			int j =0;
			for (j=0;j<i ;j++ )//i��° �׸��� menu2�� �̹� �ִ��� �˻�
			{
				if (menu[i].equals(menu2[j]))
					break;
			}
			if(i==j)
			{	
				menu2[n++] = menu[i];			
			}

		}
			for (int i=0;i<n ; i++)
		{
			System.out.println(menu2[i]);
		}
				


		
	}
}
