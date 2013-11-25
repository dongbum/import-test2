package com.entaz.bbm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame implements ActionListener {
	private ServerInfoManager server_info_manager = new ServerInfoManager();
	
	private TitledBorder border1 = new TitledBorder("서버 목록");
	private JMenuBar menuBar = new JMenuBar();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	
	private JButton closeBtn = new JButton();
	private JButton reserveBtn = new JButton();
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
		setJMenuBar(menuBar);
		setResizable(false);
		setBounds(0, 0, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		reserveBtn.setText("예약");
		reserveBtn.addActionListener(this);
		
		closeBtn.setText("닫기");
		closeBtn.addActionListener(this);
		
		
		panel1.setBorder(border1);
		
		server_info_manager.Initialize();
		
		GridLayout layout = new GridLayout();
		layout.setColumns(1);
		layout.setRows(server_info_manager.server_list.size());
		layout.setVgap(10);
		panel1.setLayout(layout);
		
		for (int i = 0; i < server_info_manager.server_list.size(); i++) {
			String server_ip = server_info_manager.server_list.get(i).server_ip;
			String server_port = "" + server_info_manager.server_list.get(i).server_port;
			String server_name = server_info_manager.server_list.get(i).server_name;
			
			JCheckBox check_box = new JCheckBox(server_ip + " : " + server_port + " - " + server_name);
			panel1.add(check_box);
		}
		
		this.add(panel1, "North");
		
		panel2.add(reserveBtn);
		panel2.add(closeBtn);
		
		this.add(panel2, "South");
		
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if (obj == closeBtn) {
			System.exit(0);
		} else if (obj == reserveBtn) {
			System.out.println("예약");
			JOptionPane.showConfirmDialog(this, "메시지 메시지", "창제목", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			// JOptionPane.showMessageDialog(this, "메시지 메시지", "창제목", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
