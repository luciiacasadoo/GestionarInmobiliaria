/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionarinmobiliaria;

/**
 *
 * @author laawa
 */
public interface IComparable {

    boolean menorQue(IComparable otroObjeto, int opcion);

    boolean mayorQue(IComparable otroObjeto, int opcion);

    boolean igualQue(IComparable otroObjeto, int opcion);
}
