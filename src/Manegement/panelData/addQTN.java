/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.panelData;

import Manegement.classData.listQ;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import user.Connect;

/**
 *
 * @author HP
 */
public class addQTN extends javax.swing.JPanel {

    //final String col[] = {"MÃ CHTN", "CÂU HỎI TN", "ĐÁP ÁN A", "ĐÁP ÁN B", "ĐÁP ÁN C", "ĐÁP ÁN D", "HÌNH ẢNH", "CÂU TRẢ LỜI", "TÊN CHỦ ĐỀ", "MÃ TV"};
    //final DefaultTableModel tbn = new DefaultTableModel(col, 0);
    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    String MaCHTN = "";
    int flag = 1;

    public addQTN() {
        initComponents();
        getSumRow();
        load_dataCHTN();
        loadDataCBBTopic();
        loadDataCBBMaTV();
    }

    public void loadDataCBBTopic() {
        try {
            pst = con.prepareStatement("Select TenChuDe from ChuDe");
            rs = pst.executeQuery();

            while (rs.next()) {
                cbbTopic.addItem(rs.getString("TenChuDe"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy tên chủ đề!");
        }
    }

    public void loadDataCBBMaTV() {
        try {
            pst = con.prepareStatement("Select MaTV from TuVung");
            rs = pst.executeQuery();

            while (rs.next()) {
                cbbMaTV.addItem(rs.getString("MaTV"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy mã từ vựng!");
        }
    }

    public ArrayList<listQ> listQuestionManagement() {
        ArrayList<listQ> adList = new ArrayList<>();
        try {
            String url = "Select * from CauHoiTN";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listQ data;
            while (rs.next()) {
                //data = new listQ(rs.getString("ID_Question"), rs.getString("Question"), rs.getString("Option1"), rs.getString("Option2"), rs.getString("Option3"), rs.getString("Option4"), rs.getBytes("Image"), rs.getString("Answer"), rs.getString("Level"));
                data = new listQ(rs.getString("MaCHTN"), rs.getString("CauHoi"), rs.getString("DapAnA"), rs.getString("DapAnB"), rs.getString("DapAnC"), rs.getString("DapAnD"),
                        rs.getBytes("HinhAnh"), rs.getString("CauTraLoi"), rs.getString("TenChuDe"), rs.getString("MaTV"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy dữ liệu!");
        }
        return adList;
    }

    public void load_dataCHTN() {
        ArrayList<listQ> list = listQuestionManagement();
        tbn = (DefaultTableModel) tblListQuestion.getModel();
        tbn.setRowCount(0);
        for (listQ i : list) {
            tbn.addRow(new Object[]{i.getMaCHTN(), i.getCHTN(), i.getOption1(), i.getOption2(), i.getOption3(), i.getOption4(), i.getImage(), i.getAnswer(), i.getTopic(), i.getMaTV()});
        }

        JTableHeader Theader = tblListQuestion.getTableHeader();

        Theader.setBackground(new Color(18, 16, 14));
        Theader.setForeground(Color.black);

        Theader.setFont(new Font("Roboto", Font.BOLD, 17));
        ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        tblListQuestion.setFont(new Font("Roboto", Font.PLAIN, 17));
        tblListQuestion.setSelectionBackground(new Color(59, 89, 152));
        tblListQuestion.setSelectionForeground(Color.white);

        dataEnabledButton();
        reset();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        txtOption2 = new javax.swing.JTextField();
        txtOption3 = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblImg = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnChooseImage = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIDQuestion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbTopic = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbMaTV = new javax.swing.JComboBox<>();
        btnTaoMa = new javax.swing.JButton();
        Bottom = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListQuestion = new javax.swing.JTable();

        setBorder(null);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1392, 812));
        setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(1390, 100));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BẢNG DỮ LIỆU CÂU HỎI TRẮC NGHIỆM");
        Header.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 100));

        jSeparator2.setBackground(new java.awt.Color(0, 120, 255));
        jSeparator2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator2.setOpaque(true);
        Header.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 300, 5));

        add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(252, 204, 99));
        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nội dung câu hỏi");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nội dung đáp án");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("A");
        jLabel4.setPreferredSize(new java.awt.Dimension(13, 35));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("B");
        jLabel5.setPreferredSize(new java.awt.Dimension(13, 35));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("C");
        jLabel6.setPreferredSize(new java.awt.Dimension(13, 35));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("D");
        jLabel7.setPreferredSize(new java.awt.Dimension(13, 35));

        txtOption1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtOption2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtOption3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtOption4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Đáp án");

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane2.setViewportView(txtQuestion);

        lblImg.setBackground(new java.awt.Color(255, 255, 255));
        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblImg.setOpaque(true);

        txtAnswer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3844432_magnifier_search_zoom_icon.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        btnAdd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/34237_+_add_plus_icon.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setPreferredSize(new java.awt.Dimension(160, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnSave.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/285657_floppy_guardar_save_icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(160, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnEdit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/17009_arrows_exchange_interact_refresh_reload_icon.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setPreferredSize(new java.awt.Dimension(160, 40));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/34218_add_cross_delete_exit_remove_icon.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(160, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnChooseImage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/211677_image_icon.png"))); // NOI18N
        btnChooseImage.setText("Tải ảnh");
        btnChooseImage.setPreferredSize(new java.awt.Dimension(160, 40));
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });
        jPanel1.add(btnChooseImage);

        btnReset.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9855519_reset_reload_sync_update_icon.png"))); // NOI18N
        btnReset.setText("Làm sạch");
        btnReset.setPreferredSize(new java.awt.Dimension(160, 40));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Mã câu hỏi");

        txtIDQuestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Tên chủ đề");

        cbbTopic.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbbTopic.setMaximumRowCount(5);
        cbbTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTopicActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Mã từ vựng");

        cbbMaTV.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbbMaTV.setMaximumRowCount(5);
        cbbMaTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn MaTV ----" }));
        cbbMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaTVActionPerformed(evt);
            }
        });

