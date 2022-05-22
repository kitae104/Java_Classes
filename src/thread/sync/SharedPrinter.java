package thread.sync;

public class SharedPrinter
{
	synchronized void print(String text) {
		// Thread.yield();
		for(int i=0; i<text.length(); i++)
			System.out.print(text.charAt(i));
		System.out.println();
	}
}
