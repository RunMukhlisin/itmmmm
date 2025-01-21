package Kepegawaian.Frame;

import Kepegawaian.PopUp.PopUpPegawai;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Revaldo
 */
public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_main1 = new javax.swing.JPanel();
        pn_line1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pn_kanan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_dasar = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();
        pn_kiri = new javax.swing.JPanel();
        pn_main2 = new javax.swing.JPanel();
        pn_line2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        pn_main4 = new javax.swing.JPanel();
        pn_line4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnBagian = new javax.swing.JLabel();
        pn_main5 = new javax.swing.JPanel();
        pn_line5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnJabatan = new javax.swing.JLabel();
        pn_main6 = new javax.swing.JPanel();
        pn_line6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        pn_main7 = new javax.swing.JPanel();
        pn_line7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnKategori1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        pn_main1.setBackground(new java.awt.Color(255, 255, 255));

        pn_line1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line1Layout = new javax.swing.GroupLayout(pn_line1);
        pn_line1.setLayout(pn_line1Layout);
        pn_line1Layout.setHorizontalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line1Layout.setVerticalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel2");

        jLabel5.setText("Data Pegawai");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pn_main1Layout = new javax.swing.GroupLayout(pn_main1);
        pn_main1.setLayout(pn_main1Layout);
        pn_main1Layout.setHorizontalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_main1Layout.setVerticalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ITM Super Apps");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/itmlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_kanan.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pn_dasar.setBackground(new java.awt.Color(204, 204, 204));

        pn_utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_utama.setLayout(new java.awt.BorderLayout());

        pn_kiri.setBackground(new java.awt.Color(255, 255, 255));

        pn_main2.setBackground(new java.awt.Color(255, 255, 255));

        pn_line2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line2Layout = new javax.swing.GroupLayout(pn_line2);
        pn_line2.setLayout(pn_line2Layout);
        pn_line2Layout.setHorizontalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line2Layout.setVerticalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/owner.png"))); // NOI18N

        btnPegawai.setBackground(new java.awt.Color(255, 255, 255));
        btnPegawai.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnPegawai.setForeground(new java.awt.Color(0, 0, 102));
        btnPegawai.setText("Pegawai");
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main2Layout = new javax.swing.GroupLayout(pn_main2);
        pn_main2.setLayout(pn_main2Layout);
        pn_main2Layout.setHorizontalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main2Layout.setVerticalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_main4.setBackground(new java.awt.Color(255, 255, 255));

        pn_line4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line4Layout = new javax.swing.GroupLayout(pn_line4);
        pn_line4.setLayout(pn_line4Layout);
        pn_line4Layout.setHorizontalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line4Layout.setVerticalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/two-arrow.png"))); // NOI18N

        btnBagian.setBackground(new java.awt.Color(255, 255, 255));
        btnBagian.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnBagian.setForeground(new java.awt.Color(0, 0, 102));
        btnBagian.setText("Bagian");
        btnBagian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBagianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBagianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBagianMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main4Layout = new javax.swing.GroupLayout(pn_main4);
        pn_main4.setLayout(pn_main4Layout);
        pn_main4Layout.setHorizontalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBagian, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main4Layout.setVerticalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBagian, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_main5.setBackground(new java.awt.Color(255, 255, 255));

        pn_line5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line5Layout = new javax.swing.GroupLayout(pn_line5);
        pn_line5.setLayout(pn_line5Layout);
        pn_line5Layout.setHorizontalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line5Layout.setVerticalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/street-map.png"))); // NOI18N

        btnJabatan.setBackground(new java.awt.Color(255, 255, 255));
        btnJabatan.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnJabatan.setForeground(new java.awt.Color(0, 0, 102));
        btnJabatan.setText("Jabatan");
        btnJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJabatanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnJabatanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnJabatanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main5Layout = new javax.swing.GroupLayout(pn_main5);
        pn_main5.setLayout(pn_main5Layout);
        pn_main5Layout.setHorizontalGroup(
            pn_main5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main5Layout.setVerticalGroup(
            pn_main5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_main6.setBackground(new java.awt.Color(255, 255, 255));

        pn_line6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line6Layout = new javax.swing.GroupLayout(pn_line6);
        pn_line6.setLayout(pn_line6Layout);
        pn_line6Layout.setHorizontalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line6Layout.setVerticalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/dashboard (1).png"))); // NOI18N

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(0, 0, 102));
        btnDashboard.setText("Dashboard");
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main6Layout = new javax.swing.GroupLayout(pn_main6);
        pn_main6.setLayout(pn_main6Layout);
        pn_main6Layout.setHorizontalGroup(
            pn_main6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main6Layout.setVerticalGroup(
            pn_main6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_main7.setBackground(new java.awt.Color(255, 255, 255));

        pn_line7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_line7Layout = new javax.swing.GroupLayout(pn_line7);
        pn_line7.setLayout(pn_line7Layout);
        pn_line7Layout.setHorizontalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        pn_line7Layout.setVerticalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconkepegawaian/category.png"))); // NOI18N

        btnKategori1.setBackground(new java.awt.Color(255, 255, 255));
        btnKategori1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnKategori1.setForeground(new java.awt.Color(0, 0, 102));
        btnKategori1.setText("Kategori");
        btnKategori1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKategori1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKategori1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKategori1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main7Layout = new javax.swing.GroupLayout(pn_main7);
        pn_main7.setLayout(pn_main7Layout);
        pn_main7Layout.setHorizontalGroup(
            pn_main7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKategori1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_main7Layout.setVerticalGroup(
            pn_main7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_main7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_line7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKategori1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pn_main2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_main4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_main5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_main6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_main7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pn_main6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_main7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_main4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_main5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_main2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_utama, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pn_kiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_kanan.add(pn_dasar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pn_kanan, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
        pn_main2.setBackground(new Color(240,240,240));
        pn_line2.setBackground(new Color(0,153,255));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuPegawai());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnPegawaiMouseClicked

    private void btnPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseEntered
        pn_main2.setBackground(new Color(250,250,250));
        pn_line2.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnPegawaiMouseEntered

    private void btnPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseExited
        pn_main2.setBackground(new Color(255,255,255));
        pn_line2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPegawaiMouseExited

    private void btnBagianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBagianMouseClicked
        pn_main4.setBackground(new Color(240,240,240));
        pn_line4.setBackground(new Color(0,153,255));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuBagian());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnBagianMouseClicked

    private void btnBagianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBagianMouseEntered
        pn_main4.setBackground(new Color(250,250,250));
        pn_line4.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnBagianMouseEntered

    private void btnBagianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBagianMouseExited
        pn_main4.setBackground(new Color(255,255,255));
        pn_line4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnBagianMouseExited

    private void btnJabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJabatanMouseClicked
        pn_main5.setBackground(new Color(240,240,240));
        pn_line5.setBackground(new Color(0,153,255));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuJabatan());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnJabatanMouseClicked

    private void btnJabatanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJabatanMouseEntered
        pn_main5.setBackground(new Color(250,250,250));
        pn_line5.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnJabatanMouseEntered

    private void btnJabatanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJabatanMouseExited
        pn_main5.setBackground(new Color(255,255,255));
        pn_line5.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnJabatanMouseExited

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        pn_main6.setBackground(new Color(240,240,240));
        pn_line6.setBackground(new Color(0,153,255));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseEntered
        pn_main6.setBackground(new Color(250,250,250));
        pn_line6.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnDashboardMouseEntered

    private void btnDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseExited
        pn_main6.setBackground(new Color(255,255,255));
        pn_line6.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnDashboardMouseExited

    private void btnKategori1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategori1MouseClicked
        pn_main7.setBackground(new Color(240,240,240));
        pn_line7.setBackground(new Color(0,153,255));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuKategori());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnKategori1MouseClicked

    private void btnKategori1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategori1MouseEntered
        pn_main7.setBackground(new Color(250,250,250));
        pn_line7.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnKategori1MouseEntered

    private void btnKategori1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategori1MouseExited
        pn_main7.setBackground(new Color(255,255,255));
        pn_line7.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnKategori1MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pn_utama.add(new MenuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("TextComponent.arc", 15);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBagian;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnJabatan;
    private javax.swing.JLabel btnKategori1;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kiri;
    private javax.swing.JPanel pn_line1;
    private javax.swing.JPanel pn_line2;
    private javax.swing.JPanel pn_line4;
    private javax.swing.JPanel pn_line5;
    private javax.swing.JPanel pn_line6;
    private javax.swing.JPanel pn_line7;
    private javax.swing.JPanel pn_main1;
    private javax.swing.JPanel pn_main2;
    private javax.swing.JPanel pn_main4;
    private javax.swing.JPanel pn_main5;
    private javax.swing.JPanel pn_main6;
    private javax.swing.JPanel pn_main7;
    public static javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
