package Command_Pattern;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		// TODO Auto-generated method stub
		System.out.println("Openning file in windows system");
	}
	@Override
	public void writeFile() {
		// TODO Auto-generated method stub
		System.out.println("Writing file in windows system");
	}
	@Override
	public void closeFile() {
		// TODO Auto-generated method stub
		System.out.println("CLosing file in windows system");
	}
	
	

}
