/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package apresentacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import negocio.Anotacao;
import persistencia.AnotacaoDAO;

/**
 *
 * @author iapereira
 */
public class Main {

    public static void main(String[] args) {
        
        Anotacao anotacao = new Anotacao();
        anotacao.setTexto("texto");
        anotacao.setTitulo("titulo");
        anotacao.setDataHora(LocalDate.now());
        new AnotacaoDAO().adicionar(anotacao);

        List<Anotacao> vetAnotacao = new AnotacaoDAO().listar();
        for (int i = 0; i < vetAnotacao.size(); i++) {
            System.out.println(vetAnotacao.get(i));
        }

//        Anotacao anotacao = new AnotacaoDAO().obter("90b9bc4c-957a-4912-b2b1-a516b75b7e92");
//        new AnotacaoDAO().remover(anotacao.getId());
//        Anotacao anotacao = new AnotacaoDAO().obter("5e231150-1e1e-4aa7-978f-eed094f6f8b5");
//        anotacao.setTitulo("igor agora vai....");
//        new AnotacaoDAO().atualizar(anotacao);
    }
}
