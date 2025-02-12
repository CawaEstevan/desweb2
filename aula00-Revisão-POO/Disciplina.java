import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private String nomeDisciplina;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private int cargaHoraria; 

    // Construtores
    public Disciplina(String nomeDisciplina, int cargaHoraria) {
        this(nomeDisciplina, new ArrayList<Aluno>(), new ArrayList<Professor>(), cargaHoraria);  
    }

    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, new ArrayList<Aluno>(), new ArrayList<Professor>(), 0);  
    }

    public Disciplina(String nomeDisciplina, List<Aluno> alunos, List<Professor> professores, int cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.alunos = alunos;
        this.professores = professores;
        this.cargaHoraria = cargaHoraria;  
    }

   
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeDisciplina() {
        return this.nomeDisciplina;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return this.professores;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    
    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void addProfessor(Professor professor) {
        this.professores.add(professor);
    }

   
    @Override
    public String toString() {
        return "Disciplina {" +
                "nomeDisciplina='" + nomeDisciplina + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", alunos=" + alunos +
                ", professores=" + professores +
                '}';
    }
}
