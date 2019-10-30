/*
����1) ���� ��Ȱ�ӿ� ����ϴ� ������ǰ�߿� �ϳ��� 
�����Ͽ� �Ӽ��� ������ �м��ϰ� Ŭ������ �����մϴ�.
���ǵ� Ŭ������ ��ü�� �����Ͽ� ������ ���ϴ�.
(������ encapsulation, ������ �ߺ�����, this, this()��
��� �����Ͽ� �����մϴ�.)


����2) �����ϴٸ� ���� Ŭ������ 
		"method overloading"�� ������ ���ϴ�.
	(������ ������ǰ�� ���� �޼ҵ� �ߺ����ǰ� 
		�ش���� ������ ���ص� �˴ϴ�.)
*/
class TV
{
	private boolean power;
	private int channel;
	private String volume;
	public static int sound;
	public void setPower(boolean power)
	{
		this.power = power;
	}
	public void setChannel(int channel)
	{
		this.channel = channel;
	}
	public void setVolume(String volume)
	{
		this.volume = volume;
	}
	public boolean getPower()
	{
		return power;
	}
	public int getChannel()
	{
		return channel;
	}
	public String getVolume()
	{
		return volume;
	}
	public boolean isPower()
	{
		return power;
	}
	public void onOff()
	{
		if(power==true)
			power=false;
		else
			power=true;
	}
	public void on()
	{
		power = true;
	}
	public void off()
	{
		power = false;
	}
	public int sounds()
	{
		sound = 0;
		if(volume=="up")
			++sound;
		else if(volume=="down")
		{
			++sound;
			sound--;
		}
		return sound;
	}
	public int getSounds()
	{
		return sound;
	}
	public TV (boolean power,int channel, String volume)
	{
		this.power=power;
		this.channel=channel;
		this.volume=volume;
	}
	public TV ()
	{
		//this(true,23,"down");
	
	}
}
class  HW1
{
	public static void main(String[] args) 
	{
		TV t1 = new TV();
		t1.setPower(false);
		t1.setChannel(19);
		t1.setVolume("up");
		System.out.println("����: "+t1.getPower());
		t1.onOff();
		System.out.println("����: "+t1.getPower());
		System.out.println("ä��: "+t1.getChannel());
		t1.setVolume("up");
		System.out.println("����: "+t1.getVolume());
		System.out.println("����: "+t1.sounds());
		t1.setVolume("down");
		System.out.println("����: "+t1.getVolume());
		System.out.println("����: "+t1.sounds());

		
	}
}