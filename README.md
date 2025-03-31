# 📩 Envio de E-mails com JavaMail

Este projeto demonstra como enviar e-mails utilizando JavaMail, incluindo suporte para mensagens em HTML e anexos em PDF gerados dinamicamente.

## 🚀 Funcionalidades

- Envio de e-mails com HTML personalizado
- Anexação automática de arquivos PDF
- Autenticação segura via SMTP (Gmail)
- Suporte a múltiplos destinatários

## 🛠️ Tecnologias Utilizadas

- **Java 8+**
- **JavaMail API**
- **iText PDF** (para geração de PDFs)

## 📦 Como Usar

### 1️⃣ Configurar Dependências
Adicione as bibliotecas necessárias ao seu projeto:
```xml
<dependencies>
    <!-- JavaMail API -->
    <dependency>
        <groupId>javax.mail</groupId>
        <artifactId>javax.mail-api</artifactId>
        <version>1.6.2</version>
    </dependency>
    
    <!-- iText PDF -->
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>itext7-core</artifactId>
        <version>7.1.15</version>
    </dependency>
</dependencies>
```

### 2️⃣ Configurar Credenciais
No arquivo `ObjetoEnviaEmail.java`, substitua as credenciais por suas informações de e-mail:
```java
private String userName = "seuemail@gmail.com";
private String password = "suasenha";
```
💡 **Dica:** Utilize variáveis de ambiente para maior segurança.

### 3️⃣ Executar o Código
Crie uma instância de `ObjetoEnviaEmail` e envie um e-mail:
```java
ObjetoEnviaEmail envio = new ObjetoEnviaEmail(
    "destinatario@email.com",
    "Seu Nome",
    "Assunto do E-mail",
    "<h1>Mensagem HTML</h1>"
);
envio.enviarEmailAnexo(true);
```

## 📧 Exemplo de E-mail Enviado
![Exemplo de E-mail](https://via.placeholder.com/600x300.png?text=Exemplo+de+Email)

## 🔐 Segurança
- **Evite expor suas credenciais no código-fonte**
- Utilize **variáveis de ambiente** ou um **arquivo de configuração externo**


