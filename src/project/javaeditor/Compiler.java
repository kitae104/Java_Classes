package project.javaeditor;

public class Compiler {
	public static void main(String[] args) {
		CmdRnd cmd = new CmdRnd();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("public class Test {");
		buffer.append("	public static void main(String[] args) {" );
		buffer.append(" System.out.println(\"hi Test2\");} }");	 	
		
		// 소스에 대한 컴파일 동작 수행 
		String command = cmd.inputSource(buffer.toString());
		System.out.println(command);
		// 
		String result = cmd.execCommand(command);
		
		System.out.println(result);
	}
}
