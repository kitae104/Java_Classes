package network.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx
{

	public static void main(String[] args)
	{
		try
		{
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소 : " + local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (int i = 0; i < iaArr.length; i++)
			{
				System.out.println("네이버 IP 주소 : " + iaArr[i].getHostAddress());
			}
		} catch (UnknownHostException e)
		{
			e.getStackTrace();
		}
		

	}

}
