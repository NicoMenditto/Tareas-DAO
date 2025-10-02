# Curso: 4k4
# Nombre: Nicolas Menditto
# Legajo: 404044
from abc import ABC, abstractmethod
class Hotel:
    def __init__(self, archivo):
        self.habitaciones = []
        try:
            with open(archivo, 'r') as file:
                for line in file:
                    datos = line.strip().split(',')
                    tipo = datos[0]
                    numero = int(datos[1])
                    huesped = datos[2]
                    costo_base = float(datos[3])
                    noches = int(datos[4])
                    if int(tipo) == 1:
                        self.habitaciones.append(Estandar(numero, huesped, costo_base, noches, False))
                    elif int(tipo) == 2:
                        vista_mar = datos[5] == 'True'
                        self.habitaciones.append(Suite(numero, huesped, costo_base, noches, vista_mar))
                    elif int(tipo) == 3:
                        jacuzzi = datos[5] == 'True'
                        self.habitaciones.append(SuitePremium(numero, huesped, costo_base, noches, jacuzzi))
        except FileNotFoundError:
            raise FileNotFoundError(f"El archivo {archivo} no existe.")
    def cantidad_habitaciones(self):
        return len(self.habitaciones)
    def cantidad_por_tipo(self):
        tipos = {"Estandar": 0, "Suite": 0, "SuitePremium": 0}
        for habitacion in self.habitaciones:
            if isinstance(habitacion, Estandar):
                tipos["Estandar"] += 1
            elif isinstance(habitacion, Suite):
                tipos["Suite"] += 1
            elif isinstance(habitacion, SuitePremium):
                tipos["SuitePremium"] += 1
        return tipos
    def obtener_suma_reservas(self):
        return sum(habitacion.calcular_costo() for habitacion in self.habitaciones)
    def obtener_reserva_mas_cara(self):
        # Devuelve la primera habitación con mayor costo, o None si no hay habitaciones
        if not self.habitaciones:
            return None
        mayor = self.habitaciones[0]
        mayor_costo = mayor.calcular_costo()
        for habitacion in self.habitaciones[1:]:
            costo = habitacion.calcular_costo()
            if costo > mayor_costo:  # mantener la primera en caso de empate
                mayor = habitacion
                mayor_costo = costo
        return mayor
    def calcular_ingreso_total(self):
        return self.obtener_suma_reservas()
    def contar_suites_vista_mar(self):
        return sum(1 for habitacion in self.habitaciones if isinstance(habitacion, Suite) and habitacion.vista_mar)
    def contar_suites_premium_jacuzzi(self):
        return sum(1 for habitacion in self.habitaciones if isinstance(habitacion, SuitePremium) and habitacion.jacuzzi) 
    
class Habitacion(ABC):
    def __init__(self, tipo, numero, huesped, costo_base, noches):
        self.tipo = int(tipo)
        self.numero = int(numero)
        self.huesped = huesped
        self.costo_base = float(costo_base)
        self.noches = int(noches)

    @abstractmethod
    def calcular_costo(self):
        pass


class Estandar(Habitacion):
    def __init__(self, numero, huesped, costo_base, noches, extra):
        super().__init__(1, numero, huesped, costo_base, noches)
        self.extra = extra
    def calcular_costo(self):
        return self.costo_base * self.noches

class Suite(Habitacion):
    def __init__(self, numero, huesped, costo_base, noches, vista_mar):
        super().__init__(2, numero, huesped, costo_base, noches)
        self.vista_mar = vista_mar
    def calcular_costo(self):
        if self.vista_mar:
            return self.costo_base * self.noches * 1.1
        else:
            return self.costo_base * self.noches

class SuitePremium(Habitacion):
    def __init__(self, numero, huesped, costo_base, noches, jacuzzi):
        super().__init__(3, numero, huesped, costo_base, noches)
        self.jacuzzi = jacuzzi
    def calcular_costo(self):
        if self.jacuzzi:
            return self.costo_base * self.noches * 1.2
        else:
            return self.costo_base * self.noches
