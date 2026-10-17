# language: es
Característica: Generación del certificado bancario en PDF
  Como cliente del banco
  Quiero generar mi certificado en PDF
  Para tener un documento con mis datos correctos

  Esquema del escenario: El PDF generado contiene los datos del cliente
    Dado que Juan abre la aplicación de certificados
    Cuando genera el certificado con nombre "<nombre>" y documento "<documento>"
    Entonces el PDF generado debe contener el nombre "<nombre>" y el documento "<documento>"

    Ejemplos:
      | nombre       | documento  |
      | Ana Gomez    | 1020304050 |
      | Carlos Perez | 9876543210 |