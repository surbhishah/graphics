package graphics;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LinesUI {

	private JFrame frame;
	private JTextField point1x;
	private JTextField point1y;
	private JTextField point2x;
	private JTextField point2y;
	private JLabel lblColor;
	private JLabel lblThickness;
	private JTextField textThickness;
	private JComboBox comboLineType;
	private JComboBox comboColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LinesUI window = new LinesUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LinesUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPoint1 = new JPanel();
		panelPoint1.setBounds(27, 39, 314, 57);
		frame.getContentPane().add(panelPoint1);
		
		JLabel lblPoint = new JLabel("Point1");
		panelPoint1.add(lblPoint);
		
		point1x = new JTextField();
		panelPoint1.add(point1x);
		point1x.setColumns(10);
		
		point1y = new JTextField();
		panelPoint1.add(point1y);
		point1y.setColumns(10);
		
		JPanel panelpoint2 = new JPanel();
		panelpoint2.setBounds(27, 117, 314, 57);
		frame.getContentPane().add(panelpoint2);
		
		JLabel lblPoint_1 = new JLabel("Point2");
		panelpoint2.add(lblPoint_1);
		
		point2x = new JTextField();
		point2x.setColumns(10);
		panelpoint2.add(point2x);
		
		point2y = new JTextField();
		point2y.setColumns(10);
		panelpoint2.add(point2y);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(51, 186, 70, 15);
		frame.getContentPane().add(lblColor);
		
		String[] colors = {"Blue","Red","Green","Black"}; 
		comboColor = new JComboBox(colors);
		comboColor.setBounds(163, 186, 112, 31);
		frame.getContentPane().add(comboColor);
		//comboColor.addItem(Color.BLACK);
		
		lblThickness = new JLabel("Thickness");
		lblThickness.setBounds(51, 255, 70, 15);
		frame.getContentPane().add(lblThickness);
		
		textThickness = new JTextField();
		textThickness.setBounds(161, 251, 114, 31);
		frame.getContentPane().add(textThickness);
		textThickness.setColumns(10);
		
		JLabel lblLineType = new JLabel("Line Type");
		lblLineType.setBounds(27, 335, 100, 15);
		frame.getContentPane().add(lblLineType);
		
		String[] lineTypes = {"Solid","Dotted","Dashed","Dashed-Dotted"};
		comboLineType = new JComboBox(lineTypes);
		comboLineType.setBounds(161, 327, 126, 31);
		frame.getContentPane().add(comboLineType);
		
		JLabel lblCapType = new JLabel("Cap Type");
		lblCapType.setBounds(35, 405, 86, 15);
		frame.getContentPane().add(lblCapType);
		String[] capTypes = {"NoCap","ButtCap","RoundCap","SquareCap"};
		JComboBox comboCapType = new JComboBox(capTypes);
		comboCapType.setBounds(161, 397, 126, 31);
		frame.getContentPane().add(comboCapType);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setBounds(134, 508, 100, 27);
		frame.getContentPane().add(btnDraw);
		ActionListener btnListener = new ButtonListener();
		btnDraw.addActionListener(btnListener);
	}
}
