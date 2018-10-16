/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function listadoFrutas(fruta1, fruta2, ...restoFrutas) {
    console.log("fruta 1: " + fruta1);
    console.log("fruta 2: " + fruta2);
    console.log(restoFrutas);
}

var frutas = ["Naranja", "Manzana"];
listadoFrutas(...frutas, "Sandia", "Melon");
 
