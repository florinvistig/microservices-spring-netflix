Sample project to run microservices based on Spring, Kafka and OAuth2

1. Start Discovery server
2. docker-compose up (start kafka and zookeeper)
3. Start other services



To generate OAuth token :

keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=microservice, L=Bucuresti, c=RO" -keypass mySecretKey -keystore jwt.jks -storepass mySecretKey

keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

curl -X POST "web-app:web-pass@localhost:9999/oauth/token" -d "grant_type=password&username=reader&password=12345678"