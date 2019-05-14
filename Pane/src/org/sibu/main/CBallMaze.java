package org.sibu.main;
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.GroupLayout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.BooleanSupplier;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.xml.crypto.Data;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
public class CBallMaze extends JFrame implements ActionListener {

	private JButton jbAct;
	private JButton jbReset;
	private JButton jbRun;
	private JTextField txOption;
	private JTextField txSource;
	private JTextField txDirection;
	private JTextField txHour;
	private JTextField txMin;
	private JTextField txSec;
	private JTextField txscore;
	private JTextField pause;
	private JTextField txlife;
	private JButton left;
	private JButton up;
	private JButton jbdown;
	private JButton jbRight;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton option1;
	private JButton option2;
	private JButton option3;
	private JButton exit;
	private JButton direction;

	private AudioClip sound1;


	private JPanel panel1;
	private int x;
	private int y;
	private int tic =0;
	private int hour=0;
	private int min=0;
	private int score=0;
	private int slid=0;
	private int lifetime =3;
	Clip stop;

	private  JPanel panel2;
	private JPanel panel3;
	private JPanel Functionpan;
	private JPanel SliedPan;


	private JMenuBar menuBar;
	private JMenu Scenerio;
	private JMenu Edit;
	private JMenu Control;
	private JMenu Help;


	private GroupLayout grouplayout;

	private JMenuItem jmExit;
	private JMenuItem jmAbout;
	private JMenuItem jmClick;


	private Timer  timer;
	private BooleanSupplier running;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel Score;
	private JLabel life;
	private JLabel jLabelDigital;
	private JLabel jlabel[][];

	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon youlose;
	private JSlider slider1;

	private ImageIcon westImage;
	private ImageIcon eastImage;
	private ImageIcon northImage;
	private ImageIcon southImage;
	private ImageIcon iconsand;
	private ImageIcon icongoldenball;
	private ImageIcon iconWhite;
	private ImageIcon iconsandstone;
	private ImageIcon iconCongrats;
	private ImageIcon iconBom;
	public static void main(String[] args) {
		CBallMaze frame = new CBallMaze();

	}

