package com.maquina.dominio;

import java.util.ArrayList;

public class maquinaExpendora {
	private String fabricante;
	private String nroSerie;
	private String tipoMaquina;
	private double deVuelta;
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	public maquinaExpendora(String fabricante, String nroSerie, String tipoMaquina, double deVuelta) {

		this.fabricante = fabricante;
		this.nroSerie = nroSerie;
		this.tipoMaquina = tipoMaquina;
		this.deVuelta = deVuelta;
	}

	public ArrayList<String> verProductoAgotados() {
		ArrayList<String> listaProductoAgotado = new ArrayList<String>();
		for (int i = 0; i < this.productos.size(); i++) {
			if (this.productos.get(i).getCantidad() == 0) {
				listaProductoAgotado.add(this.productos.get(i).getNombre());
				listaProductoAgotado.add(this.productos.get(i).getCodigo());
			}
		}
		return listaProductoAgotado;
	}

	public double comprarProductoNombre(String nombre, double dineroIngresado) {
		boolean seCompra= true;
		double cambio = 0;
		ArrayList<String> listaAgotados =verProductoAgotados();
		for(int i=0; i<listaAgotados.size();i++) {
			if(listaAgotados.get(i).contentEquals(nombre)) {
				seCompra= false;
			}
		}
		if(seCompra) {
			for(int i=0;i<this.productos.size();i++) {
				if(this.productos.get(i).getNombre().contentEquals(nombre)) {
					this.productos.get(i).retirarProducto();
					cambio=calculadeVuelta(dineroIngresado, i);
					
					
				}
			} 
		}
		return cambio; 
		
	}
	public double comprarProductoCodigo(String codigo, double dineroIngresado) {
		boolean seCompra=true;
		double cambio=0;
		ArrayList<String> listaAgotados= verProductoAgotados();
		for (int i=0; i<listaAgotados.size();i++) {
			if(i%2==0) {
				if(listaAgotados.get(i).contentEquals(codigo)) {
					seCompra= false;
				}
			}
		}
		if(seCompra) {
			for(int i=0; i<this.productos.size();i++) {
				if(this.productos.get(i).getCodigo().contentEquals(codigo)) {
					if(dineroIngresado<this.productos.get(i).getPrecio()) {
						cambio=0;
					}
					else{
						this.productos.get(i).retirarProducto();
						cambio= calculadeVuelta(dineroIngresado, i);
					}
				}
			}
		}
		return cambio;
	}
	public byte agregarProducto(String nombre, String codigo, byte cantidad) {
		byte sobrante = 0;
		for (int i = 0; i < this.productos.size(); i++) {
			if (this.productos.get(i).getCodigo().contentEquals(codigo)) {
				sobrante = this.productos.get(i).agregarProducto(cantidad);
			}
		}
		return sobrante;
	}

	public byte verTotalProductosEnMaquina() {
		byte totalProductos = 0;
		for (int i = 0; i < this.productos.size(); i++) {
			totalProductos += this.productos.get(i).getCantidad();
		}
		return totalProductos;
	}

	private double calculadeVuelta(double dineroIngresado, int nroProducto) {
		double cambio= dineroIngresado-this.productos.get(nroProducto).getPrecio();
		deVuelta -= cambio;
		return cambio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getNroSerie() {
		return nroSerie;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public double getDeVuelta() {
		return deVuelta;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setDeVuelta(double deVuelta) {
		this.deVuelta = deVuelta;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	

}
