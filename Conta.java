import java.util.Arrays;

public class Conta{
    public long numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    private double saqueMax;
    private boolean statusGerais;
   
    
    public Conta(long numConta, String tipo, String dono, double saldo, boolean status){ 
        this.numConta = numConta;
        this.tipo=tipo;
        this.dono=dono;
        this.saldo = saldo;
        this.status = status;
        this.saqueMax = 5000;
        this.statusGerais = this.status;
    }
    
    public void abrirConta(String Tipo){
      this.tipo= tipo;
      status=true; 
     System.out.println("conta aberta"); 
     if(tipo.equals("cc")){
         this.setSaldo(50);
         System.out.println("saldo inicial de 50 reais"); 
     }
     else if(tipo.equals("cp")){
         System.out.println("saldo inicial de 150 reais"); 
     }
    }
    public void fecharConta(){
      if(saldo < 0){
          System.out.println("não pode fechar uma conta com dividas na conta");
      }
      else if(saldo > 0){
        System.out.println("não pode fechar uma conta com saldo na conta");
      }
      else if(saldo == 0){
          status=false;
          System.out.println("conta fechada");
      }
    }
    public void depositar(double v){
        if(status == true && v>0){
            saldo += v;
            System.out.println("deposito bem sucedido! seu saldo aumentou para:"+ saldo+" reais");
        }
        else if(status == true && v==0){
            System.out.println("não é possivel depositar valores nulos");
        }
        else if(status == true && v<0){
            System.out.println("não é possivel depositar valores negativos");
        }
        else{
          System.out.println("não foi possivel depositar pois sua conta está fechada");
        }
    }
    public void sacar(double v){
         if(status == true && saldo > saqueMax){
           saldo -= v;
           if(saldo > 0){
           System.out.println("saque sucedido!, seu saldo atual é: "+ saldo+ " reais");}
           else if(saldo == 0){
            System.out.println("saque sucedido! todo o saldo foi sacado, atencão ao limite de saldo!, saldo atual:"+saldo+" reais");
           }
           else{
            System.out.println("saque sucedido!, atenção: seu saldo está negativo, saldo atual: "+ saldo+" reais");
           }
        }
        else if(status == false && saldo < saqueMax){
          System.out.println("não foi possivel sacar pois sua conta está fechada e ultrapassou o limite de saque por vez");
        }
        else if(status ==true){
            System.out.println("não foi possivel sacar pois ultrapassou o limite de saque");
        }
        else{
            System.out.println("não foi possivel sacar pois sua conta está fechada");
        } 
    }
    public void pagarMensal(){
        if(tipo.equals("cc")){
            saldo -= 12;
        }
        else if(tipo.equals("cp")){
            saldo -= 20;
        }
        else{
            System.out.println("tipo de conta invalido");
        }
    }
     
    public long getnumConta(){
        return numConta;  
    }
    public void setnumConta(long numConta){
        this.numConta= numConta;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getDono(){
        return dono;
    }
    public void setDono(String dono){
        this.dono = dono;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo= saldo;
        
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public double getSaqueMax(){
        return saqueMax;
    }

   
   public static void main(String[] args){
    int n = 6;
    Conta clientes[] = new Conta[n];
    clientes[0] = new Conta(235732,"cp","Diego",2345,true);
    clientes[1] = new Conta(232002,"cc","Gabriela",5000,true);
    clientes[2] = new Conta(875643,"cp","Paulo",0,true);
    clientes[3] = new Conta(122098,"cc","taylor",1000000,true);
    clientes[4] = new Conta(213454,"cp","Maria",-5434,true);
    clientes[5] = new Conta(908876,"cc","Carlos",3483,true);
    for(int c=0;c<=n-1;c++){
    System.out.println("o nome na Conta é: "+ clientes[c].getDono());
    System.out.println("o numero da conta é: "+clientes[c].getnumConta());
    System.out.println("o tipo de conta é: "+ clientes[c].getTipo());
    System.out.println("o saldo em conta corresponde a: "+ clientes[c].getSaldo());
    System.out.println("o status da conta é: "+ clientes[c].getStatus());
    System.out.println("______________________________________");
    }
    
    
    }


}
