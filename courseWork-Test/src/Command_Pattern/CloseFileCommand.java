package Command_Pattern;

public class CloseFileCommand implements command {
	
	private FileSystemReceiver fileSystem;
	
	public CloseFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.closeFile();
	}

}
