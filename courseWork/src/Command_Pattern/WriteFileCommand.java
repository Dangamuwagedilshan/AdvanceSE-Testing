package Command_Pattern;

public class WriteFileCommand implements command {
	
	private FileSystemReceiver fileSystem;
	public WriteFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.writeFile();
	}

}
