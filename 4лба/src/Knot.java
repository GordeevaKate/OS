public class Knot {
	private int knotId;
	private int fileId;
	private boolean selectFlag;
	private Knot knot;
	public Knot(int fileId, int knotId) {
		this.fileId = fileId;
		this.knotId = knotId;
	}

	public void setFile(int fileId) {
		this.fileId = fileId;
	}

	public void setKnot(int fileId, int knotId) {
		knot = new Knot(fileId, knotId);
	}

	public Knot nextNode() {
		return knot;
	}

	public int getKnotId() {
		return knotId;
	}

	public boolean getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(boolean selectFlag) {
		this.selectFlag = selectFlag;
	}

	public int getId() {
		return fileId;
	}
}
