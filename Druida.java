public class Druida extends Personaje implements Hechicero, Sanador 
{
    private int mana;
    private int poderCuracion;

    public Druida(String nombre, int nivel, int puntosVida, int mana) 
    {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = 50;
    }

    @Override
    public void atacar() throws RpgException 
    {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 10) throw new RecursoInsuficienteException("mana", mana);
        mana -= 10;
        System.out.println("[" + getNombre() + "] invoca raices del bosque y ataca con furia natural.");
    }

    @Override
    public int calcularDanio() 
    {
        return 240;
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException 
    {
        if (aliado == null) throw new PersonajeNuloException("curarAliado");
        if (!aliado.isEstaVivo()) throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        aliado.puntosVida += poderCuracion;
        System.out.println(getNombre() + " cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.puntosVida);
    }

    @Override
    public int getMana() { return mana; }
    @Override
    public int getPoderCuracion() { return poderCuracion; }
    @Override
    public void defender() 
    {
        System.out.println(getNombre() + " invoca un escudo natural de raíces para protegerse.");
    }


}
