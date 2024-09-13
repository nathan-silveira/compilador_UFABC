package io.compiler.core.ast;

public class WriteCommand extends Command {
	private String content;

	@Override
	public String generateTargetJava() {
		// TODO Auto-generated method stub
		return "System.out.println("+content+");\n";
	}
	
	@Override
	public String generateTargetPython() {
		// TODO Auto-generated method stub
		return "print("+content+")\n";
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public WriteCommand(String content) {
		super();
		this.content = content;
	}

	public WriteCommand() {
		super();
	}

	
}
