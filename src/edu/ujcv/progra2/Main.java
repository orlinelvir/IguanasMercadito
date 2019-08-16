package edu.ujcv.progra2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final int O_Leche = 0;
    private static final int O_Queso = 1;
    private static final int O_Quesillo = 2;
    private static final int O_Cuajada = 3;
    private static final int O_Bebidas = 4;
    private static final int O_Salir = 7;
    private static final int O_Salva = 0;
    private static final int O_Port_Royal = 1;
    private static final int O_Guaro = 2;
    private static final int O_Corona = 3;
    private static final int O_SalirAlcohol = 4;
    public static void main(String[] args) {
        int opcion = -1;
        String producto[] = {"Leche", "Queso", "Quesillo", "Cuajada"};
        String productoAlcohol[] = {"Salva vidas", "Port Royal", "Guaro", "Corona", "Bebidas Alcoholicas"};
        double precioAlcohol [] = {25,28, 20, 32};
        double precio[] = {20, 45, 48, 35};
        double cantidad[] = {0,0,0,0};
        double cantidadAlcohol[] = {0,0,0,0};
        double subtotal = 0;
        double total = 0;
        double isv = 0;
        double isvAlcohol = 0;
        double impuesto = 0;
        double impuestoAlcohol = 0;
        double subtotalAlcohol = 0;
        double totalAlcohol = 0;
        int seleccion = 0;
        double dolares = 0;
        String nombre = "";
        String rtn = "";
        int op = 0;
        Scanner sc = new Scanner(System.in);
        do {
            menu(sc, opcion, producto, precio, precioAlcohol, productoAlcohol, subtotal, total, isv, isvAlcohol, impuesto,
                    impuestoAlcohol, subtotalAlcohol, totalAlcohol, seleccion, nombre, rtn, cantidad, dolares, cantidadAlcohol);
            do {
                System.out.println("Desea realizar otra compra? Escriba 1 para si y 2 para no");
                op = leerEnteroValidado(sc, "Ha ingresado un numero no valido");
                if (op == 1)
                    menu(sc, opcion, producto, precio, precioAlcohol, productoAlcohol, subtotal, total, isv, isvAlcohol, impuesto,
                            impuestoAlcohol, subtotalAlcohol, totalAlcohol, seleccion, nombre, rtn, cantidad, dolares, cantidadAlcohol);
            }while(op !=2);
        }while(op !=2);
    }
    public static void menu(Scanner sc, int opcion, String[] producto, double[] precio, double[] precioAlcohol, String[] productoAlcohol, double subtotal, double total, double isv,
                            double isvAlcohol, double impuesto, double impuestoAlcohol, double subtotalAlcohol, double totalAlcohol, int seleccion, String nombre, String rtn,
                            double[] cantidad, double dolares, double[] cantidadAlcohol){
        do {
            System.out.println("\t \t \t \t Mercadito Torres \n \n Codigo \t \t   Producto \t \t \t \t Precio \n \n 111.............. " + producto[O_Leche] + "\t \t \t \t \t L. " + precio[O_Leche]
                    + "\n 112.............. " + producto[O_Queso] + "\t \t \t \t \t L. " + precio[O_Queso]
                    + "\n 113.............. " + producto[O_Quesillo] + "\t \t \t \t \t L. " + precio[O_Quesillo]
                    + "\n 114.............. " + producto[O_Cuajada] + "\t \t \t \t \t L. " + precio[O_Cuajada]
                    + "\n 6................ " + productoAlcohol[O_Bebidas]
                    + "\n 7................ Totalizar");
            opcion = leerEnteroValidado(sc,"Ha ingresado un caracter no valido o numero no valido");
            switch(opcion){
                case 111:
                    subtotal += leche(precio);
                    cantidad[O_Leche] += 1;
                    break;
                case 112:
                    subtotal += queso(precio);
                    cantidad[O_Queso] += 1;
                    break;
                case 113:
                    subtotal += quesillo(precio);
                    cantidad[O_Quesillo] += 1;
                    break;
                case 114:
                    subtotal += requeson(precio);
                    cantidad[O_Cuajada] += 1;
                    break;
                case 6:
                    menuAlcohol(sc,opcion,productoAlcohol,precioAlcohol, subtotalAlcohol,totalAlcohol,isvAlcohol,impuestoAlcohol,cantidadAlcohol);
                case 7:
                    isv = 0.15;
                    impuesto = subtotal * isv;
                    total = subtotal + impuesto;
                    impuestoAlcohol = subtotalAlcohol * 0.18;
                    subtotalAlcohol = subtotalAlcohol - impuestoAlcohol;
                    if (opcion == 7){
                        System.out.println("¿Desea la factura con nombre y RTN?");
                        do {
                            System.out.println("Escriba 1 para si o 2 para no");
                            seleccion = leerEnteroValidado(sc, "Ha ingresado un caracter o numero no valido");
                            if (seleccion == 1) {
                                System.out.println("Ingrese el nombre que desea en la factura");
                                sc.nextLine();
                                nombre = sc.nextLine();
                                System.out.println("Ingrese el RTN");
                                rtn = sc.nextLine();
                            }
                            if (seleccion == 2) {
                                nombre = "Consumidor Final";
                                rtn = "0888888888888";
                            }
                        }while(seleccion != 1 && seleccion !=2);
                        double subtotalCombinado = 0;
                        double totalImpuestos = 0;
                        imprimirFactura(nombre,rtn,producto,precio,cantidad,total,subtotal,totalAlcohol,subtotalAlcohol,isv,isvAlcohol,impuesto,impuestoAlcohol,
                                dolares,cantidadAlcohol,precioAlcohol,subtotalCombinado,totalImpuestos);
                    }
            }
        }while (opcion != O_Salir);

    }
    public static double menuAlcohol(Scanner sc, int opcion, String [] productoAlcohol, double[] precioAlcohol, double subtotalAlcohol, double totalAlcohol, double isvAlcohol, double impuestoAlcohol,
                                     double[] cantidadAlcohol){
        do{
            System.out.println("\t \t \t \t Bebidas Alcoholicas \n \n Codigo \t \t   Producto \t \t \t \t Precio \n \n "
                    + "201.............. " + productoAlcohol[O_Salva] + "\t \t \t \t L. " + precioAlcohol[O_Salva]
                    + "\n 202.............. " + productoAlcohol[O_Port_Royal] + "\t \t \t \t L. " + precioAlcohol[O_Port_Royal]
                    + "\n 203.............. " + productoAlcohol[O_Guaro] + "\t \t \t \t \t L. " + precioAlcohol[O_Guaro]
                    + "\n 204.............. " + productoAlcohol[O_Corona] + "\t \t \t \t \t L. " + precioAlcohol[O_Corona]
                    + "\n 4................ Totalizar Bebidas Alcoholicas y regresar al menu principal " );
            opcion = leerEnteroValidado(sc,"Ha ingresado un caracter no valido o numero no valido");
            switch(opcion){
                case 201:
                    subtotalAlcohol += salvavida(precioAlcohol);
                    cantidadAlcohol[O_Salva] += 1;
                    break;
                case 202:
                    subtotalAlcohol += portroyal(precioAlcohol);
                    cantidadAlcohol[O_Port_Royal] += 1;
                    break;
                case 203:
                    subtotalAlcohol += coronita(precioAlcohol);
                    cantidadAlcohol[O_Guaro] += 1;
                    break;
                case 204:
                    subtotalAlcohol += corona(precioAlcohol);
                    cantidadAlcohol[O_Corona] += 1;
                    break;
                case 4:
            }
        }while(opcion != O_SalirAlcohol);
        return subtotalAlcohol;
    }
    public static void imprimirFactura(String nombre, String rtn,String [] producto, double[] precio,double[] cantidad,double total, double subtotal, double totalAlcohol,
                                       double subtotalAlcohol, double isv, double isvAlcohol, double impuesto, double impuestoAlcohol, double dolares, double [] cantidadAlcohol, double[] precioAlcohol,
                                       double subtotalCombinado, double totalImpuestos) {
        System.out.println("\n \t \t \t \t \t \t  FACTURA \n \t \t \t \t \t \t  ======= \n");
        System.out.println("\t \t \t \t \t Mercadito Elvir Garay");
        System.out.println("\t \t \t \t \t RTN: 0801200006350");
        System.out.println("\t \t \t Pulpería Ruty");
        System.out.println("\t \t \t Col. Travesía, Tegucigalpa");
        System.out.println("\t \t \t \t \t Tel: +504 3241-5582");
        System.out.println("\t \t \t Correo: pulperia.ruty@gmail.com");
        DateFormat hourdateFormat = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");
        Date date = new Date();
        System.out.println("\t \t \t \t \t" + hourdateFormat.format(date));
        if (nombre == "S/N") {
            System.out.println("\t \t \t \t \t \t \t " + nombre);
        } else {
            System.out.println("\t \t \t \t Nombre: " + nombre);
        }
        System.out.println(" \t \t \t \t \t RTN: " + rtn);
        System.out.println("\t \t \t \t \t FACTURA ORIGINAL");
        System.out.println("\t \t   CAI: 2H6P98-78J45O-47GH21-21WE63-03S4DF-32");
        System.out.println("\t \t \t \t \t Lo atendió: Orlin Elvir \n \n " );
        int i = 0;
        while (i < cantidad[O_Leche]) {
            System.out.println("Leche" + "\t \t \t \t \t \t \t \t \t \t    " + precio[O_Leche] + "G");
            i++;
        }
        i = 0;
        while (i < cantidad[O_Queso]) {
            System.out.println("Queso" + "\t \t \t \t \t \t \t \t \t \t    " + precio[O_Queso]+ "G");
            i++;
        }
        i = 0;
        while(i<cantidad[O_Quesillo]){
            System.out.println("Quesillo" + "\t \t \t \t \t \t \t \t \t    " + precio[O_Quesillo]+ "G");
            i++;
        }
        i = 0;
        while(i<cantidad[O_Cuajada]) {
            System.out.println("Cuajada" + "\t \t \t \t \t \t \t \t \t    " + precio[O_Cuajada]+ "G");
            i++;
        }
        while (i < cantidadAlcohol[O_Salva]) {
            System.out.println("Salva Vida" + "\t \t \t \t \t \t \t \t \t    " + precioAlcohol[O_Salva] + "G");
            subtotalAlcohol += precioAlcohol[O_Salva];
            i++;
        }
        i = 0;
        while (i < cantidadAlcohol[O_Port_Royal]) {
            System.out.println("PortRoyal" + "\t \t \t \t \t \t \t \t \t    " + precioAlcohol[O_Port_Royal]+ "G");
            subtotalAlcohol += precioAlcohol[O_Port_Royal];
            i++;
        }
        i = 0;
        while(i<cantidadAlcohol[O_Guaro]){
            System.out.println("Guaro" + "\t \t \t \t \t \t \t \t \t    " + precioAlcohol[O_Guaro]+ "G");
            subtotalAlcohol += precioAlcohol[O_Guaro];
            i++;
        }
        i = 0;
        while(i<cantidadAlcohol[O_Corona]) {
            System.out.println("Corona" + "\t \t \t \t \t \t \t \t \t \t    " + precioAlcohol[O_Corona]+ "G");
            subtotalAlcohol += precioAlcohol[O_Corona];
            i++;
        }
        impuesto = subtotal * 0.15;
        impuestoAlcohol = subtotalAlcohol * 0.18;
        subtotal = subtotal - impuesto;
        subtotalAlcohol = subtotalAlcohol - impuestoAlcohol;
        subtotalCombinado = subtotal + subtotalAlcohol;
        total = subtotalAlcohol + subtotal + impuesto + impuestoAlcohol;
        dolares = total / 24;
        totalImpuestos = impuesto + impuestoAlcohol;
        System.out.println("Subtotal 15% \t \t \t \t \t \t \t \t  L." + String.format("%.2f",subtotal));
        System.out.println("Subtotal 18% \t \t \t \t \t \t \t \t  L." + String.format("%.2f",subtotalAlcohol));
        System.out.println("     Subtotal\t \t \t \t \t \t \t \t  L." + String.format("%.2f",subtotalCombinado));
        System.out.println("15% ISV \t \t \t \t \t \t \t \t \t \t " + String.format("%.2f",impuesto));
        System.out.println("18% ISV \t \t \t \t \t \t \t \t \t \t " + String.format("%.2f",impuestoAlcohol));
        System.out.println("Impuestos total \t \t \t \t \t \t \t \t L." + String.format("%.2f",totalImpuestos));
        System.out.println("Total \t \t \t \t \t \t \t \t \t \t \t L." + String.format("%.2f",total));
        System.out.println("Total en Dolares \t \t \t \t \t \t \t \t $." + String.format("%.2f",dolares));
        System.out.println("\t \t \t \t \t  G=Gravado");
        System.out.println("\t \t \t \t  Original: Cliente");
        System.out.println("\t \t Copia: Obligado tributario emisor");
        System.out.println("\t \t \t \t \t    ***");
        System.out.println("\t \t \t \t  - Cuenta Cerrada -");
    }
    static double salvavida (double[] precioAlcohol){
        double subtotal = precioAlcohol[O_Salva];
        System.out.println("Se ha agregado una cerveza Salva Vidas al carrito");
        System.out.println(subtotal);
        return subtotal;
    }

    public static double portroyal (double[] precioAlcohol){
        double subtotal = precioAlcohol[O_Port_Royal];
        System.out.println("Se ha agregado una cerveza PortRoyal al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double coronita (double[] precioAlcohol){
        double subtotal = precioAlcohol[O_Guaro];
        System.out.println("Se ha agregado una cerveza Coronita al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double corona (double[] precioAlcohol){
        double subtotal = precioAlcohol[O_Corona];
        System.out.println("Se ha agregado una cerveza Corona al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double leche (double[] precio){
        double subtotal = precio[O_Leche];
        System.out.println("Se ha agregado un litro de leche al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double queso (double[] precio){
        double subtotal = precio[O_Queso];
        System.out.println("Se ha agregado una libra de queso al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double quesillo (double[] precio){
        double subtotal = precio[O_Quesillo];
        System.out.println("Se ha agregado una libra de quesillo al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static double requeson (double[] precio){
        double subtotal = precio[O_Cuajada];
        System.out.println("Se ha agregado una libra de requeson al carrito");
        System.out.println(subtotal);
        return subtotal;
    }
    public static int leerEnteroValidado(Scanner sc,  String mensajeError){
        while(!sc.hasNextInt()){
            sc.nextLine();
            System.out.println(mensajeError);
        }
        return sc.nextInt();
    }
}