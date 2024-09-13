package io.compiler.core.ast;

import java.util.List;

public class DoWhileCommand extends Command {
	private String expression;
	private List<Command> commandList;
	
	public DoWhileCommand(String expression, List<Command> commandList) {
		super();
		this.expression = expression;
		this.commandList = commandList;
	}

	public DoWhileCommand() {
		super();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}
	
	@Override
	public String generateTargetJava() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("do {\n");
		for (Command cmd: commandList) {
			str.append(cmd.generateTargetJava()) ;
		}
		str.append("}");
		str.append("while ("+expression+");");
		return str.toString();
	}
	
	@Override
	public String generateTargetPython() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while "+expression+":\n");
		for (Command cmd: commandList) {
			str.append(cmd.generateTargetPython()) ;
		}
		return str.toString();
	}
	
	
}
