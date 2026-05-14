# Guia de Configuração - AppCondominio

Instruções detalhadas para configurar o ambiente de desenvolvimento do AppCondominio.

## 🔧 Pré-requisitos

### Software Necessário

- **Android Studio** (versão 2023.1 ou superior)
  - Download: https://developer.android.com/studio

- **JDK 11 ou superior**
  - Pode vir incluído no Android Studio
  - Ou download: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

- **SDK Android**
  - API 24 (mínimo)
  - API 36 (recomendado)
  - Instalado automaticamente pelo Android Studio

- **Git**
  - Download: https://git-scm.com/

### Requisitos de Sistema

| Requisito | Mínimo | Recomendado |
|-----------|--------|-------------|
| RAM | 4 GB | 8 GB ou mais |
| Espaço em Disco | 2 GB | 5 GB ou mais |
| Processador | Qualquer | Multi-core |

## 📥 Instalação do Ambiente

### Passo 1: Instalar Android Studio

1. Baixe o Android Studio em https://developer.android.com/studio
2. Execute o instalador
3. Siga os passos do assistente de instalação
4. Selecione componentes padrão recomendados

### Passo 2: Configurar SDK

1. Abra Android Studio
2. Vá para `Tools` → `SDK Manager`
3. Instale os seguintes componentes:
   - Android SDK Platform 36 (ou versão mais recente)
   - Android SDK Platform 24 (ou versão mais alta)
   - Android SDK Build-Tools (versão compatível)
   - Android Emulator
   - Android SDK Platform-Tools

### Passo 3: Configurar JDK

1. Vá para `File` → `Project Structure` → `SDK Location`
2. Verifique se o JDK está corretamente configurado
3. Se necessário, selecione o JDK 11 instalado

### Passo 4: Instalar Git

1. Baixe em https://git-scm.com/
2. Execute o instalador e siga as instruções padrão
3. Verifique a instalação:
   ```bash
   git --version
   ```

## 🚀 Configurar o Projeto

### Passo 1: Clonar o Repositório

```bash
git clone https://github.com/OrlandoRoberto/AppCondominio.git
cd AppCondominio
```

### Passo 2: Abrir no Android Studio

1. Abra Android Studio
2. Clique em `Open`
3. Navegue até a pasta do projeto AppCondominio
4. Clique em `OK`

### Passo 3: Aguardar Sincronização

O Android Studio sincronizará automaticamente as dependências Gradle:
- Isso pode levar alguns minutos na primeira execução
- Não feche o Android Studio durante este processo

Se a sincronização não começar automaticamente:
1. Vá para `File` → `Sync with Gradle Files`
2. Ou pressione `Ctrl+Shift+A` (Windows/Linux) / `Cmd+Shift+A` (Mac) e busque por "Sync"

### Passo 4: Confirmar Sincronização

Você saberá que a sincronização foi bem-sucedida quando:
- Não houver mensagens de erro no painel inferior
- Os ícones de arquivo aparecerem normalmente na árvore de projeto
- Você conseguir expandir as dependências Gradle

## 🏃 Executar a Aplicação

### Opção 1: Usar um Emulador Android

#### Criar um Emulador Virtual

1. Vá para `Tools` → `AVD Manager`
2. Clique em `Create Virtual Device`
3. Selecione um dispositivo (ex: Pixel 6)
4. Selecione uma versão de API (recomendado: API 30 ou superior)
5. Configure conforme necessário
6. Clique em `Finish`

#### Executar no Emulador

1. Na barra de ferramentas, selecione o emulador virtual criado
2. Clique no ícone "Run" (▶) verde
3. Ou pressione `Shift + F10` (Windows/Linux) / `Ctrl + R` (Mac)
4. Aguarde o emulador iniciar e o app ser instalado

### Opção 2: Usar um Dispositivo Físico

#### Preparar o Dispositivo

