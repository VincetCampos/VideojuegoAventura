package Clases;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private List<ObjetoMueble> items;

    public Mochila (){

        items = new ArrayList<>();
    }

    public boolean agregar(ObjetoMueble item) {
        if (items.size() == 3){
            return false;
        }
        items.add(item);
        return true;
    }

    public ObjetoMueble usarItem(int seleccionInt) {

        try {
            return items.remove(seleccionInt);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }

    }

    public int verMochila() {
        if (items.size() == 0){
            System.out.println("La mochila esta vacia");
        }
        for (int i = 0; i<items.size(); i++){
            System.out.println(i + " " + items.get(i).getNombre() + " " +  items.get(i).getDescripcionObjeto());
        }

        return items.size();
    }
}
