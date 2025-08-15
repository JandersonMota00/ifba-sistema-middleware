# Trabalho de Middleware Modular
- **Instituição:** IFBA - Instituto Federal da Bahia
- **Curso:** Análise e Desenvolvimento de Sistemas (ADS)
- **Disciplina:** Padrões de Projetos
- **Projeto:** Projeto Integrado: Sistema Modular para Gerenciamento de Dispositivos Inteligentes (IoT + Padrões GOF + SOLID)
- **Professor:** Felipe de Souza Silva
- **Semestre:** 5
- **Ano:** 2025.1

# Middleware Modular de Dispositivos Inteligentes
Projetar e desenvolver um sistema modular para gerenciamento de dispositivos  inteligentes), aplicando múltiplos padrões GOF e princípios SOLID, com foco em baixo  acoplamento, alta coesão e extensibilidade.

[A5 - SAJ-ADS08 - Sistema Modular para Gerenciamento de Dispositivos Inteligentes .pdf](https://github.com/user-attachments/files/21698573/A5.-.SAJ-ADS08.-.Sistema.Modular.para.Gerenciamento.de.Dispositivos.Inteligentes.pdf)

## Integrantes do Projeto

<table>
  <tr>
    <td align="center">
      <img src="https://avatars.githubusercontent.com/u/80362674?v=4" width="100px;" alt="Foto do Integrante Janderson"/><br />
      <sub><b><a href="https://github.com/JandersonMota">Janderson Mota</a></b></sub>
    </td>
    <td align="center">
      <img src="https://avatars.githubusercontent.com/u/110790276?v=4" width="100px;" alt="Foto da Integrante Sarah"/><br />
      <sub><b><a href="https://github.com/">Sarah Pithon</a></b></sub>
    </td>
  </tr>
</table>

## Tecnologias
- **Linguagem:** Java 21
- **Framework:** Spring

## Estrutura do Projeto


## Diagrama UML


## Documentação Técnica

### Padrões de Design GOF Aplicados

* **Singleton (Criação)**: Utilizado implicitamente pelo Spring, onde cada `@Component`, `@Service` e `@Configuration` é um bean singleton por padrão. A classe `SystemConfig` é um exemplo.
* **Factory Method (Criação)**: A interface `DeviceFactory` e sua implementação `DefaultDeviceFactory` demonstram este padrão, centralizando a criação de dispositivos e permitindo a adição de novos tipos.
* **Observer (Comportamental)**: Implementado através do sistema de eventos do Spring (`ApplicationEventPublisher` e `ApplicationListener`). Um `EventSubject` publica eventos, e os `ConcreteObserver` escutam e reagem a eles de forma desacoplada.
* **Command (Comportamental)**: A interface `Command` e suas classes concretas encapsulam ações, permitindo que elas sejam parametrizadas e executadas de forma flexível.
* **Strategy (Comportamental)**: A interface `ResponseStrategy` define diferentes algoritmos de resposta a eventos, permitindo a troca de comportamento em tempo de execução.
* **Composite (Estrutural)**: O padrão `UIComponent` e suas implementações (`Panel`, `Button`, `Text`) permitem a construção de interfaces hierárquicas, tratando elementos individuais e compostos de forma uniforme.
* **Decorator (Estrutural)**: A interface `ThemedComponent` e as classes `DarkThemeDecorator` e `LightThemeDecorator` demonstram a adição de funcionalidades de tema à interface simulada de forma dinâmica.

### Princípios SOLID

A arquitetura do projeto adere a todos os princípios SOLID:
* **SRP**: Cada classe tem uma única responsabilidade.
* **OCP**: O sistema é aberto para extensão (novos dispositivos, estratégias, temas) sem modificação do código existente.
* **LSP**: As subclasses de `Device` podem substituir a classe base sem causar erros.
* **ISP**: Interfaces como `Command` e `Observer` são pequenas e focadas.
* **DIP**: O código depende de abstrações (interfaces) em vez de implementações concretas, o que é facilitado pela injeção de dependência do Spring.