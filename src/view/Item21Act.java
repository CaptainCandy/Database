package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.omg.CORBA.PRIVATE_MEMBER;

import control.DBConnection;
import model.Course;
import model.Department;
import model.SC;
import model.Student;
import toolkit.Table;
import toolkit.Utility;

public final class Item21Act extends JPanel implements  ActionListener{
	private JPanel upper,top;
    private JButton buttonQuery;
    private JLabel labelID,labelName,labelLocation,labelHeading;
    private JComboBox comboBoxID,comboBoxName,comboBoxLocation;
    private JTable table;
    private ResultSet resultSet=null;
    
    public Item21Act (){
        super();
        labelID=new JLabel("绯诲埆浠ｇ爜");
        labelName=new JLabel("绯诲埆鍚嶇О");
        labelLocation = new JLabel("绯诲埆鍦板潃");

        upper=new JPanel();
        buttonQuery= new JButton("鏌ヨ");
        comboBoxID=new JComboBox(Utility.simpleUniqueQuery(Department.TABLE, Department.ID));
        comboBoxName=new JComboBox(Utility.simpleUniqueQuery(Department.TABLE,Department.NAME));
        comboBoxLocation=new JComboBox(Utility.simpleUniqueQuery(Department.TABLE,Department.LOCATION));
        this.upper.setLayout(createLayout());

        top=new JPanel();
        labelHeading=new JLabel("璇疯緭鍏ラ渶瑕佹煡璇㈢殑鏉′欢");
        //labelHeading.setHorizontalAlignment(SwingConstants.LEFT);
        top.add(labelHeading);

        buttonQuery.addActionListener(this);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.top);
        this.add(this.upper);
        table=new JTable(1,3);//todo What should be presented when no result has been acquired.
        

        this.setVisible(true);
        this.setFont(new Font("瀹嬩綋",Font.ITALIC,30));//TODo 涔辩爜闂杩樺湪锛涚涓�鎻愮ず鏂囧瓧娌℃湁灞呬腑銆�
        /*
        * 灏濊瘯瑙ｅ喅GUI鐨勪腑鏂囦贡鐮侀棶棰樸�
        * */
    }
	
    private LayoutManager createLayout(){
        GroupLayout layout=new GroupLayout(upper);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup1=layout.createParallelGroup().addComponent(labelID).addComponent(labelName).addComponent(labelLocation);
        GroupLayout.ParallelGroup hGroup2=layout.createParallelGroup().addComponent(comboBoxID).addComponent(comboBoxName).addComponent(comboBoxLocation);
        GroupLayout.SequentialGroup hGroup=layout.createSequentialGroup().addGroup(hGroup1).addGroup(hGroup2).addComponent(buttonQuery);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.ParallelGroup vGroup1=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelID).addComponent(comboBoxID);
        GroupLayout.ParallelGroup vGroup2=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelName).addComponent(comboBoxName);
        GroupLayout.ParallelGroup vGroup3=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelLocation).addComponent(comboBoxLocation).addComponent(buttonQuery);
        GroupLayout.SequentialGroup vGroup=layout.createSequentialGroup().addGroup(vGroup1).addGroup(vGroup2).addGroup(vGroup3);
        layout.setVerticalGroup(vGroup);

        return layout;
    }
    
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String sqlString = "select * from " + Department.TABLE + " where 1 = 1 ";
		System.out.println("dfs" + sqlString);
		if(comboBoxID.getSelectedItem().toString() != null)
			sqlString = sqlString + (" and " + Department.ID + "=" + comboBoxID.getSelectedItem().toString());
		if(comboBoxName.getSelectedItem().toString() != null)
			sqlString = sqlString + (" and " + Department.NAME + "= '" + comboBoxName.getSelectedItem().toString() + "'");
		if(comboBoxLocation.getSelectedItem().toString() != null)
			sqlString = sqlString + (" and " + Department.LOCATION + "= '" + comboBoxLocation.getSelectedItem().toString() + "'");
		System.out.println("222" + sqlString);
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlString);
            table = (new Table(resultSet)).jt;
	        this.add(this.table);
            this.updateUI();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
}
