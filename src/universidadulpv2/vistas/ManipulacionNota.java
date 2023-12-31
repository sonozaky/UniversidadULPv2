/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadulpv2.vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadulpv2.accesoADatos.AlumnoData;
import universidadulpv2.accesoADatos.InscripcionData;
import universidadulpv2.accesoADatos.MateriaData;
import universidadulpv2.entidades.Alumno;
import universidadulpv2.entidades.Inscripcion;


/**
 *
 * @author shion
 */
public class ManipulacionNota extends javax.swing.JInternalFrame {
AlumnoData controlAlumn=null;
MateriaData controlMateria=null;
InscripcionData controlInsc=null;
int idAlumnoBuscar=0;
    /**
     * Creates new form ManipulacionNota
     */
    public ManipulacionNota() {
        controlAlumn = new AlumnoData();
        controlMateria = new MateriaData();
        controlInsc = new InscripcionData();
        initComponents();
        cargarCombo();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); 
//        cargarTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaterias = new javax.swing.JTable();
        editarNota = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setText("Seleccione un Alumno");

        cbxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnosActionPerformed(evt);
            }
        });

        tbMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbMaterias);

        editarNota.setText("Editar");
        editarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarNotaActionPerformed(evt);
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
                .addGap(58, 58, 58)
                .addComponent(editarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnosActionPerformed
        cargarTabla();
        Alumno alumnoSeleccionado=(Alumno)cbxAlumnos.getSelectedItem();
        idAlumnoBuscar=alumnoSeleccionado.getIdAlumno();
        cargarTablaAlumnoSeleccionado();
    }//GEN-LAST:event_cbxAlumnosActionPerformed

    private void editarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarNotaActionPerformed
        // TODO add your handling code here:
        int NotaCambiar = Integer.parseInt(String.valueOf(tbMaterias.getValueAt(tbMaterias.getSelectedRow(), 0)));

        ModificarNota modificarNota = new ModificarNota(NotaCambiar);
        modificarNota.setVisible(true);
        modificarNota.setLocationRelativeTo(null);
    }//GEN-LAST:event_editarNotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cbxAlumnos;
    private javax.swing.JButton editarNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbMaterias;
    // End of variables declaration//GEN-END:variables

private void cargarCombo() {
        for (Alumno listita : controlAlumn.traerAlumnos()) {
            cbxAlumnos.addItem(new Alumno(listita.getIdAlumno(),listita.getDni(), listita.getApellido(), listita.getNombre()));
        }
    }

    public void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[]={"Codigo","Nombre","Nota"};
        modelo.setColumnIdentifiers(titulos);
        
        List <Inscripcion> listaInsc= controlInsc.traerInscripciones();
        if (listaInsc!=null) {
            for (Inscripcion insc : listaInsc) {
                Object[] objetos= {insc.getIdInscripcion(),insc.getIdMateria(),insc.getNota()};
                modelo.addRow(objetos);
            }
        }
        tbMaterias.setModel(modelo);
        
    }
    public void cargarTablaAlumnoSeleccionado(){
       DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[]={"Codigo","Nombre","Nota"};
        modelo.setColumnIdentifiers(titulos);
        
        List <Inscripcion> listaInsc= controlInsc.traerInscripciones();
        if (listaInsc!=null) {
            for (Inscripcion insc :listaInsc) {
                if(insc.getIdAlumno().getIdAlumno()==idAlumnoBuscar){
                    
                
                Object[] objetos= {insc.getIdInscripcion(),insc.getIdMateria(),insc.getNota()};
                modelo.addRow(objetos);
           }
                }
        }
        tbMaterias.setModel(modelo); 
    }
    
}
