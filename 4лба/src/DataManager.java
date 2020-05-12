
import java.util.ArrayList;

public class DataManager {
	public ArrayList<File> Files = new ArrayList<File>();
	private boolean startindex;
	private int chsize = 0;
	int fileId = -1;
	private int freememory = BlockMemory.n;
	private ArrayList<Knot> knots = new ArrayList<Knot>();;

	public void CreateFile(int size) {
		startindex = true;
		chsize = 0;
		fileId = Files.size();
		if (size > freememory) {
			Main.textAreaWindow.append("Невозможно добавить файл! \n");
			startindex = false;
			return;
		}

		File file = new File(fileId, size);
		for (int i = 0; i <= BlockMemory.n; i++) {
			if (size > chsize) {
				if (BlockMemory.memory.get(i).getId() != -1) {
					while (BlockMemory.memory.get(i).getId() != -1) {
						i++;
					}
				}
				int fileid = file.getId();
				addKnot(BlockMemory.memory.get(i), fileid);
				freememory--;
				chsize++;
			}
			if (size == chsize) {
				Files.add(fileId, file);
				Main.textAreaWindow.append("Добавлен файл №" + fileId + "\n");
				Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");
				return;
			}
		}
	}

	public void DeleteFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
		} else {
			freememory = freememory + Files.get(id).fileSize();
			removeKnots(id);
			Main.textAreaWindow.append("Удалён файл" + Main.textFieldId.getText() + "\n");
		}
		Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");

	}

	public void ChoiceFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
		} else {
			for (Knot knot : knots) {
				knot.setSelectFlag(true);
			}
		}
	}

	public void cancelChoiceFile() {
		for (File file : Files) {
			for (Knot knot : knots) {
				knot.setSelectFlag(false);
			}
		}
	}

	public void addKnot(Knot knot, int fileid) {
		knots.add(knot);
		knot.setFile(fileid);
	}

	public void removeKnots(int fileid) {
		for (Knot knot : knots) {
			if (knot.getId() == fileid) {
				knot.setFile(-1);
			}
		}
		knots.clear();
	}
}
