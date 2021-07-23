package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaiTap8 extends JFrame {
	DefaultTableModel dt;
	String data[][];
	public BaiTap8() {
		super("Quản Lý Sinh Viên");
		JPanel pn = new JPanel();
		setSize(600,600);
		pn.setLayout(new BoxLayout(pn,BoxLayout.Y_AXIS));
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(new BoxLayout(pn1,BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lbl1 = new JLabel("Chương Trình Quản Lý Sinh Viên");
		pnTitle.add(lbl1);
		
		JPanel pnMaSv = new JPanel();
		pnMaSv.setLayout(new FlowLayout());
		JLabel lblMsv = new JLabel("Mã Sinh Viên:");
		JTextField txtMsv = new JTextField(30);
		 txtMsv.setMaximumSize(new Dimension(400,30));
		pnMaSv.add(lblMsv);
		pnMaSv.add(txtMsv);
		
		JPanel pnTenSv = new JPanel();
		pnTenSv.setLayout(new FlowLayout());
		JLabel lblTsv = new JLabel("Tên Sinh Viên:");
		JTextField txtTsv = new JTextField(30);
		 txtTsv.setMaximumSize(new Dimension(400,30));
		pnTenSv.add(lblTsv);
		pnTenSv.add(txtTsv);
		 
		JPanel pnTuoi = new JPanel();
		pnTuoi.setLayout(new FlowLayout());
		JLabel lblTuoi = new JLabel("Tuổi:");
		JTextField txtTuoi = new JTextField(30);
		 txtTuoi.setMaximumSize(new Dimension(400,30));
		pnTuoi.add(lblTuoi);
		pnTuoi.add(txtTuoi);
		 
		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		JRadioButton rad1 = new JRadioButton("Nam");
		rad1.setActionCommand("Nam");
		JRadioButton rad2 = new JRadioButton("Nữ");
		rad2.setActionCommand("Nữ");
		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(rad1);
		pnGioiTinh.add(rad2);
		
		JPanel pnLop = new JPanel();
		pnLop.setLayout(new FlowLayout());
		JLabel lblLop = new JLabel("Lớp:");
		String arrClass[] = {"19IT1","19IT2","19IT3","19IT4","19IT5","19IT6"};
		JComboBox cbo = new JComboBox(arrClass);
		cbo.setMaximumSize(new Dimension(400,30));
		pnLop.add(lblLop);
		pnLop.add(cbo);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		JButton btnAdd = new JButton("Add");
		pnButton.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nextRowid = Integer.toString(dt.getRowCount());
				String Msv = txtMsv.getText().toString();
				String ten = txtTsv.getText().toString();
				String tuoi = txtTuoi.getText().toString();
				String gioitinh = "";
				if(rad1.isSelected() || rad2.isSelected()) {
				gioitinh = group.getSelection().getActionCommand().toString();
				}
				String lop = String.valueOf(cbo.getSelectedItem()).toString();
				if(Msv.equals("") || ten.equals("") || tuoi.equals("")) {
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin!");		
				}else {
					if(gioitinh.equals("") || lop.equals("")) {
						JOptionPane.showMessageDialog(null,"Vui lòng chọn giới tính!");
					}else {
						dt.addRow(new Object[] {nextRowid,Msv,ten,tuoi,gioitinh,lop});
					}
				}
				
			}
		});
		lblMsv.setPreferredSize(lblTsv.getPreferredSize());
		lblTuoi.setPreferredSize(lblTsv.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTsv.getPreferredSize());
		lblLop.setPreferredSize(lblGioiTinh.getPreferredSize());
		
		pn1.add(pnTitle);
		pn1.add(pnMaSv);
		pn1.add(pnTenSv);
		pn1.add(pnTuoi);
		pn1.add(pnGioiTinh);
		pn1.add(pnLop);
		pn1.add(pnButton);
		pn.add(pn1);
		JPanel pn2 = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border,"Danh sách");
		 pn2.setBorder(borderTitle);
		String header[] = {"STT","Mã SV","Tên SV","Tuổi SV","Giới Tính","Lớp"};
		dt = new DefaultTableModel(data,header);
		JTable tb = new JTable(dt);
		tb.setPreferredScrollableViewportSize(new Dimension(550,230));
        tb.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(tb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        js.setVisible(true);
		
        pn2.add(js);
		pn.add(pn2);
		
		add(pn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BaiTap8();
	}

}
