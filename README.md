# desweb2
crtl l - limpa terminal
mkdir criar pastra
touch - criar um arquivo 


 $ mvn archetype:generate -DgroupId=com.example -DartifactId=simples-sqlite -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

$ mvn compile exec:java -Dexec.mainClass="com.example.Main"

docker ps
docker stop numero_DOCKER 
docker rm  numero_DOCKER 
docker ps -a



virtualização
docker-compose up -d --build
 docker exec -it postgres_container psql -U root projeto




cd projeto/
@CawaEstevan ➜ /workspaces/desweb2/aulaSpring02/projeto (main) $ ls
HELP.md  mvnw  mvnw.cmd  pom.xml  src
@CawaEstevan ➜ /workspaces/desweb2/aulaSpring02/projeto (main) $ chmod +x mvnw
@CawaEstevan ➜ /workspaces/desweb2/aulaSpring02/projeto (main) $ ls
HELP.md  mvnw  mvnw.cmd  pom.xml  src


SPRING3 ATV produto segunda - feira
docker-compose up -d
ls
chmod +x mvnw
./mvnw spring-boot:run

sdk install java 21.0.6-amzn


so fazer a de veiculo
seguir passo a passo se não vai dar erro
na atividade usar o pom.xml que o rafael passou 


<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.4.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>projeto</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>projeto</name>
	<description>projeto spring boot aula 3</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		  </dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
