import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    public static Scanner scanner = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static String[] defeatArt = {
            "    ,---,                                                ___     ",
            "  .'  .' `\\              .--.,                         ,--.'|_   ",
            ",---.'     \\           ,--.'  \\                        |  | :,'  ",
            "|   |  .`\\  |          |  | /\\/                        :  : ' :  ",
            ":   : |  '  |   ,---.  :  : :     ,---.     ,--.--.  .;__,'  /   ",
            "|   ' '  ;  :  /     \\ :  | |-,  /     \\   /       \\ |  |   |    ",
            "'   | ;  .  | /    /  ||  : :/| /    /  | .--.  .-. |:__,'| :    ",
            "|   | :  |  '.    ' / ||  |  .'.    ' / |  \\__\\/: . .  '  : |__  ",
            "'   : | /  ; '   ;   /|'  : '  '   ;   /|  ,\" .--.; |  |  | '.'| ",
            "|   | '` ,/  '   |  / ||  | |  '   |  / | /  /  ,.  |  ;  :    ; ",
            ";   :  .'    |   :    ||  : \\  |   :    |;  :   .'   \\ |  ,   /  ",
            "|   ,.'       \\   \\  / |  |,'   \\   \\  / |  ,     .-./  ---`-'   ",
            "'---'          `----'  `--'      `----'   `--`---'               "
    };

    public static void main(String[] args) {
        Espadachim Jack = new Espadachim("Espadachim", "Jack McCoy", 200, 75, 75, 75, 100);
        String jackName = ANSI_BLUE + "Jack McCoy" + ANSI_RESET;
        String VexName = ANSI_RED + "Vex" + ANSI_RESET;
        String esqueletoName = ANSI_RED + "Esqueletos" + ANSI_RESET;
        String goldvilleVillager = ANSI_GREEN + "Cidadãos de GoldVille" + ANSI_RESET;
        System.out.print("Bem vindo(a) ao Vingança no Oeste.");
        scanner.nextLine();
        System.out.print("Nessa jornada pelo Velho-Oeste, o nome do nosso protagonista é Jack McCoy, o qual é um espadachim " +
                        "caçador de recompensas do Velho-Oeste.");
        scanner.nextLine();
        System.out.print("Pela sua esperteza, Jack McCoy está indo em direção à " +
                        "cidade " +
                        "GoldVille, uma " +
                        "cidade " +
                        "mineira que estava se tornando famosa pelo Oeste.");
        scanner.nextLine();
        System.out.print("Porém, em sua jornada, ele encontra alguns inimigos... ");
        scanner.nextLine();
        System.out.print(jackName + ": Ufa! Estou quase chegando a GoldVille. Espera o que é aquilo?\n" +
                "(De repente, aparecem esqueletos com armas.) \n" +
                "Tão querendo brincar tão? Já toma aí!");
        scanner.nextLine();

        Esqueleto esqueleto1 = new Esqueleto("Esqueleto", "Esqueleto1", 100, 100, 0, 50, 0);
        List<Esqueleto> esqueletos = new ArrayList<>();
        esqueletos.add(esqueleto1);

        System.out.print("Fase 1 - Início da Jornada\n");
        System.out.println("Inimigos: ");
        esqueleto1.imprimirAtributos();

        System.out.println("Seu time: ");
        Jack.imprimirAtributos();

        while(Jack.estaVivo() && esqueletos.stream().anyMatch(Esqueleto::estaVivo)){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Usar Item (Não implementada)");
            System.out.println("4. Usar Habilidade");

            int acao = scanner.nextInt();

            switch(acao){
                case 1:
                    System.out.println("Escolha um inimigo para atacar: ");
                    for (int i = 0; i < esqueletos.size(); i++) {
                        Esqueleto esqueleto = esqueletos.get(i);
                        if (esqueleto.estaVivo()) {
                            System.out.println((i + 1) + ". Esqueleto " + (i + 1) + " (HP: " + esqueleto.getHP() + ")");
                        }
                    }

                    int alvo = scanner.nextInt() - 1;
                    if (alvo >= 0 && alvo < esqueletos.size() && esqueletos.get(alvo).estaVivo()) {
                        Jack.Atacar(esqueletos.get(alvo));
                    } else {
                        System.out.println("Alvo inválido!");
                    }
                    break;

                case 2:
                    System.out.println("Jack McCoy se defendeu.");
                    Jack.Defender();
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }
            for (Esqueleto esqueleto : esqueletos) {
                if (esqueleto.estaVivo()) {
                    esqueleto.Atacar(Jack);
                }
            }
            if (!esqueletos.stream().anyMatch(Esqueleto::estaVivo)) {
                System.out.println("Vitória! Fase 1 - Início da Jornada concluída.");
                break;
            }

            if (!Jack.estaVivo()) {
                System.out.println(jackName + ": Ouch! É aqui onde eu termino?");
                for (String line : defeatArt) {
                    System.out.println(line);
                }
                break;
            }

            Jack.normalizarDefesa();
        }

        esqueletos.remove(esqueleto1);
        Jack.restoreHP();
        scanner.nextLine();
        System.out.print(jackName + ": Ok. Nada mal. Têm mais alguns aí? ");
        scanner.nextLine();
        System.out.print(esqueletoName + ": HA HA HA. Tem mais dois de nós McCoy...");
        scanner.nextLine();
        System.out.print(jackName + ": Venham! (Como eles sabem o meu nome? Era para eles estarem mortos.) ");
        scanner.nextLine();

        Esqueleto esqueleto2 = new Esqueleto("Esqueleto", "Esqueleto1", 100, 100, 0, 50, 0);
        Esqueleto esqueleto3 = new Esqueleto("Esqueleto", "Esqueleto2", 100, 100, 0, 50, 0);

        esqueletos.add(esqueleto2);
        esqueletos.add(esqueleto3);

        System.out.print("Fase 2 - Tá OSSO\n");
        System.out.println("Inimigos: ");
        esqueleto2.imprimirAtributos();
        esqueleto3.imprimirAtributos();

        System.out.println("Seu time: ");
        Jack.imprimirAtributos();

        while(Jack.estaVivo() && esqueletos.stream().anyMatch(Esqueleto::estaVivo)){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Usar Item (Não implementada)");
            System.out.println("4. Usar Habilidade");

            int acao = scanner.nextInt();

            switch(acao){
                case 1:
                    System.out.println("Escolha um inimigo para atacar: ");
                    for (int i = 0; i < esqueletos.size(); i++) {
                        Esqueleto esqueleto = esqueletos.get(i);
                        if (esqueleto.estaVivo()) {
                            System.out.println((i + 1) + ". Esqueleto " + (i + 1) + " (HP: " + esqueleto.getHP() + ")");
                        }
                    }

                    int alvo = scanner.nextInt() - 1;
                    if (alvo >= 0 && alvo < esqueletos.size() && esqueletos.get(alvo).estaVivo()) {
                        Jack.Atacar(esqueletos.get(alvo));
                    } else {
                        System.out.println("Alvo inválido!");
                    }
                    break;

                case 2:
                    System.out.println("Jack McCoy se defendeu.");
                    Jack.Defender();
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }
            for (Esqueleto esqueleto : esqueletos) {
                if (esqueleto.estaVivo()) {
                    esqueleto.Atacar(Jack);
                }
            }
            if (!esqueletos.stream().anyMatch(Esqueleto::estaVivo)) {
                System.out.println("Vitória! Fase 2 - 'Tá OSSO' concluída.");
                break;
            }

            if (!Jack.estaVivo()) {
                System.out.println(jackName + ": Ouch! É aqui onde eu termino?");
                for (String line : defeatArt) {
                    System.out.println(line);
                }
                break;
            }

            Jack.normalizarDefesa();
        }

        esqueletos.remove(esqueleto2);
        esqueletos.remove(esqueleto3);
        Jack.restoreHP();

        scanner.nextLine();
        System.out.print(jackName + ": Se tivesse mais um desses esqueletos eu estaria morto. Como que eles sabiam " +
                "o meu sobrenome? ");
        scanner.nextLine();
        System.out.print(esqueletoName + ": Vex... Nos perdoa.");
        scanner.nextLine();
        System.out.print(jackName + ": Vex? Ele fez os mortos de lacaios também? Aquele puto! ");
        scanner.nextLine();
        System.out.print("Ele não pode estar muito longe. Ele tem que estar em GoldVille!");
        scanner.nextLine();
        System.out.println("Chegando em GoldVille...");

        System.out.print(jackName + ": Vex! Cadê você? ");
        scanner.nextLine();
        System.out.print(VexName + ": Jack, está aqui também? Essa cidade finalmente ficou um pouco emocionante!");
        scanner.nextLine();
        System.out.print(jackName + ": Você não irá fugir dessa vez! AAAAAAAAAAAAAAAAAAAAHHHHH");
        scanner.nextLine();
        System.out.print(VexName + ": HAHAHAHAHAHHAHH. Bora lá garoto!");
        scanner.nextLine();

        Pistoleiro Vex = new Pistoleiro("Pistoleiro", "Vector Vex", 200, 150, 25, 50, 100);
        List<Pistoleiro> vectors = new ArrayList<>();
        vectors.add(Vex);

        System.out.print("Fase 3 - Duelo\n");
        System.out.println("Inimigos: ");
        Vex.imprimirAtributos();

        System.out.println("Seu time: ");
        Jack.imprimirAtributos();

        while(Jack.estaVivo() && vectors.stream().anyMatch(Pistoleiro::estaVivo)){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Usar Item (Não implementada)");
            System.out.println("4. Usar Habilidade");

            int acao = scanner.nextInt();

            switch(acao){
                case 1:
                    System.out.println("Escolha um inimigo para atacar: ");
                    for (int i = 0; i < vectors.size(); i++) {
                        Pistoleiro pistoleiro = vectors.get(i);
                        if (pistoleiro.estaVivo()) {
                            System.out.println((i + 1) + ". Vector Vex " + (i + 1) + " (HP: " + pistoleiro.getHP() +
                                    ")");
                        }
                    }

                    int alvo = scanner.nextInt() - 1;
                    if (alvo >= 0 && alvo < vectors.size() && vectors.get(alvo).estaVivo()) {
                        Jack.AtacarVector(vectors.get(alvo));
                    } else {
                        System.out.println("Alvo inválido!");
                    }
                    break;

                case 2:
                    System.out.println("Jack McCoy se defendeu.");
                    Jack.Defender();
                    break;

                case 3:
                    break;

                case 4:
                    Jack.EscolherHabilidade();
                    int habilidade = scanner.nextInt();
                    if (habilidade == 1){

                    }else if (habilidade == 2){
                        Jack.setATTACK(150);
                        System.out.println("Escolha um inimigo para atacar: ");
                        for (int i = 0; i < vectors.size(); i++) {
                            Pistoleiro pistoleiro = vectors.get(i);
                            if (pistoleiro.estaVivo()) {
                                System.out.println((i + 1) + ". Vector Vex " + (i + 1) + " (HP: " + pistoleiro.getHP() +
                                        ")");
                            }
                        }

                        alvo = scanner.nextInt() - 1;
                        if (alvo >= 0 && alvo < vectors.size() && vectors.get(alvo).estaVivo()) {
                            Jack.AtacarVector(vectors.get(alvo));
                        } else {
                            System.out.println("Alvo inválido!");
                        }
                    }
                    break;
            }
            for (Pistoleiro pistoleiro : vectors) {
                if (pistoleiro.estaVivo()) {
                    pistoleiro.Atacar(Jack);
                }
            }
            if (!vectors.stream().anyMatch(Pistoleiro::estaVivo)) {
                System.out.println("Vitória! Fase 3 - 'Duelo' concluída.");
                break;
            }

            if (!Jack.estaVivo()) {
                System.out.println(jackName + ": Ouch! É aqui onde eu termino?");
                for (String line : defeatArt) {
                    System.out.println(line);
                }
                break;
            }

            Jack.normalizarAtaque();
            Jack.normalizarDefesa();
        }

        Jack.restoreHP();

        scanner.nextLine();
        System.out.print(jackName + ": Hoje você já era!");
        scanner.nextLine();
        System.out.print(VexName + ": É o que você pensa, garoto!");
        scanner.nextLine();
        System.out.print("(Bomba de fumaça)");
        scanner.nextLine();
        System.out.print(jackName + ": Ué? Cadê ele?\n Não pode ser... DE NOVO");
        scanner.nextLine();
        System.out.print(goldvilleVillager + ": Graças a Deus! Qual é o seu nome?");
        scanner.nextLine();

        System.out.println("Demo de Vingança no Oeste concluída.\nMuito obrigado por ter jogado até aqui.");
    }
}
