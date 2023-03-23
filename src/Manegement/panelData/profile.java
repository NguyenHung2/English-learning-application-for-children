/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.panelData;

import Manegement.classData.listProfile;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import user.Connect;

/**
 *
 * @author HP
 */
public class profile extends javax.swing.JPanel {

//    final String col[] = {"MÃ ND", "TÀI KHOẢN", "MẬT KHẨU", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐỊA CHỈ", "SỐ ĐIỆN THOẠI", "EMAIL"};
//    final DefaultTableModel tbn = new DefaultTableModel(col, 0);
    ArrayList<listProfile> list = new ArrayList<listProfile>();
    int current = 0;

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String MaND = "";
    int flag = 1;

    public profile() {
        initComponents();
        getSumRow();
        load_Profile();
        load_dataProfile();
        loadDataCBBSearchID();
        dataEnabledButton();
    }

    public void loadDataCBBSearchID() {
        try {
            pst = con.prepareStatement("Select * from NguoiDung");
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            while (rs.next()) {
                cbbSearchID.addItem(rs.getString("MaND"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy maND!");
        }
    }

    public void load_Profile() {
        try {
//            String url = "SELECT MaND, TaiKhoan, MatKhau, HoTen, GioiTinh = (CASE GioiTinh WHEN 'TRUE' THEN N'NAM' ELSE N'NỮ' END), NgaySinh = CONVERT(varchar, NGAYSINH, 103)\n"
//                    + ",DiaChi, Sdt, Email\n"
//                    + "FROM NguoiDung";
            String url = "SELECT * FROM NguoiDung";
            st = con.createStatement();
            rs = st.executeQuery(url);
            list.clear();
            listProfile data;
            while (rs.next()) {
                data = new listProfile(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void load_dataProfile() {
        tbn = (DefaultTableModel) tblProfile.getModel();
        tbn.setRowCount(0);
        for (listProfile i : list) {
            tbn.addRow(new Object[]{i.getMaND(), i.getTaikhoan(), i.getMatKhau(), i.getHoTen(), i.isGioiTinh(), i.getNgaySinh(), i.getDiaChi(), i.getEmail(), i.getSDT()});
        }

        JTableHeader Theader = tblProfile.getTableHeader();

        Theader.setBackground(new Color(18, 16, 14));
        Theader.setForeground(Color.black);

        Theader.setFont(new Font("Roboto", Font.BOLD, 17));
        ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        tblProfile.setFont(new Font("Roboto", Font.PLAIN, 17));
        tblProfile.setSelectionBackground(new Color(59, 89, 152));
        tblProfile.setSelectionForeground(Color.white);

        dataEnabledButton();
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Main = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        lblMaNguoiDung = new javax.swing.JLabel();
        lblHoVaTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtMaND = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        btnTaoMa = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        txtMatKhau = new javax.swing.JPasswordField();
        Option = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        cbbSearchID = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Bottom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProfile = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 1, true));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1392, 812));
        setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(0, 100));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BẢNG DỮ LIỆU THÔNG TIN NGƯỜI DÙNG");
        jLabel1.setBorder(null);
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 100));

        jSeparator2.setBackground(new java.awt.Color(0, 120, 255));
        jSeparator2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator2.setOpaque(true);
        Header.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 300, 5));

        add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(252, 204, 99));
        Main.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Main.setPreferredSize(new java.awt.Dimension(1392, 400));
        Main.setLayout(new java.awt.BorderLayout());

        Content.setBackground(new java.awt.Color(255, 255, 204));
        Content.setBorder(null);
        Content.setOpaque(false);
        Content.setPreferredSize(new java.awt.Dimension(890, 400));
        Content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaNguoiDung.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMaNguoiDung.setText("Mã Người Dùng");
        Content.add(lblMaNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 35));

        lblHoVaTen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHoVaTen.setText("Họ và Tên");
        Content.add(lblHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, 150, 35));

        lblGioiTinh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblGioiTinh.setText("Giới Tính");
        Content.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 35));

        lblNgaySinh.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNgaySinh.setText("Ngày Sinh");
        Content.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 155, 150, 35));

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEmail.setText("Email");
        Content.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, 35));

        lblSoDienThoai.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSoDienThoai.setText("Số điện thoại");
        Content.add(lblSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 245, 150, 35));

        lblDiaChi.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDiaChi.setText("Địa Chỉ");
        Content.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 35));

        lblTaiKhoan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTaiKhoan.setText("Tài Khoản");
        lblTaiKhoan.setPreferredSize(new java.awt.Dimension(65, 35));
        Content.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 120, 35));

        lblMatKhau.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMatKhau.setText("Mật Khẩu");
        Content.add(lblMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 65, 120, 35));

        txtMaND.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtMaND, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, 35));

        txtHoTen.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 65, 250, 35));

        buttonGroup1.add(rdbMale);
        rdbMale.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        rdbMale.setText("NAM");
        rdbMale.setContentAreaFilled(false);
        rdbMale.setFocusPainted(false);
        Content.add(rdbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 35));

        buttonGroup1.add(rdbFemale);
        rdbFemale.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        rdbFemale.setText("NỮ");
        rdbFemale.setContentAreaFilled(false);
        rdbFemale.setFocusPainted(false);
        Content.add(rdbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 35));

        txtDate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 250, 35));

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 250, 35));

        txtSDT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }
        });
        Content.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 245, 250, 35));

        txtDiaChi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 250, 35));

        txtTaiKhoan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Content.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 250, -1));

        btnTaoMa.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnTaoMa.setText("Tạo mã");
        btnTaoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaActionPerformed(evt);
            }
        });
        Content.add(btnTaoMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jCheckBox4.setText("Hiện mật khẩu");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        Content.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 105, -1, 35));

        txtMatKhau.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtMatKhau.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Content.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 65, 250, 35));

        Main.add(Content, java.awt.BorderLayout.CENTER);

        Option.setBackground(new java.awt.Color(252, 204, 99));
        Option.setOpaque(false);
        Option.setPreferredSize(new java.awt.Dimension(502, 400));
        Option.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        Option.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, 35));

        cbbSearchID.setEditable(true);
        cbbSearchID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbSearchID.setMaximumRowCount(5);
        cbbSearchID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Chọn MaND ---" }));
        cbbSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchIDActionPerformed(evt);
            }
        });
        Option.add(cbbSearchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 35));

        jPanel1.setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        btnAdd.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/34237_+_add_plus_icon.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setPreferredSize(new java.awt.Dimension(160, 45));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnSave.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/285657_floppy_guardar_save_icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(160, 45));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnEdit.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/17009_arrows_exchange_interact_refresh_reload_icon.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setPreferredSize(new java.awt.Dimension(160, 45));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/34218_add_cross_delete_exit_remove_icon.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(160, 45));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnReset.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8542647_undo_back_icon.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.setPreferredSize(new java.awt.Dimension(160, 45));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);

        Option.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 310));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3844432_magnifier_search_zoom_icon.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        Option.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 50, 35));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Tìm kiếm");
        Option.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        Main.add(Option, java.awt.BorderLayout.EAST);

        add(Main, java.awt.BorderLayout.CENTER);

        Bottom.setPreferredSize(new java.awt.Dimension(0, 312));
        Bottom.setLayout(new java.awt.BorderLayout());

        tblProfile.setAutoCreateRowSorter(true);
        tblProfile.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tblProfile.setForeground(new java.awt.Color(0, 0, 0));
        tblProfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ ND", "TÀI KHOẢN", "MẬT KHẨU", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐỊA CHỈ", "EMAIL", "SỐ ĐIỆN THOẠI"
            }
        ));
        tblProfile.setRowHeight(40);
        tblProfile.setRowMargin(5);
        tblProfile.setShowHorizontalLines(true);
        tblProfile.setShowVerticalLines(true);
        tblProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfileMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProfile);

        Bottom.add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        add(Bottom, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        dataNotEnabledButton();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            if (txtMaND.getText().equals("") || txtMatKhau.getText().equals("") || txtHoTen.getText().equals("")
                    || txtDiaChi.getText().equals("") || txtSDT.getText().equals("") || txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không được bỏ trống!");
            } else {
                hopleMaND(sb);
                hopleTaiKhoan(sb);
                hopleMatKhau(sb);
                hopleEmail(sb);
                hopleSDT(sb);
                if (sb.length() > 0) { //nếu if trên đúng nó sẽ thêm vào sb 1 đoạn string, ktra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo
                    JOptionPane.showMessageDialog(this, sb.toString());
                } else {
                    String url = "insert into NguoiDung values (?,?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(url);
                    pst.setString(1, txtMaND.getText());
                    pst.setString(2, txtTaiKhoan.getText());
                    pst.setString(3, txtMatKhau.getText());
                    pst.setString(4, txtHoTen.getText());
                    if (rdbMale.isSelected()) {
                        pst.setBoolean(5, true);
                    } else {
                        pst.setBoolean(5, false);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(txtDate.getDate());
                    pst.setString(6, date);
                    pst.setString(7, txtDiaChi.getText());
                    pst.setString(8, txtSDT.getText());
                    pst.setString(9, txtEmail.getText());
                    pst.executeUpdate();
                    load_Profile();
                    load_dataProfile();//trước khi loadData cần sét số cột về 0 nếu không nó sẽ loadData lên bảng thêm 1 lần nữa
                    JOptionPane.showMessageDialog(null, "Lưu thành công!");
                    btnAdd.setEnabled(true);
                    dataEnabledButton();
                    reset();
                    loadDataCBBSearchID();
                    flag++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lưu không thành công!!!");
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtMaND.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã người dùng muốn xóa!");
            txtMaND.requestFocus();
            return;
        } else {
            try {
                pst = con.prepareStatement("Update NguoiDung set TaiKhoan=?,MatKhau=?, HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, SDT=?, Email=? where MaND=?");
                pst.setString(9, txtMaND.getText());
                pst.setString(1, txtTaiKhoan.getText());
                pst.setString(2, txtMatKhau.getText());
                pst.setString(3, txtHoTen.getText());
                if (rdbMale.isSelected()) {
                    pst.setBoolean(4, true);
                } else {
                    pst.setBoolean(4, false);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(txtDate.getDate());
                pst.setString(5, date);
                pst.setString(6, txtDiaChi.getText());
                pst.setString(7, txtSDT.getText());
                pst.setString(8, txtEmail.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
                btnAdd.setEnabled(true);
                load_Profile();
                load_dataProfile();
                dataEnabledButton();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!!");
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtMaND.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã người dùng muốn xóa!");
            txtMaND.requestFocus();
            return;
        } else {
            try {
                int row = 0;
                pst = con.prepareStatement("Delete from NguoiDung where MaND=?");
                pst.setString(1, txtMaND.getText());
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    btnAdd.setEnabled(true);
                    load_Profile();
                    load_dataProfile();
                    dataEnabledButton();
                    reset();
                    flag--;
                    loadDataCBBSearchID();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyPressed
        String phoneNumber = txtSDT.getText();

        int lenght = phoneNumber.length();

        //Kiểm tra số điện thoại 0 đến 9
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            //Kiểm tra độ dài không lớn hơn 10 số
            if (lenght <= 10) {
                txtSDT.setEditable(true);
                txtSDT.setBackground(Color.white);
            } else {
                txtSDT.setEditable(false);
                txtSDT.setBackground(Color.green);
            }
        } else {
            //Không cho phép "backsspace' và 'delete'
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtSDT.setEditable(true);
            } else {
                txtSDT.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtSDTKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        tbn = (DefaultTableModel) tblProfile.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(tbn);
        tblProfile.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfileMouseClicked
        current = tblProfile.getSelectedRow();
        show_frame(current);

        dataNotEnabledButton();
    }//GEN-LAST:event_tblProfileMouseClicked

    private void btnTaoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaActionPerformed
        reset();
        SinhMaBKT();
    }//GEN-LAST:event_btnTaoMaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dataNotEnabledButton();
        try {
            pst = con.prepareStatement("SELECT * FROM NguoiDung WHERE MaND=?");
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMaND.setText(rs.getString("MaND"));
                txtTaiKhoan.setText(rs.getString("TaiKhoan"));
                txtMatKhau.setText(rs.getString("MatKhau"));
                txtHoTen.setText(rs.getString("HoTen"));
                String gt = rs.getString("GioiTinh").trim();
                if (gt.equals("1")) {
                    rdbMale.setSelected(true);
                } else {
                    rdbFemale.setSelected(true);
                }
                try {
                    int srow = tblProfile.getSelectedRow();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((rs.getString("NgaySinh")));
                    txtDate.setDate(date);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                txtDiaChi.setText(rs.getString("DiaChi"));
                txtSDT.setText(rs.getString("SDT"));
                txtEmail.setText(rs.getString("Email"));
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!");
                dataEnabledButton();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            dataEnabledButton();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if (jCheckBox4.isSelected() == true) {
            txtMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void cbbSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchIDActionPerformed
        dataNotEnabledButton();
        txtSearch.setText("");
        try {
            pst = con.prepareStatement("Select * from NguoiDung where MaND=?");
            pst.setString(1, cbbSearchID.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMaND.setText(rs.getString("MaND"));
                txtTaiKhoan.setText(rs.getString("TaiKhoan"));
                txtMatKhau.setText(rs.getString("MatKhau"));
                txtHoTen.setText(rs.getString("HoTen"));
                String gt = rs.getString("GioiTinh").trim();
                if (gt.equals("1")) {
                    rdbMale.setSelected(true);
                } else {
                    rdbFemale.setSelected(true);
                }
                try {
                    int srow = tblProfile.getSelectedRow();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((rs.getString("NgaySinh")));
                    txtDate.setDate(date);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                txtDiaChi.setText(rs.getString("DiaChi"));
                txtSDT.setText(rs.getString("SDT"));
                txtEmail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cbbSearchIDActionPerformed

    //Đếm số lượng dòng bài kiểm tra
    public void getSumRow() {
        try {
            pst = con.prepareStatement("Select * from NguoiDung");
            rs = pst.executeQuery();

            while (rs.next()) {
                flag++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu mã người dùng!");
        }
    }

    //Sinh mã bài kiểm tra
    public void SinhMaBKT() {
        try {
            pst = con.prepareStatement("Select * from NguoiDung");
            rs = pst.executeQuery();

            int i = 1;
            while (rs.next()) {
                String checkMaBKT = rs.getString("MaND").trim();

                String temp = "";
                if (i < 10) {
                    temp = "EFK00" + i;
                } else {
                    temp = "EFK0" + i;
                }

                if (i < flag && !checkMaBKT.trim().equals(temp)) {
                    if (i < 10) {
                        MaND = "EFK00" + i;
                    } else {
                        MaND = "TV0" + i;
                    }
                    break;
                }
                i += 1;
                if (i == flag) {
                    if (i < 10) {
                        MaND = "EFK00" + i;
                    } else {
                        MaND = "EFK0" + i;
                    }
                }
            }
//            if (MaBKT.isEmpty()) {
//                MaBKT = "BKT0" + 1;
//            }
            txtMaND.setText(MaND);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu MaND!");
        }
    }

    public void show_frame(int current) {
        listProfile p = list.get(current);

        txtMaND.setText(p.getMaND());
        txtTaiKhoan.setText(p.getTaikhoan());
        txtMatKhau.setText(p.getMatKhau());
        txtHoTen.setText(p.getHoTen());
        boolean gt = p.isGioiTinh();
        if (gt == true) {
            rdbMale.setSelected(true);
            rdbMale.setText("Nam");
        } else {
            rdbFemale.setSelected(true);
            rdbFemale.setText("Nữ");
        }
        try {
            int srow = tblProfile.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) p.getNgaySinh());
            txtDate.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtDiaChi.setText(p.getDiaChi());
        txtSDT.setText(p.getSDT());
        txtEmail.setText(p.getEmail());
    }

    public void dataEnabledButton() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnReset.setEnabled(false);
        txtMaND.setEnabled(false);
        txtTaiKhoan.setEnabled(false);
        txtMatKhau.setEnabled(false);
        txtHoTen.setEnabled(false);
        rdbMale.setEnabled(false);
        rdbFemale.setEnabled(false);
        txtDate.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtSDT.setEnabled(false);
        txtEmail.setEnabled(false);
        btnTaoMa.setEnabled(false);
        jCheckBox4.setEnabled(false);
    }

    public void dataNotEnabledButton() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnReset.setEnabled(true);
        txtMaND.setEnabled(true);
        txtTaiKhoan.setEnabled(true);
        txtMatKhau.setEnabled(true);
        txtHoTen.setEnabled(true);
        rdbMale.setEnabled(true);
        rdbFemale.setEnabled(true);
        txtDate.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtSDT.setEnabled(true);
        txtEmail.setEnabled(true);
        btnTaoMa.setEnabled(true);
        jCheckBox4.setEnabled(true);
    }

    public void reset() {
        txtMaND.setText("");
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        txtHoTen.setText("");
        rdbMale.setSelected(false);
        rdbFemale.setSelected(false);
        txtDate.setDate(null);
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtSearch.setText("");
        txtMaND.setBackground(Color.white);
        txtTaiKhoan.setBackground(Color.white);
        txtMatKhau.setBackground(Color.white);
        txtSDT.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        cbbSearchID.setSelectedIndex(0);
    }

    private void hopleMaND(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where MaND = '" + txtMaND.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Mã ND này đã tồn tại!\n");
                txtMaND.setBackground(Color.green);
            } else {
                String MaND = txtMaND.getText().trim();
                //Mã ND phải gồm EFK và 3 chữ số
                String regex = "EFK\\d{3}";
                Pattern p = Pattern.compile(regex);
                //Matcher p = pattern.matcher(MaND);
                if (MaND.length() > 0) {
                    if (!MaND.matches(regex)) {
                        sb.append("Mã ND sai định dạng, Mã ND phải gồm EFK và 3 chữ số, VD: EFK001\n");
                        txtMaND.setBackground(Color.green);
                    } else {
                        txtMaND.setBackground(Color.white);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleTaiKhoan(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where TaiKhoan = '" + txtTaiKhoan.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Tài khoản này đã tồn tại!\n");
                txtTaiKhoan.setBackground(Color.green);
            } else {
                //.*[A-Z] : phải có ít nhất 1 ký tự viết hoa
                Pattern patternUpper = Pattern.compile("^.*[A-Z]+.*$");

                //.*[a-z] : phải có ít nhất 1 ký tự viết thường
                Pattern patternLower = Pattern.compile("^.*[a-z]+.*$");

                //.*[0-9] : phải có ít nhất 1 ký tự số
                Pattern patternDigit = Pattern.compile("^.*[0-9]+.*$");

                //.*[#?!@$%^&*-] : phải có ít nhất 1 ký tự đặc biệt
                Pattern patternSpecial = Pattern.compile("^.*[#?!@$%^&*-]+.*$");

                //.*[#?!@$%^&*-] : phải có ít nhất 8 ký tự 
                Pattern patternLenght = Pattern.compile("^.*{8,}+.*$");

                String account = txtTaiKhoan.getText();

                if (patternUpper.matcher(account).find() || patternLower.matcher(account).find()
                        || patternDigit.matcher(account).find() || patternSpecial.matcher(account).find()
                        || patternLenght.matcher(account).find()) {
                    txtTaiKhoan.setBackground(Color.white);
                } else {
                    sb.append("Nhập lại tài khoản!.");
                    txtTaiKhoan.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleMatKhau(StringBuilder sb) {
        //.*[A-Z] : phải có ít nhất 1 ký tự viết hoa
        Pattern patternUpper = Pattern.compile("^.*[A-Z]+.*$");

        //.*[a-z] : phải có ít nhất 1 ký tự viết thường
        Pattern patternLower = Pattern.compile("^.*[a-z]+.*$");

        //.*[0-9] : phải có ít nhất 1 ký tự số
        Pattern patternDigit = Pattern.compile("^.*[0-9]+.*$");

        //.*[#?!@$%^&*-] : phải có ít nhất 1 ký tự đặc biệt
        Pattern patternSpecial = Pattern.compile("^.*[#?!@$%^&*-]+.*$");

        //.*[#?!@$%^&*-] : phải có ít nhất 8 ký tự 
        Pattern patternLenght = Pattern.compile("^.*{8}+.*$");

        String password = txtMatKhau.getText();

        if (patternLenght.matcher(password).find()) {
            txtMatKhau.setBackground(Color.white);
        } else {
            sb.append("Nhập lại mật khẩu! Mật khẩu phải có 8 ký tự phân biệt. VD:admin123\n");
            txtMatKhau.setBackground(Color.green);
        }
    }

    private void hopleSDT(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where SDT = '" + txtSDT.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Số điện thoại này đã tồn tại!\n");
                txtSDT.setBackground(Color.green);
            } else {
                String sdt = txtSDT.getText();
                Pattern p = Pattern.compile("^[0-9]{10}$");
                if (p.matcher(sdt).find()) {
                    txtSDT.setBackground(Color.white);
                } else {
                    sb.append("Số điện thoại không hợp lệ, phải gồm 10 chữ số, VD: 0123456789\n");
                    txtSDT.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleEmail(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where Email = '" + txtEmail.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Email này đã tồn tại!\n");
                txtEmail.setBackground(Color.green);
            } else {
                String email = txtEmail.getText();
                //[a-zA-Z] : bắt đầu phải là 1 ký tự chữ hoa hoặc thường
                //[a-zA-Z0-9]+ : sau ký tự đầu tiên chữ hoặc số đều được và được viết nhiều lần
                //(\\.[a-zA-Z]+)+ : một cụm có 1 hoặc ký tự ".com" hoặc ".com.vn" ddcuuocwjj lặp lại nhiều lần
                Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
                if (p.matcher(email).find()) {
                    txtEmail.setBackground(Color.white);
                } else {
                    sb.append("Email không hợp lệ, ký tự đầu tiên phải là chữ. VD: hn12345.gmail.com, tuan123ct@student.ctu.edu.vn\n");
                    txtEmail.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Option;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoMa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSearchID;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblMaNguoiDung;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTable tblProfile;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaND;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
