# **EJB com Jakarta EE: API Rest com o servidor WildFly**!

Projeto para estudos de EJB com Jakart EE com o servidor WildFly na plataforma de ensino Alura.
Utilizando a versão 14 da linguagem de programação Java e o servidor de aplicação na versão 20.0.1-final.
[Link do curso](https://cursos.alura.com.br/course/ejb-jakarta-ee-api-rest-wildfly)




# Configuração do projeto

Etapas necessárias para configurações do projeto é servidor de aplicação.

Servidor de aplicação WildFly:

- Usando a configuração de aplicação do servidor `standalone-full.xml` temos que trocar. Para isso basta abrir o arquivo em questão no editor de preferencia procurar e editar com a sugestão abaixo.
	>  `<strict-max-pool name="slsb-strict-max-pool" derive-size="from-cpu-count" instance-acquisition-timeout="5" instance-acquisition-timeout-unit="MINUTES"/>`.
	
	>  `<strict-max-pool name="slsb-strict-max-pool" max-pool-size="20" instance-acquisition-timeout="5" instance-acquisition-timeout-unit="MINUTES"/>`.


MySQL e DataSource:
Instalar o Mysql na sua máquina ( Se não souber e só procurar no Google [link de instalação]([https://www.google.com/search?q=instalar+mysql&oq=instalar+mysql&aqs=chrome..69i57j0l7.3253j0j7&sourceid=chrome&ie=UTF-8](https://www.google.com/search?q=instalar+mysql&oq=instalar+mysql&aqs=chrome..69i57j0l7.3253j0j7&sourceid=chrome&ie=UTF-8)))

Depois de instalar, criar um database e tabela com os comandos: 
~~~ sql
```
CREATE DATABASE agendamentoemaildb;

USE agendamentoemaildb;

CREATE TABLE agendamentoemail (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    assunto varchar(50) NOT NULL,
    mensagem varchar(255) NOT NULL,
    agendado tinytext NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
~~~
[Download do MySQL Connector](https://caelum-online-public.s3.amazonaws.com/1750-ejb-jakarta-ee-api-rest-wildfly/03/mysql-connector-java-8.0.20.jar)



Configurar o datasource no WildFly

- Via Terminal/cmd/PowerShell acessar a pasta bin no WildFly e executar o comando `./jboss-cli.sh` se sistema operacional  baseado em Linux ou executar o comando `jboss-cli.bat` no Windows*.
- Depois tem que conectar com o comando `connect`.
- Após o `connect` executar o comando.
	> `module add --name=com.mysql --resources="/home/ac/develop/mysql-connector-java-8.0.20.jar" --dependencies=javax.api,javax.transaction.api`.
	
	>`/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)`