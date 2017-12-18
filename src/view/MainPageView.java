package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import control.MainControl;
import toolkit.Utility;

/**
 * Singleton. Hence we can get access to the instance with the name of the class.
 * on 2017/11/19.
 */

public class MainPageView extends JFrame implements ActionListener{
    private static final MainPageView ourInstance = new MainPageView();

    public static MainPageView getInstance() {
        MainControl.addViewToViewscollector(ourInstance);
        return ourInstance;
    }

    JMenuBar mainBar = new JMenuBar();
	JMenu menu1;
	JMenu menu2;
	JMenu menu3;
	JMenu menu31;
	JMenu menu32;
	JMenu menu33;
	JMenu menu34;
	
	JMenuItem item11;
	JMenuItem item12;
	JMenuItem item13;
	JMenuItem item14;
	JMenuItem item15;
	JMenuItem item16;
	JMenuItem item21;
	JMenuItem item22;
	JMenuItem item23;
	JMenuItem item24;
	JMenuItem item25;
	JMenuItem item26;
	JMenuItem item311;
	JMenuItem item312;
	JMenuItem item321;
	JMenuItem item322;
	JMenuItem item323;
	JMenuItem item331;
	JMenuItem item341;
	JMenuItem item342;
	JMenuItem item343;
	JMenuItem item344;
	JMenuItem item345;
	JMenuItem item346;
	JMenuItem item347;
	
	JPanel jp1 = new JPanel();
    
	//�����Ӧ�¼�ʵ��
	view.Item11Act item11Act = new view.Item11Act();
	view.Item12Act item12Act = new view.Item12Act();
	view.Item13Act item13Act = new view.Item13Act();
	/*view.Item14Act item14Act = new view.Item14Act();
	view.Item15Act item15Act = new view.Item15Act();
	view.Item16Act item16Act = new view.Item16Act();
	view.Item21Act item21Act = new view.Item21Act();
	view.Item22Act item22Act = new view.Item22Act();
	view.Item23Act item23Act = new view.Item23Act();
	view.Item24Act item24Act = new view.Item24Act();
	view.Item25Act item25Act = new view.Item25Act();
	view.Item26Act item26Act = new view.Item26Act();
	
	view.Item311Act item311Act = new view.Item311Act();
	view.Item312Act item312Act = new view.Item312Act();
	view.Item321Act item321Act = new view.Item321Act();
	view.Item322Act item322Act = new view.Item322Act();
	view.Item323Act item323Act = new view.Item323Act();
	view.Item331Act item331Act = new view.Item331Act();
	view.Item341Act item341Act = new view.Item341Act();
	view.Item342Act item342Act = new view.Item342Act();
	view.Item343Act item343Act = new view.Item343Act();
	view.Item344Act item344Act = new view.Item344Act();
	view.Item345Act item345Act = new view.Item345Act();
	view.Item346Act item346Act = new view.Item346Act();
	view.Item347Act item347Act = new view.Item347Act();*/
	
    private MainPageView() {
        super();
        createMenu();
    }
    
