# Conversor de Monedas en Java ☕
Este proyecto, fue desarrollado como una aplicación de conversión de monedas utilizando el lenguaje de programación Java 20. La aplicación permite a los usuarios convertir cantidades de dinero entre mas de 160 monedas de manera rápida y sencilla.

[![https://i.imgur.com/ungxbE9.jpg](https://i.imgur.com/ungxbE9.jpg "https://i.imgur.com/ungxbE9.jpg")](https://i.imgur.com/ungxbE9.jpg "https://i.imgur.com/ungxbE9.jpg")

## Herramientas Utilizadas
Para el desarrollo de esta aplicación, se utilizaron las siguientes herramientas y tecnologías:

**Java 20:** La versión 20 de Java como lenguaje de programación principal. Java es un lenguaje versátil y robusto que nos permite construir aplicaciones escalables y de alto rendimiento.

**IntelliJ IDEA:** Hemos utilizado IntelliJ IDEA como nuestro entorno de desarrollo integrado (IDE) para escribir, depurar y compilar el código de la aplicación. IntelliJ IDEA proporciona una amplia gama de características y herramientas que facilitan el desarrollo en Java.

**ExchangeRate-API:** Para obtener los tipos de cambio de las diferentes monedas, hemos utilizado la API de ExchangeRate-API. Esta API nos brinda acceso a tasas de cambio actualizadas y precisas, lo que nos permite realizar conversiones precisas de moneda en tiempo real.

**Biblioteca org.json:** Para trabajar con el formato JSON que proporciona la API de ExchangeRate-API, hemos utilizado la biblioteca org.json. Esta biblioteca nos permite analizar y generar datos en formato JSON de manera sencilla y eficiente.

## Funcionalidades Principales
La aplicación de conversión de monedas ofrece las siguientes funcionalidades principales:

**Interfaz gráfica intuitiva:** He desarrollado una interfaz gráfica de usuario (GUI) amigable que permite a los usuarios ingresar la cantidad de dinero y seleccionar las monedas de origen y destino para realizar la conversión.

**Obtención de tipos de cambio en tiempo real: **Utilizando la API de ExchangeRate-API, la aplicación obtiene tasas de cambio actualizadas en tiempo real para garantizar la precisión de las conversiones.

**Conversión precisa y rápida:** Con los datos proporcionados por la API, la aplicación realiza las conversiones de moneda de manera precisa y rápida, mostrando el resultado al usuario de manera clara y concisa.

## Instrucciones de Uso

Compila el código: Abre una terminal o símbolo del sistema en la carpeta raíz del proyecto y compila el código utilizando el siguiente comando:

    javac -d ./out ./src/main/java/org/example/*.java
Esto generará los archivos de clase en la carpeta out del proyecto.

Ejecuta la aplicación: Una vez compilado, ejecuta la aplicación utilizando el siguiente comando:


    java -cp ./out org.example.CurrencyConverterApp
La interfaz gráfica de la aplicación se abrirá y podrás comenzar a realizar las conversiones de moneda.

## Soporte y Contribuciones
Si encuentras algún problema con la aplicación o tienes alguna sugerencia de mejora, no dudes en abrir un problema en el repositorio de GitHub. También puedes realizar contribuciones al proyecto enviando un pull request.

¡Disfruta utilizando el Conversor de Monedas y esperamos que te sea útil en tus necesidades de conversión de monedas!

