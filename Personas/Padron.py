class Padron:
    def __init__(self):
        self.personas = dict()
    def agregar_persona(self, persona):
        self.personas[persona.dni] = persona
    def cantidad_personas(self):
        return len(self.personas)
    def cantidad_mayores(self):
        return len([p for p in self.personas.values() if p.mayor()])
    def inician_vocal(self):
        vocales = "aeiouAEIOU"
        return [p for p in self.personas.values() if p.nombre[0] in vocales]