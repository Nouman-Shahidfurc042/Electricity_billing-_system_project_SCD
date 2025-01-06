
package electricitybillingsystem2;



import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {

    BillDetails(String meter) {

        // Frame settings
        setSize(700, 650);
        setLocation(400, 150);
        setLayout(null); // Use absolute layout
        getContentPane().setBackground(Color.WHITE);

        // Heading label
        JLabel heading = new JLabel("BILL DETAILS");
        heading.setBounds(250, 10, 200, 30); // Position the heading above the table
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Table to display bill details
        JTable table = new JTable();

        try {
            Conn c = new Conn();
            String query = "select * from bill where meter_no = '" + meter + "'";
            ResultSet rs = c.s.executeQuery(query);

            // Set table model using DbUtils
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scroll pane for table
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 50, 650, 550); // Position table below the heading
        add(sp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}

