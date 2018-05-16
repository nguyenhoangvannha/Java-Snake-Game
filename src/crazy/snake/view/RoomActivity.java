/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazy.snake.view;

import crazy.snake.controller.ColorHelper;
import crazy.snake.model.Player;
import crazy.snake.model.Room;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author naco
 */
public class RoomActivity extends javax.swing.JDialog {

    int countDownTime = 10;
    Room room = new Room();
    int[] arrayRefVar = {1, 2, 3};
    ArrayList<JLabel> labelsName;
    ArrayList<JLabel> labelsOwner;

    /**
     * Creates new form RoomActivity
     */
    public RoomActivity(java.awt.Frame parent, boolean modal, int roomID, Player player) {
        super(parent, modal);
        initComponents();
        customizeUI();
        room.setID(roomID);
        if (room.getPlayers().size() < 1) {
            room.setOwner(player);
            labelsName.get(0).setText(player.getUserName());
            labelsOwner.get(0).setText("Admin");
        } else {
            if(room.getPlayers().size() > 3){
                DialogUtils.showWarning(this, "Error", "This room is already full");
            } else {
                labelsName.get(room.getPlayers().size()).setText(player.getUserName());
                labelsOwner.get(room.getPlayers().size()).setForeground(Color.GREEN);
                labelsOwner.get(room.getPlayers().size()).setText("You");
            }
        }
        room.getPlayers().add(player);
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPlayer = new javax.swing.JPanel();
        pnPlayer1 = new javax.swing.JPanel();
        lblName1 = new javax.swing.JLabel();
        lblOwer1 = new javax.swing.JLabel();
        pnPlayer2 = new javax.swing.JPanel();
        lblName2 = new javax.swing.JLabel();
        lblOwer2 = new javax.swing.JLabel();
        pnPlayer3 = new javax.swing.JPanel();
        lblName3 = new javax.swing.JLabel();
        lblOwer3 = new javax.swing.JLabel();
        pnPlayer4 = new javax.swing.JPanel();
        lblName4 = new javax.swing.JLabel();
        lblOwer4 = new javax.swing.JLabel();
        pnCountDown = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        proCountDown = new javax.swing.JProgressBar();
        lblCountDown = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblOwner = new javax.swing.JLabel();
        lblMembers = new javax.swing.JLabel();
        btnStartGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnPlayer1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnPlayer1.setForeground(new java.awt.Color(153, 255, 204));

        lblName1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName1.setForeground(new java.awt.Color(0, 204, 204));
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName1.setText("?");

        lblOwer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOwer1.setForeground(new java.awt.Color(255, 102, 51));
        lblOwer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOwer1.setText("Owner");

        javax.swing.GroupLayout pnPlayer1Layout = new javax.swing.GroupLayout(pnPlayer1);
        pnPlayer1.setLayout(pnPlayer1Layout);
        pnPlayer1Layout.setHorizontalGroup(
            pnPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOwer1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPlayer1Layout.setVerticalGroup(
            pnPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOwer1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnPlayer2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblName2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName2.setForeground(new java.awt.Color(0, 204, 204));
        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName2.setText("?");

        lblOwer2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOwer2.setForeground(new java.awt.Color(255, 102, 51));
        lblOwer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnPlayer2Layout = new javax.swing.GroupLayout(pnPlayer2);
        pnPlayer2.setLayout(pnPlayer2Layout);
        pnPlayer2Layout.setHorizontalGroup(
            pnPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(lblOwer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPlayer2Layout.setVerticalGroup(
            pnPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOwer2, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnPlayer3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblName3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName3.setForeground(new java.awt.Color(0, 204, 204));
        lblName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName3.setText("?");

        lblOwer3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOwer3.setForeground(new java.awt.Color(255, 102, 51));
        lblOwer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnPlayer3Layout = new javax.swing.GroupLayout(pnPlayer3);
        pnPlayer3.setLayout(pnPlayer3Layout);
        pnPlayer3Layout.setHorizontalGroup(
            pnPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(lblOwer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPlayer3Layout.setVerticalGroup(
            pnPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOwer3, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnPlayer4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblName4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblName4.setForeground(new java.awt.Color(0, 204, 204));
        lblName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName4.setText("?");

        lblOwer4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOwer4.setForeground(new java.awt.Color(255, 102, 51));
        lblOwer4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnPlayer4Layout = new javax.swing.GroupLayout(pnPlayer4);
        pnPlayer4.setLayout(pnPlayer4Layout);
        pnPlayer4Layout.setHorizontalGroup(
            pnPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(lblOwer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnPlayer4Layout.setVerticalGroup(
            pnPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayer4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOwer4, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnPlayerLayout = new javax.swing.GroupLayout(pnPlayer);
        pnPlayer.setLayout(pnPlayerLayout);
        pnPlayerLayout.setHorizontalGroup(
            pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayerLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        pnPlayerLayout.setVerticalGroup(
            pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPlayerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pnPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPlayer3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPlayer4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jLabel1.setText("Play in");

        lblCountDown.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCountDown.setForeground(new java.awt.Color(255, 51, 51));
        lblCountDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountDown.setText("10");

        javax.swing.GroupLayout pnCountDownLayout = new javax.swing.GroupLayout(pnCountDown);
        pnCountDown.setLayout(pnCountDownLayout);
        pnCountDownLayout.setHorizontalGroup(
            pnCountDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCountDownLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proCountDown, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCountDown)
                .addContainerGap())
        );
        pnCountDownLayout.setVerticalGroup(
            pnCountDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCountDownLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCountDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCountDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCountDownLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnCountDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(proCountDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel3.setText("Room ID");

        jLabel4.setText("Owner");

        jLabel5.setText("Members");

        lblID.setText("-1");

        lblOwner.setText("null");

        lblMembers.setText("0");

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMembers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOwner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblMembers))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        btnStartGame.setText("Start Game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCountDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(pnCountDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        // TODO add your handling code here:
        if (room.getPlayers().size() < 2) {
            DialogUtils.showWarning(this, "Cannot play game", "Room need more than one member to play");
        } else {
            btnStartGame.setEnabled(false);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= countDownTime; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RoomActivity.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        proCountDown.setValue(i);
                        lblCountDown.setText(countDownTime - i + "");
                    }
                    startGame();
                }
            });
            thread.start();
        }
    }//GEN-LAST:event_btnStartGameActionPerformed
    void startGame() {
        System.out.println("Start Game");
    }

    private void customizeUI() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(ColorHelper.bgColor);
        this.setTitle("Crazy Snake - Room: " + room.getID());
        proCountDown.setMaximum(countDownTime);
        proCountDown.setValue(0);
        lblCountDown.setText(countDownTime + "");
        labelsName = new ArrayList<>();
        labelsName.add(lblName1);
        labelsName.add(lblName2);
        labelsName.add(lblName3);
        labelsName.add(lblName4);
        labelsOwner = new ArrayList<>();
        labelsOwner.add(lblOwer1);
        labelsOwner.add(lblOwer2);
        labelsOwner.add(lblOwer3);
        labelsOwner.add(lblOwer4);
    }

    private void update() {
        lblID.setText(room.getID() + "");
        lblMembers.setText(room.getPlayers().size() + "");
        lblOwner.setText(room.getOwner().getUserName());
        this.setTitle("Crazy Snake - Room: " + room.getID());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCountDown;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMembers;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblOwer1;
    private javax.swing.JLabel lblOwer2;
    private javax.swing.JLabel lblOwer3;
    private javax.swing.JLabel lblOwer4;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JPanel pnCountDown;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPlayer;
    private javax.swing.JPanel pnPlayer1;
    private javax.swing.JPanel pnPlayer2;
    private javax.swing.JPanel pnPlayer3;
    private javax.swing.JPanel pnPlayer4;
    private javax.swing.JProgressBar proCountDown;
    // End of variables declaration//GEN-END:variables
}
