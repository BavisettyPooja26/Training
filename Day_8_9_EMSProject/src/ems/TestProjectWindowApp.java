package ems;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

//event handling: can be performed on any component or container
//step1 for event driven handling: implement the interface
class EmployeeManagementSystem implements ActionListener {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    //stack variable at global scope for storing object reference
    JFrame frmMain;
    JPanel pnlCRUD, pnlNavig;
    //text boxes
    JLabel lblname, lblsalary, lbladdr, lblid;
    JTextField txtname, txtsalary, txtaddr, txtid;
    JButton btninsert, btnclear, btndelete, btnupdate, btnsearch;
    JButton btnfirst, btnlast, btnnext, btnprev;

    void CreatGUI() {
        frmMain = new JFrame();

        // create instances of labels and text fiels to be hosted in frame
        lblname = new JLabel();
        lblname.setText("Name: ");
        txtname = new JTextField(10);

        lblid = new JLabel();
        lblid.setText("ID: ");
        txtid = new JTextField(5);

        lblsalary = new JLabel();
        lblsalary.setText("Salary: ");
        txtsalary = new JTextField(10);

        lbladdr = new JLabel("Address");
        txtaddr = new JTextField(10);

        //deciding layout for jframe (left to right by default)

        frmMain.setLayout(new FlowLayout());

        frmMain.setSize(700, 500);
        frmMain.setTitle("ems");
        // frmMain.setVisible(true);

        //we will add components(buttons,labels,boxes) into the container(frame)
        frmMain.add(lblid);
        frmMain.add(txtid);
        frmMain.add(lblname);
        frmMain.add(txtname);
        frmMain.add(lblsalary);
        frmMain.add(txtsalary);
        frmMain.add(lbladdr);
        frmMain.add(txtaddr);

// panel is subclass of frame. Main is the primary container and panels are sub-containers
        //panels and components for rud and navig

        //crud:
        pnlCRUD = new JPanel();
        pnlCRUD.setBorder(BorderFactory.createTitledBorder("CRUD Ops"));
        btninsert = new JButton("Insert");
        btninsert.addActionListener(this); //subscription; pass the current c;lass as paramenter: this keywrd

        btnsearch = new JButton("Search");
        btnsearch.addActionListener(this);

        btnupdate = new JButton("Update");
        btnupdate.addActionListener(this);

        btndelete = new JButton("Delete");
        btndelete.addActionListener(this);

        btnclear = new JButton("Clear");
        btnclear.addActionListener(this);

        //components put into panel
        pnlCRUD.add(btninsert);
        pnlCRUD.add(btnsearch);
        pnlCRUD.add(btnupdate);
        pnlCRUD.add(btnclear);
        pnlCRUD.add(btndelete);

        frmMain.add(pnlCRUD);

        //navig panel

        pnlNavig = new JPanel();
        pnlNavig.setBorder(BorderFactory.createTitledBorder("CRUD Ops"));
        btnfirst = new JButton("<<");
        btnfirst.addActionListener(this);

        btnprev = new JButton("<");
        btnprev.addActionListener(this);

        btnnext = new JButton(">");
        btnnext.addActionListener(this);

        btnlast = new JButton(">>");
        btnlast.addActionListener(this);

        //components put into panel
        pnlNavig.add(btnfirst);
        pnlNavig.add(btnprev);
        pnlNavig.add(btnnext);
        pnlNavig.add(btnlast);
        frmMain.add(pnlNavig);

        frmMain.setVisible(true);

    }

