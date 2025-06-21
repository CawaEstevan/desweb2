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



SPRING3 ATV produto segunda - feira
docker-compose up -d
ls
chmod +x mvnw
./mvnw spring-boot:run

sdk install java 21.0.6-amzn




-- ============================================
-- SCRIPT SQL COMPLETO PARA SPRING SECURITY
-- ============================================

-- 1. CRIAÇÃO DAS TABELAS
-- ============================================

-- Tabela de Roles (Perfis)
CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela de Users (Usuários)
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabela de relacionamento Users_Roles (Muitos para Muitos)
CREATE TABLE IF NOT EXISTS users_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- 2. INSERÇÃO DOS DADOS DE TESTE
-- ============================================

-- Inserir Roles
INSERT INTO roles (name) VALUES 
    ('ROLE_USER'),
    ('ROLE_ADMIN')
ON CONFLICT (name) DO NOTHING;

-- Inserir Usuários
-- Senha: 123456 (criptografada com BCrypt)
INSERT INTO users (username, password) VALUES 
    ('user', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVMFvK'),
    ('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVMFvK')
ON CONFLICT (username) DO NOTHING;

-- Associar Usuários com Roles
-- Usuário 'user' terá ROLE_USER
INSERT INTO users_roles (user_id, role_id) 
SELECT u.id, r.id 
FROM users u, roles r 
WHERE u.username = 'user' AND r.name = 'ROLE_USER'
ON CONFLICT DO NOTHING;

-- Usuário 'admin' terá ROLE_ADMIN
INSERT INTO users_roles (user_id, role_id) 
SELECT u.id, r.id 
FROM users u, roles r 
WHERE u.username = 'admin' AND r.name = 'ROLE_ADMIN'
ON CONFLICT DO NOTHING;

-- 3. VERIFICAÇÃO DOS DADOS
-- ============================================

-- Verificar se as tabelas foram criadas
SELECT table_name FROM information_schema.tables 
WHERE table_schema = 'public' 
ORDER BY table_name;

-- Verificar roles criadas
SELECT * FROM roles;

-- Verificar usuários criados
SELECT id, username, LEFT(password, 20) || '...' as password_hash 
FROM users;

-- Verificar associações usuário-role
SELECT 
    u.username,
    r.name as role_name
FROM users u
JOIN users_roles ur ON u.id = ur.user_id
JOIN roles r ON ur.role_id = r.id
ORDER BY u.username;

-- 4. CONSULTAS ÚTEIS PARA DEBUG
-- ============================================

-- Ver estrutura das tabelas
\d+ users
\d+ roles  
\d+ users_roles

-- Contar registros
SELECT 
    (SELECT COUNT(*) FROM users) as total_users,
    (SELECT COUNT(*) FROM roles) as total_roles,
    (SELECT COUNT(*) FROM users_roles) as total_associations;
