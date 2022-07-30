# Dado un path que representa un directorio en el sistema operativo, cuenta la
# cantidad de archivos que están localizados en todos los subdirectorios que tiene
# como raiz el directorio path

from genericpath import isfile
import threading
import os

# subrutina que cuenta la cantidad de archivos en un subdirectorio del path
def countFiles(name, hilo):
    print("se inicia el hilo",hilo,"responsable del directorio", name)
    subdirectorio = os.listdir(name)

    counter = 0
    for file in subdirectorio:
        if isfile(name +"/"+ file):
            counter += 1
    
    print("termina el hilo",hilo,"y el subdirectorio", name, "tiene", counter, "ficheros")


def main():

    # path de ejemplo 'path'
    path = 'path'
    pathList = os.listdir('path')
    
    # obtener los subdirectorios del path 
    for index, file in enumerate(pathList):
        sub = path+"/"+file
        if (os.path.isdir(sub)):

            # crear un hilo por cada subdirectorio encontrado
            hilo = threading.Thread(target=countFiles, args=(sub,index,))
            hilo.start()

main()
