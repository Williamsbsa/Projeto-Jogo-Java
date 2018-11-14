/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

import java.util.Scanner;

/**
 *
 * @author braga
 */
public class ProjetoJogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criando Itens
        ItemdeATK martelo= new ItemdeATK("Martelo de Valhalla","Martelo forjado por Odin, para o equilíbrio do Universo", 30);
        ItemdeDEF escudoRag = new ItemdeDEF("Escudo do Ragnarok", "Escudo enviado para impedir o fim do Mundo.", 75);
        
        ItemdeATK arco = new ItemdeATK("Arco do cosmos","Boatos cercam a criação deste arco, porém o que sabemos é que muitos poucos sobrevivem com tamanho poder", 45);
        ItemdeDEF escudoElf= new ItemdeDEF("Ecudo élfico", "Escudo feito pelo ancião da Vila élfica em seus últimos anos de vida.", 65);
        
        ItemdeATK lamina = new ItemdeATK("Lamina Sanguinária","Parece frágil, porém é a mais perigosa da Europa Ocidental, sendo que na maioria dos casos, 1 corte desta lâmina é capaz de matar.", 50);
        ItemdeDEF cotaMalha = new ItemdeDEF("Cota de malha", "Pequena e fina camada de proteção, porém agil para movimentação.", 35);
        
        ItemdeATK cetro = new ItemdeATK("Cetro de Rá","Cetro mágico com o acumulo de décadas de concentração da energia de suas vítimas.", 55);
        ItemdeDEF escudoEner = new ItemdeDEF("Escudo de energia", "Escudo não seria a palavra exata para esta magia incrível, pode não ser tão resistente, porém é de rápida conjuração.", 45);
        
        ItemdeATK espadaGob = new ItemdeATK("Espada Goblin","Espada forjada em esconderijo Goblin", 15);
        ItemdeDEF armaduraPano= new ItemdeDEF("Armadura de Pano", "Armadura fabricada pela mãe do Goblin.", 10);
        
        ItemdeATK ossoRat = new ItemdeATK("Osso de Ratazana"," Osso da última refeição do pequeno Slime", 10);
        ItemdeDEF EscudoGosm= new ItemdeDEF("Escudo Gosmento", "Escudo fabricado no primeiro dia da vida do pequeno Slime.", 15);
        
        ItemdeATK porreteOgro = new ItemdeATK("Porrete de Ogro","Porrete tradicional de Ogro, passado de geração em geração.", 30);
        ItemdeDEF tangaOgro= new ItemdeDEF("Tanga de Ogro", "Tanga para cobrir suas partes íntimas, este Ogro não gosta de armaduras.", 5);
        
        //Criando Classes
        PadraodasClasses guerreiro = new PadraodasClasses("Guerreiro","Força e Defesa altos, porém não sabe manusear armas complicadas.",25,25);
        PadraodasClasses arqueiro = new PadraodasClasses("Arqueiro","Força e Defesa não muito expressivos, porém alta habilidade com arcos.",15,10);
        PadraodasClasses ladino = new PadraodasClasses("Ladino","Força e Defesa base comuns, porém super agil com armas.",20,20);
        PadraodasClasses mago = new PadraodasClasses("Mago","Força e Defesa um pouco baixos, porém faz conjurações rápidas com suas magias e domina suas armas.",10,15);
        
        //Criando Monstros
        MonstroNormal goblin = new MonstroNormal("Goblin","Saqueador malandro do vilarejo", 25,25);
        MonstroNormal slime = new MonstroNormal("Slime bebê","Recém nascido que incomoda muito", 25,25);
        Chefao ogro = new Chefao("Ogro Verde","O líder da caverna, que está furioso com a derrota de seu companheiro",25,50,"Este Ogro Verde sempre foi habilidoso desde criança, e nunca cansou de se gabar disso, agora que você está ameaçando seu trono ele não vai deixar barato!!");
        
        //Cadastrando Classes para listá-las depois.
        guerreiro.addItemAtk(martelo);
        guerreiro.addItemDef(escudoRag);
        CadastrarClasse.addClasse(guerreiro);
        
        arqueiro.addItemAtk(arco);
        arqueiro.addItemDef(escudoElf);
        CadastrarClasse.addClasse(arqueiro);
        
        ladino.addItemAtk(lamina);
        ladino.addItemDef(cotaMalha);
        CadastrarClasse.addClasse(ladino);
        
        mago.addItemAtk(cetro);
        mago.addItemDef(escudoEner);
        CadastrarClasse.addClasse(mago);
        
        //Cadastrando Jogador- INICIO DO JOGO
        System.out.println(">>>>>>>>>>>>>>> BREAKING THE SPACE TIME !! <<<<<<<<<<<<<<<");
        System.out.println("Bem vindo ao RPG que reúne todas mitologias e crenças em um só jogo, por favor, complete as informações abaixo.");
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o seu Nome: ");
        String nome = in.next();
        System.out.print("Digite sua idade: ");
        int idade = in.nextInt();
        System.out.println("Escolha uma das classes abaixo: ");
        ListarClasse.listarClasse();
        
        int b = 0;
        PadraoDoJogador jogador = null;
        int danoClasse;
        int escudoClasse;
        int danoItem;
        int escudoItem;
        int danoTotal = 0;
        int escudoTotal = 0;
        String escolhaCla;
        Scanner on = new Scanner(System.in);
        
        while (b==0){
            System.out.print("\nDigite o nome da Classe que escolheu: ");
            escolhaCla = on.nextLine();
            System.out.println(escolhaCla);
            if (escolhaCla.equalsIgnoreCase("guerreiro")){
                jogador = new PadraoDoJogador(nome,idade,0,1,0);
                jogador.addClasse(guerreiro);
                break;
                //b = 1;
            }
            else if (escolhaCla.equalsIgnoreCase("arqueiro")){
                jogador = new PadraoDoJogador(nome,idade,0,1,0);
                jogador.addClasse(arqueiro);
                break;
                //b = 1;
            }
            else if (escolhaCla.equalsIgnoreCase("ladino")){
                jogador = new PadraoDoJogador(nome,idade,0,1,0);
                jogador.addClasse(ladino);
                break;
                //b = 1;
            }
            else if (escolhaCla.equalsIgnoreCase("mago")){
                jogador = new PadraoDoJogador(nome,idade,0,1,0);
                jogador.addClasse(mago);
                break;
                //b = 1;
            }
        }
        
        danoClasse = jogador.getClasses().get(0).getForca();
        escudoClasse = jogador.getClasses().get(0).getDefesa();
        danoItem = jogador.getClasses().get(0).getItemAtk().get(0).getDanoDeAtk();
        escudoItem = jogador.getClasses().get(0).getItemDef().get(0).getEscudo();
        danoTotal = danoClasse + danoItem;
        escudoTotal = escudoClasse + escudoItem;
        System.out.println("Dano Total = "+danoTotal);
        System.out.println("Escudo total = "+escudoTotal);
        
        System.out.println("MUDANCA DIA 13");
        //EAE PEDRO CONSEGUIsasa
        //teste do teste do teste
         
        /** cadastrando e listando itens
        ItemdeATK a1 = new ItemdeATK("martelo","Martelao enviado dos deuses", 55);
        ItemdeDEF d1 = new ItemdeDEF("Escudo","Escudo enviado de Narnia", 77);
        CadastrarItem.addItemATK(a1);
        CadastrarItem.addItemDEF(d1);
        ListarItem.editarAtaqueItenATK(a1, 105);
        ListarItem.listarItensATK();
        ListarItem.listarItensDEF();
        
        // cadastrando e listando classes
        PadraodasClasses mago = new PadraodasClasses("Mago","Força elevada, porém defesa baixa",95,34);
        mago.addItemAtk(a1);
        mago.addItemDef(d1);
        CadastrarClasse.addClasse(mago);
        ListarClasse.listarClasse();
        
        // cadastrando e listando monstros
        MonstroNormal m1 = new MonstroNormal("Goblin","Saqueador malandro do vilarejo", 45,25);
        m1.addItemATK(a1);
        m1.addItemDEF(d1);
        Chefao c1 = new Chefao("El diablo","Criatura das trevas, tome cuidado!!",88,200,"Apos ser traido e abandonado pela propria familia, El diblo construiu seu proprio imperio no submundo, jurando tomar o mundo para si");
        c1.addItemATK(a1);
        c1.addItemDEF(d1);
        CadastrarMonstro.addMonstroNormal(m1);
        CadastrarMonstro.addChefao(c1);
        ListarMonstros.listarMonstroNormal();
        ListarMonstros.listarChefao();
    
        // cadastrando e listando fases
        PadraodasFases f1 = new PadraodasFases("Ilha amaldicoada","Lugar assustador onde voce acabou de acordar", 1);
        CadastrarFase.addMonstroNormal(m1);
        CadastrarFase.addChefao(c1);
        CadastrarFase.addFase(f1);
        ListarFase.listarFase();
        */
    }
    
}
