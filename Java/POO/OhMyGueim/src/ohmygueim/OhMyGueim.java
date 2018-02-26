/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohmygueim;

import java.time.LocalDate;
import java.util.ArrayList;
import ohmygueim.Clientes.CSGO;
import ohmygueim.Clientes.ClashRoyale;
import ohmygueim.Clientes.Gamer;
import ohmygueim.Clientes.LOL;

/**
 *
 * @author daw
 */
public class OhMyGueim {
    private ArrayList <Gamer> gamers;
    public OhMyGueim() {
       gamers.add(new CSGO("Cloud9",567,"Dust 2",2000,"Carceus",56));
       gamers.get(0).addTrofeo("Pìston Cup");
       
       gamers.add(new LOL("Mid","Asesino",2300,"xPeke",72));
       gamers.get(1).addTrofeo("DreamHack 2016");
       gamers.add(new ClashRoyale(2000,"Ocelote",64));
       ((ClashRoyale)gamers.get(2)).addCarta("Gigante", 1);
       ((ClashRoyale)gamers.get(2)).addCarta("Mago", 2);
       ((ClashRoyale)gamers.get(2)).addCarta("Mago eléctrico", 4);
       ((ClashRoyale)gamers.get(2)).addCarta("Monta Puercos", 1);
       ((ClashRoyale)gamers.get(2)).addCarta("P.E.K.K.A.", 3);
       ((ClashRoyale)gamers.get(2)).addCarta("Bruja", 4);
       ((ClashRoyale)gamers.get(2)).addCarta("Arqueras", 1);
       //LocalDate temp = new LocalDate(13,11,2018);
    }

}
