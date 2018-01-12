java 不能直接支持PEM格式，但是支持PKCS8格式

openssl genrsa -out privateKey.pem 2048
openssl rsa -in privateKey.pem -out publicKey.pem
openssl pkcs8 -in privateKey.pem  -out pkcs8_privateKey.pem -topk8 -nocrypt



C:\Program Files\IBM\WebSphere\AppServer\java\8.0\bin>keytool.exe -importkeystor
e -srckeystore D:/works/sawied/keystore_IBM.jks -destkeystore D:/works/sawied/ke
ystore_p12 -srcstoretype jceks -deststoretype PKCS12 -srcstorepass 212121_vtm_ke
ystore_password_121212 -deststorepass hacn1234 -destkeypass hacn1234 -v