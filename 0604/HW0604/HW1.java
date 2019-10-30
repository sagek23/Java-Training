/*
숙제1) 나의 생활속에 사용하는 가전제품중에 하나를 
선택하여 속성과 동작을 분석하고 클래스를 정의합니다.
정의된 클래스의 객체를 생성하여 실험해 봅니다.
(가급적 encapsulation, 생성자 중복정의, this, this()를
모두 적용하여 실험합니다.)


숙제2) 가능하다면 위의 클래스에 
		"method overloading"도 적용해 봅니다.
	(선택한 가전제품에 따라 메소드 중복정의가 
		해당되지 않으면 안해도 됩니다.)
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
		System.out.println("전원: "+t1.getPower());
		t1.onOff();
		System.out.println("전원: "+t1.getPower());
		System.out.println("채널: "+t1.getChannel());
		t1.setVolume("up");
		System.out.println("볼륨: "+t1.getVolume());
		System.out.println("볼륨: "+t1.sounds());
		t1.setVolume("down");
		System.out.println("볼륨: "+t1.getVolume());
		System.out.println("볼륨: "+t1.sounds());

		
	}
}
