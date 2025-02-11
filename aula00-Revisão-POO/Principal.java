public class Principal{

    public static void main(String[] args) {

        Aluno aluno01 = new Aluno("Cawa",35,215551652,1004);
        System.out.println(aluno01.toString()); 

        Professor professor1 = new Professor ("Matheus",26,525525252,25);
        System.out.println(professor1.toString());

        Professor professor2 = new Professor ("Math",23,52525252,23);
        System.out.println(professor2.toString());

        Disciplina disciplina = new Disciplina ("Web 2");
        System.out.println(disciplina.toString());
    }
    
}