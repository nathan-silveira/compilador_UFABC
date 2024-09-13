package io.compiler.core.ast;

import java.util.List;

public class WhileCommand extends Command {
	private String expression;
	private List<Command> commandList;
	
	
	public WhileCommand() {
		super();
	}


	public WhileCommand(String expression, List<Command> commandList) {
		super();
		this.expression = expression;
		this.commandList = commandList;
	}


	public List<Command> getCommandList() {
		return this.commandList;
	}


	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}


	public String getExpression() {
		return this.expression;
	}



	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public String generateTargetJava() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while ("+expression+") {\n");
		for (Command cmd: commandList) {
			str.append(cmd.generateTargetJava()) ;
		}
		str.append("}");
		return str.toString();
	}
	
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
