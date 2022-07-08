package main

import "fmt"

// Tipo de datos recursivo para representar los numerales de Church
type Church struct {
	number *Church
}

// metodo para crear una nueva instancia con el sucesor de otra
func (c *Church) Suc() *Church {
	return &Church{c}
}

// metodo para obtener un la version en integer de un numeral de church
func (c *Church) toInt() int {
	var initial = 0
	var current = c.number
	for current != nil {
		initial++
		current = current.number
	}
	return initial
}

// Funcion para crear un numero de Church a partir de un numero entero
func intToChurch(n int) *Church {
	var church = &Church{}

	for n != 0 {
		church = church.Suc()
		n--
	}
	return church
}

// funcion recursiva para sumar dos numeros de church
func (c Church) suma(m *Church) *Church {
	if m.number == nil {
		return &c

	}

	return c.suma(m.number).Suc()
}

// funcion recursiva para multiplicar dos numeros de church
func (c Church) mult(m *Church) *Church {
	if m.number == nil {
		return m
	}

	return c.suma(c.mult(m.number))
}

// prueba de los metodos
func main() {

	// crear una instancia de church x = 3
	var x = Church{
		number: &Church{
			number: &Church{
				number: &Church{}}},
	}

	// crear una instancia a partir de los sucesores de x. (y = 6)
	var y = x.Suc().Suc().Suc()

	// crear la instancia que representa el zero
	var zero = Church{}

	// crear una instancia a partir de los sucesores del cero. z = 3
	var z = *zero.Suc().Suc().Suc()

	// crear una instacia a partir de un numero entero
	var i = intToChurch(45)

	fmt.Printf("x = %+v\n", x.toInt())             // x = 3
	fmt.Printf("y = %+v\n", y.toInt())             // y = 6
	fmt.Printf("zero = %+v\n", zero.toInt())       // zero = 0
	fmt.Printf("z = %+v\n", z.toInt())             // z = 3
	fmt.Printf("i = %+v\n", i.toInt())             // i = 45
	fmt.Printf("i + y = %+v\n", i.suma(y).toInt()) // i + y = 51
	fmt.Printf("x*y = %+v\n", x.mult(y).toInt())   // x*y = 18

}
