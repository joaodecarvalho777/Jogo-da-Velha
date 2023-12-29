/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.carvcorp.jogodavelha;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carvalho
 */
public class Tela extends javax.swing.JFrame {

    private int x, o;
    private String valor = "";
    private final int[][] matriz = new int[3][3];
    private final int cont;
    private final int[] vencx = new int[8];
    private final int[] venco = new int[8];
    private final boolean matrizCheia = false;

    /**
     * Creates new form Tela
     * @param cont
     */
    //Tela de jogo
    public Tela(int cont) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/ao/com/carvcorp/jogodavelha/img/JV.png")).getImage());
        this.cont = 0;
    }

    //Colocar a cor(preta) padrão para o texto nos botões
    public void resetarCor() {
        btn1.setForeground(Color.BLACK);
        btn2.setForeground(Color.BLACK);
        btn3.setForeground(Color.BLACK);
        btn4.setForeground(Color.BLACK);
        btn5.setForeground(Color.BLACK);
        btn6.setForeground(Color.BLACK);
        btn7.setForeground(Color.BLACK);
        btn8.setForeground(Color.BLACK);
        btn9.setForeground(Color.BLACK);
    }

    //Método para empate
    public void empate() {
        //Condicção necessária
        //Se todos os botões possuirem algum texto então, é um empate.
        if (!btn1.getText().equals("") && !btn2.getText().equals("") && !btn3.getText().equals("")
                && !btn4.getText().equals("") && !btn5.getText().equals("") && !btn6.getText().equals("")
                && !btn7.getText().equals("") && !btn8.getText().equals("") && !btn9.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Empate");
            
            //Opção para sair ou jogar novamente
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            //Se escolhar nova partida
            //Zere todos os atributos, menos a pontuação
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                resetarValores();
                
                //Se escolher sair, feche a aplicação
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0); //Sair ou fechar o programa
            }
        }
    }

    //Zerar a pontuação
    public void resetarValores() {
        vencx[0] = 0;
        vencx[1] = 0;
        vencx[2] = 0;
        vencx[3] = 0;
        vencx[4] = 0;
        vencx[5] = 0;
        vencx[6] = 0;
        vencx[7] = 0;
        venco[0] = 0;
        venco[1] = 0;
        venco[2] = 0;
        venco[3] = 0;
        venco[4] = 0;
        venco[5] = 0;
        venco[6] = 0;
        venco[7] = 0;
    }
    
    //Para o caso em que o vencedor é o jogador X
    public void vencedorX(int num1, int num2) {
        //Se a posição tiver o mesmo caracter que a posicão 
        if (num1 == num2) {
            vencx[0] += 1;
        }
        if (num1 == 0 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            vencx[1] += 1;
        }
        if (num1 == 1 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            vencx[2] += 1;
        }
        if (num1 == 2 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            vencx[3] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && (num2 == 0)) {
            vencx[4] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && num2 == 1) {
            vencx[5] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && num2 == 2) {
            vencx[6] += 1;
        }
        if ((num1 == 0 && num2 == 2) || (num1 == 1 && num2 == 1) || (num1 == 2 && num2 == 0)) {
            vencx[7] += 1;
        }

        if (vencx[0] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[1] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[2] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[3] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[4] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[5] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[6] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (vencx[7] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ1.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                x += 1;
                lblX.setText("X = " + x);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }

    //Para o caso em que o vencedor é o jogador O
    public void vencedorO(int num1, int num2) {
        if (num1 == num2) {
            venco[0] += 1;
        }
        if (num1 == 0 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            venco[1] += 1;
        }
        if (num1 == 1 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            venco[2] += 1;
        }
        if (num1 == 2 && (num2 == 0 || num2 == 1 || num2 == 2)) {
            venco[3] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && (num2 == 0)) {
            venco[4] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && num2 == 1) {
            venco[5] += 1;
        }
        if ((num1 == 0 || num1 == 1 || num1 == 2) && num2 == 2) {
            venco[6] += 1;
        }
        if ((num1 == 0 && num2 == 2) || (num1 == 1 && num2 == 1) || (num1 == 2 && num2 == 0)) {
            venco[7] += 1;
        }

        if (venco[0] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

                resetarCor();

                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[1] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[2] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[3] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[4] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[5] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[6] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else if (venco[7] == 3) {
            JOptionPane.showMessageDialog(null, "Vencedor: " + lblJ2.getText());
            int novoJogo = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (novoJogo == JOptionPane.YES_OPTION) {
                valor = "";
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                
                resetarCor();
                
                o += 1;
                lblO.setText("O = " + o);
                resetarValores();
            } else if (novoJogo == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblX = new javax.swing.JLabel();
        lblO = new javax.swing.JLabel();
        lblJ1 = new javax.swing.JLabel();
        lblJ2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogando...");
        setResizable(false);

        btn3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Placar");

        lblX.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblX.setText("X = 0");

        lblO.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblO.setText("O = 0");

        lblJ1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJ1.setText("A");

        lblJ2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJ2.setText("A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(lblX)
                                .addGap(42, 42, 42)
                                .addComponent(lblO))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblJ1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJ2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblJ2)
                    .addComponent(lblJ1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblX)
                    .addComponent(lblO))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (valor.equals("") && btn1.getText().equals("")) {
            valor = "X";
            btn1.setForeground(Color.blue);
            btn1.setText(valor);
            vencedorX(0, 0);
            empate();
        } else if (valor.equals("X") && btn1.getText().equals("")) {
            valor = "O";
            btn1.setForeground(Color.green);
            btn1.setText(valor);
            vencedorO(0, 0);
            empate();
        } else if (valor.equals("O") && btn1.getText().equals("")) {
            valor = "X";
            btn1.setForeground(Color.blue);
            btn1.setText(valor);
            vencedorX(0, 0);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (valor.equals("") && btn2.getText().equals("")) {
            valor = "X";
            btn2.setForeground(Color.blue);
            btn2.setText(valor);
            vencedorX(0, 1);
            empate();
        } else if (valor.equals("X") && btn2.getText().equals("")) {
            valor = "O";
            btn2.setForeground(Color.green);
            btn2.setText(valor);
            vencedorO(0, 1);
            empate();
        } else if (valor.equals("O") && btn2.getText().equals("")) {
            valor = "X";
            btn2.setForeground(Color.blue);
            btn2.setText(valor);
            vencedorX(0, 1);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (valor.equals("") && btn3.getText().equals("")) {
            valor = "X";
            btn3.setForeground(Color.blue);
            btn3.setText(valor);
            vencedorX(0, 2);
            empate();
        } else if (valor.equals("X") && btn3.getText().equals("")) {
            valor = "O";
            btn3.setForeground(Color.green);
            btn3.setText(valor);
            vencedorO(0, 2);
            empate();
        } else if (valor.equals("O") && btn3.getText().equals("")) {
            valor = "X";
            btn3.setForeground(Color.blue);
            btn3.setText(valor);
            vencedorX(0, 2);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (valor.equals("") && btn4.getText().equals("")) {
            valor = "X";
            btn4.setForeground(Color.blue);
            btn4.setText(valor);
            vencedorX(1, 0);
            empate();
        } else if (valor.equals("X") && btn4.getText().equals("")) {
            valor = "O";
            btn4.setForeground(Color.green);
            btn4.setText(valor);
            vencedorO(1, 0);
            empate();
        } else if (valor.equals("O") && btn4.getText().equals("")) {
            valor = "X";
            btn4.setForeground(Color.blue);
            btn4.setText(valor);
            vencedorX(1, 0);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (valor.equals("") && btn5.getText().equals("")) {
            valor = "X";
            btn5.setForeground(Color.blue);
            btn5.setText(valor);
            vencedorX(1, 1);
            empate();
        } else if (valor.equals("X") && btn5.getText().equals("")) {
            valor = "O";
            btn5.setForeground(Color.green);
            btn5.setText(valor);
            vencedorO(1, 1);
            empate();
        } else if (valor.equals("O") && btn5.getText().equals("")) {
            valor = "X";
            btn5.setForeground(Color.blue);
            btn5.setText(valor);
            vencedorX(1, 1);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (valor.equals("") && btn6.getText().equals("")) {
            valor = "X";
            btn6.setForeground(Color.blue);
            btn6.setText(valor);
            vencedorX(1, 2);
            empate();
        } else if (valor.equals("X") && btn6.getText().equals("")) {
            valor = "O";
            btn6.setForeground(Color.green);
            btn6.setText(valor);
            vencedorO(1, 2);
            empate();
        } else if (valor.equals("O") && btn6.getText().equals("")) {
            valor = "X";
            btn6.setForeground(Color.blue);
            btn6.setText(valor);
            vencedorX(1, 2);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (valor.equals("") && btn7.getText().equals("")) {
            valor = "X";
            btn7.setForeground(Color.blue);
            btn7.setText(valor);
            vencedorX(2, 0);
            empate();
        } else if (valor.equals("X") && btn7.getText().equals("")) {
            valor = "O";
            btn7.setForeground(Color.green);
            btn7.setText(valor);
            vencedorO(2, 0);
            empate();
        } else if (valor.equals("O") && btn7.getText().equals("")) {
            valor = "X";
            btn7.setForeground(Color.blue);
            btn7.setText(valor);
            vencedorX(2, 0);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (valor.equals("") && btn8.getText().equals("")) {
            valor = "X";
            btn8.setForeground(Color.blue);
            btn8.setText(valor);
            vencedorX(2, 1);
            empate();
        } else if (valor.equals("X") && btn8.getText().equals("")) {
            valor = "O";
            btn8.setForeground(Color.green);
            btn8.setText(valor);
            vencedorO(2, 1);
            empate();
        } else if (valor.equals("O") && btn8.getText().equals("")) {
            valor = "X";
            btn8.setForeground(Color.blue);
            btn8.setText(valor);
            vencedorX(2, 1);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (valor.equals("") && btn9.getText().equals("")) {
            valor = "X";
            btn9.setForeground(Color.blue);
            btn9.setText(valor);
            vencedorX(2, 2);
            empate();
        } else if (valor.equals("X") && btn9.getText().equals("")) {
            valor = "O";
            btn9.setForeground(Color.green);
            btn9.setText(valor);
            vencedorO(2, 2);
            empate();
        } else if (valor.equals("O") && btn9.getText().equals("")) {
            valor = "X";
            btn9.setForeground(Color.blue);
            btn9.setText(valor);
            vencedorX(2, 2);
            empate();
        } else {
            JOptionPane.showMessageDialog(null, "Erro! Jogada Inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn9ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblJ1;
    public javax.swing.JLabel lblJ2;
    private javax.swing.JLabel lblO;
    private javax.swing.JLabel lblX;
    // End of variables declaration//GEN-END:variables
}
