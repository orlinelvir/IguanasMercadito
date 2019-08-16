package edu.ujcv.progra2.company;

import java.util.Scanner;

public class IntroduccirCliente {
    private Scanner Sc = new Scanner(System.in);
    private DymArray<Cliente> pda = new DymArray<Cliente>();
    //* escribir archivo.

    /*/  //leer archivo
    try {
        pda = pfio.readProducts();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //*/
    public void IntroducirCliente() {

        System.out.println("NOMBRE DEL CLIENTE DEL SUPERMERCADITO: ");
        String setNombreDeCliente = Sc.next();
        Integer setNumeroDeCuenta = (int) (Math.random() * 50) + 2018;
        System.out.println("numero de cuenta: " + setNumeroDeCuenta);
        pda.add(new Cliente(setNombreDeCliente, setNumeroDeCuenta));
    }

    public void ImpresionDeClientes() {
        System.out.println("NOMBRE DEL CLIENTE Y NUMERO DE CARNET: ");
        for (int i = 0; i < pda.getSize(); i++) {
            System.out.println(pda.getItem(i));
        }


    }


    public void RemoverCliente() {
        for (int i = 0; i < pda.getSize(); i++) {
            System.out.println(pda.getItem(i));
        }
        System.out.println("numero a borrar en lista de clientes");
        Integer n = Sc.nextInt();
        pda.remove(n+1);

    }
    public void ModificarCliente(){
        System.out.println("COMPRA DEL CLIENTE: ");
        for (int i = 0; i < pda.getSize(); i++) {
            System.out.println(pda.getItem(i));
        }
        System.out.println("QUE CLIENTE DE LA LISTA DESEA MODIFICAR: (INGRESE UN NUMERO VALIDO EN LA LISTA DE CLIENTES!!) ");
        int n= Sc.nextInt();
        pda.remove(n-1);
        System.out.println("NOMBRE DEL CLIENTE DEL SUPERMERCADITO: ");
        String setNombreDeCliente = Sc.next();
        Integer setNumeroDeCuenta = (int) (Math.random() * 50) + 2018;
        System.out.println("numero de cuenta: " + setNumeroDeCuenta);
        pda.add(new Cliente(setNombreDeCliente, setNumeroDeCuenta));



    }



}
//public int[] invertir arreglo(int[]a)[
//int[] b = new int [a.length];
//for(int =a.length-1; i>=0;i--){
//b[i]=a[a.length -1 -i];
//]
//retur b;
//public T remove(int index) {
//  if(index >= mSize)
//    return null;
//T retval = mItems[index];


//for (int i = index + 1; i < mSize ; i++) {
//  mItems[i-1] = mItems[i];
//}
//mSize--;
//return retval;

