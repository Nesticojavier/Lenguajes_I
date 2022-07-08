package main

import "fmt"

// tipo de datos recursivos para representar un arbol binario
type Arbol struct {
	info    int
	hijoIzq *Arbol
	hijoDer *Arbol
}

// variables globales usadas para almacenar el recorrido de los algoritmos
var preorder = make([]int, 0)
var postorder = make([]int, 0)

// funcion para recorrer el arbol en pre-order
func preOrderVisit(a Arbol) {
	preorder = append(preorder, a.info)
	if a.hijoIzq != nil || a.hijoDer != nil {
		preOrderVisit(*a.hijoIzq)
		preOrderVisit(*a.hijoDer)
	}
}

// funcion para recorrer el arbol en post-order
func postOrderVisit(a Arbol) {
	if a.hijoIzq != nil || a.hijoDer != nil {
		postOrderVisit(*a.hijoIzq)
		postOrderVisit(*a.hijoDer)
	}
	postorder = append(postorder, a.info)
}

// funcion para determinar si es un max heap
func isMaxHeap(root Arbol) bool {
	if &root == nil {
		return true
	}

	if root.hijoIzq != nil {
		if root.info < root.hijoIzq.info {
			return false
		}
		return isMaxHeap(*root.hijoIzq)
	}
	if root.hijoDer != nil {
		if root.info < root.hijoDer.info {
			return false
		}
		return isMaxHeap(*root.hijoDer)
	}

	return true
}

// funcion para comparar si dos slices son iguales
func Equal(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}

func esMAxHeapSimetrico(A Arbol) bool {
	preOrderVisit(A)
	postOrderVisit(A)

	if isMaxHeap(A) {
		if Equal(preorder, postorder) {
			return true
		} else {
			fmt.Printf("el arbol es un max heap pero no es simetrico")
			return false
		}
	}
	fmt.Printf("el arbol no es un max heap")
	return false
}

func main() {

	// se crea una instancia de la clase Arbol
	myArbol := Arbol{
		info: 5,
		hijoIzq: &Arbol{
			info: 4,
			hijoIzq: &Arbol{
				info: 3,
			},
			hijoDer: &Arbol{
				info: 2,
			},
		},
		hijoDer: &Arbol{
			info: 3,
			hijoIzq: &Arbol{
				info: 2,
			},
			hijoDer: &Arbol{
				info: 1,
			},
		},
	}
	//         5
	//	     /   \
	// 	   4       3
	//	 /  \     /  \
	//  3    2   2    1

	esMAxHeapSimetrico(myArbol)
	// el arbol es un max heap pero no es simetrico
}
