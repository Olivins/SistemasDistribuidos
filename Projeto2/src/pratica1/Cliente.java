package pratica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){ //n�o usamos o throw para poder tratar o erro localmente e enviar uma resposta amigavel ao cliente
        try {       //neste caso usaremos o try-catch
            
            //primeiro passo � criar o socket usando localhost ou 127.0.0.1 atrav�s da porta 8080 ou outra porta qualquer (no caso 2000).
            Socket s = new Socket("10.10.80.115",2000);//trocar localhost para outro ip ou host qq
            
            //agora criamos os 2 canais - in e out
            DataOutputStream saida = new DataOutputStream(s.getOutputStream());
            DataInputStream entrada = new DataInputStream(s.getInputStream());
            
            for (int i=0 ; i<200 ; i++){
                saida.writeInt(i); //envia e mostra na tela o que foi enviado
                System.out.println("Enviei: "+i);
                String en = entrada.readUTF();//captura o que voltou e mostra na tela o que foi retornado
                System.out.println("Recebi: "+en);
            }

        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
}
