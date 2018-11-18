/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

/**
 *
 * @author braga
 */
public class ListarJogador {
    public static void listarJogador(){
            for(int i= 0;i<CadastrarMonstro.monstroNormal.size();i++){
                System.out.println("\nNome do Jogador: "+ CadastrarJogador.jogador.get(i).nome);
                System.out.println("Idade: "+ CadastrarJogador.jogador.get(i).idade);
                System.out.println("Nome da Classe: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getNome());
                System.out.println("Descrição da Classe: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getDescricao());
                System.out.println("Nome do Item de ATK: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemAtk().get(0).getNome());
                System.out.println("Descrição do Item de ATK: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemAtk().get(0).getDescricao());
                System.out.println("Dano do Item de ATK: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemAtk().get(0).getDanoDeAtk());
                System.out.println("Nome do Item de DEF: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemDef().get(0).getNome());
                System.out.println("Descrição do Item de DEF: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemDef().get(0).getDescricao());
                System.out.println("Escudo do Item de DEF: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getItemDef().get(0).getEscudo());
                System.out.println("Força do seu Personagem: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getForca());
                System.out.println("Defesa do seu Personagem: "+ CadastrarJogador.jogador.get(i).getClasses().get(0).getDefesa());
                System.out.println("Saude: "+ CadastrarJogador.jogador.get(i).saude);
                System.out.println("Level: "+ CadastrarJogador.jogador.get(i).saude);
                System.out.println("Moeda: "+ CadastrarJogador.jogador.get(i).moeda);
            }
    }
    public static void apagarJogador(int indice){
        CadastrarJogador.jogador.remove(indice);
    }
    
    public static void editarSaúde(PadraoDoJogador j1, int saude){
        j1.setSaude(saude);
    }
    
    public static void editarLevel(PadraoDoJogador j1, int level){
        j1.setLevel(level);
    }
    
    public static void editarMoeda(PadraoDoJogador j1, int moeda){
        j1.setMoeda(moeda);
    }
    
    public static void editarNomeItenATK(ItemdeATK p1, String nome){
        p1.setNome(nome);
    }

    public static void editarDescricaoItenATK(ItemdeATK p1, String descricao){
        p1.setDescricao(descricao);
    }    
    
    public static void editarAtaqueItenATK(ItemdeATK p1, int valor){
        p1.setDanoDeAtk(valor);
    }
    
    public static void editarNomeItenDef(ItemdeDEF d1, String nome){
        d1.setNome(nome);
    }
    
    public static void editarDescricaoItenDef(ItemdeDEF d1, String descricao){
        d1.setDescricao(descricao);
    }

    public static void editarEscudoItenDef(ItemdeDEF d1, int escudo){
        d1.setEscudo(escudo);
    }

}
