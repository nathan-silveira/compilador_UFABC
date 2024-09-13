package io.compiler.core.ast;

public class AttribCommand extends Command {
	private String expression;
	
	public AttribCommand() {
		super();
	}

	public AttribCommand(String expr, String id) {
		super();
		this.expression = expr;
	}

	public String getExpression() {
		return this.expression;
	}


	public void setExpression(String expr) {
		this.expression = expr;
	}
	
	@Override
	public String generateTargetJava() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append(expression + ";\n");
		return str.toString();
	}
	
	@Override
	public String generateTargetPython() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append(expression + "\n");
		return str.toString();
	}
}


