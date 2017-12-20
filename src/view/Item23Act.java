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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.DBConnection;
import model.Course;
import model.Department;
import model.SC;
import model.Student;
import toolkit.Table;
import toolkit.Utility;

public final class Item23Act extends JPanel implements  ActionListener{
	private JPanel upper,top;
    private JButton buttonQuery;
    private JLabel labelID,labelName,labelSex,labelBirth,labelProv,labelInto,labelDept,labelHeading,labelTo,labelTo1,labelTo2;
    private JComboBox comboBoxSex,comboBoxProv,comboBoxDept;
    private JTextField textIDMin, textIDMax, textName, textBirthMin, textBirthMax, textIntoMin, textIntoMax;
    private JTable table;
    private ResultSet resultSet=null;
	
    public Item23Act (){
        super();
        labelID=new JLabel("ѧ��");
        labelName=new JLabel("����");
        labelSex = new JLabel("�Ա�");
        labelBirth = new JLabel("��������");
        labelProv = new JLabel("����ʡ��");
        labelInto = new JLabel("��У���");
        labelDept = new JLabel("����ϵ������");
        labelTo = new JLabel("��");
        labelTo1 = new JLabel("��");
        labelTo2 = new JLabel("��");

        upper=new JPanel();
        buttonQuery= new JButton("��ѯ");
        comboBoxSex=new JComboBox(Utility.simpleUniqueQuery(Student.TABLE, Student.SEX));
        comboBoxProv=new JComboBox(Utility.simpleUniqueQuery(Student.TABLE,Student.PROV));
        comboBoxDept=new JComboBox(Utility.simpleUniqueQuery(Department.TABLE,Department.NAME));
        textIDMin=new JTextField(30);
        textIDMax=new JTextField(30);
        textName=new JTextField(30);
        textBirthMin=new JTextField(30);
        textBirthMax=new JTextField(30);
        textIntoMin=new JTextField(30);
        textIntoMax=new JTextField(30);
        this.upper.setLayout(createLayout());

        top=new JPanel();
        labelHeading=new JLabel("��������Ҫ��ѯ������");
        //labelHeading.setHorizontalAlignment(SwingConstants.LEFT);
        top.add(labelHeading);

        buttonQuery.addActionListener(this);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.top);
        this.add(this.upper);
        table=new JTable(1,3);//todo What should be presented when no result has been acquired.
        this.add(this.table);

        this.setVisible(true);
        this.setFont(new Font("����",Font.ITALIC,30));//TODo �������⻹�ڣ���һ����ʾ����û�о��С�
        /*
        * ���Խ��GUI�������������⡣
        * */
    }
    
    private LayoutManager createLayout(){
        GroupLayout layout=new GroupLayout(upper);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup1=layout.createParallelGroup().addComponent(labelName).addComponent(labelSex).addComponent(labelProv).addComponent(labelDept).addComponent(labelID).addComponent(labelBirth).addComponent(labelInto);
        GroupLayout.ParallelGroup hGroup2=layout.createParallelGroup().addComponent(textName).addComponent(comboBoxSex).addComponent(comboBoxProv).addComponent(comboBoxDept).addComponent(textIDMin).addComponent(textBirthMin).addComponent(textIntoMin);
        GroupLayout.ParallelGroup hGroup3=layout.createParallelGroup().addComponent(labelTo).addComponent(labelTo1).addComponent(labelTo2);
        GroupLayout.ParallelGroup hGroup4=layout.createParallelGroup().addComponent(textIDMax).addComponent(textBirthMax).addComponent(textIntoMax);
        GroupLayout.SequentialGroup hGroup=layout.createSequentialGroup().addGroup(hGroup1).addGroup(hGroup2).addGroup(hGroup3).addGroup(hGroup4).addComponent(buttonQuery);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.ParallelGroup vGroup1=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelID).addComponent(textIDMin).addComponent(labelTo).addComponent(textIDMax);
        GroupLayout.ParallelGroup vGroup2=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelName).addComponent(textName);
        GroupLayout.ParallelGroup vGroup3=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelSex).addComponent(comboBoxSex);
        GroupLayout.ParallelGroup vGroup4=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelBirth).addComponent(textBirthMin).addComponent(labelTo1).addComponent(textBirthMax);
        GroupLayout.ParallelGroup vGroup5=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelProv).addComponent(comboBoxProv);
        GroupLayout.ParallelGroup vGroup6=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelInto).addComponent(textIntoMin).addComponent(labelTo2).addComponent(textIntoMax);
        GroupLayout.ParallelGroup vGroup7=layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelDept).addComponent(comboBoxDept).addComponent(buttonQuery);
        GroupLayout.SequentialGroup vGroup=layout.createSequentialGroup().addGroup(vGroup1).addGroup(vGroup2).addGroup(vGroup3).addGroup(vGroup4).addGroup(vGroup5).addGroup(vGroup6).addGroup(vGroup7);
        layout.setVerticalGroup(vGroup);

        return layout;
    }
    
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String sqlString = "select * from " + Student.TABLE + " and " + Department.TABLE + " where " + Student.DEPT + " = " + Department.ID; //TODO
		System.out.print(sqlString);
		if(this.textIDMin.getText() != null) {
			float idMin = Float.parseFloat(textIDMin.getText());
			sqlString.concat(" and " + Student.ID + " >= " + idMin);
		}
		if(this.textIDMax.getText() != null) {
			float idMax = Float.parseFloat(textIDMax.getText());
			sqlString.concat(" and" + Student.ID + " <= " + idMax);
		}
		if(this.textName.getText() != null) {
			//WHERE TN LIKE ����%��
			sqlString.concat(" and " + Student.NAME + " like % " + textName.getText() + " %");
		}
		if(this.comboBoxSex.getSelectedItem() != null)
			sqlString.concat(" and " + Student.SEX + " = " + comboBoxSex.getSelectedItem());
		//TODO �����������ʽδ֪����δ����ȥ
		if(this.comboBoxProv.getSelectedItem() != null)
			sqlString.concat(" and " + Student.PROV + " = " + comboBoxProv.getSelectedItem());
		if(this.textIntoMin.getText() != null) {
			float intoMin = Float.parseFloat(textIntoMin.getText());
			sqlString.concat(" and " + Student.INTO + " >= " + intoMin);
		}
		if(this.textIntoMax.getText() != null) {
			float intoMax = Float.parseFloat(textIntoMax.getText());
			sqlString.concat(" and" + Student.INTO + " <= " + intoMax);
		}
		if(this.comboBoxDept.getSelectedItem() != null) {
			//TODO ������ȷ�ϲ�ͬ����Ƿ�Ҳ����������
			sqlString.concat(" and " + Department.NAME + " = " + comboBoxProv.getSelectedItem());
		}
		System.out.println(sqlString);
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlString);
            table = (new Table(resultSet)).jt;
            this.updateUI();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
