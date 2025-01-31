# EncurtaUrl
 Desafio BackEndBrasil

EncurtaUrl
Um encurtador de URLs desenvolvido em Java Spring Boot que permite encurtar URLs longas e redirecionar para a URL original. O projeto utiliza PostgreSQL como banco de dados e inclui funcionalidades como agendamento para excluir URLs expiradas.

Funcionalidades
Encurtar URLs: Gera uma URL curta (5 a 10 caracteres) a partir de uma URL original.

Redirecionamento: Recupera a URL original a partir da URL encurtada.

Expiração de URLs: URLs encurtadas são automaticamente excluídas após 15 minutos de inatividade.

Tecnologias Utilizadas
Java 17

Spring Boot 3.x

PostgreSQL (Banco de dados)

Spring Data JPA (Persistência de dados)

Lombok (Redução de código boilerplate)

Apache Commons Lang (Geração de strings aleatórias)

GitHub (Versionamento de código)