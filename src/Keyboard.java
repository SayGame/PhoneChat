import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Keyboard extends JPanel {

	private Talk talk;

	private YButton yButton[];
	private JButton shift = new JButton(new ImageIcon("shift1.jpg"));
	private JButton abc = new JButton(new ImageIcon("123.jpg"));
	private final JButton back = new JButton(new ImageIcon("back.jpg"));
	private final JButton enter = new JButton(new ImageIcon("enter.jpg"));
	private final JButton space = new JButton(new ImageIcon("space.jpg"));
	private final JButton comma = new JButton(new ImageIcon("comma.jpg"));
	private final JButton dot = new JButton(new ImageIcon("dot.jpg"));

	private JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	private JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	private JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	private JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

	public Keyboard(Talk t) {

		talk = t;

		setBackground(new Color(27, 27, 27));
		setLayout(new GridLayout(4, 1));

		yButton = new YButton[26];

		addActionListeners();
		setButtonSizes();
		setButtonsAndIcons();
		addButtons();
		addPanels();
	}

	public void setButtonSizes() {
		shift.setPreferredSize(new Dimension(85, 77));
		abc.setPreferredSize(new Dimension(85, 75));
		back.setPreferredSize(new Dimension(85, 77));
		comma.setPreferredSize(new Dimension(56, 77));
		dot.setPreferredSize(new Dimension(56, 77));
		enter.setPreferredSize(new Dimension(85, 77));
		space.setPreferredSize(new Dimension(342, 73));
	}

	public void setButtonsAndIcons() {

		for (int i = 0; i < yButton.length; i++) {
			yButton[i] = new YButton();
		}

		for (int i = 0; i < 3; i++) {
			yButton[0].icon[i] = new ImageIcon("q" + i + ".jpg");
			yButton[1].icon[i] = new ImageIcon("w" + i + ".jpg");
			yButton[2].icon[i] = new ImageIcon("e" + i + ".jpg");
			yButton[3].icon[i] = new ImageIcon("r" + i + ".jpg");
			yButton[4].icon[i] = new ImageIcon("t" + i + ".jpg");
			yButton[5].icon[i] = new ImageIcon("y" + i + ".jpg");
			yButton[6].icon[i] = new ImageIcon("u" + i + ".jpg");
			yButton[7].icon[i] = new ImageIcon("i" + i + ".jpg");
			yButton[8].icon[i] = new ImageIcon("o" + i + ".jpg");
			yButton[9].icon[i] = new ImageIcon("p" + i + ".jpg");
			yButton[10].icon[i] = new ImageIcon("a" + i + ".jpg");
			yButton[11].icon[i] = new ImageIcon("s" + i + ".jpg");
			yButton[12].icon[i] = new ImageIcon("d" + i + ".jpg");
			yButton[13].icon[i] = new ImageIcon("f" + i + ".jpg");
			yButton[14].icon[i] = new ImageIcon("g" + i + ".jpg");
			yButton[15].icon[i] = new ImageIcon("h" + i + ".jpg");
			yButton[16].icon[i] = new ImageIcon("j" + i + ".jpg");
			yButton[17].icon[i] = new ImageIcon("k" + i + ".jpg");
			yButton[18].icon[i] = new ImageIcon("l" + i + ".jpg");
			yButton[19].icon[i] = new ImageIcon("z" + i + ".jpg");
			yButton[20].icon[i] = new ImageIcon("x" + i + ".jpg");
			yButton[21].icon[i] = new ImageIcon("c" + i + ".jpg");
			yButton[22].icon[i] = new ImageIcon("v" + i + ".jpg");
			yButton[23].icon[i] = new ImageIcon("b" + i + ".jpg");
			yButton[24].icon[i] = new ImageIcon("n" + i + ".jpg");
			yButton[25].icon[i] = new ImageIcon("m" + i + ".jpg");
		}

		for (int i = 0; i < yButton.length; i++) {
			yButton[i].setIcon();
		}

	}

	public void addButtons() {
		panel1.setBackground(new Color(27, 27, 27));
		for (int i = 0; i < 10; i++) {
			panel1.add(yButton[i]);
		}

		panel2.setBackground(new Color(27, 27, 27));
		for (int i = 10; i < 19; i++) {
			panel2.add(yButton[i]);
		}

		panel3.setBackground(new Color(27, 27, 27));
		panel3.add(shift);
		for (int i = 19; i < 26; i++) {
			panel3.add(yButton[i]);
		}
		panel3.add(back);

		panel4.setBackground(new Color(27, 27, 27));
		panel4.add(abc);
		panel4.add(comma);
		panel4.add(space);
		panel4.add(dot);
		panel4.add(enter);
	}

	public void addPanels() {
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}

	public void addActionListeners() {
		shift.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (yButton[0].getType() == 1) {
					shift.setIcon(new ImageIcon("shift0.jpg"));
					for (int i = 0; i < yButton.length; i++) {
						yButton[i].setType(0);
					}
				} else if (yButton[0].getType() == 0) {
					shift.setIcon(new ImageIcon("shift1.jpg"));
					for (int i = 0; i < yButton.length; i++) {
						yButton[i].setType(1);
					}
				}
			}
		});

		abc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (yButton[0].getType() == 2) {
					shift.setIcon(new ImageIcon("shift0.jpg"));
					abc.setIcon(new ImageIcon("123.jpg"));
					for (int i = 0; i < yButton.length; i++) {
						yButton[i].setType(0);
					}
				} else {
					abc.setIcon(new ImageIcon("abc.jpg"));
					for (int i = 0; i < yButton.length; i++) {
						yButton[i].setType(2);
					}
				}

			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (talk.text.getText().length() > 0)
					talk.text.setText(talk.text.getText().substring(0,
							talk.text.getText().length() - 1));
			}
		});
		comma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				talk.text.setText(talk.text.getText() + ",");
			}
		});
		space.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				talk.text.setText(talk.text.getText() + " ");
			}
		});
		dot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				talk.text.setText(talk.text.getText() + ".");
			}
		});
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				talk.text.setText(talk.text.getText()
						+ "\n");				
			}

		});

	}

	class YButton extends JButton implements ActionListener {

		private ImageIcon icon[];
		private int type = 1;

		public YButton() {
			super();

			setPreferredSize(new Dimension(58, 83));
			icon = new ImageIcon[3];
			addActionListener(this);
			setIcon();
		}

		public void setIcon() {
			if (icon[type] != null)
				super.setIcon(icon[type]);
		}

		public void setType(int type) {
			this.type = type;
			setIcon();
		}

		public int getType() {
			return type;
		}

		public String punctuation() {

			String temp = "";

			switch (this.icon[2].toString().charAt(0)) {
			case 'q':
				temp = "1";
				break;
			case 'w':
				temp = "2";
				break;
			case 'e':
				temp = "3";
				break;
			case 'r':
				temp = "4";
				break;
			case 't':
				temp = "5";
				break;
			case 'y':
				temp = "6";
				break;
			case 'u':
				temp = "7";
				break;
			case 'i':
				temp = "8";
				break;
			case 'o':
				temp = "9";
				break;
			case 'p':
				temp = "0";
				break;
			case 'a':
				temp = "@";
				break;
			case 's':
				temp = "#";
				break;
			case 'd':
				temp = "$";
				break;
			case 'f':
				temp = "&";
				break;
			case 'g':
				temp = "*";
				break;
			case 'h':
				temp = "-";
				break;
			case 'j':
				temp = "+";
				break;
			case 'k':
				temp = "(";
				break;
			case 'l':
				temp = ")";
				break;
			case 'z':
				temp = "!";
				break;
			case 'x':
				temp = "\"";
				break;
			case 'c':
				temp = "'";
				break;
			case 'v':
				temp = ":";
				break;
			case 'b':
				temp = ";";
				break;
			case 'n':
				temp = "/";
				break;
			case 'm':
				temp = "?";
				break;

			default:
				break;
			}

			return temp;

		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (type == 0) {
				talk.text.setText(talk.text.getText()
						+ String.format("%s", icon[type].toString().charAt(0)));

			} else if (type == 1)
				talk.text.setText(talk.text.getText()
						+ String.format("%s", icon[type].toString()
								.toUpperCase().charAt(0)));
			else
				talk.text.setText(talk.text.getText() + punctuation());
		}

	}

}
