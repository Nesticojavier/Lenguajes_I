import math

class Cuaternion(object):
    """ Clase que representa un Cuaternion como un vector en 4 dimensiones
        que representa a un numero comlejo con tres partes imaginarias ijk:
        a + bi + cj + dk
    """

    def __init__(self, a, b, c, d):
        self.a = a
        self.b = b
        self.c = c
        self.d = d


    def __add__(self, other):
        """Sobrecargar el operador +. """

        # Comprobar si el otro operando es un cuaternion
        if isinstance(other, Cuaternion):
            return Cuaternion(
                self.a + other.a,
                self.b + other.b,
                self.c + other.c,
                self.d + other.d)
        
        # comprobar si el otro operando es un entero o flotante
        elif isinstance(other, int) or isinstance(other, float):
            return Cuaternion(
                self.a + other,
                self.b,
                self.c,
                self.d 
                )


        # comprobar que el tipo de datos sea el adecuado para sumar
        else:
            raise TypeError("Formato no soportado para la suma de cuterniones")

    def __invert__(self):
        """Sobrecarga del operador ~ para hallar la conjugada de un cuaternion"""
        return Cuaternion(self.a, -self.b, -self.c, -self.d)

    def __mul__(self, other):
        """sobrecarga del operador * para multiplicar cuaterniones"""

        # Comprobar si el otro operando es un cuaternion
        if isinstance(other, Cuaternion):
            return Cuaternion(
                self.a*other.a - self.b*other.b - self.c*other.c - self.d*other.d,
                self.a*other.b + self.b*other.a + self.c*other.d - self.d*other.c,
                self.a*other.c - self.b*other.d + self.c*other.a + self.d*other.b,
                self.a*other.d + self.b*other.c - self.c*other.b + self.d*other.a
            )
        
        # comprobar si el otro operando es un entero o flotante
        if isinstance(other, int) or isinstance(other, float):
            return Cuaternion(
                self.a*other,
                self.b*other,
                self.c*other,
                self.d*other
            )

        # comprobar que el tipo de datos sea el adecuado para sumar
        else:
            raise TypeError("Formato no soportado para la suma de cuterniones")

    def __pos__(self):
        """Sobreescibrir el operador + para calcular el valor absoluto"""  
        return math.sqrt((self.a)**2 + (self.b)**2 + (self.c)**2 + (self.d)**2)
    
    def __str__(self):
        """La representacion en string de un cuaternion en string"""
        return str(self.a) + " + " + str(self.b)+"i + " + str(self.c) +"j + "+ str(self.d)+"k"

    def __eq__(self, other):
        """Operador == sobrecargado para permitir comparar dos cuaterniones """

        return ( math.isclose(self.a, other.a) and
            math.isclose(self.b, other.b) and
            math.isclose(self.c, other.c) and
            math.isclose(self.d, other.d))