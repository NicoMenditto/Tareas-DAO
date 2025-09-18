from Persona import Persona
from Padron import Padron
class LectorArchivo:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo

    def cargar_padron(self):
        p = Padron()
        archivo = open(self.nombre_archivo, "r")
        for linea in archivo:
            datos = linea.split(",")
            persona = Persona(int(datos[0]), datos[1], datos[2], int(datos[3]))
            p.agregar_persona(persona)
        archivo.close()
        return p