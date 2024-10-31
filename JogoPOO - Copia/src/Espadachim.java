public class Espadachim extends Personagem{
    private String classe;
    private String nome;
    private int HP;
    private int ATTACK;

    @Override
    public int getATTACK() {
        return ATTACK;
    }

    @Override
    public void setATTACK(int ATTACK) {
        this.ATTACK = ATTACK;
    }

    private int DEFENCE;
    private int SPEED;
    private int AP;
    private boolean defendendo;
    private int BaseDEFENCE = 75;

    public String getNome() {
        return nome;
    }

    public Espadachim(String classe, String nome, int HP, int ATTACK, int DEFENCE, int SPEED, int AP) {
        this.classe = classe;
        this.nome = nome;
        this.HP = HP;
        this.ATTACK = ATTACK;
        this.DEFENCE = DEFENCE;
        this.SPEED = SPEED;
        this.AP = AP;
    }

    public void imprimirAtributos(){
        System.out.println("Nome: " + nome + ", HP: " + HP + ", ATTACK: " + ATTACK + ", DEFENCE: " + DEFENCE);
    }

    @Override
    public void Atacar(Esqueleto esqueleto){
        System.out.println("Jack McCoy ataca " + esqueleto.getClass().getSimpleName() + "!");
        esqueleto.tomarDano(ATTACK);
    }

    @Override
    public void Defender(){
        this.DEFENCE = DEFENCE + DEFENCE;
    }

    @Override
    public void EscolherHabilidade(){
        System.out.println("Escolha uma habilidade: " +
                "1. Corte Rápido (AP=10) (Não implementada)   |     2. Lâmina Sanguinária (AP=50)" +
                " ");
    }

    @Override
    public void UsarItem(){

    }

    public boolean estaVivo() {
        return HP > 0;
    }

    public void AtacarVector(Pistoleiro pistoleiro){
        System.out.println("Jack McCoy ataca Vector Vex!" );
        pistoleiro.tomarDano(ATTACK);
    }

    public void tomarDano(int dano) {
        int effectiveDamage = dano - DEFENCE;
        if (effectiveDamage > 0) {
            HP -= effectiveDamage;
            if (HP < 0){
                HP = 0;
            }
            System.out.println(this.getNome() + " tomou " + effectiveDamage + " de dano. Resta " +
                    "HP: " + HP);
            if (HP == 0) {
                System.out.println(this.getNome() + " derrotado.\n");
            }
        } else {
            System.out.println(this.getNome() + " possui defesa muito alta! Nenhum dano tomado.");
        }
    }

    public void normalizarDefesa(){
        this.DEFENCE = BaseDEFENCE;
    }

    public void normalizarAtaque(){
        this.ATTACK = 75;
    }

    public void restoreHP(){
        this.HP = 200;
        System.out.println(this.getNome() + " recuperou a vida.");
    }
}
