/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.view;

import br.uefs.ecomp.controller.Controller;
import br.uefs.ecomp.model.Espera;
import br.uefs.ecomp.model.Trecho;
import br.uefs.ecomp.model.Trechos;
import br.uefs.ecomp.servico.ClienteRmi;
import com.google.gson.Gson;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author marcos
 */
public class UsuarioGui {

    public JFrame frame;
    public int id;
    public JPanel panel = new JPanel();
    public javax.swing.JList<Trecho> listaReservas = new JList();
    public javax.swing.JList<Trecho> listaTrechos = new JList();
    public List<Trecho> trechosReserva = new ArrayList<>();
    public DefaultListModel src = new DefaultListModel();
    public DefaultListModel dst = new DefaultListModel();
    public JTextField origem = new JTextField();
    public JTextField destino = new JTextField();
    public JLabel origemtex = new JLabel("ORIGEM :");
    public JLabel destinotex = new JLabel("DESTINO :");
    public JLabel posicEsp = new JLabel("SUA POSIÇAO NA LISTA DE ESPERA");
    public JButton source = new JButton("OK");
    public JButton trecho = new JButton("TRECHOS DISPONIVEIS ");
    public JButton comprar = new JButton("COMPRAR PASSAGEM ");
    public JButton resevar = new JButton("REALIZAR RESEVAR = >");
    public JButton cancelar = new JButton("< = CANCELAR RESEVAR");
    public JButton sair = new JButton("SAIR");
    public JButton conecta = new JButton("CONECTAR");
    public JButton atualizar = new JButton("ATUALIZAR");
    public JLabel posicao = new JLabel(" ");
    public Controller control;
    public Trecho mTrecho;
    ClienteRmi rmi;

    public UsuarioGui() {
        Incializar();
        rmi = new ClienteRmi();
    }

    private void Incializar() {
        /**
         * a seguir o if que vai set icones e cores na interface do sistema.
         * <br/>
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        frame = new JFrame();
        frame.setBounds(100, 40, 1050, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("DECOLAGEM");

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(30, 30, 990, 640);
        frame.getContentPane().add(tabbedPane);

        tabbedPane.addTab(" BEM VINDO!  ", null, panel, null);
        panel.setLayout(null);

        mostrarTrechos();
        origemDestino();
        lista();

    }

    private void mostrarTrechos() {
//<<<<<<< HEAD
        ButtonHandller btmH = new ButtonHandller();
        listaTrechos.setBounds(30, 75, 300, 450);

        frame.getContentPane().add(listaTrechos);
        panel.add(listaTrechos);

        trecho.addActionListener(btmH);
        trecho.setBounds(90, 550, 180, 40);
        frame.getContentPane().add(trecho);
        panel.add(trecho);

        resevar.addActionListener(btmH);
        resevar.setBounds(350, 190, 190, 40);
        frame.getContentPane().add(resevar);
        panel.add(resevar);

        cancelar.addActionListener(btmH);
        cancelar.setBounds(350, 290, 190, 40);
        frame.getContentPane().add(cancelar);
        panel.add(cancelar);

        listaReservas.setBounds(560, 75, 300, 450);
        frame.getContentPane().add(listaReservas);
        panel.add(listaReservas);

        comprar.addActionListener(btmH);
        comprar.setBounds(610, 550, 180, 40);
        frame.getContentPane().add(comprar);
        panel.add(comprar);

        sair.addActionListener(btmH);
        sair.setBounds(880, 40, 100, 40);
        frame.getContentPane().add(sair);
        panel.add(sair);

        conecta.addActionListener(btmH);
        conecta.setBounds(880, 190, 100, 40);
        frame.getContentPane().add(conecta);
        panel.add(conecta);

        atualizar.addActionListener(btmH);
        atualizar.setBounds(880, 360, 100, 40);
        frame.getContentPane().add(atualizar);
        panel.add(atualizar);

//=======
        /*  ButtonHandller btmH = new ButtonHandller();
         listaTrechos.setBounds(30, 75, 300, 450);
       
         frame.getContentPane().add(listaTrechos);
         panel.add(listaTrechos);
         
            src.addElement("teste");       
           listaTrechos.setModel(src);
           src.addElement("teste-2");       
           listaTrechos.setModel(src);
//             listaReservas.setModel(src);;
       
        
         trecho.addActionListener(btmH);
         trecho.setBounds(90, 550, 180, 40);
         frame.getContentPane().add(trecho);
         panel.add(trecho);
        
         resevar.addActionListener(btmH);
         resevar.setBounds(350, 190, 190, 40);
         frame.getContentPane().add(resevar);
         panel.add(resevar);
         
         cancelar.addActionListener(btmH);
         cancelar.setBounds(350, 290, 190, 40);
         frame.getContentPane().add( cancelar );
         panel.add( cancelar );
        
         listaReservas.setBounds(560, 75, 300, 450);
         frame.getContentPane().add(listaReservas);
         panel.add(listaReservas);
        
         comprar.addActionListener(btmH);
         comprar.setBounds(610, 550, 180, 40);
         frame.getContentPane().add(comprar);
         panel.add(comprar);
        
         sair.addActionListener(btmH);
         sair.setBounds(880, 40, 100, 40);
         frame.getContentPane().add( sair);
         panel.add( sair);
         
         conecta .addActionListener(btmH);
         conecta .setBounds(880,190, 100, 40);
         frame.getContentPane().add(conecta );
         panel.add(conecta);
         
         atualizar.addActionListener(btmH);
         atualizar.setBounds(880,360, 100, 40);
         frame.getContentPane().add(atualizar );
         panel.add(atualizar);
           
//>>>>>>> master*/
    }

