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
      
        ItemdeATK  presasmorc = new ItemdeATK("Presas de Morcego Sanguessuga","Presas que facilitam sugar sangue",40);
        ItemdeDEF pelodemorce = new ItemdeDEF("Pelo de Morcego Sanguessuga","Pelos negros que cobrem o corpo todo",20);
        
        ItemdeATK  presasmorc = new ItemdeATK("Presas de Morcego Sanguessuga","Presas que facilitam sugar sangue",40); 
        ItemdeDEF pelodemorce = new ItemdeDEF("Pelo de Morcego Sanguessuga","Pelos negros que cobrem o corpo todo",20); 
         
        ItemdeATK queliceras = new ItemdeATK("Quelíceras da Aranha Negra","Machucam e liberam veneno",45); 
        ItemdeDEF exoaranha = new ItemdeDEF("Exoesqueleto de Aranha Negra","Carapaça muito resistente",55); 
         
        ItemdeATK  machadohiena= new ItemdeATK("Machado poderoso de aventureiro"," Machado poderoso para um aventureiro iniciante",55); 
        ItemdeDEF  amadurahiena= new ItemdeDEF("Armadura do Guerreiro","Armadura de ferro maciço ",65); 
         
        ItemdeATK  almafa= new ItemdeATK("Alma de Fantasma","Item muito requisitado por Magos iniciantes",30); 
        ItemdeDEF  poeiraf= new ItemdeDEF("Poeira Fantasmagórica","Item não poderoso porém muito bonito",30); 
         
        ItemdeATK  lascadep= new ItemdeATK(" Lasca de Pedra","Criação especial da Gárgula",45); 
        ItemdeDEF  amaduradep= new ItemdeDEF(" Armadura de Pedra","Tão dura quanto uma Gárgula",60); 
         
        ItemdeATK  cajmag= new ItemdeATK("Cajado do Mago Cinzento","Não se engane pela aparência, este item é muito poderoso",); 
        ItemdeDEF  vestesmag= new ItemdeDEF(" Vestes da Academia de Magia","Uniforme da escola de magia mais procurada em todo mundo",); 
         
        ItemdeATK  ferraoven= new ItemdeATK("Ferrão Venenoso","Contém veneno e mata lentamente",); 
        ItemdeDEF  carapver= new ItemdeDEF("Carapaça Vermelha"," Suporta até o calor mais forte do Deserto",); 
         
         
        ItemdeATK  dentesg= new ItemdeATK("Dentes Giratórios do Verme do Deserto"," Mesmo morto estes dentes continuam a girar pela eternidade, se o portador desejar",); 
        ItemdeDEF  areiap= new ItemdeDEF("Areia Processada","Gerada dentro do estômago do Verme",); 
         
        ItemdeATK  bastaodam= new ItemdeATK("Bastão da Morte","Conhecido por ser a arma que define quem vive e morre",); 
        ItemdeDEF  sarcofagop= new ItemdeDEF("Sarcófago Protetor"," Que a bênção dos antigos Faraós o acompanhe",); 
         
        ItemdeATK  dentedes= new ItemdeATK("Dente de Sabre","O famoso Dente de Sabre do Tigre mais perigoso do mundo",); 
        ItemdeDEF  tunicab= new ItemdeDEF("Túnica Branca","Aquece Qualquer aventureiro",); 
         
        ItemdeATK  maodeg= new ItemdeATK("Mão de Gorila"," Um cruzado de direita dessa mão nocauteia qualquer um",); 
        ItemdeDEF  escudodec= new ItemdeDEF("Escudo de Cipó"," Achado na toca de Gorilas",); 
         
        ItemdeATK  bastaorex= new ItemdeATK("Bastão Conjurador de Rex","Usada por tribos de magos na antiguidade para conjurar o Rei",); 
        ItemdeDEF  esqueletoj= new ItemdeDEF("Esqueleto Jurássico","Ossos muito rígidos ",); 
         
        ItemdeATK  harpal= new ItemdeATK("Harpa do Leão","Libera um poderoso rugido que atordoa adversários",); 
        ItemdeDEF  jubac= new ItemdeDEF("Juba Congelada","Além de exibir poder é muito eficaz para se defender",); 
         
        ItemdeATK  estacagel= new ItemdeATK("Estaca de Gelo"," Parte do corpo do Golem de Gelo",); 
        ItemdeDEF  escudogel= new ItemdeDEF("Escudo de gelo", "Parte do corpo do Golem de Gelo",); 
         
        ItemdeATK  furacaogel= new ItemdeATK("Furacão de Gelo","Ninguém nunca pensou que desse para domar um furacão",); 
        ItemdeDEF  nevep= new ItemdeDEF("Neve Protetora","É muito difícil atravessar essa barreira ",); 
         
        ItemdeATK  triquei= new ItemdeATK("Tridente Queimado"," Antigamente era posse de Poseidon",); 
        ItemdeDEF  escudocinz= new ItemdeDEF("Escudo de Cinzas","O que restou de um monstro perturbado",); 
         
        ItemdeATK  arcofogo= new ItemdeATK("Arco de Fogo"," Das asas da Fênix surgiu um Arco extremamente preciso",); 
        ItemdeDEF  armadurachamav= new ItemdeDEF("Armadura da Chama Viva"," Dizem que essa armadura faz com que a Fênix renasça das cinzas",); 
         
        ItemdeATK  espadaflam= new ItemdeATK("Espada Flamejante","Após a morde de um Dragão sua alma pode ser introduzida em um objeto, esta espada possuí a alma do dragão mais poderoso",); 
        ItemdeDEF  couradrag= new ItemdeDEF("Couraça de Dragão","Nem mesmo a mais poderosa espada pode atravessá-la",); 
         
        ItemdeATK  lancacav= new ItemdeATK("Lança de Cavaleiro"," Antiga lança de um nobre cavaleiro",); 
        ItemdeDEF  cabecaflam= new ItemdeDEF("Cabeça Flamejante"," A lenda do Cavaleiro sem Cabeça continua",); 
         
        ItemdeATK  cabechidra= new ItemdeATK("Cabeça de Hidra ","Uma arma para perder a cabeça",); 
        ItemdeDEF  escamahidra= new ItemdeDEF("Escamas de Hidra","ão fortes que até mesmo Hércules não conseguiu perfurar",); 
         
        ItemdeATK  caudasq= new ItemdeATK("Cauda de Serpente de Quimera"," Uma arma inteligente que pode atacar em áreas que aventureiros não conhecem do oponente",); 
        ItemdeDEF  cerebroquim= new ItemdeDEF("Cérebro de Quimera","Porque um escudo potente quando se pode prever todos os movimentos em uma batalha",); 
         
        ItemdeATK  chuvap= new ItemdeATK("Chuva de Pedras","Potente contra um exército de inimigos",); 
        ItemdeDEF  cancaop= new ItemdeDEF("Canção da Proteção","Além de linda, pode proteger um aventureiro",); 
         
        ItemdeATK  ferraduraaco= new ItemdeATK("Ferradura do Mar"," Pode ser que sua sorte melhore com uma arma dessas",); 
        ItemdeDEF  chifrecav= new ItemdeDEF("Chifre de Cavalo Marinho","Muito mais duro que um diamante",); 
         
        ItemdeATK  tentaculoc= new ItemdeATK("Tentáculo do Cthulhu","Cthulhu não precisa de mais nada além de seus tentáculos e sua presença",); 
        ItemdeDEF  tentaculocd= new ItemdeDEF("Tentáculo do Cthulhu ","Cthulhu não precisa de mais nada além de seus tentáculos e sua presença ",); 
         
        ItemdeATK  espnegra= new ItemdeATK("Espada Negra","Apenas olhar para essa espada te destruir por completo",); 
        ItemdeDEF  assasanjo= new ItemdeDEF("Assas de Anjo Caído"," Carregam penas negras como a própria escuridão",); 
         
        ItemdeATK  cajdonecromante= new ItemdeATK("Cajado no Necromante","Poder suficiente para destruir mundos",); 
        ItemdeDEF  capanecromante= new ItemdeDEF("Capa do Necromante","Presente especial do Rei Demônio",); 
         
        ItemdeATK  presennsup= new ItemdeATK(" Presença Suprema"," Ninguém pode sobreviver a presença do senhor das trevas",); 
        ItemdeDEF  presensupr= new ItemdeDEF(" Presença Suprema"," Ninguém pode sobreviver a presença do senhor das trevas",);
        
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
