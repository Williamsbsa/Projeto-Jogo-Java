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
public class ListarClasse {
    public static void listarClasse(){
        for(int i=0; i<CadastrarClasse.classe.size(); i++){
            System.out.println("\nNome da Classe: " +CadastrarClasse.classe.get(i).getNome());
            System.out.println("Descricao: " +CadastrarClasse.classe.get(i).getDescricao());
            System.out.println("Nome item de Atk: " +CadastrarClasse.classe.get(i).getItemAtk().get(0).getNome());
            System.out.println("Descricao item de Atk: " +CadastrarClasse.classe.get(i).getItemAtk().get(0).getDescricao());
            System.out.println("Dano item de Atk: " +CadastrarClasse.classe.get(i).getItemAtk().get(0).getDanoDeAtk());
            System.out.println("Nome item de DEF: " +CadastrarClasse.classe.get(i).getItemDef().get(0).getNome());
            System.out.println("Descricao item de DEF: " +CadastrarClasse.classe.get(i).getItemDef().get(0).getDescricao());
            System.out.println("Escudo item de DEF: " +CadastrarClasse.classe.get(i).getItemDef().get(0).getEscudo());
            System.out.println("Forca: " +CadastrarClasse.classe.get(i).getForca());
            System.out.println("Defesa: " +CadastrarClasse.classe.get(i).getDefesa());
        }       
    }
    
    public static void apagarClasse(int indice){
        CadastrarClasse.classe.remove(indice);
    }
    
    public static void editarNome(PadraodasClasses p1, String nome){
        p1.setNome(nome);
    }
    
    public static void editarDescricao(PadraodasClasses p1, String descricao){
        p1.setDescricao(descricao);
    }
    
    public static void editarItemAtk(PadraoDoJogador j1, ItemdeATK itemAtk){
        j1.getClasses().get(0).getItemAtk().remove(0);
        j1.getClasses().get(0).getItemAtk().add(itemAtk);
    }
    
    public static void editarItemDef(PadraoDoJogador j1, ItemdeDEF itemDef){
        j1.getClasses().get(0).getItemDef().remove(0);
        j1.getClasses().get(0).getItemDef().add(itemDef);
    }
    
    public static void editarForca(PadraodasClasses p1, int forca){
        p1.setForca(forca);
    }
    
    public static void editarDefesa(PadraodasClasses p1, int defesa){
        p1.setDefesa(defesa);
    }    
    
}
