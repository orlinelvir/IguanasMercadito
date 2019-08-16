package edu.ujcv.progra2.company;

import java.util.Scanner;

public class Menu { public int menu() {
    System.out.println("");
    System.out.println("");
    System.out.println("\t \t \t \t MENU\t \t \t \t \t");
    System.out.println("1. PRODUCTOS ");
    System.out.println("2. CLIENTES ");
    System.out.println("3. FACTURA ");
    System.out.println("0. SALIR");
    int opcion = 0;
    while ((opcion < 1) || (opcion > 6)) {
        System.out.println("Favor Ingresar Una Opcion : ");
        Scanner Sc = new Scanner(System.in);
        opcion = Sc.nextInt();
        if ((opcion < 1) || (opcion > 6)) {
            System.out.println("Opcion No Invalida.");
        }
    }
    return opcion;

}

    public int MenuDeClientes() {
        System.out.println("");
        Scanner Sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("========================MENU==========================");
        System.out.println("==================MENU DE CLIENTES==============");
        System.out.println("1. AGREGAR CLIENTE ");
        System.out.println("2. VER CLIENTE ");
        System.out.println("3. ELIMINAR CLIENTE ");
        System.out.println("4. MODIFICAR CLIENTE  ");
        System.out.println("5. SALIR");


        int opcion = 0;

        while ((opcion < 1) || (opcion > 6)) {
            System.out.println("Favor Ingresar Una Opcion : ");
            Scanner dSc = new Scanner(System.in);
            opcion = Sc.nextInt();
            if ((opcion < 1) || (opcion > 6)) {
                System.out.println("Opcion No Invalida.");
            }
        }
        return opcion;
    }
    public int MenuDeProductos() {
        System.out.println("");
        System.out.println("");
        System.out.println("========================MENU==========================");
        System.out.println("1. AGREGAR PRODUCTOS ");
        System.out.println("2. VER PRODUCTOS ");
        System.out.println("3. ELIMINAR PRODUCTO ");
        System.out.println("4. MODIFICAR PRODUCTO  ");
        System.out.println("5. Salir");
        int opcion = 0;
        while ((opcion < 1) || (opcion > 6)) {
            System.out.println("Favor Ingresar Una Opcion : ");
            Scanner Sc = new Scanner(System.in);
            opcion = Sc.nextInt();
            if ((opcion < 1) || (opcion > 6)) {
                System.out.println("Opcion No Invalida.");
            }
        }
        return opcion;

    }
}
