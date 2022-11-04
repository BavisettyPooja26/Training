package mms;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MedicalManagementPage implements ActionListener {

    //stack variable at global scope for storing object reference
    JFrame frmMain;
    JPanel pnlCRUD, pnlNavig;
    //text boxes
    JLabel lblname,lblprice,lblqty,lblmid;
    JTextField txtname, txtprice, txtqty,txtmid;
    JButton btninsert,btnclear,btndelete,btnupdate,btnsearch;
    JButton btnfirst,btnlast,btnnext,btnprev;
    void CreatGUI(){
        frmMain=new JFrame();

        lblname=new JLabel();
        lblname.setText("Med name: ");
        txtname=new JTextField(10);

        lblmid=new JLabel();
        lblmid.setText("MedID: ");
        txtmid=new JTextField(5);

        lblprice=new JLabel();
        lblprice.setText("Price: ");
        txtprice=new JTextField(10);

        lblqty=new JLabel("Quantity");
        txtqty=new JTextField(10);

        frmMain.setLayout(new FlowLayout());

        frmMain.setSize(700,500);
        frmMain.setTitle("Medical Management System");

        frmMain.add(lblmid);
        frmMain.add(txtmid);
        frmMain.add(lblname);
        frmMain.add(txtname);
        frmMain.add(lblprice);
        frmMain.add(txtprice);
        frmMain.add(lblqty);
        frmMain.add(txtqty);
        //crud:
        pnlCRUD=new JPanel();
        pnlCRUD.setBorder(BorderFactory.createTitledBorder("CRUD Ops"));
        btninsert= new JButton("Insert");
        btninsert.addActionListener(this); //subscription; pass the current c;lass as paramenter: this keywrd

        btnsearch= new JButton("Search");
        btnsearch.addActionListener(this);

        btnupdate= new JButton("Update");
        btnupdate.addActionListener(this);

        btndelete= new JButton("Delete");
        btndelete.addActionListener(this);

        btnclear= new JButton("Clear");
        btnclear.addActionListener(this);

        //components put into panel
        pnlCRUD.add(btninsert);
        pnlCRUD.add(btnsearch);
        pnlCRUD.add(btnupdate);
        pnlCRUD.add(btnclear);
        pnlCRUD.add(btndelete);

        frmMain.add(pnlCRUD);

        //navig panel

        pnlNavig=new JPanel();
        pnlNavig.setBorder(BorderFactory.createTitledBorder("Navigation"));
        btnfirst= new JButton("<<");
        btnfirst.addActionListener(this);

        btnprev= new JButton("<");
        btnprev.addActionListener(this);

        btnnext= new JButton(">");
        btnnext.addActionListener(this);

        btnlast= new JButton(">>");
        btnlast.addActionListener(this);

        //components put into panel
        pnlNavig.add(btnfirst);
        pnlNavig.add(btnprev);
        pnlNavig.add(btnnext);
        pnlNavig.add(btnlast);
        frmMain.add(pnlNavig);

        frmMain.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Insert"){
            System.out.println("insert pressed");
        }
        else if(e.getActionCommand()=="Update"){
            System.out.println("update pressed");
        }
        else if(e.getActionCommand()=="Delete"){
            System.out.println("delete pressed");
        }
        else if(e.getActionCommand()=="Search"){
            System.out.println("search pressed");
        }
        else if(e.getActionCommand()=="Clear"){
            System.out.println("clear pressed");
        }
        else if(e.getActionCommand()=="<<"){
            System.out.println("<< pressed");
        }
        else if(e.getActionCommand()=="<"){
            System.out.println(" < pressed");
        }
        else if(e.getActionCommand()==">"){
            System.out.println("> pressed");
        }
        else if(e.getActionCommand()==">>"){
            System.out.println(">> pressed");
        }
    }
}
