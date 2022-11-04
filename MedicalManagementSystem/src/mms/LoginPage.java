package mms;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage implements ActionListener {

    //stack variable at global scope for storing object reference
    JFrame frmMain;
    JPanel pnlNavig;
    //text boxes
    JLabel lblUsername,lblpwd,lblerror;
    JTextField txtUsername, txtpwd;
    JButton btnnext,btnclear;
    void CreatGUI(){
        frmMain=new JFrame();

        lblUsername=new JLabel();
        lblUsername.setText("Username: ");
        txtUsername=new JTextField(10);

        lblpwd=new JLabel();
        lblpwd.setText("Password: ");
        txtpwd=new JTextField(10);

        frmMain.setLayout(new FlowLayout());

        frmMain.setSize(700,500);
        frmMain.setTitle("Medical Management System");

        frmMain.add(lblUsername);
        frmMain.add(txtUsername);
        frmMain.add(lblpwd);
        frmMain.add(txtpwd);
        //navig panel
        pnlNavig=new JPanel();
        pnlNavig.setBorder(BorderFactory.createTitledBorder("Navigation"));

        btnnext= new JButton("Next");
        btnnext.addActionListener(this);
        btnclear= new JButton("Clear");
        btnclear.addActionListener(this);

        pnlNavig.add(btnnext);
        pnlNavig.add(btnclear);
        frmMain.add(pnlNavig);
        frmMain.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String user=txtUsername.getText();
        String pwd=txtpwd.getText();

        if(e.getActionCommand()=="Next"&&user.equals("pooja")&&pwd.equals("pooja")){
            MedicalManagementPage mmpobj = new MedicalManagementPage();
            mmpobj.CreatGUI();
        }
        else if(e.getActionCommand()=="Next"&&txtUsername.equals("")&&txtpwd.equals("")){
            System.out.println("none");
        }
        else if(e.getActionCommand()=="Clear"){
            txtUsername.setText("");
            txtpwd.setText("");
            System.out.println("clear pressed");
        }
    }
}
