import pytest
import Cuaterniones
import math 

cuat1 = Cuaterniones.Cuaternion( 4,3,5, 2)
cuat2 = Cuaterniones.Cuaternion(-3,4,2,-1)
cuat3 = Cuaterniones.Cuaternion(5,5,5,5)

cuat1F = Cuaterniones.Cuaternion(2.0, 1.1, 3.0, 2.0)
cuat2F = Cuaterniones.Cuaternion(3.0, 1.1, 1.5, 2.0)
cuat3F = Cuaterniones.Cuaternion(2.0, 1.1, 3.0, 2.0)

#probar igualdad
def test_eq():
    assert cuat1 == cuat1 and cuat2 == cuat2

# probar la suma entre dos cuaterniones
def test_suma():
    assert cuat1 + cuat2 == Cuaterniones.Cuaternion(1, 7, 7, 1)

# probar la suma entre un cuaternion y numero (float o int)
def test_sumaNum():
    assert cuat1 + 3 == Cuaterniones.Cuaternion(7,3,5,2) and cuat1 + 3.0 == Cuaterniones.Cuaternion(7,3,5,2)

#probar error de tipo de dato incorrecto
def test_suma_fail():
    with pytest.raises(TypeError):
        assert cuat2 + [4,4]

# probar conjugada
def test_conjugada():
    assert ~cuat1 == Cuaterniones.Cuaternion(4,-3,-5,-2)

# probar el producto entre dos cuaterniones
def test_producto():
    assert cuat1*cuat2 == Cuaterniones.Cuaternion(-32,-2,4,-24)

# probar el producto entre un cuaternion y un numero (floats o int)
def test_productoNum():
    assert cuat1*3 == Cuaterniones.Cuaternion(12,9,15,6)

#probar error de tipo de dato incorrecto
def test_producto_fail():
    with pytest.raises(TypeError):
        assert cuat2 * [4,4]

# prueba del calculo del valor absoluto
def test_valor_absoluto():
    assert +cuat3 == 10 and +cuat1 == math.sqrt(54)

# prueba distributividad de */+
def test_distributividad():
    assert cuat1*(cuat2 + cuat3) == cuat1*cuat2 + cuat1*cuat3

# prueba de elemento neutro
def test_neutro():
    assert cuat1 + Cuaterniones.Cuaternion(0,0,0,0) == cuat1 and cuat3 + 0 == cuat3

# prueba de elemento absorvente
def test_absorvente():
    assert cuat1 * Cuaterniones.Cuaternion(0,0,0,0) == Cuaterniones.Cuaternion(0,0,0,0) and \
    cuat3*0 == Cuaterniones.Cuaternion(0,0,0,0)

def test_suma2():
    assert cuat1F + cuat2F == Cuaterniones.Cuaternion(5.0, 2.2, 4.5, 4.0)

