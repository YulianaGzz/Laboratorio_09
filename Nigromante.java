public class Nigromante extends Personaje implements Hechicero 
{
    private int mana;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) 
    {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException 
    {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 15) throw new RecursoInsuficienteException("mana", mana);
        mana -= 15;
        System.out.println("[" + getNombre() + "] lanza una maldicion oscura.");
    }

    @Override
    public int calcularDanio() 
    {
        return 200;
    }

    @Override
    public int getMana() { return mana; }

    @Override
    public void defender() 
    {
        System.out.println(getNombre() + " invoca un escudo de energía oscura para protegerse.");
    }

}
