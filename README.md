# Nome do projeto
Escreva um ou dois parágrafo resumindo o objetivo do seu projeto.

## Integrantes
* Alexandre Breedveld Athayde Filho
* Davi Andrade Rocha Melo de Oliveira
* Nome completo do aluno 3
* Nome completo do aluno 4

## Orientadores
* Nome completo do professor 1
* Nome completo do professor 2

## Instruções de utilização
Assim que a primeira versão do sistema estiver disponível, deverá complementar com as instruções de utilização. Descreva como instalar eventuais dependências e como executar a aplicação.

# Histórias de Usuário - Sistema de Matrículas Universitário

## Como um Aluno

1. Eu quero fazer login no sistema para acessar as funcionalidades de matrícula.
2. Eu quero me matricular em até 4 disciplinas obrigatórias e 2 optativas para compor meu semestre.
3. Eu quero cancelar matrículas feitas anteriormente para ajustar minha grade curricular.
4. Eu quero consultar as disciplinas em que estou matriculado para acompanhar minha situação acadêmica.

## Como um Professor

1. Eu quero fazer login no sistema para acessar as informações das minhas turmas.
2. Eu quero consultar a lista de alunos matriculados em cada disciplina que leciono para planejar minhas aulas.

## Como a Secretaria

1. Eu quero fazer login no sistema para gerenciar as informações acadêmicas.
2. Eu quero gerar o currículo para cada semestre para organizar a oferta de disciplinas.
3. Eu quero manter as informações sobre disciplinas para manter o catálogo atualizado.
4. Eu quero manter as informações sobre professores para associá-los às disciplinas.
5. Eu quero manter as informações sobre alunos para gerenciar os registros acadêmicos.
6. Eu quero verificar o status das disciplinas após o período de matrículas para decidir quais serão ofertadas.

## Como o Sistema

1. Eu quero validar o login de todos os usuários para garantir a segurança do acesso.
2. Eu quero limitar as matrículas em cada disciplina a 60 alunos para respeitar a capacidade máxima.
3. Eu quero verificar se há pelo menos 3 alunos matriculados em cada disciplina para determinar se ela será ofertada.
4. Eu quero notificar o sistema de cobranças após a matrícula de um aluno para que as taxas sejam aplicadas corretamente.

```plantuml
@startuml
left to right direction
actor Aluno
actor Professor
actor Secretaria
actor "Sistema de Cobranças" as Cobrancas

rectangle "Sistema de Matrículas" {
  usecase "Fazer Login" as UC1
  usecase "Matricular em Disciplinas" as UC2
  usecase "Cancelar Matrícula" as UC3
  usecase "Consultar Disciplinas Matriculadas" as UC4
  usecase "Gerar Currículo Semestral" as UC5
  usecase "Manter Informações de Disciplinas" as UC6
  usecase "Manter Informações de Professores" as UC7
  usecase "Manter Informações de Alunos" as UC8
  usecase "Verificar Status de Disciplinas" as UC9
  usecase "Consultar Alunos Matriculados" as UC10
  usecase "Notificar Cobrança" as UC11
}

Aluno --> UC1
Aluno --> UC2
Aluno --> UC3
Aluno --> UC4

Professor --> UC1
Professor --> UC10

Secretaria --> UC1
Secretaria --> UC5
Secretaria --> UC6
Secretaria --> UC7
Secretaria --> UC8
Secretaria --> UC9

UC2 ..> UC9 : <<include>>
UC3 ..> UC9 : <<include>>
UC9 ..> UC11 : <<extend>>

Cobrancas <-- UC11
@enduml
```