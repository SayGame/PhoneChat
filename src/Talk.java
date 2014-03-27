import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class Talk extends JPanel {

	private JLabel message = new JLabel("Text:");
	public JTextArea text;
	private JButton send = new JButton(new ImageIcon("send.jpg"));
	private JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel panelCenter = new JPanel(new GridLayout(50, 1));
	private JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));

	private int index = 2;
	
	public Talk() {

		setLayout(new BorderLayout());
		text = new JTextArea(1, 13);
		text.setEditable(false);
		text.setFont(new Font("", Font.PLAIN, 40));
		text.setLineWrap(true);
		send.setPreferredSize(new Dimension(124, 77));
		message.setFont(new Font("",Font.BOLD,30));
		message.setForeground(Color.BLUE);
		
		panelNorth.setBackground(Color.LIGHT_GRAY);
		JLabel name = new JLabel("Yunus");
		name.setFont(new Font("",Font.ITALIC + Font.BOLD,20));
		panelNorth.add(name);
		
		panelSouth.setBackground(new Color(221, 221, 221));
		panelSouth.add(message);
		panelSouth.add(text, BorderLayout.CENTER);
		panelSouth.add(send, BorderLayout.EAST);
		panelSouth.add(new JLabel(), BorderLayout.WEST);
		panelSouth.add(new JLabel(), BorderLayout.NORTH);
		panelSouth.add(new JLabel(), BorderLayout.SOUTH);

		JScrollPane pane = new JScrollPane(panelCenter);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(panelNorth, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message();
				text.setText("");
			}
		});

	}

	public void message() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		panelCenter.setLayout(new GridLayout(index += 2, 1));
		
		JTextArea t = new JTextArea(" " + text.getText() + " ");
		t.setFont(new Font("", Font.PLAIN, 20));
		t.setBackground(Color.GREEN);
		t.setEditable(false);
		
		p.add(t);
		panelCenter.add(p);
		revalidate();
		randomMessage(text.getText());
	}

	public void randomMessage(String s) {

		String answer = "";

		try {
			Scanner scan = new Scanner(new File("talk.txt"));

			while (scan.hasNext()) {

				if (scan.nextLine().contains(s.toLowerCase())) {
					answer = scan.nextLine();
					break;
				}
				scan.nextLine();
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JTextArea t;

		if (answer == "" || s == "") {
			for (int i = 0; i < (int) (1 + Math.random() * 5); i++) {

				String word = "";

				for (int j = 0; j < (int) (3 + Math.random() * 7); j++)
					word += (char) ('a' + Math.random() * ('z' - 'a' + 1));
				answer += word + " ";
			}
		}

		t = new JTextArea(" " + answer + " ");

		t.setFont(new Font("", Font.PLAIN, 20));
		t.setBackground(new Color(200, 200, 200));
		t.setEditable(false);

		p.add(t);
		panelCenter.add(p);
		revalidate();
	}

}