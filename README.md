# Loader4a

[![Build Status](https://travis-ci.org/Arquisoft/Loader_e4a.svg?branch=master)](https://travis-ci.org/Arquisoft/Loader_e4a)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f2f0d0b009384c8aba7deacb39b7b541)](https://www.codacy.com/app/Llambi/Loader_e4a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Loader_e4a&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/Arquisoft/Loader_e4a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Loader_e4a)

*Skeleton of Loader module*

## Authors originales

* Daniel Alba Muñiz (UO245188)
* José Luis Bugallo González (UO244702)
* Ignacio Escribano Burgos (UO227766)
* Daniel Duque Barrientos (UO245553)
* Rubén de la Varga Cabero (UO246977)

## Authors modificacion

* Pablo Amorin Triana (UO237060)
* Hugo Perez Fernandez (UO250708)
* Ivan Casielles Alvarez (UO251063)
* Mirza Ojeda Vieira (UO251443)
* Antonio Payá González(UO251065)

## Descripcion

El objetivo de este proyecto es actuar como modulo de carga de agentes para un sistema de incidencias

## Manual de uso

### Crear proyecto en eclipse

1. Clonar el proyecto mediante Git en una carpeta local [Loader_e4a](https://github.com/Arquisoft/Loader_e4a.git).
2. Importar el proyecto clonado a Eclipse.
3. Actualizar dependencias con Maven.

### Ejecucion

Para ejecutar la aplicacion se debe ir al directorio *ejecucion* y una vez ahi se dispondra de tres archivos .bat:

* *Help*: Para ver la ayuda de la aplicacion.
* *Info*: Para ver la informacion sobre la aplicacion.
* *Test*: Para realizar una ejecucion de la aplicacion.

Ademas para realizar una ejecucion de la aplicacion por uno mismo se debera ejecutar en la linea de comandos la siguiente instruccion:

	mvn -q exec:java -Dexec.mainClass="main.LoadAgents" -Dexec.args="Aqui iran los argumentos a usar"
	
	e.j.:mvn -q exec:java -Dexec.mainClass="main.LoadAgents" -Dexec.args="load src/test/resources/test.csv src/test/resources/test.xlsx"