	public CBallMaze() {
		setBounds(250,70,775, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Container window = getContentPane();
		window.setLayout(null);
		panel1=new  JPanel();
		panel1.setBounds(0, 0, 560, 540);
		panel1.setBackground(Color.white);
		jlabel =new JLabel[16][13];
		iconsand=new ImageIcon("images/sand.png");
		iconWhite=new ImageIcon("images/white35x35.jpg");
		icongoldenball=new ImageIcon("Images/goldenball.png");
		iconsandstone=new ImageIcon("Images/sandstone.jpg");


		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints gbc =new GridBagConstraints();
		panel1.setLayout(grid);
		for(int i=0;i<=15;i++) {
			for(int j=0;j<=12;j++) {


				if(j==0||j==3||j==6||j==9||j==12) {
					jlabel[i][j]=new JLabel(iconsand);
					gbc.gridx=i;
					gbc.gridy=j;
					panel1.add(jlabel[i][j],gbc);
				}else {
					jlabel[i][j]=new JLabel(iconWhite);
					gbc.gridx=i;
					gbc.gridy=j;
					panel1.add(jlabel[i][j],gbc);

				}
			}
			x=0;
			y=12;
			jlabel[x][y].setIcon(iconsandstone);
			
			

		}
		for(int j=1;j<=2;j++) {
			jlabel[3][j].setIcon(iconsand);
			jlabel[7][j].setIcon(iconsand);
			jlabel[11][j].setIcon(iconsand);
		}
		for(int j=4;j<=5;j++) {
			jlabel[4][j].setIcon(iconsand);
			jlabel[8][j].setIcon(iconsand);
			jlabel[12][j].setIcon(iconsand);

		}
		for(int j=7;j<=8;j++) {
			jlabel[3][j].setIcon(iconsand);
			jlabel[7][j].setIcon(iconsand);
			jlabel[14][j].setIcon(iconsand);
		}
		for(int j=10;j<=11;j++) {
			jlabel[4][j].setIcon(iconsand);
			jlabel[8][j].setIcon(iconsand);
		}
		x=15;
		y=0;
		jlabel[x][y].setIcon(icongoldenball);

		window.add(panel1);



		panel2= new JPanel();
		panel2.setBackground(Color.gray);
		panel2.setBounds(560, 0, 200, 540);
		label2=new JLabel("option");
		panel2.add(label2);
		label3=new JLabel("source");
		panel2.add(label3);
		label4=new JLabel("Direction");
		panel2.add(label4);
		txOption=new JTextField("1");
		panel2.add(txOption);
		txSource=new JTextField("15 , 0");
		panel2.add(txSource);
		life = new JLabel("Life");
		panel2.add(life);
		txlife = new JTextField("3");
		panel2.add(txlife);
		txDirection=new JTextField(4);
		//panel2.add(txDirection);
		jLabelDigital = new JLabel("    Digital Clock ");
		jLabelDigital.setFont(jLabelDigital.getFont().deriveFont(20f));
		txHour=new JTextField("00");
		panel2.add(txHour);
		label5=new JLabel(":");
		panel2.add(label5);
		txMin=new JTextField("00");
		panel2.add(txMin);
		label6=new JLabel (":");
		panel2.add(label6);
		txSec=new JTextField("00");
		panel2.add(txSec);
		
		ImageIcon leftImage= new ImageIcon("Images/left.png");
		left =new JButton(leftImage );
		left.setActionCommand("left");
		left.addActionListener(this);
		panel2.add(left);
		ImageIcon rightImage=new ImageIcon("Images/right.png");
		jbRight=new JButton(rightImage);
		jbRight.setActionCommand("right");
		jbRight.addActionListener(this);
		panel2.add(jbRight);
		ImageIcon UpImage=new ImageIcon("Images/up.png");
		up=new JButton(UpImage);
		up.setActionCommand("up");
		up.addActionListener(this);
		panel2.add(up);
		ImageIcon DownImages = new ImageIcon("Images/down.png");

		jbdown=new JButton(DownImages);
		jbdown.setActionCommand("down");
		jbdown.addActionListener(this);
		panel2.add(jbdown);

		button5= new JButton("");
		button5.setBackground(Color.GRAY);
		button5.setBorder(BorderFactory.createLoweredBevelBorder ());
		button5.add (new JToggleButton("     ",true));
		button6=new JButton("      ");
		button6.setBackground(Color.GRAY);
		button6.setBorder(BorderFactory.createLoweredBevelBorder ());
		button6.add (new JToggleButton("     ",true));
		button7=new JButton("      ");
		button7.setBackground(Color.GRAY);
		button7.setBorder(BorderFactory.createLoweredBevelBorder ());
		button7.add (new JToggleButton("     ",true));
		button8=new JButton("      ");
		button8.setBackground(Color.GRAY);
		button8.setBorder(BorderFactory.createLoweredBevelBorder ());
		button8.add (new JToggleButton("     ",true));
		button9=new JButton("       ");
		button9.setBackground(Color.GRAY);
		button9.setBorder(BorderFactory.createLoweredBevelBorder ());
		button9.add (new JToggleButton("    ",true));
		option1=new JButton("Option1");
		option1.setActionCommand("option1");
		option1.addActionListener(this);
		option2=new JButton("option2");
		option2.setActionCommand("option2");
		option2.addActionListener(this);
		option3=new JButton("option3");
		option3.setActionCommand("option3");
		option3.addActionListener(this);
		exit=new JButton("   exit   ");
		direction = new JButton();
		exit.setActionCommand("exit");
		exit.addActionListener(this);

		westImage=new ImageIcon("Images/west.jpg");
		eastImage=new ImageIcon("Images/east.jpg");
		northImage=new ImageIcon("Images/north.jpg");
		southImage = new ImageIcon("Images/south.jpg"); 
		direction.setIcon(westImage);
		grouplayout=new GroupLayout(panel2);
		panel2.setLayout(grouplayout);
		grouplayout.setAutoCreateGaps(true);
		grouplayout.setAutoCreateContainerGaps(true);


		grouplayout.setHorizontalGroup( grouplayout.createSequentialGroup().
				addGroup(grouplayout.createParallelGroup()
						.addGroup(grouplayout.createSequentialGroup()
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label2)
										.addComponent(label3)
										.addComponent(label4)
										.addComponent(life))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txOption)
										.addComponent(txSource)
										.addComponent(txDirection)
										.addComponent(txlife)
										)
								)
						//.addGap(30)
						.addGroup(grouplayout.createSequentialGroup()
								.addComponent(jLabelDigital)

								)

