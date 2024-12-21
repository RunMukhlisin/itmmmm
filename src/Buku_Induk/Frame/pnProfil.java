/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Buku_Induk.Frame;

import Class.mahasiswa;
import static Main.menuBukuinduk.ContenPanel;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;

public class pnProfil extends javax.swing.JPanel {

    public pnProfil() {
        initComponents();
        loadProfil();
    }

    void loadProfil() {
        JSONArray data = mahasiswa.getDataMhs();
        for (int i = 0; i < data.length(); i++) {
            JSONObject item = data.getJSONObject(i);
            if (i == mahasiswa.getBaris()) {
                tNim.setText(item.getString("mhs_nim"));
                tNama.setText(item.getString("mhs_nama"));
                tJk.setText(item.getString("mhs_jk"));
                tTtl.setText(item.getString("mhs_tempatlahir") + ", " + item.getString("mhs_tanggallahir"));
                tEmail.setText(item.getString("mhs_email"));
                tHp.setText(item.getString("mhs_hp"));
                if (item.has("mhs_foto") && !item.isNull("mhs_foto")) {
                    ImageIcon image = mahasiswa.base64ToImage(item.getString("mhs_foto"), tFoto.getWidth(), tFoto.getHeight());
                    tFoto.setIcon(image);
                    tFoto.setText(null); 
                } else {
                    tFoto.setText("Foto tidak tersedia");
                    tFoto.setIcon(null); 
                }
            }
        }

    }

    void updateButton() {
        bRevouse.setEnabled(mahasiswa.getBaris() > 0);
        bNext.setEnabled(mahasiswa.getBaris() < mahasiswa.getDataMhs().length() - 1);
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
        bClose = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bRevouse = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bNext = new javax.swing.JButton();
        tNim = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tTtl = new javax.swing.JTextField();
        tHp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tFoto = new javax.swing.JLabel();
        tNama = new javax.swing.JLabel();
        tJk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bClose.setBackground(new java.awt.Color(2, 154, 170));
        bClose.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bClose.setForeground(new java.awt.Color(255, 255, 255));
        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 154, 170));
        jLabel5.setText("Jenis Kelamin");

        bRevouse.setBackground(new java.awt.Color(2, 154, 170));
        bRevouse.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bRevouse.setForeground(new java.awt.Color(255, 255, 255));
        bRevouse.setText("Revouse");
        bRevouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevouseActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 154, 170));
        jLabel9.setText("No Hp");
        jLabel9.setToolTipText("");

        bNext.setBackground(new java.awt.Color(2, 154, 170));
        bNext.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bNext.setForeground(new java.awt.Color(255, 255, 255));
        bNext.setText("Next");
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });

        tNim.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tNim.setForeground(new java.awt.Color(2, 154, 170));
        tNim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tNim.setText("NIM");

        jLabel8.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 154, 170));
        jLabel8.setText("Email");

        tTtl.setEditable(false);
        tTtl.setBackground(new java.awt.Color(255, 255, 255));
        tTtl.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tTtl.setForeground(new java.awt.Color(2, 154, 170));

        tHp.setEditable(false);
        tHp.setBackground(new java.awt.Color(255, 255, 255));
        tHp.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tHp.setForeground(new java.awt.Color(2, 154, 170));

        jLabel6.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 154, 170));
        jLabel6.setText("Tempat Tanggal Lahir");

        tEmail.setEditable(false);
        tEmail.setBackground(new java.awt.Color(255, 255, 255));
        tEmail.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tEmail.setForeground(new java.awt.Color(2, 154, 170));
        tEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DM Sans SemiBold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 154, 170));
        jLabel1.setText("Buku Induk > Mahasiswa > Profil");

        tFoto.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tFoto.setText("Foto");
        tFoto.setToolTipText("");
        tFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tNama.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tNama.setForeground(new java.awt.Color(2, 154, 170));
        tNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tNama.setText("NAMA");

        tJk.setEditable(false);
        tJk.setBackground(new java.awt.Color(255, 255, 255));
        tJk.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tJk.setForeground(new java.awt.Color(2, 154, 170));

        jLabel2.setFont(new java.awt.Font("DM Sans ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 154, 170));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bRevouse)
                                .addGap(18, 18, 18)
                                .addComponent(bNext)
                                .addGap(18, 18, 18)
                                .addComponent(bClose))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(83, 83, 83))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tHp, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tTtl, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(tJk, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))))))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tJk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tTtl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(tHp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRevouse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        ContenPanel.removeAll();
        ContenPanel.add(new pnMahasiswa());
        ContenPanel.revalidate();
        ContenPanel.repaint();
    }//GEN-LAST:event_bCloseActionPerformed

    private void bRevouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevouseActionPerformed
        if (mahasiswa.getBaris() > 0) {
            mahasiswa.setBaris(mahasiswa.getBaris() - 1);
            loadProfil();
            updateButton();
        }
    }//GEN-LAST:event_bRevouseActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        if (mahasiswa.getBaris() >= 0 && mahasiswa.getBaris() <= mahasiswa.getDataMhs().length()) {
            mahasiswa.setBaris(mahasiswa.getBaris() + 1);
            loadProfil();
            updateButton();
        }
    }//GEN-LAST:event_bNextActionPerformed

    private void tEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bNext;
    private javax.swing.JButton bRevouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tEmail;
    private javax.swing.JLabel tFoto;
    private javax.swing.JTextField tHp;
    private javax.swing.JTextField tJk;
    private javax.swing.JLabel tNama;
    private javax.swing.JLabel tNim;
    private javax.swing.JTextField tTtl;
    // End of variables declaration//GEN-END:variables
}
