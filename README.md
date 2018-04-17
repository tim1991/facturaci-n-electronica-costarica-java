# facturacion-electronica-costarica-java

Este proyecto realiza el firmado digital de los XMLs de factura electrónica para Costa Rica esta basado en el proyecto xades-signer-cr: https://github.com/johann04/xades-signer-cr.

Se le agrego soporte para firma de notas de Credito y notas de debito, tambien para tickete electonico este ultimo no se ha probado aún

En la carpeta https://github.com/tim1991/facturaci-n-electronica-costarica-java/tree/master/jar%20compilado%20con%20nota%20de%20credito%20de%20ejemplo está el jar ya compilado: con ejemplo de nota de credito

```
Usage:
java -jar xades-signer-cr sign_factura <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>
java -jar xades-signer-cr send_factura <endPoint> <xmlPath> <username> <password>
java -jar xades-signer-cr sign_nota_debito <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>
java -jar xades-signer-cr send_nota_debito <endPoint> <xmlPath> <username> <password>
java -jar xades-signer-cr sign_nota_credito <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>
java -jar xades-signer-cr send_nota_credito <endPoint> <xmlPath> <username> <password>
java -jar xades-signer-cr sign_tiquete <keyPath> <keyPassword> <xmlInPath> <xmlOutPath>
java -jar xades-signer-cr send_tiquete <endPoint> <xmlPath> <username> <password>
java -jar xades-signer-cr query <endPoint> <xmlPath> <username> <password>
```

**sign_factura** firma el xml solo para facturas.
**sign_nota_debito** firma el xml solo para notas de debito.
**sign_nota_credito** firma el xml solo para notas de credito.

**send_factura** envía el xml a hacienda.
**send_nota_debito** envía el xml a hacienda.
**send_nota_credito** envía el xml a hacienda.

**query** consulta el status de una factura basado en su xml (lee el consecutivo del archivo y consulta ese consecutivo).

**<keypath>** Ruta de la llave (archivo .p12) generado en ATV (https://www.hacienda.go.cr/ATV/login.aspx).

**<keyPassword>** Pin elegido a la hora de descargar la llave.

**<endPoint>** Endpoint para enviar/recibir la información a hacienda (igual ATV lo proporciona, varía entre producción y desarrollo).

**<username>** Nombre de usuario generado en ATV.

**<password>** Password generado en ATV.
