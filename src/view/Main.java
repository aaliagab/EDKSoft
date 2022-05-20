/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Control;
import controller.Toast;
import criptographia.Encriptado;
import dao.BussinessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import pojos.Acesso;
import pojos.Usuario;

/**
 *
 * @author
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Control control;
    private Toast msg;
    private Usuario utilizador_login;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        control = new Control();
        jLabel1.setSize(this.getWidth(), this.getHeight());
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1, "src/resource/fondo.jpg");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                setSizeImage();
            }
        });
        inserirAcessos();
        inserirSuperUser();
        LoginDialog obj = new LoginDialog(this, true);
        obj.show();
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resource/icon50.png")));
    }

    public void inserirSuperUser() {
        try {
            Usuario superuser = control.getUsuarioDAO().getByUserName("admin");
            Acesso admin = control.getAcessoDAO().getByNome("admin");
            if (superuser == null) {
                if (admin == null) {
                    admin = new Acesso("admin");
                    control.getAcessoDAO().save(admin);
                }
                superuser = new Usuario(admin, "admin", Encriptado.getEncriptadoForte("adminadmin"));
                control.getUsuarioDAO().save(superuser);
            }
        } catch (BussinessException ex) {
            msg = new Toast(ex.getMessage(), 2000);
            msg.showToast();
        }

    }

    public void setUsuario(Usuario utilizador) {
        this.utilizador_login = utilizador;
    }

    public Usuario getUsuario_login() {
        return utilizador_login;
    }

    public void setBemvindo(String text) {
        this.setTitle("EDKSOFT - SEJA BEM-VIND@ " + text.toUpperCase());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resource/icon50.png"));

        return retValue;
    }

    public void setSizeImage() {
        jLabel1.setSize(this.getWidth(), this.getHeight());
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1, "src/resource/fondo.jpg");
    }

    public void inserirAcessos() {
        try {
            Acesso admin = control.getAcessoDAO().getByNome("admin");
            Acesso director = control.getAcessoDAO().getByNome("director");
            Acesso professor = control.getAcessoDAO().getByNome("professor");
            Acesso secretaria = control.getAcessoDAO().getByNome("secretaria");
            Acesso instrutor = control.getAcessoDAO().getByNome("instrutor");
            
            if (admin == null) {
                admin = new Acesso("admin");
                control.getAcessoDAO().save(admin);
            }
            if (director == null) {
                director = new Acesso("director");
                control.getAcessoDAO().save(director);
            }
            if (professor == null) {
                professor = new Acesso("professor");
                control.getAcessoDAO().save(professor);
            }
            if (secretaria == null) {
                secretaria = new Acesso("secretaria");
                control.getAcessoDAO().save(secretaria);
            }
            if (instrutor == null) {
                instrutor = new Acesso("instrutor");
                control.getAcessoDAO().save(instrutor);
            }
        } catch (BussinessException ex) {
            msg = new Toast(ex.getMessage(), 2000);
            msg.showToast();
        }
    }

    public void menuDirector() {
        //operacoes
        menuSeguranca.setVisible(false);
        menuTipos.setVisible(true);    
        menuEnsino.setVisible(true);
            menuItemInscricoes.setVisible(true);
            menuItemTransportes.setVisible(true);
            menuItemExames.setVisible(true);
            menuItemAulas.setVisible(true);
        menuPessoas.setVisible(true);
            menuItemCargos.setVisible(true);
            menuItemProvincia.setVisible(true);
            menuItemMunicipio.setVisible(true);
            menuItemBairros.setVisible(true);
            menuItemFuncionario.setVisible(true);
            menuItemAlunos.setVisible(true);
            menuItemProfessores.setVisible(true);
            menuItemInstrutores.setVisible(true);
        //relatorios
        menuImpressoes.setVisible(true);
    }

    public void menuSecretaria() {
        menuSeguranca.setVisible(false);
        menuTipos.setVisible(true);
        menuEnsino.setVisible(true);
            menuItemInscricoes.setVisible(true);
            menuItemTransportes.setVisible(true);
            menuItemExames.setVisible(false);
            menuItemAulas.setVisible(false);
        menuPessoas.setVisible(true);
            menuItemCargos.setVisible(false);
            menuItemProvincia.setVisible(true);
            menuItemMunicipio.setVisible(true);
            menuItemBairros.setVisible(true);
            menuItemFuncionario.setVisible(false);
            menuItemAlunos.setVisible(true);
            menuItemProfessores.setVisible(true);
            menuItemInstrutores.setVisible(true);
        //relatorios
        menuImpressoes.setVisible(true);
    }

    public void menuAdmin() {
        menuSeguranca.setVisible(true);
        menuTipos.setVisible(false);   
        menuEnsino.setVisible(false);        
        menuPessoas.setVisible(true);
            menuItemCargos.setVisible(true);
            menuItemProvincia.setVisible(false);
            menuItemMunicipio.setVisible(false);
            menuItemBairros.setVisible(false);
            menuItemFuncionario.setVisible(true);
            menuItemAlunos.setVisible(false);
            menuItemProfessores.setVisible(false);
            menuItemInstrutores.setVisible(false);
        //relatorios
        menuImpressoes.setVisible(false);
    }
    
    public void menuProfessor() {
        menuSeguranca.setVisible(false);
        menuTipos.setVisible(false);
        menuEnsino.setVisible(true);
            menuItemInscricoes.setVisible(false);
            menuItemTransportes.setVisible(false);
            menuItemExames.setVisible(false);
            menuItemAulas.setVisible(true);
        menuPessoas.setVisible(false);
            menuItemCargos.setVisible(true);
            menuItemProvincia.setVisible(true);
            menuItemMunicipio.setVisible(true);
            menuItemBairros.setVisible(true);
            menuItemFuncionario.setVisible(true);
            menuItemAlunos.setVisible(true);
            menuItemProfessores.setVisible(true);
            menuItemInstrutores.setVisible(true);
        //relatorios
        menuImpressoes.setVisible(true);
    }
    
    public void menuInstrutor() {
        menuSeguranca.setVisible(false);
        menuTipos.setVisible(false);    
        menuEnsino.setVisible(true);
            menuItemInscricoes.setVisible(false);
            menuItemTransportes.setVisible(false);
            menuItemExames.setVisible(true);
            menuItemAulas.setVisible(false);
        menuPessoas.setVisible(false);
            menuItemCargos.setVisible(true);
            menuItemProvincia.setVisible(true);
            menuItemMunicipio.setVisible(true);
            menuItemBairros.setVisible(true);
            menuItemFuncionario.setVisible(true);
            menuItemAlunos.setVisible(true);
            menuItemProfessores.setVisible(true);
            menuItemInstrutores.setVisible(true);
        //relatorios
        menuImpressoes.setVisible(true);
    }

    public void showMenuAcesso() {
        if (utilizador_login.getAcesso().getNome().equals("director")) {
            menuDirector();
        } else if (utilizador_login.getAcesso().getNome().equals("professor")) {
            menuProfessor();
        } else if (utilizador_login.getAcesso().getNome().equals("instrutor")) {
            menuInstrutor();
        } else if (utilizador_login.getAcesso().getNome().equals("secretaria")) {
            menuSecretaria();
        } else {
            menuAdmin();
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSeguranca = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuTipos = new javax.swing.JMenu();
        menuItemTipo = new javax.swing.JMenuItem();
        menuItemTipoTransporte = new javax.swing.JMenuItem();
        menuItemTipoInscricao = new javax.swing.JMenuItem();
        menuItemCategoria = new javax.swing.JMenuItem();
        menuPessoas = new javax.swing.JMenu();
        menuItemCargos = new javax.swing.JMenuItem();
        menuItemProvincia = new javax.swing.JMenuItem();
        menuItemMunicipio = new javax.swing.JMenuItem();
        menuItemBairros = new javax.swing.JMenuItem();
        menuItemFuncionario = new javax.swing.JMenuItem();
        menuItemAlunos = new javax.swing.JMenuItem();
        menuItemProfessores = new javax.swing.JMenuItem();
        menuItemInstrutores = new javax.swing.JMenuItem();
        menuEnsino = new javax.swing.JMenu();
        menuItemInscricoes = new javax.swing.JMenuItem();
        menuItemTransportes = new javax.swing.JMenuItem();
        menuItemExames = new javax.swing.JMenuItem();
        menuItemAulas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        menuImpressoes = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDKSOFT");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/fondo.jpg"))); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_file_submodule_28px.png"))); // NOI18N
        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_administrative_tools_28px.png"))); // NOI18N
        menuSeguranca.setText("Administração");
        menuSeguranca.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_access_28px_1.png"))); // NOI18N
        jMenuItem2.setText("Acessos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuSeguranca.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_add_user_male_28px.png"))); // NOI18N
        jMenuItem1.setText("Usuários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSeguranca.add(jMenuItem1);

        jMenu1.add(menuSeguranca);

        menuTipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_text_width_28px.png"))); // NOI18N
        menuTipos.setText("Tipos e categorias");
        menuTipos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuItemTipo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_classroom_28px.png"))); // NOI18N
        menuItemTipo.setText("Tipo exame o aula");
        menuItemTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTipoActionPerformed(evt);
            }
        });
        menuTipos.add(menuItemTipo);

        menuItemTipoTransporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemTipoTransporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_transportation_28px.png"))); // NOI18N
        menuItemTipoTransporte.setText("Tipo de transporte");
        menuItemTipoTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTipoTransporteActionPerformed(evt);
            }
        });
        menuTipos.add(menuItemTipoTransporte);

        menuItemTipoInscricao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemTipoInscricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_sign_up_28px.png"))); // NOI18N
        menuItemTipoInscricao.setText("Tipo de inscrição");
        menuItemTipoInscricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTipoInscricaoActionPerformed(evt);
            }
        });
        menuTipos.add(menuItemTipoInscricao);

        menuItemCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_categorize_28px.png"))); // NOI18N
        menuItemCategoria.setText("Categorias");
        menuItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategoriaActionPerformed(evt);
            }
        });
        menuTipos.add(menuItemCategoria);

        jMenu1.add(menuTipos);

        menuPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_people_28px_1.png"))); // NOI18N
        menuPessoas.setText("Menu de Pessoas");
        menuPessoas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuItemCargos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_diploma_28px.png"))); // NOI18N
        menuItemCargos.setText("Cargos");
        menuItemCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCargosActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemCargos);

        menuItemProvincia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_country_28px.png"))); // NOI18N
        menuItemProvincia.setText("Províncias");
        menuItemProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProvinciaActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemProvincia);

        menuItemMunicipio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemMunicipio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_libya_map_28px.png"))); // NOI18N
        menuItemMunicipio.setText("Municípios");
        menuItemMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMunicipioActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemMunicipio);

        menuItemBairros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemBairros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_maps_28px_1.png"))); // NOI18N
        menuItemBairros.setText("Bairros");
        menuItemBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBairrosActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemBairros);

        menuItemFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_solicitor_28px.png"))); // NOI18N
        menuItemFuncionario.setText("Funcionários");
        menuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFuncionarioActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemFuncionario);

        menuItemAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_registration_28px.png"))); // NOI18N
        menuItemAlunos.setText("Alunos");
        menuItemAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAlunosActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemAlunos);

        menuItemProfessores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemProfessores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_valet_28px.png"))); // NOI18N
        menuItemProfessores.setText("Professores");
        menuItemProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProfessoresActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemProfessores);

        menuItemInstrutores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        menuItemInstrutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_valet_28px.png"))); // NOI18N
        menuItemInstrutores.setText("Instructores");
        menuItemInstrutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInstrutoresActionPerformed(evt);
            }
        });
        menuPessoas.add(menuItemInstrutores);

        jMenu1.add(menuPessoas);

        menuEnsino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_class_28px.png"))); // NOI18N
        menuEnsino.setText("Ensino");
        menuEnsino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuItemInscricoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemInscricoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_sign_up_28px.png"))); // NOI18N
        menuItemInscricoes.setText("Inscrições");
        menuItemInscricoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInscricoesActionPerformed(evt);
            }
        });
        menuEnsino.add(menuItemInscricoes);

        menuItemTransportes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemTransportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_transportation_28px.png"))); // NOI18N
        menuItemTransportes.setText("Transportes");
        menuItemTransportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTransportesActionPerformed(evt);
            }
        });
        menuEnsino.add(menuItemTransportes);

        menuItemExames.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemExames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_scorecard_28px.png"))); // NOI18N
        menuItemExames.setText("Exames");
        menuItemExames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExamesActionPerformed(evt);
            }
        });
        menuEnsino.add(menuItemExames);

        menuItemAulas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemAulas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_classroom_28px.png"))); // NOI18N
        menuItemAulas.setText("Aulas");
        menuItemAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAulasActionPerformed(evt);
            }
        });
        menuEnsino.add(menuItemAulas);

        jMenu1.add(menuEnsino);
        jMenu1.add(jSeparator1);

        jMenuItem28.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem28.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_change_user_28px.png"))); // NOI18N
        jMenuItem28.setText("Trocar de usuário");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem28);

        jMenuBar1.add(jMenu1);

        menuImpressoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_business_report_28px.png"))); // NOI18N
        menuImpressoes.setText("Relatórios");
        menuImpressoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_pdf_28px_3.png"))); // NOI18N
        jMenuItem15.setText("Inscrições");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        menuImpressoes.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_pdf_28px_3.png"))); // NOI18N
        jMenuItem16.setText("Pautas");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        menuImpressoes.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_pdf_28px_3.png"))); // NOI18N
        jMenuItem17.setText("Aulas");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        menuImpressoes.add(jMenuItem17);

        jMenuBar1.add(menuImpressoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProvinciaActionPerformed
        ProvinciaDialog obj = new ProvinciaDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemProvinciaActionPerformed

    private void menuItemMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMunicipioActionPerformed
        try {
            if (control.getProvinciaDAO().findAll().size() == 0) {
                msg = new Toast("Província deve ser inserida antes", 2000);
                msg.showToast();
            } else {
                MunicipioDialog obj = new MunicipioDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemMunicipioActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed

        LoginDialog l = new LoginDialog(this, true);
        l.show();
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void menuItemCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCargosActionPerformed
        CargoDialog obj = new CargoDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemCargosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        UsuariosDialog obj = new UsuariosDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AcessoDialog obj = new AcessoDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFuncionarioActionPerformed
        try {
            if (control.getBairroDAO().findAll().size() == 0) {
                msg = new Toast("Bairro deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getCargoDAO().findAll().size() == 0) {
                msg = new Toast("Cargo deve ser inserido antes.", 2000);
                msg.showToast();
            } else {
                FuncionarioDialog obj = new FuncionarioDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemFuncionarioActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
//        try {
//            List<ResidentesReport> objs = new ArrayList<>();
//            List<Emigrante> dist = control.getEmigranteDAO().findAll();
//            for (Emigrante obj : dist) {
//                if(obj.getCategoriaMigratoria().getTipoVisto().getNome().equals("Autorização de Residência"))
//                objs.add(new ResidentesReport(obj));
//            }
//            try {
//                JasperReport reporte = null;
//                URL path = this.getClass().getResource("/reports/autorizacao_report_geral.jasper");
//                Map<String, Object> parametros = new HashMap<>();
//                parametros.put("logo", this.getClass().getResource("/resource/logo.jpg").toString());
//                reporte = (JasperReport) JRLoader.loadObject(path);
//                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(objs));
//                JasperViewer jviewer = new JasperViewer(jprint, false);
//                jviewer.setVisible(true);
//                jviewer.setTitle("autorizacao_report_geral");
//
//            } catch (Exception e) {
//                msg = new Toast(e.getMessage(), 2000);
//                msg.showToast();
//            }
//        } catch (BussinessException ex) {
//            control.messageErroBussiness(ex);
//        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
//      try {
//            List<VistoPermanenciaReport> objs = new ArrayList<>();
//            List<Emigrante> dist = control.getEmigranteDAO().findAll();
//            for (Emigrante obj : dist) {
//                if(obj.getCategoriaMigratoria().getTipoVisto().getNome().equals("Visto de Permanência Temporária"))
//                objs.add(new VistoPermanenciaReport(obj));
//            }
//            try {
//                JasperReport reporte = null;
//                URL path = this.getClass().getResource("/reports/permanencia_report_geral.jasper");
//                Map<String, Object> parametros = new HashMap<>();
//                parametros.put("titulo", "VISTO DE PERMANÊNCIA TEMPORÁRIA");
//                parametros.put("logo", this.getClass().getResource("/resource/logo.jpg").toString());
//                reporte = (JasperReport) JRLoader.loadObject(path);
//                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(objs));
//                JasperViewer jviewer = new JasperViewer(jprint, false);
//                jviewer.setVisible(true);
//                jviewer.setTitle("permanencia_report_geral");
//
//            } catch (Exception e) {
//                msg = new Toast(e.getMessage(), 2000);
//                msg.showToast();
//            }
//        } catch (BussinessException ex) {
//            control.messageErroBussiness(ex);
//        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void menuItemExamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExamesActionPerformed
        try {
            if (control.getInstructorDAO().findAll().size() == 0) {
                msg = new Toast("Instrutor deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getTipoDAO().findAll().size() == 0) {
                msg = new Toast("Tipo deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getCategoriaDAO().findAll().size() == 0) {
                msg = new Toast("Categoria deve ser inseridA antes.", 2000);
                msg.showToast();
            } else {
                ExameDialog obj = new ExameDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemExamesActionPerformed

    private void menuItemBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBairrosActionPerformed
        try {
            if (control.getMunicipioDAO().findAll().size() == 0) {
                msg = new Toast("Município deve ser inserido antes", 2000);
                msg.showToast();
            } else {
                BairroDialog obj = new BairroDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemBairrosActionPerformed

    private void menuItemTransportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTransportesActionPerformed
        try {
            if (control.getTipoTransporteDAO().findAll().size() == 0) {
                msg = new Toast("Tipo de transporte deve ser inserido antes", 2000);
                msg.showToast();
            } else {
                TransporteDialog obj = new TransporteDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemTransportesActionPerformed

    private void menuItemInscricoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInscricoesActionPerformed
        try {
            if (control.getAlunoDAO().findAll().size() == 0) {
                msg = new Toast("Aluno deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getTipoInscricaoDAO().findAll().size() == 0) {
                msg = new Toast("Tipo de inscrição deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getCategoriaDAO().findAll().size() == 0) {
                msg = new Toast("Categoria deve ser inseridA antes.", 2000);
                msg.showToast();
            } else {
                InscricaoDialog obj = new InscricaoDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemInscricoesActionPerformed

    private void menuItemAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAulasActionPerformed
        try {
            if (control.getProfessorDAO().findAll().size() == 0) {
                msg = new Toast("Professor deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getTipoDAO().findAll().size() == 0) {
                msg = new Toast("Tipo deve ser inserido antes.", 2000);
                msg.showToast();
            } else {
                AulaDialog obj = new AulaDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemAulasActionPerformed

    private void menuItemAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAlunosActionPerformed
        try {
            if (control.getBairroDAO().findAll().size() == 0) {
                msg = new Toast("Bairro deve ser inserido antes.", 2000);
                msg.showToast();
            } else if (control.getTransporteDAO().findAll().size() == 0) {
                msg = new Toast("Transporte deve ser inserido antes.", 2000);
                msg.showToast();
            } else {
                AlunoDialog obj = new AlunoDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemAlunosActionPerformed

    private void menuItemTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTipoActionPerformed
        TipoDialog obj = new TipoDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemTipoActionPerformed

    private void menuItemTipoTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTipoTransporteActionPerformed
        TipoTransporteDialog obj = new TipoTransporteDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemTipoTransporteActionPerformed

    private void menuItemTipoInscricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTipoInscricaoActionPerformed
        TipoInscricaoDialog obj = new TipoInscricaoDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemTipoInscricaoActionPerformed

    private void menuItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategoriaActionPerformed
        CategoriaDialog obj = new CategoriaDialog(this, true);
        obj.setVisible(true);
    }//GEN-LAST:event_menuItemCategoriaActionPerformed

    private void menuItemProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProfessoresActionPerformed
        try {
            if (control.getBairroDAO().findAll().size() == 0) {
                msg = new Toast("Bairro deve ser inserido antes.", 2000);
                msg.showToast();
            } else {
                ProfessorDialog obj = new ProfessorDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemProfessoresActionPerformed

    private void menuItemInstrutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInstrutoresActionPerformed
        try {
            if (control.getBairroDAO().findAll().size() == 0) {
                msg = new Toast("Bairro deve ser inserido antes.", 2000);
                msg.showToast();
            } else {
                InstructorDialog obj = new InstructorDialog(this, true);
                obj.setVisible(true);
            }
        } catch (BussinessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemInstrutoresActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
            Toast msg2 = new Toast(e.getMessage(), 2000);
            msg2.showToast();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuEnsino;
    private javax.swing.JMenu menuImpressoes;
    private javax.swing.JMenuItem menuItemAlunos;
    private javax.swing.JMenuItem menuItemAulas;
    private javax.swing.JMenuItem menuItemBairros;
    private javax.swing.JMenuItem menuItemCargos;
    private javax.swing.JMenuItem menuItemCategoria;
    private javax.swing.JMenuItem menuItemExames;
    private javax.swing.JMenuItem menuItemFuncionario;
    private javax.swing.JMenuItem menuItemInscricoes;
    private javax.swing.JMenuItem menuItemInstrutores;
    private javax.swing.JMenuItem menuItemMunicipio;
    private javax.swing.JMenuItem menuItemProfessores;
    private javax.swing.JMenuItem menuItemProvincia;
    private javax.swing.JMenuItem menuItemTipo;
    private javax.swing.JMenuItem menuItemTipoInscricao;
    private javax.swing.JMenuItem menuItemTipoTransporte;
    private javax.swing.JMenuItem menuItemTransportes;
    private javax.swing.JMenu menuPessoas;
    private javax.swing.JMenu menuSeguranca;
    private javax.swing.JMenu menuTipos;
    // End of variables declaration//GEN-END:variables
}
