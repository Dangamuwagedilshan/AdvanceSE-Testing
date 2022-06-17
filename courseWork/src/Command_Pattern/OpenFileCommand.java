package Command_Pattern;

public class OpenFileCommand implements command {

	private FileSystemReceiver fileSystem;
	
	public OpenFileCommand(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.openFile();
	}

}
