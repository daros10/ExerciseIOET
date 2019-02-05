# Ejercicio IOET - Cálculo de salarios 

El programa permite calcular el sueldo de empleados mediante la lectura de datos en un archivo.txt.<br />
Los datos correspoden a la cantidad de horas que trabaja el empleado en la empresa ACME.<br />
La misma que efecuta los pagos en base a la siguiente tabla:<br />

Lunes a Viernes<br />
00:01 - 09:00 25 USD<br />
09:01 - 18:00 15 USD<br />
18:01 - 00:00 20 USD<br />

Sábado y Domingo<br />
00:01 - 09:00 30 USD<br />
09:01 - 18:00 20 USD<br />
18:01 - 00:00 25 USD<br />

La nomeclatura adoptada para los días de la semana debe ser como se expone en la siguiente tabla:<br />

MO: lunes<br />
TU: martes<br />
WE: miércoles<br />
TH: jueves<br />
FR: viernes<br />
SA: sábado<br />
SU: domingo<br />


# Diseño

Para la elaboración de la solución se dividio el problema en pequeñas partes para de esta manera tener un control sobre los datos.<br />
Se dividio toda la cadena de datos para poder implementar la solución, para esto se uso varios metodos que trabajan en cadena.<br />

# Prerrequisitos 

Contar con algun IDE que soporte Java 

```
NetBeans, Eclipse, VisualStudioCode...
```

# Instalación

Descargue el archivo en formato .rar y luego transformelo a .zip e importelo a cualquiero IDE que soporte Java.

Si usa NetBeans:

```
File > Import Project > From ZIP..
```

# Ejecución

El programa hace uso de un archivo .txt que cuenta con los datos de los empleados a calcularse.<br />

El archivo se encuentra dentro del programa:<br />

```
ExerciseIOET\PaidWorkExercise\datos.txt
```

### Ejecutando la solución 

El archivo debe tener el siguiente formato

```
NOMBRE:DIAHHi:MMi-HHf:MMf,DIAHHi:MMi-HHf:MMf,....
```
* DIA = MO,TU,WE,TH,FR,SU,SA
* HHi = Hora de inicio del empleado
* MMi = Hora de fin del empleado


### Ejemplo Entrada 

La entrada debe ser algo como esto:

```
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```

### Ejemplo Salida

El programa devolvera el costo total a pagarse al empleado:

```
The amount to pay ASTRID is: 85 USD
```

## Autor

* **Dario Herrera** - *Estudiante EPN* - [Perfil](https://github.com/daros10)


## Licencia 

Este proyecto está licenciado bajo la Licencia MIT - vea el archivo [LICENSE.md] (LICENSE.md) para más detalles