    //JDBC and SQL with Oracle
    void DatabaseOps() {
        //step 1: loading the driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");//giving ref to oracleDriver
            System.out.println("driver loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //step 2: establishing the connectivity
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "nriems", "nriems");
            System.out.println("connection established");
            //step3: create sql queries
            String sql = "select empid,empname,empsal,empaddress from tblnriems";
            //step 4: messenger
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //step 5: send sql as message from .java file to oracle and will receive the table back here
//            select -> execute query
//            update delete -> execute Update
            rs = stmt.executeQuery(sql);//knows the location of db because of stmt object; rs->virtual table;
            //rs.next();

            //retrieve the info for columns for a given record

            int eid = rs.getInt("empid");
            String en = rs.getString("empname");
            int es = rs.getInt("empsal");
            String ed = rs.getString("empaddress");

            txtid.setText(Integer.toString(eid));
            txtname.setText(en);
            txtaddr.setText(ed);
            txtsalary.setText(Integer.toString(es));

//            fetching using index:(iundexing starts with 1 here)
//
//            int eid = rs.getInt(1);
//            String en = rs.getString(2);
//            int es = rs.getInt(3);
//            String ed = rs.getString(4);


//            //step 6: now we will retrieve the details of one record at a time and will get it displayed on the console and then later in the respective textfield
//            //Step 7: (row pointer/cursor)rs behaves as a pointer; next() method helps us to traverse one record one by one
//            while(rs.next()) {
//                //step 8: fetch all the column values row after row
//                int eid = rs.getInt("empid");
//                String en = rs.getString("empname");
//                int es = rs.getInt("empsal");
//                String ed = rs.getString("empaddress");
//                //step 9: fetching data
//                System.out.println(eid + " " + en + " " + es + " " + " " + ed);
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void fillUpText() throws SQLException {
        int eid = rs.getInt("empid");
        String en = rs.getString("empname");
        int es = rs.getInt("empsal");
        String ed = rs.getString("empaddress");
        txtid.setText(Integer.toString(eid));
        txtname.setText(en);
        txtaddr.setText(ed);
        txtsalary.setText(Integer.toString(es));
    }


    // tracks which component got clicked
    //subscription-> component is registering itself to action listener; passing of the reference to action listener -> delegation
// callback method -> abstract method of interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Insert") {
            try{
                //make a blank row
                rs.moveToInsertRow();
                //collect the value from textfield and store it here
                rs.updateInt("empid",Integer.parseInt(txtid.getText()));
                rs.updateString("empname",txtname.getText());
                rs.updateInt("empsal",Integer.parseInt(txtsalary.getText()));
                rs.updateString("empaddress",txtaddr.getText());
                rs.insertRow();
                JOptionPane.showMessageDialog(frmMain,"Row inserted");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "Update") {
            try{
                //collect the value from textfield and store it here
                rs.updateInt("empid",Integer.parseInt(txtid.getText()));
                rs.updateString("empname",txtname.getText());
                rs.updateInt("empsal",Integer.parseInt(txtsalary.getText()));
                rs.updateString("empaddress",txtaddr.getText());
                rs.updateRow();
                JOptionPane.showMessageDialog(frmMain,"Row updated");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "Delete") {
            try {
                rs.deleteRow();
                JOptionPane.showMessageDialog(frmMain,"Row deleted");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "Search") {
            if(txtid.getText().isEmpty()){
                JOptionPane.showMessageDialog(frmMain,"Employee id required.");
            }
            else{
                //collecting emp id from run time execution
                int eid=Integer.parseInt(txtid.getText().trim());
                String query="select empid,empname,empsal,empddress from tblnriems where empid=?";
                //pstmt helps in run time parameter passing; using wildcard while stmt cannot
                try {
                    pstmt=conn.prepareStatement(query);
                    //wild card(?) works sequentially
                    pstmt.setInt(1,eid);
                    rs=pstmt.executeQuery();
                    if(rs.next()){
                        fillUpText();
                    }
                    else {
                        JOptionPane.showMessageDialog(frmMain,eid+"not found.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        } else if (e.getActionCommand() == "Clear") {
            txtid.setText("");
            txtname.setText("");
            txtsalary.setText("");
            txtaddr.setText("");
        } else if (e.getActionCommand() == "<<") {
            try {
                rs.first();
                fillUpText();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "<") {
            try {
                if (rs.previous()) {
                    fillUpText();
                } else {
                    rs.next();
                    JOptionPane.showMessageDialog(frmMain, "First Record");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == ">") {
            try {
                if (rs.next()) {
                    fillUpText();
                } else {
                    rs.previous();
                    JOptionPane.showMessageDialog(frmMain, "Last Record");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == ">>") {
            try {
                rs.last();
                fillUpText();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
public class TestProjectWindowApp {
    public static void main(String[] args) {
        EmployeeManagementSystem obj = new EmployeeManagementSystem();
        obj.CreatGUI();
        obj.DatabaseOps();
    }
}

/*
* steps for standard coding(for event driven programming):
* 1. create container and sub container
* 2.create components
* 3.decide layout
* 4.add the components into containers
* 5. perform event handling on components using subscription and delegation model
* 6. Go for database operations*/