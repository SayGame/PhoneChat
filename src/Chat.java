import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Chat extends JFrame {

	private Talk talk = new Talk();
	private Keyboard keyboard = new Keyboard(talk);

	public Chat() {
		setLayout(new GridLayout(2,1));
		add(talk, BorderLayout.CENTER);
		add(keyboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
