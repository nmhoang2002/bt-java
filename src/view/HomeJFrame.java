
package view;

import controller.function;
import model.HocVien;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;


/**
 *
 * @author PH Laptop
 */
public class HomeJFrame extends javax.swing.JFrame {
    
    private HocVien[] arr = function.readFromFile("hocvien.txt");
    private DefaultTableModel model;
    private DefaultTableModel table_update;
    private DefaultTableModel statistical;
   
    
    public HomeJFrame() {
        initComponents();
        setTitle("Quản lý điểm");
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) List.getModel();
        table_update = (DefaultTableModel) Update.getModel();
        statistical = (DefaultTableModel) Table_statistical.getModel();
        this.ShowList(arr,model);
        this.ShowList(arr,table_update);
        this.Statistical();
    }
    public void ShowList(HocVien[] hv,DefaultTableModel table){
        table.setRowCount(0);
        for(int i=0;i<hv.length;i++)
            this.ShowData(hv[i],table);
    }
    public void Statistical(){
       statistical.setRowCount(0);
       for(int i=0;i<arr.length;i++)
           if(arr[i].getDiemthi()<4)
               this.ShowData(arr[i],statistical);
    }
    public void ShowData(HocVien hv,DefaultTableModel table){
//        table_update.setRowCount(0);
        table.addRow(new Object[] {
            hv.getMahv(),hv.getHovaten(),hv.getDiemthi(),hv.getMon(),hv.getLop()
        });
                
            
    }
   
    public int check(String ma,HocVien list[]){
        int k = -1 ;
        for(int i=0;i<list.length;i++)
            if(list[i].getMahv().equals(ma)){
                k = i ;
                break ;
            }
        return k ;
    }
    public boolean addHocVien(HocVien h){
        boolean add = true ;
        HocVien[] temp = function.readFromFile("hocvien.txt");
        if(check(h.getMahv(),temp)!=-1){
            JOptionPane.showMessageDialog(rootPane,"Mã hoc viên này đã tồn tại");
            add = false ;
            return add;
        }
        arr = function.Add(arr, h);
        this.ShowList(arr,model);
        this.ShowList(arr,table_update);
        this.Statistical();
        function.writeToFile("hocvien.txt", h);
        return add;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu3 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jFrame1 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        Tab1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        List = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Sort = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Tab3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        MaHV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Update = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        SuaDiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        Fin = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_statistical = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jToggleButton1.setText("jToggleButton1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("jMenu3");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tab1.setBackground(new java.awt.Color(250, 255, 159));
        Tab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tab1.setToolTipText("");
        Tab1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tab1.setPreferredSize(new java.awt.Dimension(749, 470));

        jPanel1.setBackground(new java.awt.Color(57, 46, 146));
        jPanel1.setToolTipText("QUẢN LÝ ĐIỂM");

        List.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        List.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HV", "Họ và tên", "Điểm", "Môn", "Lớp"
            }
        ));
        List.setSelectionBackground(new java.awt.Color(102, 102, 255));
        List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(List);
        if (List.getColumnModel().getColumnCount() > 0) {
            List.getColumnModel().getColumn(0).setPreferredWidth(10);
            List.getColumnModel().getColumn(1).setPreferredWidth(50);
            List.getColumnModel().getColumn(2).setPreferredWidth(8);
            List.getColumnModel().getColumn(3).setPreferredWidth(20);
            List.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        Delete.setBackground(new java.awt.Color(255, 102, 102));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete.setText("Xóa");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Add.setBackground(new java.awt.Color(114, 199, 114));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Thêm");
        Add.setMaximumSize(new java.awt.Dimension(93, 23));
        Add.setMinimumSize(new java.awt.Dimension(93, 23));
        Add.setPreferredSize(new java.awt.Dimension(93, 23));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(204, 204, 204));
        Exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit.setText("Thoát");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không sắp xếp", "Sắp xếp điểm theo chiều tăng dần", "Sắp xếp điểm theo chiều giảm dần" }));
        Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 153));
        jLabel12.setText("XEM ĐIỂM");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nhập mã học viên");

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("TÌm kiếm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("Clean");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\java\\Nhom6\\bt-java\\images\\save-file.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel13)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Search)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(50, 50, 50)))
                .addGap(273, 273, 273))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        Tab1.addTab("Xem điểm", jPanel1);

        Tab3.setBackground(new java.awt.Color(57, 46, 146));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 255, 159));
        jLabel10.setText("NHẬP/SỬA ĐIỂM");

        MaHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaHVActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nhập mã học viên");

        Update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Update.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HV", "Họ và tên", "Điểm", "Môn", "Lớp"
            }
        ));
        Update.setRowHeight(15);
        Update.setSelectionBackground(new java.awt.Color(102, 102, 255));
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Update);
        if (Update.getColumnModel().getColumnCount() > 0) {
            Update.getColumnModel().getColumn(0).setPreferredWidth(8);
            Update.getColumnModel().getColumn(2).setPreferredWidth(15);
            Update.getColumnModel().getColumn(3).setPreferredWidth(15);
            Update.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jButton3.setBackground(new java.awt.Color(114, 199, 114));
        jButton3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton3.setText("Tìm kiếm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton4.setText("Clean");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        SuaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaDiemActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nhập điểm");

        jButton7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton7.setText("Clean");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Fin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Fin.setForeground(new java.awt.Color(0, 153, 0));

        jButton10.setBackground(new java.awt.Color(114, 199, 114));
        jButton10.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton10.setText("Nhập điểm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 153, 153));
        jButton11.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jButton11.setText("Sửa điểm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tab3Layout = new javax.swing.GroupLayout(Tab3);
        Tab3.setLayout(Tab3Layout);
        Tab3Layout.setHorizontalGroup(
            Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab3Layout.createSequentialGroup()
                .addGap(773, 773, 773)
                .addComponent(Fin)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(Tab3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(31, 31, 31)
                .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tab3Layout.createSequentialGroup()
                        .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Tab3Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11))
                            .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(Tab3Layout.createSequentialGroup()
                                    .addComponent(SuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Tab3Layout.createSequentialGroup()
                                    .addComponent(MaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jButton4))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Tab3Layout.createSequentialGroup()
                        .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        Tab3Layout.setVerticalGroup(
            Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tab3Layout.createSequentialGroup()
                        .addGap(0, 258, Short.MAX_VALUE)
                        .addComponent(Fin))
                    .addGroup(Tab3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(16, 16, 16)
                        .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)
                            .addComponent(jLabel14))
                        .addGap(17, 17, 17)
                        .addGroup(Tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButton10))
                        .addGap(45, 45, 45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Tab1.addTab("Nhập/Sửa điểm", Tab3);

        jPanel4.setBackground(new java.awt.Color(57, 46, 146));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 153));
        jLabel9.setText("DANH SÁCH HỌC VIÊN THI LẠI");

        Table_statistical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Table_statistical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HV", "Họ và tên", "Điểm", "Môn", "Lớp"
            }
        ));
        Table_statistical.setGridColor(new java.awt.Color(204, 204, 255));
        Table_statistical.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jScrollPane4.setViewportView(Table_statistical);
        if (Table_statistical.getColumnModel().getColumnCount() > 0) {
            Table_statistical.getColumnModel().getColumn(0).setMinWidth(50);
            Table_statistical.getColumnModel().getColumn(0).setPreferredWidth(50);
            Table_statistical.getColumnModel().getColumn(0).setMaxWidth(50);
            Table_statistical.getColumnModel().getColumn(1).setMinWidth(200);
            Table_statistical.getColumnModel().getColumn(1).setPreferredWidth(200);
            Table_statistical.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel9)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        Tab1.addTab("Thống kê", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

            
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        SuaDiem.setText("");
        Fin.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void SuaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaDiemActionPerformed

    }//GEN-LAST:event_SuaDiemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MaHV.setText("");
        Fin.setText("");
        this.ShowList(arr, table_update);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String ma = MaHV.getText();
        if(ma.trim().length()==0)
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập vào mã học viên","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        else if(check(ma,arr)!=-1){    
            int index = check(ma,arr) ;
            
            SuaDiem.setText(String.valueOf(arr[index].getDiemthi()));
            if(arr[index].getDiemthi()==-1)
                SuaDiem.setText("");
            table_update.setRowCount(0);
            this.ShowData(arr[index],table_update);      
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Mã học viên không tồn tại", "ERROL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MaHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaHVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaHVActionPerformed

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        
            int index = Update.getSelectedRow();
            if(index==-1)
                return ;
            else{
                String ma = (String) table_update.getValueAt(index, 0);
                MaHV.setText(ma);
                SuaDiem.setText(String.valueOf(arr[index].getDiemthi()));
                if(arr[index].getDiemthi()==-1){
                    SuaDiem.setText("");
                }
                    
                
            }
           
        
        
    }//GEN-LAST:event_UpdateMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        if(MaHV.getText().trim().length()==0){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập mã học viên", "ERROR",JOptionPane.ERROR_MESSAGE);
        
        }
        else{
            int index = check(MaHV.getText(),arr);
            if(SuaDiem.getText().length()==0 && index!=-1 ){
                JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập điểm", "ERROR",JOptionPane.ERROR_MESSAGE);
                return ;
            }
            if(index!=-1){
                if(arr[index].getDiemthi()!=-1){
                    JOptionPane.showMessageDialog(rootPane,"Điểm của sinh viên đã được nhập");
//                    MaHV.setText("");
//                    SuaDiem.setText("");
                    this.ShowList(arr, table_update);
                    return;
                }
                float Diem = -1 ;
                try {
                    Diem = Float.parseFloat(SuaDiem.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane,"Điểm không hợp lệ", "ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                
                if(Diem < 0 || Diem >10){
                    JOptionPane.showMessageDialog(rootPane,"Điểm không hợp lệ", "ERROR",JOptionPane.ERROR_MESSAGE); 
                  
                }
                else{
                    arr[index].setDiemthi(Diem);
                    this.ShowList(arr, model);
                    this.ShowList(arr, table_update);
                    this.Statistical();
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Mã học viên không tồn tại", "ERROL",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(MaHV.getText().trim().length()==0){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập mã học viên", "ERROR",JOptionPane.ERROR_MESSAGE);
         
        }
        else{
            int index = check(MaHV.getText(),arr);
            if(SuaDiem.getText().length()==0 && index!=-1 ){
                JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập điểm", "ERROR",JOptionPane.ERROR_MESSAGE);
                return ;
            }
            if(index!=-1){
                if(arr[index].getDiemthi()==-1){
                    JOptionPane.showMessageDialog(rootPane,"Điểm của sinh viên chưa được nhập");
//                    MaHV.setText("");
//                    SuaDiem.setText("");
                    this.ShowList(arr, table_update);
                    return;
                }
                float Diem = -1 ;
                try {
                    Diem = Float.parseFloat(SuaDiem.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane,"Điểm không hợp lệ", "ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(Diem < 0 || Diem >10){
                    JOptionPane.showMessageDialog(rootPane,"Điểm không hợp lệ", "ERROR",JOptionPane.ERROR_MESSAGE); 
                  
                }
                else{
                    arr[index].setDiemthi(Diem);
                    this.ShowList(arr, model);
                    this.ShowList(arr, table_update);
                    this.Statistical();
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Mã học viên không tồn tại", "ERROL",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Search.setText("");
        this.ShowList(arr,model);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(Search.getText().trim().length()==0){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập vào mã học viên","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String ma = Search.getText();
            if(check(ma,arr)==-1){
                JOptionPane.showMessageDialog(rootPane,"Mã học viên không tồn tại","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int i = check(ma,arr);
                model.setRowCount(0);
                this.ShowData(arr[i], model);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortActionPerformed

        int index = Sort.getSelectedIndex();
        if(index>=0){
            if(index==0){
                this.ShowList(arr,model);
            }
            else if(index==1){
                HocVien[] the = Copy();
                function.Sort(the,true);
                this.ShowList(the, model);
                this.ShowList(the,table_update);
            }
            else if(index==2){
                HocVien[] the = Copy();
                function.Sort(the,false);
                this.ShowList(the, model);
                this.ShowList(the,table_update);
            }
        }
    }//GEN-LAST:event_SortActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int n = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn lưu lại ko", "QUESTION", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            function.SaveData("hocvien.txt", arr);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        new add(this, rootPaneCheckingEnabled).setVisible(true);

    }//GEN-LAST:event_AddActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(Search.getText().trim().length()==0){
            JOptionPane.showMessageDialog(rootPane,"Vui lòng nhập vào mã học viên", "ERROR",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        int index = check(Search.getText(),arr);
        if(index ==-1){
            JOptionPane.showMessageDialog(rootPane,"Mã học viên không tồn tại", "ERROR",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        int n = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa học viên này không", "QUESTION", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            arr = function.Delete(arr, index);
            this.ShowList(arr,model);
            this.Statistical();
            this.ShowList(arr,table_update);
            Search.setText("");
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListMouseClicked
        int indexRow = List.getSelectedRow();
        Search.setText((String) List.getValueAt(indexRow, 0));
    }//GEN-LAST:event_ListMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        function.SaveData("hocvien.txt", arr);
        int n = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn lưu lại ko", "QUESTION", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            function.SaveData("hocvien.txt", arr);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
           
    public HocVien[] Copy(){
        HocVien[] temp = new HocVien[arr.length];
        for(int i=0;i<this.arr.length;i++){
            temp[i] = arr[i];
        }
        return temp;
    }
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
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
               
            }
        });
    }
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;
    private javax.swing.JTextField InputDiem;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Fin;
    private javax.swing.JTable List;
    private javax.swing.JTextField MaHV;
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> Sort;
    private javax.swing.JTextField SuaDiem;
    private javax.swing.JTabbedPane Tab1;
    private javax.swing.JPanel Tab3;
    private javax.swing.JTable Table_statistical;
    private javax.swing.JTable Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