						.addGroup(grouplayout.createSequentialGroup()
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txHour)	
										)
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label5)	
										)
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txMin)	
										)
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label6)	
										)
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txSec)	
										)
								)
						.addGap(30)
						.addGroup(grouplayout.createSequentialGroup()

								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button5)		
										.addComponent(left)
										.addComponent(button6))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)		
										.addComponent(up)
										.addComponent(button7)
										.addComponent(jbdown))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)	
										.addComponent(button8)
										.addComponent(jbRight)
										.addComponent(button9)))





						.addGroup(grouplayout.createSequentialGroup()
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(option1)
										.addComponent(option3))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
										.addComponent(option2)
										.addComponent(exit)

										))

						.addGroup(grouplayout.createSequentialGroup()
								.addGap(40)
								.addComponent(direction)
								)));








		grouplayout.setVerticalGroup(grouplayout.createSequentialGroup().
				addGroup(grouplayout.createParallelGroup(Alignment.BASELINE).
						addComponent(label2).addComponent(txOption)).
				addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label3)
						.addComponent(txSource)).
				addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label4)
						.addComponent(txDirection))
				.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(life)
						.addComponent(txlife))
						
				.addGap(20)
				.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE).addComponent(jLabelDigital))
				.addGap(20)
				.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txHour)
						.addComponent(label5)
						.addComponent(txMin)
						.addComponent(label6)
						.addComponent(txSec)
						)
				.addGap(40)

				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button5)		
						.addComponent(up)
						.addComponent(button8))
				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)		
						.addComponent(left)
						.addComponent(button7)
						.addComponent(jbRight))
				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)	
						.addComponent(button6)
						.addComponent(jbdown)
						.addComponent(button9))
				.addGap(40)
				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(option1)
						.addComponent(option2))
				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(option3)
						.addComponent(exit))
				.addGap(30)
				.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addGap(30)
						.addComponent(direction))	


				);


		window.add(panel2);




		panel3=new JPanel();
		slider1=new JSlider(JSlider.HORIZONTAL, 1, 5, 2);
		slider1.setPaintTicks(true);
		slider1.setMajorTickSpacing(1);

		panel3.setBounds(0, 550, 750, 100);
		panel3.setBackground(Color.black);

		image1=new ImageIcon(("Images/step.png"));
		image2=new ImageIcon(("Images/run.png"));
		image3=new ImageIcon(("Images/reset.png"));
		image4= new ImageIcon(("Images/pause.png"));
		jbAct=new JButton("Act",image1);
		jbAct.addActionListener(this);

		jbRun=new JButton("Run",image2);
		jbRun.addActionListener(this);
		jbReset=new JButton("Reset",image3);
		jbReset.setActionCommand("Reset");
		jbReset.addActionListener(this);





		Functionpan=new JPanel();
		Score = new JLabel("Score");
		txscore=new JTextField(5);

		JPanel jpanelscore=new JPanel();
		jpanelscore.add(Score);
		jpanelscore.add(txscore);

		Functionpan.add(jbAct);
		Functionpan.add(jbRun);
		Functionpan.add(jbReset);


		SliedPan=new JPanel();
		label1=new JLabel("Speed");
		SliedPan.add(label1);

		SliedPan.add(slider1);
		panel3.setLayout(new BorderLayout());
		panel3.add(Functionpan,BorderLayout.CENTER);
		panel3.add(SliedPan,BorderLayout.LINE_END);
		panel3.add(jpanelscore,BorderLayout.LINE_START);


		window.add(panel3);


		setVisible(true);
		menuBar=new JMenuBar();

		Scenerio=new JMenu("Scenerio");

		Edit=new JMenu("Edit");
		Control=new JMenu("control");
		
		Help=new JMenu("Help");

		menuBar.add(Scenerio);
		menuBar.add(Edit);
		menuBar.add(Control);
		jmClick=new JMenuItem("Click");
		jmClick.addActionListener(this);
		Control.add(jmClick);
		menuBar.add(Help);

		jmExit=new JMenuItem("exit");
		jmExit.setActionCommand("exit");
		jmExit.addActionListener(this);

		Scenerio.add(jmExit);
		jmAbout= new JMenuItem("About");
		Help.add(jmAbout);
		jmAbout.addActionListener(this);

		setJMenuBar(menuBar);

		setVisible(true);

	}

	private TimerTask time;
	public  void drop() { 
		
		time=new TimerTask() {
			
			@Override
			public void run() {
				try {

					if (jlabel[x][y+1].getIcon().equals(iconsand)) {
						jlabel[x][y].setIcon(iconsand);
						y=y+1;

						jlabel[x][y].setIcon(icongoldenball);
						direction.setIcon(southImage);
						txDirection.setText("south");
						txSource.setText(x+ " ," + y);
						System.out.println(".");
						music();
					}

				}catch (Exception e) {

				}

			}
		};

	}

	public void Score() {

		score++;
		txscore.setText(score+ "");

	}
	
	public void Goal() {
		if(jlabel[x-1][y].getIcon().equals(iconsandstone)) {
			iconCongrats=new ImageIcon("Images/congrats.jpg");
			jlabel[7][7].setIcon(iconCongrats);


		}
	}
	public void pause() {
		jbRun.setActionCommand("Run");
		jbRun.setText("Run");
		timer.purge();
		timer.cancel();
		jbRun.setIcon(image2);

	}
	public void act() {
		/*jlabel[x-1][y].setIcon(icongoldenball);
		jlabel[x][y].setIcon(iconsand);
		x=x-1;
		direction.setIcon(westImage);
		txDirection.setText("west");
		txSource.setText(x+ " ," + y);
		drop();
		Score();*/
		try {
		if(jlabel[x][y+1].getIcon().equals(iconsand)) {
			movedown();
			
		}else {
			moveLeft();
		}
		
	}
		catch(Exception e) {
			moveLeft();
		}
	}
		
	public void placeBomb() {
			iconBom=new ImageIcon("Images/bom[1132].png");
			jlabel[10][0].setIcon(iconBom);
			jlabel[7][1].setIcon(iconBom);
			jlabel[5][3].setIcon(iconBom);
			jlabel[2][0].setIcon(iconBom);
			jlabel[13][6].setIcon(iconBom);
			jlabel[3][6].setIcon(iconBom);
			jlabel[6][9].setIcon(iconBom);
			jlabel[4][11].setIcon(iconBom);
			jlabel[10][12].setIcon(iconBom);
			Reset();
				
		}
	public void removeBomb() {
		jlabel[10][0].setIcon(iconsand);
		jlabel[7][1].setIcon(iconsand);
		jlabel[5][3].setIcon(iconsand);
		jlabel[2][0].setIcon(iconsand);
		jlabel[13][6].setIcon(iconsand);
		jlabel[3][6].setIcon(iconsand);
		jlabel[6][9].setIcon(iconsand);
		jlabel[4][11].setIcon(iconsand);
		jlabel[10][12].setIcon(iconsand);
		
	}
	



	private SequentialGroup addGap(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void moveLeft() {
		try {
		Goal();
		if(jlabel[x-1][y].getIcon().equals(iconsand)||jlabel[x-1][y].getIcon().equals(iconBom)) {
			//actionEvent is left and block left from goldenball is sand
			if(jlabel[x-1][y].getIcon().equals(iconBom)) {
				decresselife();
			}
			jlabel[x][y].setIcon(iconsand);

			x--;
			jlabel[x][y].setIcon(icongoldenball);
			direction.setIcon(westImage);
			txDirection.setText("west");
			txSource.setText(x+ " ," + y);

			Score();  
		}
		}catch (Exception e) {
			
		}
	}
	
	public void moveright() {
		try {
		if( jlabel[x+1][y].getIcon().equals(iconsand)|| jlabel[x+1][y].getIcon().equals(iconBom))
		{
			if( jlabel[x+1][y].getIcon().equals(iconBom)) {
				decresselife();
			}
		jlabel[x][y].setIcon(iconsand);
		x++;
		jlabel[x][y].setIcon(icongoldenball);
		direction.setIcon(eastImage);
		txDirection.setText("east");
		txSource.setText(x+ " ," + y);

		Score();
		}
			}catch (Exception e) {
			
		}
	}
	public void moveUp() {
		try {
		if( jlabel[x][y-1].getIcon().equals(iconsand)|| jlabel[x][y-1].getIcon().equals(iconBom)) {
			if(jlabel[x][y-1].getIcon().equals(iconBom)) {
				decresselife();
			}
			jlabel[x][y].setIcon(iconsand);
			y--;
			jlabel[x][y].setIcon(icongoldenball);
			direction.setIcon(northImage);
			txDirection.setText("north");
			txSource.setText(x+ " ," + y);

			Score();
		}
	}catch (Exception e){
		
		}
	}
	public void movedown() {
		try {
		if(jlabel[x][y+1].getIcon().equals(iconsand)|| jlabel[x][y+1].getIcon().equals(iconBom)) {
			if(jlabel[x][y+1].getIcon().equals(iconBom)) {
				decresselife();
			}
			jlabel[x][y].setIcon(iconsand);

			y++;
			jlabel[x][y].setIcon(icongoldenball);
			direction.setIcon(southImage);
			txDirection.setText("south");
			txSource.setText(x+ " ," + y);

			Score();
		}
		}catch (Exception e) {
			
		}
		
	}
	public void decresselife() {
		lifetime--;
		txlife.setText(""+lifetime);
		if(lifetime==0) {
			youlose= new ImageIcon("Images/lose.png");
			jlabel[7][7].setIcon(youlose);
		}
		
	}
	
	public void option2() {
		Timer timer=new Timer();
		drop();
		timer.schedule(time, 1000,1000);
		txOption.setText("2");
		
		
	}
	public void option3() {
		txOption.setText("3");
		placeBomb();
		
		
	}
	
	public void Reset() {
		jlabel[x][y].setIcon(iconsand);
		jlabel[7][7].setIcon(iconsand);
		jlabel[7][7].setIcon(iconsand);
		x=15;
		y=0;
		jlabel[x][y].setIcon(icongoldenball);
		jlabel[0][12].setIcon(iconsandstone);
		
	}
	public void Run() {
		timer=new Timer();
		int slid = slider1.getValue();
		timer.schedule(new Clock(),500+100*slid, 500+100*slid);
		
		System.out.println(slid);
		jbRun.setIcon(image4);
		jbRun.setText("pause");
		jbRun.setActionCommand("pause");
		
		
	}
		
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String aCommand=event.getActionCommand().toString();
		if(aCommand.equals("left")) {
			moveLeft();

		}else if (aCommand.equals("right")){
			// actionEvent is right and block right from goldenball is sand.
			moveright();
		}
		else if(aCommand.equals("up")) {
			moveUp();
			}


		else if(aCommand.equals("down")) {
			movedown();

		}
		else if( aCommand.equals("option1")) {
			txOption.setText("1");
			removeBomb();
		}
		else if (aCommand.equals("option2")) {
			option2();
			removeBomb();
		}
		else if(aCommand.equals("option3")) {
			option3();
		}
		else if(aCommand.equals("exit")) {
			System.exit(0);
		}
		else if(aCommand.equals("Act")) {
			act();
			}

		else if (aCommand.equals("Run")) {
			Run();

		}
		else if (aCommand.equals("pause")) {
			
			pause();
		}

		else if (aCommand.equals("Reset")) {
			Reset();
			
		}else if (aCommand.equals("About")) {
			JOptionPane.showMessageDialog(null, "Assignment 2:Application - BallMaze\nFilename: CBallMaze.java\n Tutor: Kumar Lamichane \nModule: "
					+ "CSY1020 PSP\nSubmission Date: 15 July 2018");
		}else if(aCommand.equals("Click")) {
			JOptionPane.showMessageDialog(null, "left key (<): press to move left of maze\nright key(>): press to move right of maze\n"
					+ "up key(^): press to move ball up\n down key(v   ): press to move down ");
		}

		
	}
	public void music() {
		Clip clip = null;
		try {
			
			AudioInputStream InputStream=AudioSystem.getAudioInputStream(new File("sound/balldrop.wav"));
			AudioFormat dig = InputStream.getFormat(); 
			
			DataLine.Info information = new DataLine.Info(Clip.class, dig);
			clip = (Clip) AudioSystem.getLine(information);
			clip.open(InputStream);
		}
		catch (Exception e) {
			System.out.println("....");
		}
		clip.start();
	}
	
	

	public void stopmusic() {
		
		
	}


	class Clock extends TimerTask{

		@Override
		public void run() {
			tic=Integer.parseInt(txSec.getText());
			min=Integer.parseInt(txMin.getText());
			hour=Integer.parseInt(txHour.getText());

			tic++;
			txSec.setText(tic+"");
			if(tic==59) {
				min++;
				txSec.setText(0+"");   
				txMin.setText(min+ "");
				if(min==59) {
					hour++;
					txMin.setText(0+"");
					txHour.setText(hour+ "");
					timer.cancel();
				}
				
			}
			try {
			if(jlabel[x][y+1].getIcon().equals(iconsand)) {
				movedown();
				
			}else {
				moveLeft();
			}
			
		}catch (Exception e) {
			moveLeft();
		}
		}
		
		
	}



}




