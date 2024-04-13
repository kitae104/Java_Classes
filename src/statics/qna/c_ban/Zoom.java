package statics.qna.c_ban;

public class Zoom
{
	private int num;		// 접속 사람수 
	private String name;	// Java-C
	private boolean mic;	// 마이크 사용 여부 
	public static int cnt = 0;
	int ab;
	public Zoom(int roomNumer, String name, boolean mic)
	{
		//super();
		this.num = roomNumer;
		this.name = name;
		this.mic = mic;
		cnt++;
	}

	public Zoom()
	{
		super();
		cnt++;
	}

	public int getCnt()
	{
		return cnt;
	}

	public void setCnt(int cnt)
	{
		ab = 10;
		this.cnt = cnt + ab;
	}

	public int getNum()
	{
		return num + ab;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isMic()
	{
		return mic;
	}

	public void setMic(boolean mic)
	{
		this.mic = mic;
	}
	
	
	
}
