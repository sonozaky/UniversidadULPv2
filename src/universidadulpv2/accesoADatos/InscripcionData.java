
package universidadulpv2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulpv2.entidades.Inscripcion;
import universidadulpv2.entidades.Materia;

//Instanci conexcion
public class InscripcionData {
    private Connection con = null;
//Asigna la conexcion
    public InscripcionData() {
        con = Conexion.getConexion();
    }
    //Carga las inscripciones
    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion(nota,idAlumno,idMateria)"
                + "VALUE (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 0);
            ps.setInt(2, insc.getIdAlumno().getIdAlumno());
            ps.setInt(3, insc.getIdMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }
    //Borra Inscripcion(ManejoInscripcion)
    public void borrarInscripcionMateria(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            }else if (exito>=2) {
                JOptionPane.showMessageDialog(null, "Multiples copias borradas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }
    //Actualiza la nota (ModificarNota)
    public void actualizarNota(int notita, int id){
        String sql = "UPDATE inscripcion SET nota=?  WHERE idInscripcion=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,notita );
            ps.setInt(2,id );
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Nota modificada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }
    //Trae las inscripciones de la base de datos
    public List<Inscripcion> traerInscripciones(){
        List<Inscripcion> inscripcions = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion WHERE idInscripcion > 0 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();     
            while (rs.next()) {
                AlumnoData alum=new AlumnoData();
                MateriaData mater=new MateriaData();
                Inscripcion nuevaInscripcion=new Inscripcion();
                nuevaInscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                nuevaInscripcion.setNota(rs.getInt("nota"));
                nuevaInscripcion.setIdAlumno(alum.traerAlumnoID(rs.getInt("idAlumno")));
                nuevaInscripcion.setIdMateria(mater.traerMateriaID(rs.getInt("idMateria")));
                inscripcions.add(nuevaInscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
        return inscripcions;
    }
    //Genera lista de materias cursadas (ManejoInscripcion)
    public List<Materia> obtenerMateriasCursadas(int in){
        List<Materia> materias = new ArrayList<>();
        String sql="SELECT * FROM materia WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, in);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Materia newMateria=new Materia();
                newMateria.setIdMateria(rs.getInt("idMateria"));
                newMateria.setCodigo(rs.getInt("codigo"));
                newMateria.setNombre(rs.getString("nombre"));
                newMateria.setAnioMateria(rs.getInt("anioMateria"));
                newMateria.setActivo(rs.getBoolean("activo"));
                materias.add(newMateria);               
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
        return  materias;
    }
    
    //Busca por la id
    public Inscripcion buscarInscripcionID(int id){
        String sql="SELECT idInscripcion, nota, idAlumno, idMateria FROM Inscripcion WHERE idInscripcion=?";
        Inscripcion insc=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                insc=new Inscripcion();
                AlumnoData alum=new AlumnoData();
                MateriaData mater=new MateriaData();
                insc.setIdInscripcion(id);
                insc.setNota(rs.getInt("nota"));
                insc.setIdAlumno(alum.traerAlumnoID(rs.getInt("idAlumno")));
                insc.setIdMateria(mater.traerMateriaID(rs.getInt("idMateria")));
            }/*else{
                JOptionPane.showMessageDialog(null, "No existe el ID de la inscripcion");
            }*/
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return insc;
    }

     //Genera lista de materias no cursadas (ManejoInscripcion)
        public List<Materia> obtenerMateriasNoCursadas(int in){
            List<Materia> materias = new ArrayList<>();
            String sql = "SELECT codigo, nombre, anioMateria FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, in);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int subjectId = rs.getInt("codigo");
                    String subjectName = rs.getString("nombre");
                    int anioMat = rs.getInt("anioMateria");
                    Materia subject = new Materia(subjectId, subjectName, anioMat);
                    materias.add(subject);
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Inscripcion " + ex.getMessage());
            }
            return materias;
    }
}