    private void lista() {

        posicao.setHorizontalAlignment(SwingConstants.CENTER);
        posicao.setFont(new Font("Tahoma", Font.PLAIN, 40));
        posicao.setBounds(290, 440, 360, 75);
        frame.getContentPane().add(posicao);
        panel.add(posicao);
        control = new Controller(posicao);

        posicEsp.setHorizontalAlignment(SwingConstants.CENTER);
        posicEsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
        posicEsp.setBounds(260, 400, 360, 75);
        frame.getContentPane().add(posicEsp);
        panel.add(posicEsp);
    }

    private void origemDestino() {
        ButtonHandller btmH = new ButtonHandller();

        source.addActionListener(btmH);
        source.setBounds(200, 15, 90, 40);
        frame.getContentPane().add(source);
        panel.add(source);

        origemtex.setHorizontalAlignment(SwingConstants.CENTER);
        origemtex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        origemtex.setBounds(-125, -15, 360, 75);
        frame.getContentPane().add(origemtex);
        panel.add(origemtex);

        origem = new JTextField();
        origem.setBounds(90, 10, 89, 25);
        frame.getContentPane().add(origem);
        origem.setColumns(10);
        panel.add(origem);

        destinotex.setHorizontalAlignment(SwingConstants.CENTER);
        destinotex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        destinotex.setBounds(-130, 15, 360, 75);
        frame.getContentPane().add(destinotex);
        panel.add(destinotex);

        destino = new JTextField();
        destino.setBounds(90, 40, 89, 25);
        frame.getContentPane().add(destino);
        destino.setColumns(10);
        panel.add(destino);

    }

    public void exibir() {

        listaTrechos.setModel(dst);
    }

    public void exibir(int op) {
        if (op == 1) {
            src.addElement(listaTrechos.getName());
            //src.addElement(listaTrechos.getSelectedValue());
            listaReservas.setModel(src);
        } else if (op == 0) {
            src.removeElement(listaReservas.getSelectedValue());
            listaReservas.setModel(src);
        }
    }

