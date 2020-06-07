Aplicação desenvolvida em Java 8 e utilizando troca de DAO dinâmica.

As formas de persistências escolhidas foram: MySql e arquivo txt. Porém podem ser aceitas qualquer outras formas, umas vez que a aplicação tem contrato apenas com as interfaces.

Para isso é utilizado o padão chamado de Factory Method Dynamic. Dessa forma a aplicação apenas
consome as daos de forma externa, sem precisar conhecer a sua implementação.

Dentro da pasta codigo_fonte/src/configuracao, contém o arquivo .properties, onde é possível confgurar qual a persitência a ser utilizada, tanto a de a persistência dos dados dos funcionário, como a de LOG da aplicação.

Padrões de desenvolvimento utilizados no projeto:
1. State
2. Command
3. Builder
4. Factory Method Dynamic
5. Observer
6. Iterator
7. Memento
8. Chain of Responsibility
9. Abstract Factory
10. Factory Method


Padrão estrutural utilizado: MVP (Model View Presenter).

Projeto desenvolvido em 2017.
