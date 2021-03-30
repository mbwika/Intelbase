/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intel.gov.ke.view;


import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class PrintReport extends JFrame{
    
    PreparedStatement st;
    ResultSet rs;
    java.sql.Connection conn;

    
        
    public PrintReport() throws HeadlessException{       
    }
    
    public void showReport() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
            conn.prepareStatement("SELECT * FROM targets");
//            st.setString(1, idno);
//
//            rs = st.executeQuery();
// 
//            while(rs.next()){

            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\reports\\specificTargetReport.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
            JRViewer viewer = new JRViewer(jasperPrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            
            this.add(viewer);
            this.setSize(900, 500);
            this.setVisible(true);  
            
        }catch(JRException ex){
        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    AddTargetController id;
    
    
    public void printCaseReport() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
            conn.prepareStatement("SELECT * FROM crimes");
//            st.setString(1, getIdno());
//
//            rs = st.executeQuery();
// 
//            while(rs.next()){

            JasperReport caseReport = JasperCompileManager.compileReport("C:\\Users\\Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\reports\\caseReport.jrxml");
            JasperPrint casePrint = JasperFillManager.fillReport(caseReport, null, conn);
            JRViewer viewer = new JRViewer(casePrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            
            this.add(viewer);
            this.setSize(900, 700);
            this.setVisible(true);  
            
        }catch(JRException ex){
        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
