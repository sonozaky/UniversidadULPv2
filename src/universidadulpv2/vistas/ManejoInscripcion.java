/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadulpv2.vistas;


import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadulpv2.accesoADatos.AlumnoData;
import universidadulpv2.accesoADatos.InscripcionData;
import universidadulpv2.accesoADatos.MateriaData;
import universidadulpv2.entidades.Alumno;
import universidadulpv2.entidades.Inscripcion;
import universidadulpv2.entidades.Materia;

/**
 *
 * @author shion
 */
public class ManejoInscripcion extends javax.swing.JInternalFrame {
    public DefaultTableModel modelo = new DefaultTableModel();
    AlumnoData controlAlumn = null;
    MateriaData controlMateria = null;
    InscripcionData controlIns = null;
    int idAlumnito;
    int numerito;
    boolean botonInsc=true;
    boolean botonNoInsc=true;

    /**
     * Creates new form ManejoInscripcion
     */
    public ManejoInscripcion() {
        controlAlumn=new AlumnoData();
        controlMateria=new MateriaData();
        controlIns=new InscripcionData();
        initComponents();
        cargarCombo();
        encabezadoTabla();
        borrarFilas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxAlumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        rbtnMaterIns = new javax.swing.JRadioButton();
        rbtnMaterNoIns = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaterias = new javax.swing.JTable();
        btnInscribir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno:");

        cbxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setText("Listado de Materias");

        rbtnMaterIns.setText("Materias Inscriptas");
        rbtnMaterIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaterInsActionPerformed(evt);
            }
        });

        rbtnMaterNoIns.setText("Materias No Inscriptas");
        rbtnMaterNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaterNoInsActionPerformed(evt);
            }
        });

        tbMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbMaterias);

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnAnular.setText("Anular Inscripcion");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnMaterIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnMaterNoIns)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnMaterIns)
                    .addComponent(rbtnMaterNoIns))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInscribir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnosActionPerformed
        borrarFilas();
        Alumno alumnoSeleccionado = (Alumno) cbxAlumnos.getSelectedItem();
        idAlumnito = alumnoSeleccionado.getIdAlumno();
     
        for (Inscripcion insc : controlIns.traerInscripciones()) {
            if (insc.getIdAlumno().getIdAlumno() == idAlumnito) {
                controlIns.obtenerMateriasCursadas(insc.getIdMateria().getIdMateria());
                modelo.addRow(new Object[]{
                    insc.getIdMateria().getCodigo(),
                    insc.getIdMateria().getNombre(),
                    insc.getIdMateria().getAnioMateria()});
            }           
        }       
    }//GEN-LAST:event_cbxAlumnosActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        Alumno alumnoSeleccionado = (Alumno) cbxAlumnos.getSelectedItem();
        Inscripcion nuevaInscripcion=new Inscripcion();
        Materia materiaSeleccionada=new Materia();
        idAlumnito = alumnoSeleccionado.getIdAlumno();
        if (tbMaterias.getRowCount() > 0) {
            if (tbMaterias.getSelectedRow() != -1) {
                int cumCod = Integer.parseInt(String.valueOf(tbMaterias.getValueAt(tbMaterias.getSelectedRow(), 0)));
                
                for (Materia mate : controlMateria.traerMaterias()) {
                    if (cumCod == mate.getCodigo()) {
                        materiaSeleccionada.setIdMateria(mate.getIdMateria());
                    }
                }
                nuevaInscripcion.setIdAlumno(alumnoSeleccionado);
                nuevaInscripcion.setIdMateria(materiaSeleccionada);
                controlIns.guardarInscripcion(nuevaInscripcion);

            } else {
                mostrarMensaje("No marcó ninguna opcion", "Error", "Falló la carga");
            }
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbtnMaterInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaterInsActionPerformed
        if (botonNoInsc=true) {
            rbtnMaterNoIns.setSelected(false);
        }
        borrarFilas();
        for (Inscripcion insc : controlIns.traerInscripciones()) {
            if (insc.getIdAlumno().getIdAlumno() == idAlumnito) {
                modelo.addRow(new Object[]{
                    insc.getIdMateria().getCodigo(),
                    insc.getIdMateria().getNombre(),
                    insc.getIdMateria().getAnioMateria()});
            }           
        }
    }//GEN-LAST:event_rbtnMaterInsActionPerformed

    private void rbtnMaterNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaterNoInsActionPerformed
        if (botonInsc=true) {
            rbtnMaterIns.setSelected(false);
        }
        borrarFilas();

        List<Materia> noInsc = controlIns.obtenerMateriasNoCursadas(idAlumnito);
        for (Materia insc : noInsc) {
            modelo.addRow(new Object[]{
                insc.getIdMateria(),
                insc.getNombre(),
                insc.getAnioMateria()});

        }

    }//GEN-LAST:event_rbtnMaterNoInsActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        Alumno alumnoSeleccionado = (Alumno) cbxAlumnos.getSelectedItem();
        idAlumnito = alumnoSeleccionado.getIdAlumno();
        if (tbMaterias.getRowCount() > 0) {
            if (tbMaterias.getSelectedRow() != -1) {
                int cumCod = Integer.parseInt(String.valueOf(tbMaterias.getValueAt(tbMaterias.getSelectedRow(), 0)));                
                for (Materia mate : controlMateria.traerMaterias()) {
                    if (cumCod == mate.getCodigo()) {
                      controlIns.borrarInscripcionMateria(idAlumnito, mate.getIdMateria());  
                    }
                }                
            } else {
                mostrarMensaje("No marcó ninguna opcion", "Error", "Falló la carga");
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cbxAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbtnMaterIns;
    private javax.swing.JRadioButton rbtnMaterNoIns;
    private javax.swing.JTable tbMaterias;
    // End of variables declaration//GEN-END:variables
    
    private void cargarCombo() {
        for (Alumno listita : controlAlumn.traerAlumnos()) {
            cbxAlumnos.addItem(new Alumno(listita.getIdAlumno(), listita.getDni(), listita.getApellido(), listita.getNombre()));
        }
    }
           
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else if(tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialogo = optionPane.createDialog(titulo);
        dialogo.setAlwaysOnTop(true);
        dialogo.setVisible(true);       
    }
    
    private void encabezadoTabla(){
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        tbMaterias.setModel(modelo);
    }
    
    public void borrarFilas() {
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
       
}
