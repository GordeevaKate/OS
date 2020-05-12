public class File {
	private int fileSize;
	private int fileId;

	public File(int fileId, int fileSize) {
		this.fileId = fileId;
		this.fileSize = fileSize;
	}

	public int getId() {
		return fileId;
	}

	public int fileSize() {
		return fileSize;
	}
}
