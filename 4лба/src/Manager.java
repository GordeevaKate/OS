
import java.awt.Graphics;
import javax.swing.JPanel;

public class Manager extends JPanel {

	/**
	 * Create the panel.
	 */
	BlockMemory Memory;

	public Manager(BlockMemory memory) {
		Memory = memory;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Memory.Visualmemory(g, this.getWidth(), this.getHeight());
	}
}
