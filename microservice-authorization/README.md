java 不能直接支持PEM格式，但是支持PKCS8格式

openssl genrsa -out privateKey.pem 2048
openssl rsa -in privateKey.pem -out publicKey.pem
openssl pkcs8 -in privateKey.pem  -out pkcs8_privateKey.pem -topk8 -nocrypt