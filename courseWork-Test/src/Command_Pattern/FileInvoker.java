package Command_Pattern;

public class FileInvoker {
	
	public Command_Pattern.command command;
	
	public FileInvoker(Command_Pattern.command c){
		this.command=c;
	}
	
	public void execute(){
		this.command.execute();
	}
		
}
