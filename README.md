# xades-signer-cr
Este proyecto realiza el firmado digital de los XMLs de factura electrónica para Costa Rica.

En la carpeta https://github.com/tim1991/facturaci-n-electronica-costarica-java/tree/master/jar%20compilado%20con%20nota%20de%20credito%20de%20ejemplo está el jar ya compilado:

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

**sign** firma el xml.

**send** envía el xml a hacienda.

**query** consulta el status de una factura basado en su xml (lee el consecutivo del archivo y consulta ese consecutivo).

**<keypath>** Ruta de la llave (archivo .p12) generado en ATV (https://www.hacienda.go.cr/ATV/login.aspx).

**<keyPassword>** Pin elegido a la hora de descargar la llave.

**<endPoint>** Endpoint para enviar/recibir la información a hacienda (igual ATV lo proporciona, varía entre producción y desarrollo).

**<username>** Nombre de usuario generado en ATV.

**<password>** Password generado en ATV.
