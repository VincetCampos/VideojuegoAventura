package MethodFactory;

public class NPCFactory {

    public NPC fabricarNPC(String nombreNPC){

        if(nombreNPC.equals("SpiderMan")){
            return new SpiderMan();
        }
        else if (nombreNPC.equals("Venom")){
            return new Venom();

        }else if (nombreNPC.equals("Deadpool")){

            return new Deadpool();

        }else if (nombreNPC.equals("SuperMan")){
            return new SuperMan();

        }else if (nombreNPC.equals("Batman")){
            return new Batman();
        }
        else {
            return null;
        }
    }
}
