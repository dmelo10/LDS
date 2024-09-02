# Sistema de Matrículas Universitárias
O Sistema de Matrículas Universitárias é um programa que permite a gestão das matrículas dos alunos em uma universidade. Ele organiza as disciplinas oferecidas em cada semestre e permite que os alunos escolham suas matérias obrigatórias e optativas dentro de um período específico. O sistema garante que uma disciplina só será realizada se tiver pelo menos três alunos matriculados e fecha automaticamente as inscrições quando o limite de 60 alunos é atingido.

Além de facilitar o processo de inscrição para os alunos, o sistema permite que os professores visualizem a lista de alunos matriculados em suas disciplinas. O sistema também notifica o setor de cobranças da universidade, assegurando que os alunos sejam cobrados corretamente pelas disciplinas escolhidas. A segurança é mantida através de um sistema de login com senhas para todos os usuários.

## Integrantes
* Alexandre Breedveld Athayde Filho
* Davi Andrade Rocha Melo de Oliveira

## Orientadores
* Cristiano de Macêdo Neto

## Instruções de utilização
Para executar o sistema de matrículas, certifique-se de que o JDK está instalado. Navegue até a pasta onde o arquivo Main.java está localizado, compile-o usando javac Main.java e, em seguida, execute o programa com java Main. O sistema será iniciado no terminal.

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