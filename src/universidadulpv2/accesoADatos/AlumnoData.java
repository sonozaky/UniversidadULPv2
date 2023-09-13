
package universidadulpv2.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulpv2.entidades.Alumno;


public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData(){
        con=Conexion.getConexion();
    }
    
    public void nuevoAlumno(Alumno alumno){
        String sql="INSERT INTO  alumno(dni,apellido,nombre,fechaNacimiento,activo)"
                + "VALUE (?,?,?,?,?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? "
                + "WHERE idAlumno=?";        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno para modificar");
        }
    }
    
    public void eliminarAlumno(int id){
        String sql="UPDATE  alumno SET activo=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Alumno borrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public Alumno buscarAlumnoID(int id){
        String sql="SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno=?"
                + "AND estado=1;";
        Alumno alumnito=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumnito=new Alumno();
                alumnito.setIdAlumno(id);
                alumnito.setDni(rs.getString("dni"));
                alumnito.setApellido(rs.getString("apellido"));
                alumnito.setNombre(rs.getString("nombre"));
                alumnito.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumnito.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el ID del alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumnito;
    }
    
    public Alumno buscarAlumnoDNI(String dni){
        String sql="SELECT idAlumno,dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=?"
                + "AND estado=1;";
        Alumno alumnito=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumnito=new Alumno();
                alumnito.setIdAlumno(rs.getInt("idAlumno"));
                alumnito.setDni(rs.getString("dni"));
                alumnito.setApellido(rs.getString("apellido"));
                alumnito.setNombre(rs.getString("nombre"));
                alumnito.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumnito.setActivo(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el ID del alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return alumnito;
    }
    
    public List<Alumno> traerAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getString("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                alumnos.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumnos;
    }
    
        public Alumno traerAlumnoID(int id){
            Alumno alumno = new Alumno();
        try {
            String sql = "SELECT * FROM alumno WHERE activo = 1 AND idAlumno= "+id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getString("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumno;
    }
}
