
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BlockMemory {
	public static ArrayList<Knot> memory;
	public static int n = 64;
	public BlockMemory() {
		memory = new ArrayList<Knot>();
		for (int i = 0; i < n; i++) {
			memory.add(i, new Knot(-1, i));
		}
	}
	public void Visualmemory(Graphics g, int width, int height) {
		int cellHeight = 30;
		int cellWidth = 30;
		int chsize = 0;
		int left = 0;
		int top = 0;
		for (int i = 0; i < n; i++) {
			left = chsize * cellWidth;
			chsize++;

			Color[] colors = { new Color(128, 128, 128), new Color(0, 0, 255), new Color(255, 0, 0) };
			if (memory.get(i).getId() == -1) {
				g.setColor(Color.GRAY);
			} else {
				g.setColor(Color.BLUE);
			}
			if (memory.get(i).getSelectFlag()) {
				g.setColor(Color.RED);
			}
			g.fillRect(left, top, cellWidth, cellHeight);
			g.setColor(Color.WHITE);
			g.drawRect(left, top, cellWidth, cellHeight);
			g.drawString(memory.get(i).getId() + "", left + 5, top + 20);
			if (chsize == 16) {
				top += cellHeight;
				chsize = 0;
				left = 0;
			}
		}
	}
}
