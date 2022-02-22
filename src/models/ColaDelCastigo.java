package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDelCastigo<E> {

	private ArrayList<E> lista;
	private Comparator<E> comp;

	/**
	 * Constructor que invoca una nueva ArrayList de genéricos, que recibe un
	 * comparador de sus elementos.
	 * 
	 * @param comp Comparador.
	 */
	public ColaDelCastigo(Comparator<E> comp) {
		lista = new ArrayList<E>();
		this.comp = comp;
	}

	/**
	 * Dice cuántos elementos hay en el ArrayList.
	 * 
	 * @return Devuelve un int de esa cantidad.
	 */
	public int size() {
		return lista.size();
	}

	/**
	 * Dice si el ArrayList contiene o no algún o ningún elemento.
	 * 
	 * @return True si no contiene ningún elemento o False si contiene uno o más.
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
	 * Compara el elemento seleccionado con todos los elementos que hay dentro del
	 * ArrayList.
	 * 
	 * @param o Elemento seleccionado.
	 * @return True si coincide al menos uno de los elementos del ArrayList con el
	 *         elemento indicado, False si no coincide con ninguno.
	 */
	public boolean contains(Object o) {
		return lista.contains(o);
	}

	/**
	 * Devuelve un iterator.
	 * 
	 * @return Devuelve un iterator.
	 */
	public Iterator iterator() {
		return lista.iterator();
	}

	/**
	 * Devuelve el ArrayList en forma de Array.
	 * 
	 * @return Devuelve un Array con el contenido del ArrayList.
	 */
	public Object[] toArray() {
		return lista.toArray();
	}

	public Object[] toArray(Object[] a) {
		return lista.toArray(a);
	}

	/**
	 * Elimina el primer elemengo seleccionado del ArrayList, pero no puede quedar
	 * vacío.
	 * 
	 * @param Elemento seleccionado a eliminar.
	 * @return Devuelve el ArrayList con el elemento eliminado.
	 * @throws Exception En caso de que el ArrayList contenga uno o menos elementos,
	 *                   el progama lanza una excepción.
	 */
	public boolean remove(Object o) throws Exception {
		if (lista.size() > 1) {
			return lista.remove(o);
		} else {
			throw new ElementBlockedException("El lista no puede estar vacío.");
		}
	}

	/**
	 * Compara los elementos de la colección.
	 * 
	 * @param c La colección elegida.
	 * @return True si contiene todos los elementos de la colección, False si no
	 *         contiene al menos un elemento de la colección.
	 */
	public boolean containsAll(Collection<E> c) {
		return lista.containsAll(c);
	}

	/**
	 * Añade todos los elementos de la colección al ArrayList siempre y cuando no se
	 * exceda de 10 elementos en el ArrayList.
	 * 
	 * @param c La colección elegida.
	 * @return Devuelve el ArrayList con la colección ya añadida y ordenada.
	 * @throws Exception Si la suma de los elementos del ArrayList y de la colección
	 *                   supera los 10 elementos, o si el contenido de la colección
	 *                   es null; salta la Exception.
	 */
	public boolean addAll(Collection<E> c) throws Exception {
		if (c.contains(null)) {
			throw new LlevateTuNullDeAquiException("El contenido no puede ser null.");
		} else if ((c.size() + lista.size()) > 10) {
			throw new ColaExceededSizeException("El lista no puede contener más de 10 elementos.");
		} else {
			boolean resultado = lista.addAll(c);
			Collections.sort(lista, comp);
			return resultado;
		}
	}

	/**
	 * Elimina todos los elementos coincidentes con la colección, siempre y cuando
	 * los elementos del ArrayList no quede vacío.
	 * 
	 * @param c La colección elegida.
	 * @return Devuelve el ArrayList con los elementos borrados.
	 * @throws Exception Si el tamaño de la colección es mayor que el del ArrayList,
	 *                   salta la Exception.
	 */
	public boolean retainAll(Collection<E> c) throws Exception {
		if (lista.size() > c.size()) {
			return lista.retainAll(c);
		} else {
			throw new ElementBlockedException("El lista no puede quedar vacía.");
		}

	}

	/**
	 * Elimina todos los elementos del ArrayList exceptuando el primero.
	 */
	public void clear() {
		for (int i = lista.size() - 1; i < 0; i++) {
			lista.remove(i);
		}
	}

	/**
	 * Añade un objeto al ArrayList si no se excede de 10 elementos en ésta o si el elemento a añadir es null.
	 * @param e Elemento a añadir.
	 * @return Devuelve el ArrayList con el elemento añadido.
	 * @throws Exception Si el tamaño de la lista es mayor o igual a diez, o el elemento a añadir es null; salta la Exception.
	 */
	public boolean add(Object e) throws Exception {
		if (e == null) {
			throw new LlevateTuNullDeAquiException("El contenido no puede ser null.");
		} else if (lista.size() <= 10) {
			throw new ColaExceededSizeException("El lista no puede contener más de 10 elementos.");
		} else {
			boolean resultado = lista.add((E) e);
			Collections.sort(lista, comp);
			return resultado;
		}
	}

}
