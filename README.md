# requisitos
# deve estar rodando o consul no container na porta 8500

docker run --rm --name consul -p 8500:8500 -p 8501:8501 consul:latest agent -dev -ui -client:0.0.0.0 -bind=0.0.0.0 --https-port=8501

# pode ser acessado o consul pelo link:
http://localhost:8500

# para rodar a aplicação usar o comando:
mvn quarkus:dev

# para testar entrar no seguinte endereço: e ficar dando refresh na pagina
localhost:8080/api

# ou rodar o comando no terminal:
while true; do curl localhost:8080/api ; echo '' ; sleep 1; done



# PARA SUBIR O KEYCLOAK NO KUBERNETES ENTRAR NA PASTA 'kubernetes/keycloack'
# Executar os seguintes comandos:

kubectl apply -f postgres.yaml 

kubectl apply -f postgres-port.yaml 

kubectl apply -f keycloack.yaml 

# Após isso deve ser possível acessar o painel de administração do keycloak pelo endereço
http://localhost:8082