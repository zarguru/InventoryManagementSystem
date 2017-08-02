package inventorymanagementsystem;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LanternGenie
 */
public final class Main_Window extends javax.swing.JFrame {

    /**
     * Creates new form Main_Window
     */
    public Main_Window() {
        initComponents();
        JTableHeader th = JTable_Products.getTableHeader();
        th.setPreferredSize(new Dimension(100, 32));
        th.setFont(new java.awt.Font("Tahoma", 1, 28));
        this.setTitle("Inventory Management");
        Show_Products_In_JTable();
    }

    String ImgPath = null;
    int pos = 0;
    
    // Function To Connect To MySQL Database 
    public Connection getConnection()
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/products_db2","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //check Input Fileds
    
    public boolean checkInputs() {
        if(txt_name.getText() == null || txt_price.getText() == null
                || txt_AddDate.getDate() == null) {
            return false;           
        } else {
            try {
                Float.parseFloat(txt_price.getText()); //parse if txt_price a valid value
                return true;
            } catch(Exception ex) {
                return false;
            }
        }
    }
    
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;
        
        if(imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    // Display Data In JTable:
    //      1 - Fill ArrayList with The Data
    
    public ArrayList<Product> getProductList() {
        
            ArrayList<Product> productList = new ArrayList<Product>();
            String query = "SELECT * FROM products";
            
            Statement st;
            ResultSet rs;
            
        try {
            
            
            Connection con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            Product product;
            
            while(rs.next()) {
                product = new Product(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("price")),rs.getString("add_date"),rs.getBytes("image"));
                productList.add(product);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }
    
    //      2 - Populate the JTable
    
    public void Show_Products_In_JTable() {
        ArrayList<Product> list = getProductList();
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
        
        // lcear JTable_Products content
        model.setRowCount(0);
        
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++) {
        row[0] = list.get(i).getId();
        row[1] = list.get(i).getName();
        row[2] = list.get(i).getPrice();
        row[3] = list.get(i).getAddDate();
        
        model.addRow(row);
    }
    }
    
    public void showItem(int index) {
        txt_ID.setText(Integer.toString(getProductList().get(index).getId()));
        txt_name.setText(getProductList().get(index).getName());
        txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
        
        Date addDate = null;
        try {
            addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)getProductList().get(index).getAddDate());
            txt_AddDate.setDate(addDate);
        } catch (ParseException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lbl_image.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_ID = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        lbl_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        txt_AddDate = new org.jdesktop.swingx.JXDatePicker();
        Btn_Choose_Image = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Prev = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setText("Image:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel4.setText("Price:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel5.setText("Add Date:");

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        txt_ID.setEditable(false);
        txt_ID.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        txt_price.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        lbl_image.setBackground(new java.awt.Color(204, 255, 255));
        lbl_image.setOpaque(true);

        JTable_Products.setFont(JTable_Products.getFont().deriveFont((float)30));
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Add Date"
            }
        ));
        JTable_Products.setRowHeight(28);
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);

        txt_AddDate.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txt_AddDate.setFormats("yyyy-MM-dd");

        Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_Choose_Image.setText("Choose Image");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });

        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/add.png"))); // NOI18N
        Btn_Insert.setText("  Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        Btn_Delete.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/delete.png"))); // NOI18N
        Btn_Delete.setText("  Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_Update.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/Refresh.png"))); // NOI18N
        Btn_Update.setText("  Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        Btn_Prev.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/previous.png"))); // NOI18N
        Btn_Prev.setText("  Previous");
        Btn_Prev.setToolTipText("");
        Btn_Prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PrevActionPerformed(evt);
            }
        });

        Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/next.png"))); // NOI18N
        Btn_Next.setText("  Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Last.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/last.png"))); // NOI18N
        Btn_Last.setText("  Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        Btn_First.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Btn_First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/icons/first.png"))); // NOI18N
        Btn_First.setText("  First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(Btn_Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1452, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txt_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Prev, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(810, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null)); 
            ImgPath = path;
        } else {
            System.out.print("No File");
        }
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        
        if(checkInputs() && ImgPath != null) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO products(name,price,add_date,image)"
                                          + "values(?,?,?,?) ");
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_price.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String addDate = dateFormat.format(txt_AddDate.getDate());
                ps.setString(3, addDate);
                
                System.out.println("Name => "+txt_name.getText());
                System.out.println("Price => "+txt_price.getText());
                System.out.println("Add Date => "+addDate);
                System.out.println("Image => "+ImgPath);
                
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(4, img);
                ps.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null, "Data Inserted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or More Fields Are Empty.");
        }
        
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        
        if(!txt_ID.getText().equals("")) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
                int id = Integer.parseInt(txt_ID.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null, "Product Deleted");                        
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product Not Deleted");
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Product Not Deleted: No Id to Delete");
        }
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        if(checkInputs() && txt_ID.getText() != null) {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            
            // update without image
            if(ImgPath == null) {
                try {
                    //con = getConnection();
                    UpdateQuery = "UPDATE products SET name = ?, price = ?"
                            + ", add_date = ? WHERE id = ?";                    
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_name.getText());
                    ps.setString(2, txt_price.getText());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateFormat.format(txt_AddDate.getDate());
                    
                    ps.setString(3, addDate);
                    
                    ps.setInt(4, Integer.parseInt(txt_ID.getText()));
                    
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Product Updated");
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else { // update With Image
                try {
                    //con = getConnection();                    
                    InputStream img = new FileInputStream(new File(ImgPath));
                    
                    UpdateQuery = "UPDATE products SET name = ?, price = ?"
                            + ", add_date = ?, image = ? WHERE id = ?";                    
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, txt_name.getText());
                    ps.setString(2, txt_price.getText());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateFormat.format(txt_AddDate.getDate());                    
                    ps.setString(3, addDate);  
                    
                    ps.setBlob(4, img);                    
                    ps.setInt(5, Integer.parseInt(txt_ID.getText()));
                    
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Product Updated");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }                
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or More Fields Are Empty Or Wrong");
        }
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Btn_PrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PrevActionPerformed
        
        pos = (pos>0?pos-1:0);
        showItem(pos);
    }//GEN-LAST:event_Btn_PrevActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        
        pos = (pos<getProductList().size()-1?pos+1:getProductList().size()-1);
        showItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        
        pos = getProductList().size()-1;
        showItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
    
        pos = 0;
        showItem(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        
        int index = JTable_Products.getSelectedRow();
        showItem(index);
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);     //create login window  
                //new Main_Window().setVisible(true);         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Prev;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JTable JTable_Products;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private org.jdesktop.swingx.JXDatePicker txt_AddDate;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