1. **Ativar Debugging**:
   - Ir para `Settings` → `About phone`
   - Tocar 7 vezes em `Build number`
   - Voltar e ir para `Settings` → `Developer options`
   - Ativar `USB Debugging`

2. **Conectar ao Computador**:
   - Conectar o dispositivo via USB
   - Autorizar o computador no dispositivo (se solicitado)

#### Verificar Conexão

```bash
adb devices
# Deve listar seu dispositivo
```

#### Executar no Dispositivo

1. Na barra de ferramentas, selecione seu dispositivo conectado
2. Clique no ícone "Run" (▶) verde
3. Ou pressione `Shift + F10` (Windows/Linux) / `Ctrl + R` (Mac)

## 🧪 Executar Testes

### Testes Unitários

```bash
# Via Gradle
./gradlew test

# Via Android Studio
Clique com botão direito no pacote → Run 'Tests in ...'
```

### Testes Instrumentados

```bash
# Via Gradle
./gradlew connectedAndroidTest

# Via Android Studio
Clique com botão direito no pacote Android Tests → Run 'Android Tests'
```

## 🔨 Comandos Gradle Úteis

```bash
# Sincronizar dependências
./gradlew sync

# Compilar Debug
./gradlew assembleDebug

# Compilar Release
./gradlew assembleRelease

# Limpar build
./gradlew clean

# Executar testes unitários
./gradlew test

# Executar testes instrumentados
./gradlew connectedAndroidTest

# Verificar lint
./gradlew lint

# Gerar documento de dependências
./gradlew dependencies
```

## 🐛 Troubleshooting

### Problema: "No SDK found"

**Solução**:
1. Vá para `File` → `Project Structure` → `SDK Location`
2. Verifique o caminho do Android SDK
3. Se estiver vazio, aponte para a pasta de SDK

### Problema: Sincronização Gradle falha

**Solução**:
1. Vá para `File` → `Invalidate Caches...`
2. Selecione `Invalidate and Restart`
3. Aguarde reiniciar
4. Tente sincronizar novamente

### Problema: Compilação falha - "target release version should be 11"

**Solução**:
1. Abra `gradle.properties`
2. Verifique as versões de compilação
3. Execute `./gradlew clean` e sincronize novamente

### Problema: Emulador não inicia

**Solução**:
1. Feche e reabra o AVD Manager
2. Clique com botão direito no emulador → `Cold Boot Now`
3. Se ainda não funcionar, delete e recrie o emulador

### Problema: "adb not found"

**Solução**:
1. Vá para `File` → `Settings` → `Appearance & Behavior` → `System Settings` → `Android SDK` → `SDK Tools`
2. Certifique-se que "Android SDK Platform-Tools" está instalado
3. Reinicie o Android Studio

## ⚙️ Configurações Recomendadas

### Configurar Formatter de Código

1. Vá para `File` → `Settings` → `Editor` → `Code Style` → `Kotlin`
2. Configure conforme o padrão do projeto

### Ativar Lint

1. Vá para `File` → `Settings` → `Editor` → `Inspections`
2. Procure por "Lint"
3. Ative as inspeções desejadas

### Configurar Visualização de Gradle

1. Vá para `View` → `Tool Windows` → `Gradle`
2. Explore as tarefas disponíveis
3. Clique duplo em uma tarefa para executá-la

## 📚 Próximos Passos

1. Leia o [README.md](README.md) para uma visão geral do projeto
2. Estude a [ARCHITECTURE.md](ARCHITECTURE.md) para entender a estrutura
3. Consulte [CONTRIBUTING.md](CONTRIBUTING.md) para contribuir

## 🤝 Suporte

Se encontrar problemas na configuração:

1. Verifique os logs no Android Studio (View → Tool Windows → Logcat)
2. Consulte a documentação oficial: https://developer.android.com/
3. Abra uma issue no repositório com detalhes do problema

---

Última atualização: 14 de maio de 2026
