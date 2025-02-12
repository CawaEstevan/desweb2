public class Principal{

    public static void main(String[] args) {

        Aluno aluno01 = new Aluno("Cawa",35,215551652,1004);
        System.out.println(aluno01.toString());

        Aluno aluno02 = new Aluno("Carlos",30,2135651652,1204);
        System.out.println(aluno02.toString());

        Professor professor1 = new Professor ("Matheus",26,525525252,25);
        System.out.println(professor1.toString());

        Professor professor2 = new Professor ("Math",23,52525252,23);
        System.out.println(professor2.toString());


        Disciplina disciplina = new Disciplina ("Web 2");

         // Adicionando alunos e professores à disciplina
         disciplina.addAluno(aluno01);
         disciplina.addProfessor(professor1);
         disciplina.addProfessor(professor2);
         
         // Imprimindo a disciplina com os alunos e professores adicionados
         System.out.println(disciplina.toString());
        



    }
   



    
}