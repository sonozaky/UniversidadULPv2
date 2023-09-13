
package universidadulpv2.entidades;


public class Inscripcion {
private int idInscripcion;
    private int nota;
    public Alumno idAlumno;
    private Materia idMateria;

    public Inscripcion() {
    }

    public Inscripcion(Alumno idAlumno, Materia idMateria) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    
    
    public Inscripcion(int nota, Alumno idAlumno, Materia idMateria) {
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public Inscripcion(int idInscripcion, int nota, Alumno idAlumno, Materia idMateria) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        String insc=idInscripcion+" "+idAlumno.getApellido()+" "+idAlumno.getNombre()+" "+idMateria.getNombre();
        return  insc;
    }
}
