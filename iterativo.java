import java.util.Scanner;

class Candidato{
    
    private String nome,partido;
    private int votos;
    
    public Candidato(String nome,String partido){
        this.nome = nome;
        this.partido = partido;
        this.votos = 0;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPartido(String partido){
        this.partido = partido;
    }
    
    public void Vota(){
        votos++;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getPartido(){
        return this.partido;
    }
    
    public int getVotos(){
        return this.votos;
    }
    
}

class urna{
    
    Candidato c1;
    Candidato c2;
    int votos;
    int brancos;
    
    public urna(Candidato c1,Candidato c2){
        this.c1 = c1;
        this.c2 = c2;
        this.votos = 0;
        this.brancos = 0;
    }
    
    public void votar(int voto){
        votos++;
        if(voto==1){
            c1.Vota();
        }else if(voto==2){
            c2.Vota();
        }else{
            brancos++;
        }
    }
    
    public void exibirTotalGeralDeVotos(){
        System.out.println("VOTOS: " + votos);
    }
    
    public void exibirTotalDeVotosBrancosNulos(){
        System.out.println("VOTOS BRANCOS OU NULOS: " + brancos);
    }
    
    public void exibirTotalDeVotosDosCandidatos(){
        System.out.println("------CANDIDATO1------");
        System.out.println(c1.getNome() + ": " + c1.getVotos());
        System.out.println("");
        System.out.println("------CANDIDATO2------");
        System.out.println(c2.getNome() + ": " + c2.getVotos());
    }
    
    public void exibirDadosDoCandidatoVencedor(){ 
        if(c1.getVotos() > c2.getVotos()){  
            
            System.out.println("CANDIDATO1 VENCEU");
            System.out.println(c1.getNome() + ": " + c1.getVotos());
            
        }else if(c2.getVotos() > c1.getVotos()){
            
            System.out.println("CANDIDATO2 VENCEU");
            System.out.println(c2.getNome() + ": " + c2.getVotos());
            
        }else{
            System.out.println("EMPATE :(");
        }
    }
    
}

public class Teste{
    public static void main(String args[]){
        
        Candidato c1 = new Candidato("Jose","Partida da Felicidade");
        Candidato c2 = new Candidato("Joao","Partido da Esperanca");
        
        urna URNA = new urna(c1,c2);
        
        Scanner l = new Scanner(System.in);
        
        System.out.println("FUNCIONOU");
        
        int opc = -1;
        
        while(true){
            
            opc = l.nextInt();
            
            if(opc==0){break;}
            
            URNA.votar(opc);
            
        }
        
        
        
        URNA.exibirTotalGeralDeVotos();
        URNA.exibirTotalDeVotosBrancosNulos();
        URNA.exibirTotalDeVotosDosCandidatos();
        URNA.exibirDadosDoCandidatoVencedor();
    }
}
