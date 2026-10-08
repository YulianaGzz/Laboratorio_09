public class Guerrero extends Personaje 
{
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int vida, String armadura, int fuerza)
    {
        super(nombre, nivel, vida);
        this.armadura = armadura;
        this.fuerza = fuerza;
    }

    @Override
    public void atacar() 
    {
        System.out.println(getNombre() + " golpea con su espada causando " + fuerza + " de daño!");
    }

    @Override
    public void defender() 
    {
        System.out.println(getNombre() + " bloquea con su armadura de " + armadura + ".");
    }

    @Override
    public int calcularDanio() 
    {
        return fuerza * getNivel();
    }

    public void entrenar() 
    {
        fuerza += 5;
        System.out.println(getNombre() + " entrenó y su fuerza ahora es " + fuerza);
    }

    public void entrenar(int sesiones) 
    {
        fuerza += 5 * sesiones;
        System.out.println(getNombre() + " entrenó " + sesiones + " veces. Fuerza actual: " + fuerza);
    }

    public void entrenar(int sesiones, boolean intensivo) 
    {
        if (intensivo) 
            {
                fuerza += (5 * sesiones) * 2;
                System.out.println(getNombre() + " entrenó intensivamente " + sesiones + " veces. Fuerza actual: " + fuerza);
            } 
        else 
            {
                entrenar(sesiones);
            }
    }
}
