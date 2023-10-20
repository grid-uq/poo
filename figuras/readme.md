# Pruebas


## Con null 

Se espera Error

## Con colección vacía

Se espera una colección vacía


## Con Datos

{ Triangulo{1,0;1,0} }

Se espera una colección vacía


{ Cuadrado{1,0;1,0} }

Se espera una colección con { Cuadrado{1,0;1,0} }

{ Triangulo{1,0;1,0}, Cuadrado{1,0;1,0} }

Se espera una colección con { Cuadrado{1,0;1,0} }


{ Triangulo{1,0;1,0}, Cuadrado{1,0;1,0}, Rectagulo{5,0,7,0} }

Se espera una colección con { Cuadrado{1,0;1,0}, Rectagulo{5,0;7,0} }

{ Triangulo{1,0;1,0}, Cuadrado{1,0;1,0}, Rectagulo{5,0;7,0}, Rectangulo{1,0;1,0} }

Se espera una colección con { Cuadrado{1,0;1,0},Rectangulo{1,0;1,0}, Rectagulo{5,0,7,0} }
