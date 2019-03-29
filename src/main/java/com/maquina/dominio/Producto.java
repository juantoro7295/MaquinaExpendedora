package com.maquina.dominio;

public class Producto {
	private String nombre;
	private String codigo;
	private byte cantidad;
	private double Precio;

	public Producto(String nombre, String codigo, byte cantidad, double precio) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.Precio = precio;
	}

	public byte agregarProducto(byte cantidad) {
		byte sobrante=0;
		byte cantidadAgregada=0;
		if (this.cantidad >= 12) {

		} else {
			cantidadAgregada+=(12-this.cantidad);
			sobrante=(byte) (cantidad-cantidadAgregada);
			this.cantidad+=cantidadAgregada;
		}
		return sobrante;
		}
	public void retirarProducto() {
		if(this.cantidad==0) {
			
		}else {
			this.cantidad--;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public byte getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return Precio;
	}

	

}
