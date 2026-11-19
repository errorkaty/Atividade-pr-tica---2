# Respostas — Sistema de Reserva de Laboratorio

Nome completo: Katllyn Carina Rezende RA: 3111392523003

> Preencha **todos** os campos. Campo vazio é campo não avaliado.
> Não apague os títulos nem os rótulos em negrito: a correção procura por eles.

---

# Etapa 1 — Diagnóstico

## Problema 1 — a conversão do inventario patrimonial

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
**R:** O problema consiste em uma duplicação da lógica de parsing e conversão dos dados brutos devolvidos pelo serviço externo "String[][]" para o modelo de domínio do sistema "Equipamento". Que implemneta tanto "CatalogoEquipamentos quanto em "RelatorioAcervo". Ai conforme cresce e tem novos módulos para consultar o acervo de equipamentos a lógica fica sendo replicada varias vezes. E também como resultado direto disso as regras divergiram "RelatorioAcervo" passou a tratar letras minúsculas e "CatalogoEquipamentos" continuou exigindo maiúsculas e com isso o equipamento "PAT_1003" ficou existente no relatório mas não no catálogo.

**Princípio SOLID violado:**
**R:** Viola o Princípio de SRP (Single Responsibility Principle), porque as classes "CatalogoEquipamentos" e "RelatorioAcervo", além de fazer suas responsabilidades de negócio e apresentação, também tem responsabilidade de interpretar, converter e sanitizar os dados brutos de um serviço externo. Viola também o DIP (Dependency Inversion Principle). Módulos de alto nível dependem diretamente de uma classe concreta de baixo nível ("InventarioLegadoWS"), e não de uma abstração.

**Classes afetadas (pelo nome):**
**R:** "CatalogoEquipamentos" e "RelatorioAcervo"

**Que outra dependência indevida essas classes têm em relação ao
inventario patrimonial, e por que ela é um problema:**
**R:** Além da duplicação da lógica de conversão, as classes estão diretamente acopladas à estrutura de dados interna do serviço legado: uma matriz posicional "String[][]". Elas precisam conhecer o significado de cada posição: o índice 0 corresponde ao código, o índice 1 à descrição e o índice 2 à situação, representada por uma letra. Esse acoplamento é um problema grave, porque mostra detalhes de implementação de um serviço de terceiros às regras de negócio. Se o provedor do serviço patrimonial alterar a ordem das colunas, inserir uma nova coluna ou modificar o tipo de retorno, todas as classes consumidoras poderão deixar de funcionar. Além disso, a dependência da classe concreta "InventarioLegadoWS" dificulta a execução de testes unitários isolados, por não permitir o uso de mocks baseados em uma interface, e impede a substituição transparente do provedor de dados.

## Problema 2 — o ciclo de vida de Reserva

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
**R:** O problema consiste em modelar e controlar o ciclo de vida da entidade "Reserva" por meio de uma variável tipo "String" ("situacao") e de "if/else" espalhadas pelos métodos públicos, como "retirar()", "devolver()" e "cancrlar()". O sistema cresce e surgem novos estados ou transições, como "RESERVADA", "CANCELADA" e "EXPIRADA", os métodos afetados precisam ser reabertos e modificados para incluir novos ramos condicionais. Isso aumenta a complexdade ciclomática, compromete o encapsulamento do ciclo de vida e eleva o risco de erros em tempo de execução causados por fslhas de digitação em strings literais(magics strings).

**Princípio SOLID violado:**
**R:** Viola o Princípio Aberto/Fechado (OCP), uma vez que a classe "Reserva' não está fechada para modificação quando novas fases ou transições precisam ser suportadas. Viola também o Princípio da Responsabilidade Única (SRP), pois "Reservs" acumula a gestão dos dados da reserva e a lógica/regras detalhadas de cada um dos estados e suas transições permitidas e proibidas.

**Classes afetadas (pelo nome):**
**R:** "Reserva"

---

# Etapa 4 — Justificativa

## Padrão aplicado ao Problema 1

**O problema que ele resolve (descreva antes de nomear o padrão):**


**Nome do padrão:**


**Alternativa descartada e por que ela não resolveria por completo:**


## Padrão aplicado ao Problema 2

**O problema que ele resolve (descreva antes de nomear o padrão):**


**Nome do padrão:**


**Alternativa descartada e por que ela não resolveria por completo:**
