/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static mainPackage.IngresarAlSistema.conexion;


/**
 *
 * @author Success
 */
public class AdministrarUsuarios extends javax.swing.JFrame {
    
    
     Operaciones operacion = new Operaciones();
     
     
    Font deletingUser = new Font("Arial",Font.BOLD,12);
    
    //static boolean flag=false;
    
    static int tableSize=0,tableSizeComparator=0;
    static PreparedStatement pre;
    static ResultSet res, spaceUsed;
    static String testUsers[] = new String[4]; //Este arreglo es para conseguir un renglón de datos según el ID cuando el de CONSULTAR está activo
    static int unPunto=0;
    
    /**
     * Creates new form agregarModificarUsuario
     */
    public AdministrarUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
                    
        TextPrompt tp7 = new TextPrompt("Ejemplo: adminAurea333", jTextField1);
        //TextPrompt tp8 = new TextPrompt("Ejemplo: Leonardo David Madrigal Arellano", jComboBox2);
        TextPrompt tp9 = new TextPrompt("Cualquier combinación caracteres es aceptada", jTextField3);
        tp7.changeAlpha(0.5f);
        tp7.changeStyle(Font.ITALIC);
        //tp8.changeAlpha(0.5f);
        //tp8.changeStyle(Font.ITALIC);
        tp9.changeAlpha(0.5f);
        tp9.changeStyle(Font.ITALIC);
        
        
        jRadioButton1.setSelected(true);
        jRadioButton2.setEnabled(false);
        jRadioButton3.setEnabled(false);
        jRadioButton5.setVisible(false);
        jRadioButton5.setSelected(true);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
        
        
        
        
        jComboBox2.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                
                if(jRadioButton6.isSelected())
                {
                String cadenaEscrita = jComboBox2.getEditor().getItem().toString();

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   if(comparar(cadenaEscrita)){// compara si el texto escrito se ecuentra en la lista
                       // busca el texto escrito en la base de datos
                       buscar(cadenaEscrita);
                   }else{// en caso contrario toma como default el elemento 0 o sea el primero de la lista y lo busca.
                    buscar(jComboBox2.getItemAt(0).toString());
                    jComboBox2.setSelectedIndex(0);
                    }
                }


                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    jComboBox2.setModel(operacion.getLista(cadenaEscrita));
                    if (jComboBox2.getItemCount() > 0) {
                        jComboBox2.getEditor().setItem(cadenaEscrita);
                        jComboBox2.showPopup();                     

                    } else {
                        jComboBox2.addItem(cadenaEscrita);
                    }
                }
            }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Clave:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Tipo:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador" }));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jToggleButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jToggleButton4.setText("Aceptar");
        jToggleButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton4MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton1.setText("Agregar");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton2.setText("Modificar");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton3.setText("Eliminar");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton4.setText("Consultar");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("ADMINISTRACIÓN DE USUARIOS");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Por ID");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Por Nombre");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("Mostrar todas las ID");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jComboBox2.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton7))))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel5)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5))
                        .addGap(1, 1, 1)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton6)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton7)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextField1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //PARA VALIDAR EL NOMBRE DE USUARIO Y EL NOMBRE REAL DEL USUARIO
    
    public static void fieldCleaner()
    {
        jTextField1.setText("");
        jComboBox2.getEditor().setItem("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
    }
    
    public static boolean validadorNombresAgregar()
    {
        tableSize=0;tableSizeComparator=0;
        
        ResultSet res, spaceUsed;
    
        String testUsers[][] = new String[3][1];

        res=Conexion.Consulta("execute selectionForAccess");   
        spaceUsed=Conexion.Consulta("execute getRowCount"); 
        
        try{
            while (spaceUsed.next()){
             tableSize=spaceUsed.getInt(1);
            }
        }catch(SQLException e)
        {}
       
        try
        {
            while(res.next())
            {
                testUsers[0][0]=res.getString(1);
                tableSizeComparator++;
                
                if(jTextField1.getText().equals(testUsers[0][0]))
                {
                    tableSizeComparator=0;
                    JOptionPane.showMessageDialog(null, "El nombre de usuario "+jTextField1.getText()+" ya está en uso ","Error en el nombre de usuario",JOptionPane.PLAIN_MESSAGE);
                   return false;
                }
            }
        }
        catch(SQLException e)
        {}
        
            for(int i=0; i<(jComboBox2.getEditor().getItem().toString()).length();i++)
            {
                if(jComboBox2.getEditor().getItem().toString().charAt(i)==49)
                {unPunto++;}
            }
        
            if(jTextField1.getText().length()<5 || jTextField1.getText().length()>20)
            {
               JOptionPane.showMessageDialog(null, "El nombre de usuario tiene que ser de al "
                        + "menos 5 caracteres y de máximo 20","Error en el nombre de usuario",JOptionPane.PLAIN_MESSAGE);
               return false;
            }
            else if(jComboBox2.getEditor().getItem().toString().length()<10 || jComboBox2.getEditor().getItem().toString().length()>50)
            {
                JOptionPane.showMessageDialog(null, "El nombre real del usuario tiene que ser de al "
                        + "menos 10 caracteres y de máximo 50","Error en el nombre real del usuario",JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            else if(jTextField3.getText().length()<5 || jTextField3.getText().length()>30)
            {
                JOptionPane.showMessageDialog(null, "La clave debe ser de al menos 5 caracteres y "
                        + "de máximo 30","Error en la clave",JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            else
            {
                for(int i=0;i<jComboBox2.getEditor().getItem().toString().length();i++)
                {
                    if((jComboBox2.getEditor().getItem().toString()).indexOf("..")>0 || (jComboBox2.getEditor().getItem().toString()).indexOf("  ")>0)
                    {
                        JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener dos puntos seguidos ni dos espacios seguidos","Error en el nombre real del usuario",JOptionPane.PLAIN_MESSAGE);
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                return true;
            }
            
            
    }
    
    public static boolean validadorNombresModificar()
    {
        tableSize=0;tableSizeComparator=0;
        
        ResultSet res, spaceUsed;
    
        String testUsers[][] = new String[3][1];

        res=Conexion.Consulta("execute selectionForAccess");   
        spaceUsed=Conexion.Consulta("execute getRowCount"); 
        
        try{
            while (spaceUsed.next()){
             tableSize=spaceUsed.getInt(1);
            }
        }catch(SQLException e)
        {}
        
            if(jComboBox2.getEditor().getItem().toString().length()<10 || jComboBox2.getEditor().getItem().toString().length()>50)
            {
                JOptionPane.showMessageDialog(null, "El nombre real del usuario tiene que ser de al "
                        + "menos 10 caracteres y de máximo 50","Error en el nombre real del usuario",JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            else if(jTextField3.getText().length()<5 || jTextField3.getText().length()>30)
            {
                JOptionPane.showMessageDialog(null, "La clave debe ser de al menos 5 caracteres y "
                        + "de máximo 30","Error en la clave",JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            else
            {
                for(int i=0;i<jComboBox2.getEditor().getItem().toString().length();i++)
                {
                    if((jComboBox2.getEditor().getItem().toString()).indexOf("..")>0 || (jComboBox2.getEditor().getItem().toString()).indexOf("  ")>0)
                    {
                        JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener dos puntos seguidos ni dos espacios seguidos","Error en el nombre real del usuario",JOptionPane.PLAIN_MESSAGE);
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                return true;
            }
            
            
    }
    
    
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed

       jLabel1.setEnabled(true);
       jTextField1.setEnabled(true);
       jTextField1.setEditable(false);
       jTextField1.setBackground(Color.RED);
        jLabel2.setEnabled(false);
       jComboBox2.setEnabled(false);
        jLabel3.setEnabled(false);
       jTextField3.setEnabled(false);
        jLabel4.setEnabled(false);
       jComboBox1.setEnabled(false);
       
       jRadioButton5.setVisible(false);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed
//**********************ELPRIMERO ES ESTE DE ABAJO XDXDXDXDX****************************
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
        jTextField1.setEditable(true);
       jTextField1.setBackground(Color.WHITE);
        
        jLabel1.setEnabled(true);
       jTextField1.setEnabled(true);
        jLabel2.setEnabled(true);
       jComboBox2.setEnabled(true);
        jLabel3.setEnabled(true);
       jTextField3.setEnabled(true);
        jLabel4.setEnabled(true);
       jComboBox1.setEnabled(true);
       
       jRadioButton2.setEnabled(false);
       jRadioButton3.setEnabled(false);
       
       jTextField1.setText("");
       jComboBox2.getEditor().setItem("");
       jTextField3.setText("");
       
       jRadioButton5.setVisible(false);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
       
       
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       jTextField1.setBackground(Color.WHITE);
        jLabel1.setEnabled(false);
       jTextField1.setEnabled(false);
        jLabel2.setEnabled(true);
       jComboBox2.setEnabled(true);
        jLabel3.setEnabled(true);
       jTextField3.setEnabled(true);
        jLabel4.setEnabled(true);
       jComboBox1.setEnabled(true);
       
       jRadioButton5.setVisible(false);
        jRadioButton6.setVisible(false);
        jRadioButton7.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
       
        
        
        jTextField1.setEditable(true);
       jTextField1.setBackground(Color.WHITE);
        jLabel1.setEnabled(true);
       jTextField1.setEnabled(true);
        jLabel2.setEnabled(false);
       jComboBox2.setEnabled(false);
        jLabel3.setEnabled(false);
       jTextField3.setEnabled(false);
        jLabel4.setEnabled(false);
       jComboBox1.setEnabled(false);
       
       jRadioButton5.setSelected(true);

       jRadioButton5.setVisible(true);
        jRadioButton6.setVisible(true);
        jRadioButton7.setVisible(true);
       
       
       
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        InterfazAdministrador InterfazAdministrador  = new InterfazAdministrador ();
        InterfazAdministrador.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jToggleButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MouseClicked
         
        try
        {
            conexion = Conexion.realizarConexion();

            if(jRadioButton1.isSelected())
            {
                if(validadorNombresAgregar()==true)
                {
                    pre=conexion.prepareStatement("{call insertNewUser(?,?,?,?)}");

                    pre.setString(1,jTextField1.getText());
                    pre.setString(2,jComboBox2.getEditor().getItem().toString());
                    pre.setString(3,jTextField3.getText());
                    pre.setString(4,String.valueOf(jComboBox1.getSelectedItem()));
                    pre.executeUpdate();

                    JOptionPane.showMessageDialog(null, "USUARIO [ "+jComboBox2.getEditor().getItem().toString()+" ] AGREGADO CORRECTAMENTE A "+String.valueOf(jComboBox1.getSelectedItem())+"es","Usuario agregado",JOptionPane.PLAIN_MESSAGE);
                    
                    fieldCleaner();
                }

            }
            else if(jRadioButton2.isSelected())
            {
                if(validadorNombresModificar()==true)
                {
                    pre=conexion.prepareStatement("{call modifyUser(?,?,?,?)}");

                    pre.setString(1,jTextField1.getText());
                    pre.setString(2,jComboBox2.getEditor().getItem().toString());
                    pre.setString(3,jTextField3.getText());
                    pre.setString(4,String.valueOf(jComboBox1.getSelectedItem()));
                    pre.executeUpdate();

                    JOptionPane.showMessageDialog(null, "DATOS DEL USUARIO ["+jTextField1.getText()+" ] MODIFICADOS CORRECTAMENTE","Usuario modificado",JOptionPane.PLAIN_MESSAGE);
                }
            }
            
            else if(jRadioButton3.isSelected())
            {
                pre=conexion.prepareStatement("{call deleteUser(?)}");
                pre.setString(1,jTextField1.getText());
                pre.executeUpdate();
                
                jRadioButton2.setEnabled(false);
                jRadioButton3.setEnabled(false);
                jRadioButton4.setSelected(true);

                JOptionPane.showMessageDialog(null, "USUARIO ["+jTextField1.getText()+" ] ELIMINADO CORRECTAMENTE","Usuario eliminado",JOptionPane.PLAIN_MESSAGE);
                
                 jTextField1.setBackground(Color.WHITE);
                 jTextField1.setEditable(true);
                 fieldCleaner();
                 
                 
            }
            
            else if(jRadioButton4.isSelected())
            {
                 res=Conexion.Consulta("execute consultUser");   
                 spaceUsed=Conexion.Consulta("execute getRowCount"); 

                 try
                 {
                    while (spaceUsed.next())
                    {
                       tableSize=spaceUsed.getInt(1);
                    }
                 }
                 catch(SQLException e)
                 {}
                 String totalConsult[]= new String [tableSize];
                    while(res.next())
                    {
                        

                        testUsers[0]=res.getString(1);  //ID DEL USUARIO
                        testUsers[1]=res.getString(2);  //NOMBRE DEL USUARIO
                        testUsers[2]=res.getString(3);  //CLAVE DEL USUARIO
                        testUsers[3]=res.getString(4);  //TIPO DEL USUARIO
                        
                        if(jRadioButton5.isSelected())
                        {
                            if(((jTextField1.getText()).equals(testUsers[0])))
                            {

                                jRadioButton2.setEnabled(true);
                                jRadioButton3.setEnabled(true);
                                JOptionPane.showMessageDialog(null, "USUARIO ENCONTRADO \n Usted ahora puede: \n Modificar los datos del usuario \n Eliminar al usuario","USUARIO ENCONTRADO",JOptionPane.PLAIN_MESSAGE);
                                jComboBox2.getEditor().setItem(testUsers[1]);
                                jTextField3.setText(testUsers[2]);
                                if(testUsers[3].equals("Administrador"))
                                {
                                    jComboBox1.setSelectedIndex(1);
                                }
                                else
                                {
                                     jComboBox1.setSelectedIndex(0);
                                }
                                break;
                            }
                            else if(tableSizeComparator==tableSize-1)
                            {
                                
                                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO","USUARIO NO ENCONTRADO",JOptionPane.PLAIN_MESSAGE);
                                break;
                            }
                        }
                        else if(jRadioButton6.isSelected())
                        {
                            if(((jComboBox2.getEditor().getItem().toString()).equals(testUsers[1])))
                            {

                                jRadioButton2.setEnabled(true);
                                jRadioButton3.setEnabled(true);
                                JOptionPane.showMessageDialog(null, "USUARIO ENCONTRADO \n Usted ahora puede: \n Modificar los datos del usuario \n Eliminar al usuario","USUARIO ENCONTRADO",JOptionPane.PLAIN_MESSAGE);
                                jTextField1.setText(testUsers[0]);
                                jTextField3.setText(testUsers[2]);
                                if(testUsers[3].equals("Administrador"))
                                {
                                    jComboBox1.setSelectedIndex(1);
                                }
                                else
                                {
                                     jComboBox1.setSelectedIndex(0);
                                }
                                break;
                            }
                            else if(tableSizeComparator==tableSize-1)
                           {
                                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO","USUARIO NO ENCONTRADO",JOptionPane.PLAIN_MESSAGE);
                                break;
                            }
                        }
                        else if(jRadioButton7.isSelected())
                        {
                            jRadioButton2.setEnabled(false);
                            jRadioButton3.setEnabled(false);
                            System.out.println(tableSizeComparator);
                            totalConsult[tableSizeComparator]=testUsers[0];
                            if(tableSizeComparator==tableSize-1)
                           {
                               
                               JOptionPane.showMessageDialog(null, Arrays.toString(totalConsult));
                               break;
                            }
                                
                            
                        }
                        tableSizeComparator++;
                    }
                    tableSizeComparator=0;
            }                
        }
        catch (SQLException e)
        {JOptionPane.showMessageDialog(null,e.getMessage());}  
        
    }//GEN-LAST:event_jToggleButton4MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

        
    int values = (int) evt.getKeyChar(); 
        
      if (values!=8 && (values<48 || values>57) && (values<65 || values>90) && (values<97 || values>122)) 
      { 
        evt.consume(); 
        JOptionPane.showMessageDialog(null, "Sólo letras y números, juntos ","Caracter no válido presionado", JOptionPane.PLAIN_MESSAGE); 
      }
        
        
        
      /*PARA QUE SÓLO ACEPTE NÚMEROS, NO APLICA AQUÍ
      int value = (int) evt.getKeyChar(); 
        
      if (value<58 && value>48 || value==8) 
      {}
      else
      {
        evt.consume(); 
        JOptionPane.showMessageDialog(null, " Caracter erróneo ", " Error detectado ", JOptionPane.ERROR_MESSAGE); 
      }
      */
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed

        jLabel1.setEnabled(true);
       jTextField1.setEnabled(true);
        jLabel2.setEnabled(false);
       jComboBox2.setEnabled(false);

    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jLabel1.setEnabled(false);
       jTextField1.setEnabled(false);
        jLabel2.setEnabled(true);
       jComboBox2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        jLabel1.setEnabled(false);
       jTextField1.setEnabled(false);
       jLabel2.setEnabled(false);
       jComboBox2.setEnabled(false);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    
    private boolean comparar(String cadena){
    Object [] lista=jComboBox2.getComponents();
    boolean encontrado=false;
        for (Object object : lista) {
            if(cadena.equals(object)){
                encontrado=true;
              break;
            }

        }
       return encontrado;
    }
    
    public void buscar(String nombre) {
        String datos[] = operacion.buscar(nombre);

        if (datos[0] != null) {
            jTextField1.setText(datos[0]);
            jComboBox2.getEditor().setItem(datos[1]);
            jTextField3.setText(datos[2]);

        } else {

            JOptionPane.showMessageDialog(rootPane, "No se encontro ningun archivo", "Error", JOptionPane.WARNING_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarUsuarios().setVisible(true);
            }
        });
        

        

        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private static javax.swing.JButton jButton1;
    private static javax.swing.JComboBox<String> jComboBox1;
    private static javax.swing.JComboBox<String> jComboBox2;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JRadioButton jRadioButton1;
    private static javax.swing.JRadioButton jRadioButton2;
    private static javax.swing.JRadioButton jRadioButton3;
    private static javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField3;
    private static javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables
}