    private class ButtonHandller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("OK".equals(e.getActionCommand())) {
                if (origem.getText() == null || origem.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "O SENHOR TEM QUE INFORMA  A SUA  ORIGEM \n PARA O SISTEMA RELIZAR  A PESQUISAR ");
                } else if (destino.getText() == null || destino.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "O SENHOR TEM QUE INFORMA  O SEU DESTINO \n  PARA O SISTEMA RELIZAR  A PESQUISAR ");
                } else {
                    control.buscar(origem.getText(), destino.getText());
                }
            } else if ("SAIR".equals(e.getActionCommand())) {
                frame.dispose();
            } else if ("TRECHOS DISPONIVEIS ".equals(e.getActionCommand())) {
                try {
                    //   exibir(1);
                    //control.atulizar();
                    List<Trecho> mT = new ArrayList<>();
                    JSONArray ja = new JSONArray(rmi.trechos2());
                    for (int i = 0; ja.length() > i; i++) {
                        //System.out.println(ja.get(i));
                        JSONObject jo = (JSONObject) ja.get(i);
                        Trecho t = new Trecho(jo.getString("cidadedestino"), jo.getString("cidadeorigem"), jo.getInt("id"), jo.getInt("quantAssentos"), jo.getInt("id"));
                        //(String cidadeorigem, String cidadedestino, int  companhia, int quantAssentos, int id) {
                        // t.setCidadedestino(jo.getString("cidadedestino"));
                        //t.setCidadeorigem(jo.getString("cidadeorigem"));
                        JSONArray filaEspera = jo.getJSONArray("fila");
                        if (filaEspera != null && filaEspera.length() > 0) {
                            System.out.println(filaEspera.toString());
                            for (int j = 0; filaEspera.length() < j; j++) {
                                JSONObject mJo = (JSONObject) filaEspera.get(j);
                                Espera espera = new Espera();
                                espera.setIp(mJo.getString("ip"));
                                espera.setNum(mJo.getInt("num"));
                                List<Espera> mEsperas = new ArrayList<>();
                                mEsperas.add(espera);
                                t.setFila(mEsperas);
                            }
                        }
                        //((List<Espera>) jo.getJSONArray("fila"));
                        // t.setId(jo.getInt("id"));
                        //t.setQuantAssentos(jo.getInt("quantAssentos"));
                        //t.setCompanhia(jo.getInt("id"));
                        t.setSemaforo(jo.getInt("semaforo"));
                        mT.add(t);
                        //{"cidadedestino":"Vitória","cidadeorigem":"Manaus","fila":[],"quantAssentos":2,"id":21,"companhia":1,"semaforo":0}
                    }
                    //System.out.println(rmi.testar());
                    // List<Trecho> mT = gson.fromJson(rmi.trechos(),  List<Trecho>());
                    for (int i = 0; mT.size() > i; i++) {
                        // System.out.println(Trechos.retornarListaTrechos().get(i));
                        // src.add(i, e);
                        dst.add(i, mT.get(i));
                        //listaReservas.setModel(dst);
                        listaTrechos.setModel(dst);

                        //listaTrechos.add(new JScrollPane(dst));
                    }
                    //exibir();
                } catch (RemoteException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(UsuarioGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("CONECTAR".equals(e.getActionCommand())) {

                control.conectar();

            } else if ("ATUALIZAR".equals(e.getActionCommand())) {
                control.atulizar();
                if (mTrecho != null) {

                }
            } else if ("COMPRAR PASSAGEM ".equals(e.getActionCommand())) {

                if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA COMPRAR \n  DEPOIS  QUE JA TEM REALIZADO UMA RESEVA! ");
                } else {
                    control.RealizarComparar();
                }

            } else if ("REALIZAR RESEVAR = >".equals(e.getActionCommand())) {

                if (mTrecho != null) {
                    if (!verificarReserva(mTrecho)) {
                        // listaReservas.add(mTrecho);
                        src.addElement(mTrecho);
                        listaReservas.setModel(src);
                        trechosReserva.add(mTrecho);
                    }
                }

                /*if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA RESEVAR \n  APOS SELECINAR UM TRECHO! ");
                } else {
                    System.out.println("Teste");
                    src.addElement(listaTrechos.getSelectedValue());
                    listaReservas.setModel(src);
                    control.Resevar();
                }*/
            } else if ("< = CANCELAR RESEVAR".equals(e.getActionCommand())) {
                if (src.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O SENHOR SO PODE CANSELAR UM RESEVAR \n  CASO JA TEM REALIZADO UM RESEVA! ");
                } else {
                    trechosReserva.remove(listaReservas.getSelectedValue());
                    src.removeElement(listaReservas.getSelectedValue());
                    listaReservas.setModel(src);
                    control.CancelarResevar();
                    if (src.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "O SENHOR SO PODE REALIZAR UMA RESEVAR \n  APOS SELECINAR UM TRECHO! ");
                    } else {
//                      src.addElement(listaTrechos.getSelectedValue());
//                     listaReservas.setModel(src);
//                        exibir(1);
                        control.Resevar();
                    }
                }

            }

            listaTrechos.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //  System.out.println(lse);
                    if (listaTrechos.getSelectedValue() != null) {
                        //System.out.println(listaTrechos.getSelectedValue());
                        //System.out.println(buscartrecho((Trecho)listaTrechos.getSelectedValue()));
                        mTrecho = listaTrechos.getSelectedValue();
                    }
                }
            });

        }
    }

    public Trecho buscartrecho(Trecho t) {
        List<Trecho> trechos = Trechos.retornarListaTrechos();
        for (int i = 0; trechos.size() > i; i++) {
            if (t.getId() == trechos.get(i).getId()) {
                return trechos.get(i);
            }
        }
        return null;
    }

    public void reservar(Trecho t) {
        List<Trecho> trechos = Trechos.retornarListaTrechos();
        Trecho t2 = null;
        for (int i = 0; trechos.size() > i; i++) {
            if (t.getId() == trechos.get(i).getId()) {
                t2 = trechos.get(i);
                break;
            }
        }

        if (t2 != null) {
            List<Espera> fila = t2.getFila();

            if (fila != null && !fila.isEmpty()) {
                Espera espera = null;
                for (Espera e : fila) {
                    if (e.getIp().equals("ip")) {
                        espera = e;
                        break;
                    }
                }
                if (espera != null) {
                    espera = new Espera();
                    espera.setIp("ip");
                    espera.setNum(fila.size() + 1);
                    fila.add(espera);
                    t.setFila(fila);
                    Trechos.retornarListaTrechos().remove(t);
                    Trechos.retornarListaTrechos().add(t);
                } else {
                    espera = new Espera();
                    espera.setIp("ip");
                    espera.setNum(1);
                    fila.add(espera);
                    t.setFila(fila);
                    Trechos.retornarListaTrechos().remove(t);
                    Trechos.retornarListaTrechos().add(t);
                }
            } else {
                Espera espera = new Espera();
                espera.setIp("ip");
                espera.setNum(1);
                fila.add(espera);
                t.setFila(fila);
                Trechos.retornarListaTrechos().remove(t);
                Trechos.retornarListaTrechos().add(t);
            }
        }
    }

    public boolean verificarReserva(Trecho mt) {
        List<Trecho> lista = trechosReserva;
        if (lista != null && !lista.isEmpty()) {
            for (Trecho t : lista) {
                //System.out.println(t.getId());
                if (t.getId() == mt.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
