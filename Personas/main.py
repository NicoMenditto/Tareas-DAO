from LectorArchivo import LectorArchivo
def main():
    lector = LectorArchivo("2025-guias/tema-03/personas2/personas.csv")
    padron = lector.cargar_padron()
    print("Cantidad de personas en el padrón:", padron.cantidad_personas())
    print("Personas mayores de edad:", padron.cantidad_mayores())
    input("Presione Enter para ver las personas cuyos nombres inician con vocal...")
    for persona in padron.inician_vocal():
        print(persona)
    input("Presione enter para ver la cantidad de personas por cada apellido...")
    apellidos = dict()
    for persona in padron.personas.values():
        if persona.apellido in apellidos:
            apellidos[persona.apellido] += 1
        else:
            apellidos[persona.apellido] = 1
    for apellido, cantidad in apellidos.items():
        print(f"{apellido}: {cantidad}")
    
    
    
    
    
if __name__ == "__main__":
    main()