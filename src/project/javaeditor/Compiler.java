package project.javaeditor;

public class Compiler {
	public static void main(String[] args) {
		CmdRnd cmd = new CmdRnd();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("public class Test {");
		buffer.append("	public static void main(String[] args) {" );
		buffer.append("{ System.out.println(\"hi test\");} }");		
		
		String command = cmd.inputSource(buffer.toString());
		String result = cmd.execCommand(command);
		
		System.out.println(result);
	}
}
