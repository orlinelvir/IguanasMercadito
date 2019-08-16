package edu.ujcv.progra2.company;

import java.io.IOException;
import java.util.Scanner;

public class  Main {

    public static void main(String[] args) {
	// write your code here
        float precio = 0;
        String nombre = null;
        Scanner Sc= new Scanner(System.in);
        DymArray<Producto> pda = new DymArray();
        FileIO pfio = new FileIO("products.csv");

        try {
            pfio.writeProducts(pda);
        } catch (IOException var13) {
            var13.printStackTrace();
        }

        for(int i = 0; i < pda.getSize(); ++i) {
            System.out.println(pda.getItem(i));
        }

        IntroduccirProducto Intro = new IntroduccirProducto();
        IntroduccirCliente Introcliente = new IntroduccirCliente();
        Menu menuu = new Menu();
        int opcion = 0;
        boolean var10 = false;

        while(true) {
            while(true) {
                opcion = menuu.menu();
                switch(opcion) {
                    case 1:
                        while(opcion != 5) {
                            opcion = menuu.MenuDeProductos();
                            switch(opcion) {
                                case 1:
                                    Intro.IntroProducto();
                                    break;
                                case 2:
                                    Intro.ImpresionDeProducto();
                                    break;
                                case 3:
                                    Intro.RemoverProducto();
                                    break;
                                case 4:
                                    Intro.ModificarProducto();
                                    break;
                                case 5:
                                    default:
                                        System.out.println("Saliendo de menu de productos");
                            }
                        }
                    case 2:
                        while(opcion != 5) {
                            opcion = menuu.MenuDeClientes();
                            switch(opcion) {
                                case 1:
                                    Introcliente.IntroducirCliente();
                                    break;
                                case 2:
                                    Introcliente.ImpresionDeClientes();
                                    break;
                                case 3:
                                    Introcliente.RemoverCliente();
                                    break;
                                case 4:
                                    Introcliente.ModificarCliente();
                                    break;
                                case 5:
                                default:
                                    System.out.println("Saliendo...");
                            }
                        }

                }
            }


        }

        }

}