	public void createMenu(){

        setUIFont();
		
        //initialize every item
		menu1 = new JMenu("����ά��");
		menu2 = new JMenu("ģ����ѯ");
		menu3 = new JMenu("ͳ�Ʋ�ѯ");
		menu31 = new JMenu("��ʦ��Ϣ");
		menu32 = new JMenu("�γ����");
		menu33 = new JMenu("ѧ��������Ϣ");
		menu34 = new JMenu("ѧ���ɼ���Ϣ");
		
		item11 = new JMenuItem("ѧ����Ϣ");
		item12 = new JMenuItem("��ʦ��Ϣ");
		item13 = new JMenuItem("ϵ����Ϣ");
		item14 = new JMenuItem("�γ���Ϣ");
		item15 = new JMenuItem("ѧ��ѡ�����");
		item16 = new JMenuItem("��ʦ�ڿ����");
		item21 = new JMenuItem("ѧ����Ϣ");
		item22 = new JMenuItem("��ʦ��Ϣ");
		item23 = new JMenuItem("ϵ����Ϣ");
		item24 = new JMenuItem("�γ���Ϣ");
		item25 = new JMenuItem("ѧ��ѡ�����");
		item26 = new JMenuItem("��ʦ�ڿ����");
		
		item311 = new JMenuItem("���̵ȼ�");
		item312 = new JMenuItem("ȫ�Ž�ʦ���γ�");
		item321 = new JMenuItem("ѡ������");
		item322 = new JMenuItem("�γ̳ɼ�");
		item323 = new JMenuItem("�γ̷ֵ�����");
		item331 = new JMenuItem("��Դ�����");
		item341 = new JMenuItem("�γ�ǰ������");
		item342 = new JMenuItem("�ܳɼ�����");
		item343 = new JMenuItem("ȫ��ѧ������");
		item344 = new JMenuItem("������ѧ��");
		item345 = new JMenuItem("������γ�");
		item346 = new JMenuItem("ѡ�ΰ�����ѯ");
		item347 = new JMenuItem("��ţѧ����ѯ");
        
		//�Ѳ˵���ӽ��˵���
		mainBar.add(menu1);
		mainBar.add(menu2);
		mainBar.add(menu3);
		mainBar.setAutoscrolls(true);
		mainBar.setSize( 1280, 30);
		
		//�Ѳ˵�������˵�
		menu1.add(item11);
		menu1.add(item12);
		menu1.add(item13);
		menu1.add(item14);
		menu1.add(item15);
		menu1.add(item16);
		menu2.add(item21);
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		menu2.add(item25);
		menu2.add(item26);
		
		//����Ӳ˵�
		menu3.add(menu31);
		menu3.add(menu32);
		menu3.add(menu33);
		menu3.add(menu34);
		
		//�Ѳ˵�����ӽ��Ӳ˵�
		menu31.add(item311);
		menu31.add(item312);
		menu32.add(item321);
		menu32.add(item322);
		menu32.add(item323);
		menu33.add(item331);
		menu34.add(item341);
		menu34.add(item342);
		menu34.add(item343);
		menu34.add(item344);
		menu34.add(item345);
		menu34.add(item346);
		menu34.add(item347);
		
		//��ʾ�˵�
		this.setJMenuBar(mainBar);
		this.add(jp1);
		
		//add listeners
		item11.addActionListener(this);
		item12.addActionListener(this);
		item13.addActionListener(this);
		item14.addActionListener(this);
		item15.addActionListener(this);
		item16.addActionListener(this);
		item21.addActionListener(this);
		item22.addActionListener(this);
		item23.addActionListener(this);
		item24.addActionListener(this);
		item25.addActionListener(this);
		item26.addActionListener(this);
		
		item311.addActionListener(this);
		item312.addActionListener(this);
		item321.addActionListener(this);
		item322.addActionListener(this);
		item323.addActionListener(this);
		item331.addActionListener(this);
		item341.addActionListener(this);
		item342.addActionListener(this);
		item343.addActionListener(this);
		item344.addActionListener(this);
		item345.addActionListener(this);
		item346.addActionListener(this);
		item347.addActionListener(this);
		
		//set UI
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setTitle("���ݿ����ҵ ����� �ܿ��� ������ ������");
	}
	
	public void actionPerformed(ActionEvent e){  
        if(e.getSource() == item11){//�ı�ͼ�λ�����Ϊ���������Ľ��档  
            jp1.removeAll();  
            jp1.add("11" , item11Act);//�л����롣  
            jp1.validate();
            jp1.updateUI(); 
        }  
        else if(e.getSource() == item12){
            jp1.removeAll();
            jp1.add("12", item12Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item13){
            jp1.removeAll();
            jp1.add("13", item13Act);
            jp1.validate();  
            jp1.updateUI();
        }
        /*else if(e.getSource() == item14){
            jp1.removeAll();
            jp1.add("14", item14Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item15){ 
            jp1.removeAll();
            jp1.add("15", item15Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item16){
            jp1.removeAll();
            jp1.add("16", item16Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item21){
            jp1.removeAll();
            jp1.add("21", item21Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item22){
            jp1.removeAll();
            jp1.add("22", item22Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item23){  
            jp1.removeAll();
            jp1.add("23", item23Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item24){
            jp1.removeAll();
            jp1.add("24", item24Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item25){
            jp1.removeAll();
            jp1.add("25", item25Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item26){  
            jp1.removeAll();
            jp1.add("26", item26Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item311){
            jp1.removeAll();
            jp1.add("311", item311Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item312){
            jp1.removeAll();
            jp1.add("312", item312Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item321){
            jp1.removeAll();
            jp1.add("321", item321Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item322){
            jp1.removeAll();
            jp1.add("322", item322Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item323){  
            jp1.removeAll();
            jp1.add("323", item323Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item331){
            jp1.removeAll();
            jp1.add("331", item331Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item341){
            jp1.removeAll();
            jp1.add("341", item341Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item342){
            jp1.removeAll();
            jp1.add("342", item342Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item343){
            jp1.removeAll();
            jp1.add("343", item343Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item344){
            jp1.removeAll();
            jp1.add("344", item344Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item345){
            jp1.removeAll();
            jp1.add("345", item345Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item346){ 
            jp1.removeAll();
            jp1.add("346", item346Act);
            jp1.validate();  
            jp1.updateUI();
        }
        else if(e.getSource() == item347){
            jp1.removeAll();
            jp1.add("347", item347Act);
            jp1.validate();  
            jp1.updateUI();
        }*/
    }
    
    static void setUIFont()
	{
		Font f = new Font("����",Font.BOLD,20);
		String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
				"JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
				"TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
				"OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
				"ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
				"PasswordField","TextField", "Table", "Label", "Viewport",
				"RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
		}; 
		for (String item : names) {
			 UIManager.put(item+ ".font",f); 
		}
	}
}
