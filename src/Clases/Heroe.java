package Clases;

public class Heroe extends Guerrero {

    private Mochila mochila;

    public Heroe(){
        mochila = new Mochila();
    }

    public boolean recogerItem(ObjetoMueble item){

        return mochila.agregar(item);

    }

    public void usarMochila(int seleccionInt) {

        ObjetoMueble objetoMueble = mochila.usarItem(seleccionInt);
        if (objetoMueble != null){
            if (objetoMueble instanceof Arma){
                Arma arma = (Arma) objetoMueble;
                super.setNivelEnergia(super.getNivelEnergia() + arma.getNivelEnergia());
                System.out.println("Arma equipada");
                System.out.println("Nuevo nivel de energia: " + super.getNivelEnergia());
                super.setCapacidadOfensiva(super.getCapacidadOfensiva() + arma.getPotenciarAtaque());
                System.out.println("Nueva capacidad ofensiva " + super.getCapacidadOfensiva());
            }else {
                super.setNivelEnergia(super.getNivelEnergia() + objetoMueble.getNivelEnergia());
                System.out.println(objetoMueble.getNombre() + " consumido tu nuevo nivel de energia es " + super.getNivelEnergia());
            }

        }
    }

    public int vermochila() {

        return mochila.verMochila();
    }
}
