package com.app;

import java.util.ArrayList;
import java.util.Arrays;

import com.maquina.dominio.Producto;
import com.maquina.dominio.maquinaExpendora;


public class App {

	public static void main(String[] args) {
		double compra=0;
		maquinaExpendora maquinaDeMecato=new maquinaExpendora("Vending", "10077465", "Mecato", 50000);
		Producto lays= new Producto("Lays", "A-1", (byte) 10, 1800);
		Producto margarita= new Producto("Margarita", "A-2",(byte) 10, 1800);
		Producto chocolatinaJumbo= new Producto("chocolatinaJumbo", "A-3", (byte) 10, 2400);
		Producto chocolatinaJet= new Producto("Chocolatina Jet", "A-4", (byte) 10, 1000);
		Producto cheetos= new Producto("Cheetos", "A-5", (byte) 10, 1200);
		Producto deTodito= new Producto("De Todito", "B-1", (byte) 10, 2000);
		Producto chocoramo= new Producto("chocoramo", "B-2", (byte) 10, 1600);
		Producto wafer= new Producto("Wafer", "B-3", (byte) 10, 800);
		Producto doritos= new Producto("Doritos","B-4", (byte) 10, 1200);
		Producto margaritaLimon= new Producto("Margarita Limon", "B-5", (byte) 0, 2000);
		ArrayList<Producto> listaDeProductos= new ArrayList<Producto>(Arrays.asList(lays,margarita,chocolatinaJumbo,chocolatinaJet,cheetos,deTodito,chocoramo,wafer,doritos,margaritaLimon));
		maquinaDeMecato.setProductos(listaDeProductos);
		for (int i=0;i<listaDeProductos.size();i++) {
			System.out.println(maquinaDeMecato.getProductos().get(i).getNombre()+" Codigo: "+maquinaDeMecato.getProductos().get(i).getCodigo()+" Precio: "+maquinaDeMecato.getProductos().get(i).getPrecio()+" Cantidad: "+maquinaDeMecato.getProductos().get(i).getCantidad()+"\n");
		}
		System.out.println("Gracias por comprar, devuelta: "+maquinaDeMecato.comprarProductoCodigo("A-1", 2000)+"\n\n");
		System.out.println("_____________________________________________________________________________________________________");
		for (int i=0;i<listaDeProductos.size();i++) {
			System.out.println(maquinaDeMecato.getProductos().get(i).getNombre()+" Codigo: "+maquinaDeMecato.getProductos().get(i).getCodigo()+" Precio: "+maquinaDeMecato.getProductos().get(i).getPrecio()+" Cantidad: "+maquinaDeMecato.getProductos().get(i).getCantidad()+"\n");
		}
		compra= maquinaDeMecato.comprarProductoNombre("Margarita Limon", 2000);
		if(compra==0) {
			System.out.println("Lo Sentimos, Este producto de encuentra agotado \n\n");
		}else {
			System.out.println("Gracias por su compra, devuelta: "+compra+"\n\n");
			
		}
		System.out.println("_____________________________________________________________________________________________________");
		System.out.println("Productos Agotados: "+maquinaDeMecato.verProductoAgotados()+"\n\n");
		System.out.println("Cantidad de productos en la maquina: "+ maquinaDeMecato.verTotalProductosEnMaquina()+"\n\n");
		System.out.println("_____________________________________________________________________________________________________");
		maquinaDeMecato.agregarProducto("Gansito", "B-5", (byte) 14);
		
		for (int i=0;i<listaDeProductos.size();i++) {
			System.out.println(maquinaDeMecato.getProductos().get(i).getNombre()+" Codigo: "+maquinaDeMecato.getProductos().get(i).getCodigo()+" Precio: "+maquinaDeMecato.getProductos().get(i).getPrecio()+" Cantidad: "+maquinaDeMecato.getProductos().get(i).getCantidad()+"\n");
		}
	}

}
