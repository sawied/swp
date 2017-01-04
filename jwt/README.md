>JWT Security reference implement


* Step one: generate 3DES key

>`keytool -genseckey -alias VTM_LOGON_UK -keyalg DESede -keysize 168 -storetype jceks -keystore keystore-3DES.jks -keypass changeit -storepass changeit -v `
