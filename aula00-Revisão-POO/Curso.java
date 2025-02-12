import java.util.List;
import java.util.ArrayList;

public class Curso {
    private String nomeCurso;
    private List<Disciplina> disciplinas;

    
    public Curso() {
        this("");
    }

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.disciplinas = new ArrayList<Disciplina>();
       
    }

   
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

 
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public int CargaHorariaTotal() {
        int cargaHorariaTotal = 0;
        for (Disciplina  n : disciplinas) {
            cargaHorariaTotal += n.getCargaHoraria();
        }
        return cargaHorariaTotal;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + getNomeCurso() + '\'' +
                ", disciplinas=" + getDisciplinas() +
                ", carga horaria=" + CargaHorariaTotal() +
                '}';
    }
    
}
