package pratica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args)  {
        
        try {
            
        	InetAddress endereco_remoto;
        	int porta_remota;
            ServerSocket s = new ServerSocket(2000);//o server socket tem um servi�o que espera conexao (implementado abaixo)
            System.out.println("Esperando conexao..........");
            
            Socket conexao = s.accept(); //esta op��o faz o servidor ficar rodando esperando conexao
            System.out.println("Conexao aceita - esperando dados....");
            
            endereco_remoto = conexao.getInetAddress();
            porta_remota = conexao.getPort();
            System.out.println("Nome da maquina remota: " + endereco_remoto.getHostName());
            System.out.println("IP da maquina remota: " + endereco_remoto.getHostAddress());
            System.out.println("Porta maquina remota: " + porta_remota);
            
            //agora criamos os 2 canais - in e out para conexao (n�o sobre o s)
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());

            for (int i=0 ; i<200 ; i++){
                int entra = entrada.readInt();
                System.out.println("Entrei");
                saida.writeUTF("Seu dado foi recebido: "+entra);
            }

            
        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
}