        btnTaoMa.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnTaoMa.setText("Tạo mã");
        btnTaoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addComponent(cbbMaTV, 0, 252, Short.MAX_VALUE)
                                        .addGap(28, 28, 28)))
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtIDQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(MainLayout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                                        .addComponent(btnTaoMa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addComponent(jLabel1))
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTaoMa)))
                                    .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(txtIDQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        add(Main, java.awt.BorderLayout.CENTER);

        Bottom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Bottom.setPreferredSize(new java.awt.Dimension(1200, 300));
        Bottom.setLayout(new java.awt.BorderLayout());

        tblListQuestion.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tblListQuestion.setForeground(new java.awt.Color(0, 0, 0));
        tblListQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ CHTN", "CÂU HỎI", "ĐÁP ÁN A", "ĐÁP ÁN B", "ĐÁP ÁN C", "ĐÁP ÁN D", "HÌNH ẢNH", "CÂU TRẢ LỜI", "TÊN CHỦ ĐỀ", "MÃ TV"
            }
        ));
        tblListQuestion.setRowHeight(40);
        tblListQuestion.setRowMargin(5);
        tblListQuestion.setShowHorizontalLines(true);
        tblListQuestion.setShowVerticalLines(true);
        tblListQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListQuestionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListQuestion);

        Bottom.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        add(Bottom, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            if (txtIDQuestion.getText().equals("") || txtQuestion.getText().equals("") || txtOption1.getText().equals("") || txtOption2.getText().equals("")
                    || txtOption3.getText().equals("") || txtOption4.getText().equals("") || txtAnswer.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không được bỏ trống!");
            } else {
                hopleMaCHTN(sb);
                if (sb.length() > 0) { //nếu if trên đúng nó sẽ thêm vào sb 1 đoạn string, ktra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo
                    JOptionPane.showMessageDialog(this, sb.toString());
                } else {
                    String url = "insert into CauHoiTN values (?,?,?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(url);
                    pst.setString(1, txtIDQuestion.getText());
                    pst.setString(2, txtQuestion.getText());
                    pst.setString(3, txtOption1.getText());
                    pst.setString(4, txtOption2.getText());
                    pst.setString(5, txtOption3.getText());
                    pst.setString(6, txtOption4.getText());
                    pst.setBytes(7, img_DATA);
                    pst.setString(8, txtAnswer.getText());
                    pst.setString(9, cbbTopic.getSelectedItem().toString());
                    pst.setString(10, cbbMaTV.getSelectedItem().toString());
                    pst.executeUpdate();
                    load_dataCHTN();
                    dataEnabledButton();
                    reset();
                    flag++;
                    JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtIDQuestion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chọn mã cần sửa nội dung!");
        } else {
            try {
                pst = con.prepareStatement("Update CauHoiTN set CauHoi=?,DapAnA=?,DapAnB=?,DapAnC=?,DapAnD=?,HinhAnh=?,CauTraLoi=?,TenChuDe=?, MaTV=? where MaCHTN=?");
                pst.setString(10, txtIDQuestion.getText());
                pst.setString(1, txtQuestion.getText());
                pst.setString(2, txtOption1.getText());
                pst.setString(3, txtOption2.getText());
                pst.setString(4, txtOption3.getText());
                pst.setString(5, txtOption4.getText());
                pst.setBytes(6, img_DATA);
                pst.setString(7, txtAnswer.getText());
                pst.setString(8, cbbTopic.getSelectedItem().toString());
                pst.setString(9, cbbMaTV.getSelectedItem().toString());
                pst.executeUpdate();
                load_dataCHTN();
                dataEnabledButton();
                reset();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        JFileChooser fBuild = new JFileChooser("C:\\Java-JSP\\duan9\\src\\img\\Vocabulary");

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.Image", "jpg", "png");
        fBuild.addChoosableFileFilter(fnef);

        int result = fBuild.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = fBuild.getSelectedFile();
            fPath = f.getAbsolutePath();
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(fPath).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(ResizeImage(fPath));
        }

        try {
            File image = new File(fPath);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            img_DATA = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblListQuestion.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtIDQuestion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã câu hỏi trắc nghiệm cần xóa!");
        } else {
            try {
                pst = con.prepareStatement("Delete CauHoiTN where MaCHTN=?");
                pst.setString(1, tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 0).toString());
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    load_dataCHTN();
                    dataEnabledButton();
                    reset();
                    flag--;
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbbMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaTVActionPerformed
        txtSearch.setText("");
        try {
            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIDQuestion.setText(rs.getString("MaCHTN"));
                txtQuestion.setText(rs.getString("CauHoi"));
                byte[] img = rs.getBytes("HinhAnh");
                cbbTopic.setSelectedItem(rs.getString("TenChuDe"));
                txtOption1.setText(rs.getString("DapAnA"));
                txtOption2.setText(rs.getString("DapAnB"));
                txtOption3.setText(rs.getString("DapAnC"));
                txtOption4.setText(rs.getString("DapAnD"));
                txtAnswer.setText(rs.getString("CauTraLoi"));
                cbbTopic.setSelectedItem(rs.getString("TenChuDe"));
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            } else {
                txtIDQuestion.setText("");
                txtQuestion.setText("");
                txtOption1.setText("");
                txtOption2.setText("");
                txtOption3.setText("");
                txtOption4.setText("");
                pst = con.prepareStatement("SELECT * FROM TuVung WHERE MaTV=?");
                pst.setString(1, cbbMaTV.getSelectedItem().toString());
                rs = pst.executeQuery();
                if (rs.next()) {
                    byte[] img = rs.getBytes("HinhAnh");
                    txtAnswer.setText(rs.getString("TuVung"));
                    cbbTopic.setSelectedItem(rs.getString("TenChuDe"));
                    ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                    lblImg.setIcon(imgIcon);
                    img_DATA = img;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_cbbMaTVActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dataNotEnabledButton();
        try {
            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE MaCHTN=?");
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIDQuestion.setText(rs.getString("MaCHTN"));
                txtQuestion.setText(rs.getString("CauHoi"));
                txtOption1.setText(rs.getString("DapAnA"));
                txtOption2.setText(rs.getString("DapAnB"));
                txtOption3.setText(rs.getString("DapAnC"));
                txtOption4.setText(rs.getString("DapAnD"));
                byte[] img = rs.getBytes("HinhAnh");
                txtAnswer.setText(rs.getString("CauTraLoi"));
                cbbTopic.setSelectedItem(rs.getString("TenChuDe"));
                cbbMaTV.setSelectedItem(rs.getString("MaTV"));
                
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!");
                dataEnabledButton();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbbTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTopicActionPerformed
//        try {
//            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE TenChuDe=?");
//            pst.setString(1, cbbTopic.getSelectedItem().toString());
//            rs = pst.executeQuery();
//            cbbMaTV.setSelectedIndex(0);
//            while (rs.next()) {
//                txtIDQuestion.setText(rs.getString("MaCHTN"));
//                txtQuestion.setText(rs.getString("CauHoi"));
//                byte[] img = rs.getBytes("HinhAnh");
//                cbbMaTV.addItem(rs.getString("MaTV"));
//                txtOption1.setText(rs.getString("DapAnA"));
//                txtOption2.setText(rs.getString("DapAnB"));
//                txtOption3.setText(rs.getString("DapAnC"));
//                txtOption4.setText(rs.getString("DapAnD"));
//                txtAnswer.setText(rs.getString("CauTraLoi"));
//                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
//                lblImg.setIcon(imgIcon);
//                img_DATA = img;
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
    }//GEN-LAST:event_cbbTopicActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dataNotEnabledButton();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblListQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListQuestionMouseClicked
        int i = tblListQuestion.getSelectedRow();
        TableModel model = tblListQuestion.getModel();

        txtIDQuestion.setText(model.getValueAt(i, 0).toString());
        txtQuestion.setText(model.getValueAt(i, 1).toString());
        txtOption1.setText(model.getValueAt(i, 2).toString());
        txtOption2.setText(model.getValueAt(i, 3).toString());
        txtOption3.setText(model.getValueAt(i, 4).toString());
        txtOption4.setText(model.getValueAt(i, 5).toString());
        byte[] img = (listQuestionManagement().get(i).getImage());
        ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
        lblImg.setIcon(imgIcon);
        img_DATA = img;
        txtAnswer.setText(model.getValueAt(i, 7).toString());
        cbbTopic.setSelectedItem(model.getValueAt(i, 8).toString());
        cbbMaTV.setSelectedItem(model.getValueAt(i, 9).toString());

        dataNotEnabledButton();
    }//GEN-LAST:event_tblListQuestionMouseClicked

    private void btnTaoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaActionPerformed
        SinhMaBKT();
    }//GEN-LAST:event_btnTaoMaActionPerformed

    //Đếm số lượng dòng bài kiểm tra
    public void getSumRow() {
        try {
            pst = con.prepareStatement("Select * from CauHoiTN");
            rs = pst.executeQuery();

            while (rs.next()) {
                flag++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu mã câu hỏi trắc nghiệm!");
        }
    }

    //Sinh mã bài kiểm tra
    public void SinhMaBKT() {
        try {
            pst = con.prepareStatement("Select * from CauHoiTN");
            rs = pst.executeQuery();

            int i = 1;
            while (rs.next()) {
                String checkMaBKT = rs.getString("MaCHTN");

                String temp = "";
                if (i < 10) {
                    temp = "TN00" + i;
                } else {
                    temp = "TN0" + i;
                }

                if (i < flag - 1 && !checkMaBKT.trim().equals(temp)) {
                    if (i < 10) {
                        MaCHTN = "TN00" + i;
                    } else {
                        MaCHTN = "TN0" + i;
                    }
                    break;
                }
                i += 1;
                if (i == flag) {
                    if (i < 10) {
                        MaCHTN = "TN00" + i;
                    } else {
                        MaCHTN = "TN0" + i;
                    }
                }
            }
//            if (MaBKT.isEmpty()) {
//                MaBKT = "BKT0" + 1;
//            }
            txtIDQuestion.setText(MaCHTN);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu MaCHTN!");
        }
    }

    private void hopleMaCHTN(StringBuilder sb) {
        try {
            String check_url = "Select * from CauHoiTN where MaCHTN = '" + txtIDQuestion.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Mã câu hỏi trắc nghiệm này đã tồn tại!\n");
                txtIDQuestion.setBackground(Color.green);
            } else {
                String MaCHTN = txtIDQuestion.getText().trim();
                //Mã ND phải gồm EFK và 3 chữ số
                String regex = "TN\\d{3}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(MaCHTN);
                if (!matcher.find()) {
                    sb.append("Mã câu hỏi trắc nghiệm sai định dạng, Mã câu hỏi trắc nghiệm phải gồm TN và 3 chữ số, VD: TN001\n");
                    txtIDQuestion.setBackground(Color.green);
                } else {
                    txtIDQuestion.setBackground(Color.white);
                }
            }
        } catch (Exception e) {
        }
    }

    public void dataEnabledButton() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnReset.setEnabled(false);
        btnChooseImage.setEnabled(false);
        txtIDQuestion.setEnabled(false);
        txtQuestion.setEnabled(false);
        cbbMaTV.setEnabled(false);
        cbbTopic.setEnabled(false);
        txtOption1.setEnabled(false);
        txtOption2.setEnabled(false);
        txtOption3.setEnabled(false);
        txtOption4.setEnabled(false);
        txtAnswer.setEnabled(false);
        lblImg.setEnabled(false);
        btnTaoMa.setEnabled(false);
    }

    public void dataNotEnabledButton() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnReset.setEnabled(true);
        btnChooseImage.setEnabled(true);
        txtIDQuestion.setEnabled(true);
        txtQuestion.setEnabled(true);
        cbbMaTV.setEnabled(true);
        cbbTopic.setEnabled(true);
        txtOption1.setEnabled(true);
        txtOption2.setEnabled(true);
        txtOption3.setEnabled(true);
        txtOption4.setEnabled(true);
        txtAnswer.setEnabled(true);
        lblImg.setEnabled(true);
        btnTaoMa.setEnabled(true);
    }

    public void reset() {
        txtIDQuestion.setText("");
        cbbMaTV.setSelectedIndex(0);
        cbbTopic.setSelectedIndex(-1);
        txtAnswer.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        lblImg.setIcon(null);
        txtQuestion.setText("");
        txtSearch.setText("");
        
        txtIDQuestion.setBackground(Color.white);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoMa;
    private javax.swing.JComboBox<String> cbbMaTV;
    private javax.swing.JComboBox<String> cbbTopic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tblListQuestion;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtIDQuestion;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
