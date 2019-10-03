import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


interface Veiculo{
  abstract void acelerar();

  abstract void frear();
  
}

abstract class veiculoBasic implements Veiculo{
  private int velocidade;
  private String descricao;
  private int ano;
  private String placa;
  private double valor;

  public veiculoBasic(int velocidade, String descricao, int ano, String placa, double valor){
    this.velocidade=velocidade;
    this.descricao=descricao;
    this.ano=ano;
    this.placa=placa;
    this.valor=valor;
    
  }


  public int getVelocidade(){
    return velocidade;
  } 

  public void setVelocidade(int velocidade){
    this.velocidade=velocidade;
  }

  public String getDescricao(){
    return descricao;
  }
  
  public void setDescricao(String descricao){
    this.descricao=descricao;
  }

  public int getAno(){
    return ano;
  }

  public void setAno(int ano){
    this.ano=ano;
  }

  public String getPlaca(){
    return placa;
  }

  public void setPlaca(String placa){
    this.placa=placa;
  }

  public double getValor(){
    return valor;
  }

  public void setValor(double valor){
    this.valor=valor;
  }
}



class Moto extends veiculoBasic implements Veiculo{
  
  private int potencia;

  public Moto(int velocidade, String descricao, int ano, String placa, int potencia, double valor){
    super(velocidade,descricao,ano,placa,valor);
    this.potencia=potencia;
    
  }


  public int getPotencia(){
    return potencia;
  }

  public void setPotencia(int potencia){
    this.potencia=potencia;
  }

  public void acelerar(){
    setVelocidade((getVelocidade()+10));
  }

  public void frear(){
    if (getVelocidade()>0){
      setVelocidade((getVelocidade()-10));
    }
  }
}

class Carro extends veiculoBasic implements Veiculo{
  private int potencia;
  private int qtde_portas;

  public Carro(int velocidade, String descricao, int ano, String placa, int potencia, double valor, int qtde_portas){
    super(velocidade,descricao,ano,placa,valor);
    this.potencia=potencia;
    this.qtde_portas= qtde_portas;
  }

  
  public int getPotencia(){
    return potencia;
  }

  public void setPotencia(int potencia){
    this.potencia=potencia;
  }

  public int getQtde_portas(){
    return qtde_portas;
  }

  public void setQtde_portas(int qtde_portas){
    this.qtde_portas=qtde_portas;
  }

  public void acelerar(){
    setVelocidade((getVelocidade()+10));
  }

  public void frear(){
    if (getVelocidade()>0){
      setVelocidade((getVelocidade()-10));
    }
  }
}

class Caminhao extends veiculoBasic implements Veiculo {
  private int carga_suportada;
  private int comprimento;

  public Caminhao(int velocidade, String descricao, int ano, String placa, int carga_suportada, double valor, int comprimento){
    super(velocidade, descricao, ano, placa, valor);
    this.carga_suportada=carga_suportada;
    this.comprimento=comprimento;
  }

  public int getCarga_suportada(){
    return carga_suportada;
  }

  public void setCarga_suportada(int carga_suportada){
    this.carga_suportada=carga_suportada;
  }

  public int getComprimento(){
    return comprimento;
  }

  public void setComprimento(int comprimento){
    this.comprimento=comprimento;
  }

  public void acelerar(){
    setVelocidade((getVelocidade()+8));
  }

  public void frear(){
    if (getVelocidade()>0){
      setVelocidade((getVelocidade()-8));
    }
  }

}

class Onibus extends veiculoBasic implements Veiculo{
  private int capacidade_passageiros;
  private int comprimento;

  public Onibus(int velocidade, String descricao, int ano, String placa, int capacidade_passageiros, double valor, int comprimento){
    super(velocidade, descricao, ano, placa, valor);
    this.capacidade_passageiros=capacidade_passageiros;
    this.comprimento=comprimento;
  }

  public int getCapacidade_passageiros(){
    return capacidade_passageiros;
  }

  public void setCapacidade_passageiros(int capacidade_passageiros){
    this.capacidade_passageiros=capacidade_passageiros;
  }

  public int getComprimento(){
    return comprimento;
  }

  public void setComprimento(int comprimento){
    this.comprimento=comprimento;
  }

  public void acelerar(){
    setVelocidade((getVelocidade()+8));
  }

  public void frear(){
    if (getVelocidade()>0){
      setVelocidade((getVelocidade()-8));
    }
  }
}

class Estacionamento{
  
  private List<veiculoBasic> veiculos=new ArrayList<veiculoBasic>();
  
  private int qtdeCarros=0;
  private int qtdeMoto=0;
  private int qtdeOnibus=0;
  private int qtdeCaminhao=0;

  private double val = 0;

  public void add(veiculoBasic v){
    if(veiculos.size() == 100){
      return;
    }
    veiculos.add(v);
    val+=v.getValor();
    if(v instanceof Carro){
      qtdeCarros++;
    }
    if(v instanceof Caminhao){
      qtdeCaminhao++;
    }
    if(v instanceof Moto){
      qtdeMoto++;
    }
    if(v instanceof Onibus){
      qtdeOnibus++;
    }
  }

  public void qtdeVeiculos(String consultaVeiculo){

    if(consultaVeiculo=="Caminhao"){
      System.out.println(qtdeCaminhao);
    }

    if(consultaVeiculo=="Carro"){
      System.out.println(qtdeCarros);
    }

    if(consultaVeiculo=="Moto"){
      System.out.println(qtdeMoto);
    }

    if(consultaVeiculo=="Onibus"){
      System.out.println(qtdeOnibus);
    }

  }

  public String getMenor(){
      
        if(this.veiculos.size() == 0){ 
          return "TEM NADA AQUI NÃO";
        }
        
        double Menor = this.veiculos.get(0).getValor();
        String tipo = "";
        
        veiculoBasic V = this.veiculos.get(0);
        
        if(V instanceof Moto    ){tipo = "moto";}
        if(V instanceof Carro   ){tipo = "carro";}
        if(V instanceof Caminhao){tipo = "caminhao";}
        if(V instanceof Onibus  ){tipo = "onibus";}
        
        
        for(veiculoBasic v: this.veiculos){
            
            if (v.getValor() < Menor){
                
                Menor = v.getValor();
                
                if(v instanceof Moto    ){tipo = "moto";}
                if(v instanceof Carro   ){tipo = "carro";}
                if(v instanceof Caminhao){tipo = "caminhao";}
                if(v instanceof Onibus  ){tipo = "onibus";}
                
            }
            
        }

        return tipo;

  }

  public String MaiorQuantidade(){
    
    int maior = qtdeCaminhao;
    String tipo = "Caminhao";
    
    if(qtdeCarros > maior){
      maior = qtdeCarros;
      tipo = "Carro";
    }

    if(qtdeMoto > maior){
      maior = qtdeMoto;
      tipo = "Moto";
    }

    if(qtdeOnibus > maior){
      maior = qtdeOnibus;
      tipo = "Onibus";
    }

    return tipo;

  }

  public double TotalFrota(){
    return val;
  }

  public void acelera(){
    for(int i=0;i<veiculos.size();i++){
      veiculos.get(i).acelerar();
    }
  }

  public void Mostra(){
    for(int i=0;i<veiculos.size();i++){
      veiculoBasic a = veiculos.get(i);
      System.out.println("{"+a.getVelocidade+", "+a.getDescricao+", "+a.getAno()+"}");
    }
  }

  public void freia(){
    for(int i=0;i<veiculos.size();i++){
      veiculos.get(i).frear();
    }
  }

}

public class Main{
    public static void main(String[] args){
        System.out.println("Fuck My Ass");
    }
}