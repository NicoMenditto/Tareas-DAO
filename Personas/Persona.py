class Persona:
    def __init__(self, dni, nombre, apellido, edad):
        self.dni = dni
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
    def __str__(self):
        return f"{self.dni}, {self.nombre}, {self.apellido}, {self.edad}"
    def mayor(self):
        return self.edad >= 18