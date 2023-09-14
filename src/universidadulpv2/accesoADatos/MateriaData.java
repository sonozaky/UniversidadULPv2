
package universidadulpv2.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulpv2.entidades.Materia;


public class MateriaData {
    private Connection con=null;
    
    public MateriaData(){
        con=Conexion.getConexion();
    }

    public List<Materia> traerMaterias() {
        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia matt = new Materia();
                matt.setIdMateria(rs.getInt("idMateria"));
                matt.setCodigo(rs.getInt("codigo"));
                matt.setNombre(rs.getString("nombre"));
                matt.setAnioMateria(rs.getInt("anioMateria"));
                matt.setActivo(rs.getBoolean("activo"));
                materias.add(matt);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return materias;
    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE  materia SET activo=0 WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mataeria borrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }
    
    
    public void nuevaMateria(Materia materia) {
        String sql = "INSERT INTO materia (codigo,nombre, anioMateria, activo) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, materia.getCodigo());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getAnioMateria());
            ps.setBoolean(4, materia.isActivo()); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }
    
    public void modificarMateria(Materia mater) {
        String sql = "UPDATE materia SET codigo=?, nombre=?, anioMateria=? WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mater.getCodigo());
            ps.setString(2, mater.getNombre());
            ps.setInt(3, mater.getAnioMateria());
            ps.setInt(4, mater.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia para modificar");
        }
    }
    
        public Materia traerMateriaID(int id) {
            Materia matt=new Materia();
        try {
            String sql = "SELECT * FROM materia WHERE activo = 1 AND idMateria= "+id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                matt.setIdMateria(rs.getInt("idMateria"));
                matt.setCodigo(rs.getInt("codigo"));
                matt.setNombre(rs.getString("nombre"));
                matt.setAnioMateria(rs.getInt("anioMateria"));
                matt.setActivo(rs.getBoolean("activo"));

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia " + ex.getMessage());
        }
        return matt;
    }
}
