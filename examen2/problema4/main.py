import functions
import time
import sys
sys.setrecursionlimit(1000000000)



# print("Resutados para la funcion recursiva simple:")
# print("n      |     time (seg)")
# for n in range(10,101,10) :

#     inicio = time.time()
#     functions.fRecursiva(n)
#     fin = time.time()
#     print(str(n) + "    |     "+ str(fin-inicio)) 

print("\n*****************************\n")

print("Resutados para la funcion recursiva de cola:")
print("n      |     time (seg)")
for n in range(10000,20001,1000) :

    inicio = time.time()
    functions.fRecursivaDeCola(n)
    fin = time.time()
    print(str(n) + "    |     "+ str(fin-inicio)) 

print("\n*****************************\n")

print("Resutados para la version iterativa:")
print("n      |     time (seg)")
for n in range(10000,20001,1000) :
    inicio = time.time()
    functions.fIterativa(n)
    fin = time.time()
    print(str(n) + "    |     "+ str(fin-inicio)) 

