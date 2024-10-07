- David Zaragoza García
- Desarrollador Android
- isczaragoza@gmail.com

/*Leer documento desde Android Studio*/

Prueba Técnica de evalución en el proceso de selección para vacante Android en Konfio.

Adjunto este documento README.md, para complementar el desarrollo de la prueba y aplicación.

- Arquitectura:

Elegí el enfoque a una arquitectura limpia (Clean Architecture) definida por 3 Capas: Framework, Data, Domain; Para mantener separadas responsabilidades, 
manter bajo el acoplamiento, una alta cohesión, permitir la sustitución de implementaciones y facilitar la testabilidad.
-Framework: Todo lo relacionado al Framework de Android, librerias e implementaciones concretas.
-Data: Encargada de gestionar los datos de fuentes externes (base de datos, red), implementación de fuentes de datos y repositorios, logica de aplicación.
-Domain: Casos de Uso, Modelos, Entidades, Logica de negocio/Reglas de negocio.

- MVVM:
  
Elegí implementar también el patrón MVVM para separar y comunicar la logica de pantalla (UI) con la lógica de aplicación y mantener resposabilidades separadas.
- Uso de la libreria para gestión del ciclo de vida de una Aplicación Android y del ViewModel (JetPack lifecycle).

- DDR (Domain Driven Design):

También me gustaría agregar que seguí algunos principios que considero importantes del diseño orientado al dominio:
- Modelos en core de aplicación
- Reglas de negocio en el core de aplicación.

Se siguieron los principios S.O.L.I.D.

Diagrama de alto nivel de estructura/arquitectura del proyecto:

___________________________________________________________________
|                          Framework                              |
|  Framework/Features(Home,ListOfDogs,etc)/DesignSystem/UiTheme)  |
|                                                                 |
|_________________________________________________________________|
                              |
                              |
                              |
                              |
                              |
                              V
___________________________________________________________________
|                          Domain                                 |
|            UseCases/Entitites/Repositories/etc                  |
|                                                                 |
|_________________________________________________________________|
                              |
                              |
                              |
                              |
                              |
                              |
                              V
___________________________________________________________________
|                          Data                                   |
|         RepositoriesImpl/DataSources/DTOs/Contracts             |
|                                                                 |
|_________________________________________________________________|

- Peticiones a la Red:
Retrofit

- Persistencia Local
Room Database

- Inyección de dependencias
Koin

Comentarios:
El archivo proporcionado para realizar la prueba técnica era legible, entendible y claro con las instrucciones y lo que se solicitaba.
No tuve ningun problema relacionado a la prueba.

Problemas de ejecución:
Realmente no experimente ningun problema durante mi desarrollo en la prueba, pero si debo admitir que siempre tratar de seguir
las buenas prácticas, la calidad y patrones recomendados, conlleva un reto para ajustarlas a las necesidades de los requerimientos.
Mi manera de afrontar ese reto es realizar algunos diágramas de alto nivel, pequeños diágramas de flujo y bocetos básicos, para comprender 
el punto en el que me encuntro y verificar que entendí o tengo claros los requerimientos.

Concluciones:
La prueba técnica la considero un buen ejercicio para poner a prueba varios puntos y algunos allá del conocimiento técnico.
Es un ejercicio bastante completo, me agradó que se cubriera una parte de diseño.
Para finalizar me siento emocionado de poder entregar esta prueba técnica y espero pronto la revisión y el feedback de la misma.



