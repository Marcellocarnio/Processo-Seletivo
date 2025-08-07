import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args){
            String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Lucas", "Fernanda", "Carlos", "Beatriz", "Rafael", "Juliana"};
           
            for (String candidato: candidatos) {
                entrandoEmContato(candidato);
            }
        }
        static void entrandoEmContato(String candidato) {
            int tentativasRealizadas = 1;
            boolean continuarTentando = false;
            boolean atendeu = false;
            do{
                atendeu = atender();
                continuarTentando = !atendeu;
                if (continuarTentando) 
                    tentativasRealizadas++;
                else 
                    System.out.println("Contato realizado com sucesso");

            }while (continuarTentando && tentativasRealizadas <= 3);
            if (atendeu) {
                System.out.println("Conseguimos contato com o " + candidato + " na tentativa " + tentativasRealizadas + ".");
            } else {
                System.out.println("Não conseguimos contato com o " + candidato + " após " + tentativasRealizadas + " tentativas.");
            }
        }

        static boolean atender() {
            return new Random().nextInt(3) == 1;
        }

        static void imprimirCandidatosSelecionados(String[] candidatosSelecionados) {
            System.out.println("Imprimindo lista de candidatos selecionados: ");

            for (int indice = 0; indice < candidatosSelecionados.length; indice++) {
                System.out.println("Candidato " + (indice + 1) + ": " + candidatosSelecionados[indice]);
            }

        }

        static void selecionarCandidatos() {
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Lucas", "Fernanda", "Carlos", "Beatriz", "Rafael", "Juliana"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato =  candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println(" O canditado " + candidato + " solicitou o salário de " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("Candidato " + candidato + " selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0,2200.0);
    }

    static void analisandoCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o Candidato");
            
        }if (salarioBase == salarioPretendido) {
            System.out.println("Ligar e oferecer uma contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
