package ui;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import longnbp.dtos.ProductsDTO;
import longnbp.dtos.CategoriesDTO;

public class ProductManagement extends javax.swing.JFrame {

    CategoryDAO sd;
    DefaultTableModel tableModel;
    Vector columnHeader = new Vector();
    boolean addCate = false;
    boolean addProduct = false;

    public ProductManagement() {
        initComponents();
        sd = new CategoryDAO();
        ViewCategory();
        ViewPro();
        setLocationRelativeTo(null);

    }

    public void ViewCategory() {
        txtCateCode.setEditable(false);
        txtCateName.setEditable(false);
        txtCateDescription.setEditable(false);
        columnHeader = new Vector();
        columnHeader.add("ID");
        columnHeader.add("Name");
        columnHeader.add("description");
        Vector<Vector<String>> cateList;
        try {
            cateList = CategoryDAO.getCategoryList();
            CategoryDAO dao = new CategoryDAO();
            tableModel = new DefaultTableModel();
            tableModel.setDataVector(cateList, columnHeader);
            tblCategory.setModel(tableModel);
            cbxCategory.setModel(new DefaultComboBoxModel<>(dao.getCombobox()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    public void ViewPro() {
        int pos = 0;
        txtProductCode.setEditable(false);
        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductUnit.setEditable(false);
        cbxCategory.setEditable(false);
        txtProductQuanity.setEditable(false);
        columnHeader = new Vector();
        columnHeader.add("Product Code:");
        columnHeader.add("Product Name:");
        columnHeader.add("CategoryID:");
        columnHeader.add("Unit");
        columnHeader.add("Price");
        columnHeader.add("Quanity:");
        Vector<Vector<String>> cateList;
        try {
            cateList = ProductDAO.getProductList();
            CategoryDAO dao = new CategoryDAO();
            tableModel = new DefaultTableModel();
            tableModel.setDataVector(cateList, columnHeader);
            tblProduct.setModel(tableModel);
            for (Vector<String> vector : cateList) {
                tableModel.setValueAt(dao.getCate(vector.get(2)), pos, 2);
                pos++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String validateCateInput() {
        String check = "";

        if (txtCateCode.getText().isEmpty()) {
            check += "Cate code can not empty.\n";
        } else {
            if (txtCateCode.getText().length() > 10) {
                check += "Cate code has maximum 10 characters\n";
            }

        }
        if (txtCateName.getText().isEmpty()) {
            check += "Cate name can not empty.\n";
        } else {
            if (txtCateName.getText().length() > 50) {
                check += "Cate name has maximum 50 characters\n";
            }

        }

        if (txtCateDescription.getText().isEmpty()) {
            check += "Cate Description can not empty.\n";
        } else {
            if (txtCateDescription.getText().length() > 200) {
                check += "Cate Description has maximum 200 characters\n";
            }
        }

        return check;
    }

    private String validateProductInput() {
        String check = "";

        if (txtProductCode.getText().isEmpty()) {
            check += "Item code can not empty.\n";
        } else {
            if (txtProductCode.getText().length() > 10) {
                check += "\nProduct code has maximum 10 characters\n";
            }

        }

        if (txtProductName.getText().isEmpty()) {
            check += "Product name can not empty.\n";
        } else {
            if (txtProductName.getText().length() > 50) {
                check += "Product name has maximum 50 characters\n";
            }
        }

        if (txtProductPrice.getText().isEmpty()) {
            check += "Product price can not empty.\n";
        } else {
            try {
                if (Float.parseFloat(txtProductPrice.getText()) < 0) {
                    check += "Product price must > 0\n";
                }
            } catch (NumberFormatException e) {
                check += "Price is a float\n";
            }

        }

        if (txtProductQuanity.getText().isEmpty()) {
            check += "Product Quantity can not empty.\n";
        } else {
            try {
                if (Integer.parseInt(txtProductQuanity.getText()) < 0) {
                    check += "Product quantiry must > 0\n";
                }
            } catch (NumberFormatException e) {
                check += "quantity is a int\n";
            }

        }

        if (txtProductUnit.getText().isEmpty()) {
            check += "Product unit can not empty.\n";
        } else {
            if (txtProductUnit.getText().length() > 50) {
                check += "Product unit has maximum 50 characters\n";
            }

        }
        if (cbxCategory.getSelectedItem().equals("Choose one")) {
            check += "Choose a category\n";
        }

        return check;
    }

    private void resetFormCate() {
        txtCateCode.setText("");
        txtCateName.setText("");
        txtCateDescription.setText("");
    }

    private void resetFormPro() {
        txtProductCode.setText("");
        txtProductName.setText("");
        cbxCategory.setSelectedIndex(0);
        txtProductUnit.setText("");
        txtProductPrice.setText("");
        txtProductQuanity.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCateCode = new javax.swing.JTextField();
        txtCateName = new javax.swing.JTextField();
        txtCateDescription = new javax.swing.JTextField();
        btnAddNewCate = new javax.swing.JButton();
        btnCateSave = new javax.swing.JButton();
        btnCateDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jcro = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        txtProductUnit = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtProductCode = new javax.swing.JTextField();
        cbxCategory = new javax.swing.JComboBox<>();
        btnProductNew = new javax.swing.JButton();
        btnProductSave = new javax.swing.JButton();
        btnProductDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtProductQuanity = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Supplier Details"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Description: ");

        txtCateCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCateCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCateCodeKeyReleased(evt);
            }
        });

        txtCateName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCateNameKeyReleased(evt);
            }
        });

        txtCateDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCateDescriptionKeyReleased(evt);
            }
        });

        btnAddNewCate.setBackground(new java.awt.Color(0, 102, 102));
        btnAddNewCate.setText("Add new");
        btnAddNewCate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddNewCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCateActionPerformed(evt);
            }
        });

        btnCateSave.setBackground(new java.awt.Color(0, 102, 102));
        btnCateSave.setText("Save");
        btnCateSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCateSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCateSaveActionPerformed(evt);
            }
        });

        btnCateDelete.setBackground(new java.awt.Color(0, 102, 102));
        btnCateDelete.setText("Delete");
        btnCateDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCateDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCateDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtCateCode, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCateName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAddNewCate))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCateDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnCateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCateDelete)
                                .addGap(25, 25, 25)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCateCode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCateName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCateDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCateDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewCate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Main part"));

        jcro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcroMouseClicked(evt);
            }
        });

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCategory.getTableHeader().setReorderingAllowed(false);
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jcro.setViewportView(tblCategory);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcro))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Category", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Detailed part"));

        jLabel5.setText("Product Code:");

        jLabel6.setText("Product Name:");

        jLabel7.setText("Category name:");

        jLabel8.setText("Unit:");

        jLabel9.setText("Price:");

        txtProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductPriceKeyReleased(evt);
            }
        });

        txtProductUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductUnitKeyReleased(evt);
            }
        });

        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
        });

        txtProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductCodeKeyReleased(evt);
            }
        });

        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        btnProductNew.setText("Add New");
        btnProductNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductNewActionPerformed(evt);
            }
        });

        btnProductSave.setText("Save");
        btnProductSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductSaveActionPerformed(evt);
            }
        });

        btnProductDelete.setText("Delete");
        btnProductDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductDeleteActionPerformed(evt);
            }
        });

        jLabel10.setText("Quanity:");

        txtProductQuanity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductQuanityKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnProductNew)
                                .addGap(61, 61, 61)
                                .addComponent(btnProductSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(btnProductDelete))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProductPrice)
                                    .addComponent(txtProductUnit)
                                    .addComponent(txtProductName)
                                    .addComponent(txtProductCode)
                                    .addComponent(cbxCategory, 0, 189, Short.MAX_VALUE)
                                    .addComponent(txtProductQuanity))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProductCode, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProductQuanity, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductSave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductNew, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Mainpart"));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Product", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductNewActionPerformed

        addProduct = true;
        txtProductCode.setEnabled(true);
        txtProductCode.setEditable(true);
        txtProductName.setEditable(true);
        txtProductUnit.setEditable(true);
        txtProductPrice.setEditable(true);
        txtProductQuanity.setEditable(true);
        cbxCategory.setEnabled(true);
        cbxCategory.setEditable(true);
        txtProductCode.setText("");
        txtProductName.setText("");
        txtProductUnit.setText("");
        txtProductPrice.setText("");
        txtProductQuanity.setText("");
        cbxCategory.setSelectedIndex(0);


    }//GEN-LAST:event_btnProductNewActionPerformed

    private void btnProductSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductSaveActionPerformed
       String check = validateProductInput();
        if (!addProduct) {
            String id = txtProductCode.getText();
            try {
                if (ProductDAO.checkProductCode(id) && check.equals("")) {
                    String name = txtProductName.getText();
                    String unit = txtProductUnit.getText();
                    int qua = Integer.parseInt(txtProductQuanity.getText());
                    float price = Float.parseFloat(txtProductPrice.getText());
                    String category = (String) cbxCategory.getSelectedItem();
                    StringTokenizer stk = new StringTokenizer(category, "-");
                    String cateCode = "";
                    if (stk.hasMoreTokens()) {
                        cateCode = stk.nextToken();
                    }
                    ProductsDTO dto = new ProductsDTO(id, name, unit, price, qua, cateCode);
                    boolean result = ProductDAO.updateProduct(dto);
                    if (result) {
                        ViewPro();
                        JOptionPane.showMessageDialog(this, "update successful.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, check);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            if (check.equals("")) {
                try {
                    String proCode = txtProductCode.getText();
                    if (!ProductDAO.checkProductCode(proCode)) {
                        String proName = txtProductName.getText();
                        String unit = txtProductUnit.getText();
                        int qua = Integer.parseInt(txtProductQuanity.getText());
                        float price = Float.parseFloat(txtProductPrice.getText());
                        String category = (String) cbxCategory.getSelectedItem();
                        StringTokenizer stk = new StringTokenizer(category, "-");
                        String cateCode = "";
                        if (stk.hasMoreTokens()) {
                            cateCode = stk.nextToken();
                        }
                        ProductsDTO i = new ProductsDTO(proCode, proName, unit, price, qua, category);
                        boolean result = ProductDAO.InsertProduct(i);
                        if (result) {
                            ViewPro();
                            JOptionPane.showMessageDialog(this, "Insert successful.");
                            addProduct = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Duplicate CategoryCode");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, check);
            }
        }
    }//GEN-LAST:event_btnProductSaveActionPerformed

    private void btnProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDeleteActionPerformed

        int pos = tblProduct.getSelectedRow();
        if (pos < 0) {
            JOptionPane.showMessageDialog(this, "Please choose row want to remove");
        } else {
            String id = txtProductCode.getText();
            int l = JOptionPane.showConfirmDialog(this, "Do you want to romove", "remove", JOptionPane.YES_NO_OPTION);
            if (l == JOptionPane.YES_OPTION) {
                try {
                    if (ProductDAO.checkProductCode(id)) {
                        ProductsDTO dto = new ProductsDTO(id);
                        if (ProductDAO.deleteProduct(dto)) {
                            ViewPro();
                            resetFormPro();
                            JOptionPane.showMessageDialog(this, "Delete successfully");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "proID does not exist");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }


    }//GEN-LAST:event_btnProductDeleteActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked


        txtProductCode.setEditable(true);
        txtProductName.setEditable(true);
        txtProductPrice.setEditable(true);
        txtProductQuanity.setEditable(true);
        txtProductUnit.setEditable(true);
        cbxCategory.setEditable(true);
        try {
            int row = tblProduct.getSelectedRow();
            String productCode = tblProduct.getValueAt(row, 0).toString();
            txtProductCode.setEnabled(false);
            ProductDAO dao = new ProductDAO();
            ProductsDTO dto = dao.getProductDetail(productCode);
            txtProductCode.setText(dto.getProductID());
            txtProductName.setText(dto.getProductName());
            txtProductUnit.setText(dto.getUnit());
            txtProductPrice.setText(dto.getPrice() + "");
            txtProductQuanity.setText(dto.getQuantity() + "");
            CategoryDAO catedao = new CategoryDAO();
            cbxCategory.setSelectedItem(catedao.getCate(dto.getCategory()));

        } catch (Exception e) {
        }

    }//GEN-LAST:event_tblProductMouseClicked

    private void btnAddNewCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCateActionPerformed

        addCate = true;
        txtCateCode.setEnabled(true);
        txtCateName.setEditable(true);
        txtCateDescription.setEditable(true);
        txtCateCode.setEditable(true);
        txtCateCode.setText("");
        txtCateName.setText("");
        txtCateDescription.setText("");

    }//GEN-LAST:event_btnAddNewCateActionPerformed

    private void btnCateSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCateSaveActionPerformed

        String check = validateCateInput();
        if (!addCate) {
            String id = txtCateCode.getText();
            try {
                if (CategoryDAO.checkCode(id) && check.equals("")) {
                    String name = txtCateName.getText();
                    String des = txtCateDescription.getText();
                    CategoriesDTO dto = new CategoriesDTO(id, name, des);
                    boolean result = CategoryDAO.updateCategory(dto);
                    if (result) {
                        ViewCategory();
                        ViewPro();
                        JOptionPane.showMessageDialog(this, "update successful.");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, check);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            if (check.equals("")) {
                try {
                    String categoryCode = txtCateCode.getText();
                    if (!CategoryDAO.checkCode(categoryCode)) {
                        String categoryName = txtCateName.getText();
                        String description = txtCateDescription.getText();

                        CategoriesDTO s = new CategoriesDTO(categoryCode, categoryName, description);
                        boolean result = CategoryDAO.InsertCategory(s);
                        if (result) {
                            ViewCategory();
                            ViewPro();
                            JOptionPane.showMessageDialog(this, "Insert successful.");

                            addCate = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Duplicate supplierCode");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, check);
            }
        }


    }//GEN-LAST:event_btnCateSaveActionPerformed

    private void btnCateDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCateDeleteActionPerformed

//        int pos = tblCategory.getSelectedRow();
//        if (pos < 0) {
//            JOptionPane.showMessageDialog(this, "please choose row");
//        } else {
//            try {
//                String Id = txtCateCode.getText();
//                if (!sd.checkDupID(Id)) {
//                    int l = JOptionPane.showConfirmDialog(this, "want toremove", "remove", JOptionPane.YES_NO_OPTION);
//                    if (l == JOptionPane.YES_OPTION) {
//                        try {
//                            if (CategoryDAO.checkCode(Id)) {
//                                CategoriesDTO dto = new CategoriesDTO(Id);
//                                if (CategoryDAO.deleteCategory(dto)) {
//                                    ViewCategory();
//                                    ViewPro();
//                                    resetFormCate();
//                                    JOptionPane.showMessageDialog(this, "successfully");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(this, "catecode  does not exist");
//                            }
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(this, e.getMessage());
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "cateCode  duplicate");
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, e.getMessage());
//            }
//        }
        int pos = tblCategory.getSelectedRow();
        if (pos < 0) {
            JOptionPane.showMessageDialog(this, "please  choose row want to delete");
        } else {
            try {
                String id = txtCateCode.getText();
                if (!sd.checkDupID(id)) {
                    int i = JOptionPane.showConfirmDialog(this, "Do you want to remove", " remove", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        try {
                            if (CategoryDAO.checkCode(id)) {
                                CategoriesDTO dto = new CategoriesDTO(id);
                                if (CategoryDAO.deleteCategory(dto)) {
                                    ViewCategory();
                                    ViewPro();
                                    JOptionPane.showMessageDialog(this, "Delete successfully");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "categoryID does not exist");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e.getMessage());
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "duplicate");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());

            }
        }

    }//GEN-LAST:event_btnCateDeleteActionPerformed

    private void jcroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcroMouseClicked

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        txtCateName.setEditable(true);
        txtCateDescription.setEditable(true);
        try {
            int row = tblCategory.getSelectedRow();
            String cateCode = tblCategory.getValueAt(row, 0).toString();
            txtCateCode.setEnabled(false);
            CategoryDAO dao = new CategoryDAO();
            CategoriesDTO dto = dao.getCategoryDetail(cateCode);
            txtCateCode.setText(dto.getCategoryID());
            txtCateName.setText(dto.getCategoryName());
            txtCateDescription.setText(dto.getDescription());
            addCate = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void txtCateCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCateCodeKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCateCodeKeyPressed

    private void txtCateCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCateCodeKeyReleased
        // TODO add your handling code here:
        txtCateCode.setText(txtCateCode.getText().replaceAll("[-\\+'!@:}#?$%=^&*{)(._]", ""));
        txtCateCode.setText(txtCateCode.getText().replace("[", ""));
        txtCateCode.setText(txtCateCode.getText().replace("]", ""));
        txtCateCode.setText(txtCateCode.getText().replace("`", ""));
        txtCateCode.setText(txtCateCode.getText().replace("~", ""));
        txtCateCode.setText(txtCateCode.getText().replace("/", ""));

    }//GEN-LAST:event_txtCateCodeKeyReleased

    private void txtCateNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCateNameKeyReleased
        // TODO add your handling code here:
        txtCateName.setText(txtCateName.getText().replaceAll("[-\\+'!@:}#?$%^&*{)(_.]", ""));
        txtCateName.setText(txtCateName.getText().replace("[", ""));
        txtCateName.setText(txtCateName.getText().replace("]", ""));
        txtCateName.setText(txtCateName.getText().replace("`", ""));
        txtCateName.setText(txtCateName.getText().replace("~", ""));
        txtCateName.setText(txtCateName.getText().replace("/", ""));


    }//GEN-LAST:event_txtCateNameKeyReleased

    private void txtCateDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCateDescriptionKeyReleased

        txtCateDescription.setText(txtCateDescription.getText().replaceAll("[-\\+'!@:}#?$%^<>&*{)(_.]", ""));
        txtCateDescription.setText(txtCateDescription.getText().replace("[", ""));
        txtCateDescription.setText(txtCateDescription.getText().replace("]", ""));
        txtCateDescription.setText(txtCateDescription.getText().replace("`", ""));
        txtCateDescription.setText(txtCateDescription.getText().replace("~", ""));
        txtCateDescription.setText(txtCateDescription.getText().replace("/", ""));
    }//GEN-LAST:event_txtCateDescriptionKeyReleased

    private void txtProductCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductCodeKeyReleased
        // TODO add your handling code here:
        txtProductCode.setText(txtProductCode.getText().replaceAll("[-\\+'!@:}#?$%^&*{)(_<>.]", ""));
        txtProductCode.setText(txtProductCode.getText().replace("[", ""));
        txtProductCode.setText(txtProductCode.getText().replace("]", ""));
        txtProductCode.setText(txtProductCode.getText().replace("`", ""));
        txtProductCode.setText(txtProductCode.getText().replace("~", ""));
        txtProductCode.setText(txtProductCode.getText().replace("/", ""));

    }//GEN-LAST:event_txtProductCodeKeyReleased

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
        // TODO add your handling code here:
        txtProductName.setText(txtProductName.getText().replaceAll("[-\\+'!@:}#?$%^&*{)12345<>67890(_.]", ""));
        txtProductName.setText(txtProductName.getText().replace("[", ""));
        txtProductName.setText(txtProductName.getText().replace("]", ""));
        txtProductName.setText(txtProductName.getText().replace("`", ""));
        txtProductName.setText(txtProductName.getText().replace("~", ""));
        txtProductName.setText(txtProductName.getText().replace("/", ""));

    }//GEN-LAST:event_txtProductNameKeyReleased

    private void txtProductUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductUnitKeyReleased
        // TODO add your handling code here:
        txtProductUnit.setText(txtProductUnit.getText().replaceAll("[-\\+'!@:}<>#?$%^&*{)(_.]", ""));
        txtProductUnit.setText(txtProductUnit.getText().replace("[", ""));
        txtProductUnit.setText(txtProductUnit.getText().replace("]", ""));
        txtProductUnit.setText(txtProductUnit.getText().replace("`", ""));
        txtProductUnit.setText(txtProductUnit.getText().replace("~", ""));
        txtProductUnit.setText(txtProductUnit.getText().replace("/", ""));

    }//GEN-LAST:event_txtProductUnitKeyReleased

    private void txtProductPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductPriceKeyReleased
        txtProductPrice.setText(txtProductPrice.getText().replaceAll("[-\\+'!@:}<>#?$%^&*{)(_.qwertyuiopasdfghjk<>lzxcvbnm]", ""));        // TODO add your handling code here:
        txtProductPrice.setText(txtProductPrice.getText().replace("[", ""));
        txtProductPrice.setText(txtProductPrice.getText().replace("]", ""));
        txtProductPrice.setText(txtProductPrice.getText().replace("`", ""));
        txtProductPrice.setText(txtProductPrice.getText().replace("~", ""));
        txtProductPrice.setText(txtProductPrice.getText().replace("/", ""));

    }//GEN-LAST:event_txtProductPriceKeyReleased

    private void txtProductQuanityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductQuanityKeyReleased
        // TODO add your handling code here:
        txtProductQuanity.setText(txtProductQuanity.getText().replaceAll("[-\\+'!@:}<>#?$%^&*{)(_.qwertyuiopasdfghjk<>lzxcvbnm]", ""));
        txtProductQuanity.setText(txtProductQuanity.getText().replace("[", ""));
        txtProductQuanity.setText(txtProductQuanity.getText().replace("]", ""));
        txtProductQuanity.setText(txtProductQuanity.getText().replace("`", ""));
        txtProductQuanity.setText(txtProductQuanity.getText().replace("~", ""));
        txtProductQuanity.setText(txtProductQuanity.getText().replace("/", ""));

    }//GEN-LAST:event_txtProductQuanityKeyReleased

//    /**
//     * @param args the command line arguments
//     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCate;
    private javax.swing.JButton btnCateDelete;
    private javax.swing.JButton btnCateSave;
    private javax.swing.JButton btnProductDelete;
    private javax.swing.JButton btnProductNew;
    private javax.swing.JButton btnProductSave;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jcro;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtCateCode;
    private javax.swing.JTextField txtCateDescription;
    private javax.swing.JTextField txtCateName;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuanity;
    private javax.swing.JTextField txtProductUnit;
    // End of variables declaration//GEN-END:variables
}
