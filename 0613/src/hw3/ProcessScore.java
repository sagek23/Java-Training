package hw3;

import java.util.ArrayList;

class IllegalScore extends Exception
{
	public IllegalScore(String msg)
	{
		super(msg);
	}
}
public class ProcessScore 
{
	double sum=0;
	double avg=0;
	ArrayList<Double> s = new ArrayList<Double>();
	
	public ProcessScore(double sum, double avg, ArrayList<Double> s) {
		super();
		this.sum = sum;
		this.avg = avg;
		this.s = s;
	}
	
	public ProcessScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void getScore(Double score)
	{
		s.add(score);
	}
	
	public double Score()
	{
		for (int i=0;i<s.size();i++)
		{
			s.get(i);
			
			sum+=s.get(i);
		}
		System.out.println(sum);
		return sum;
	}
	public double Avg()
	{
		avg = sum/s.size();
		System.out.println(avg);
		return avg;
	}

}
