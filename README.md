# MoviesKMP

Aplicativo multiplataforma (Android e iOS) de catálogo de filmes construído com Kotlin Multiplatform (KMP) e Compose Multiplatform.

## Tecnologias Utilizadas
- **Kotlin Multiplatform (KMP):** Compartilhamento de lógica de negócios e estado entre plataformas.
- **Compose Multiplatform:** UI declarativa compartilhada.
- **Android & iOS:** Módulos de aplicação nativa.

## Estrutura do Projeto
- `/androidApp`: Módulo do aplicativo Android. Contém o ponto de entrada (`MainActivity.kt`) e configurações do aplicativo.
- `/iosApp`: Módulo do aplicativo iOS. Contém o projeto Xcode e o ponto de entrada (`MainViewController.kt`, `ContentView.swift`).
- `/shared`: Módulo central contendo o código compartilhado.
  - `commonMain`: Código e UI independentes de plataforma.
    - `domain/model/Movie.kt`: Modelo de dados da aplicação.
    - `navigation/AppRoutes.kt`: Gerenciamento de rotas e navegação.
    - `ui/movies/MoviesListScreen.kt`: Tela principal de listagem.
    - `ui/components/`: Componentes visuais da interface (`MoviePoster.kt`, `MoviesSection.kt`).
    - `composeResources/`: Recursos estáticos da interface multiplataforma.
  - `androidMain` / `iosMain`: Implementações específicas de plataforma (`Platform.kt`).

## Como Executar

### Android
1. Abra o projeto no Android Studio.
2. Sincronize o projeto com o Gradle.
3. Selecione a configuração de execução `androidApp` e execute.

### iOS
1. Certifique-se de ter o Xcode instalado no macOS.
2. Sincronize o projeto via Gradle.
3. Abra o projeto `iosApp/iosApp.xcodeproj` no Xcode ou execute o target `iosApp` diretamente via Android Studio/Fleet.
