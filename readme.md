# HamrohUz

**HamrohUz** is an Android application designed to facilitate ride-sharing and carpooling services, drawing inspiration from the **BlaBlaCar** platform. The app aims to connect **drivers** and **passengers** traveling in the same direction, promoting **cost-effective** and **eco-friendly** transportation solutions.

## Architecture

The project follows a **modular architecture** to ensure **scalability** and **maintainability**. The primary modules include:

- **App Module** – Contains the main application logic and entry points.
- **Core Module** – Contains common utilities and foundational classes shared across multiple modules.
- **Feature Modules** – Encapsulate distinct features such as user profile management, ride handling, and messaging.
- **Navigation Module** – Manages in-app navigation and routing.
- **Build Logic Module** – Contains custom Gradle scripts and build configurations.

---

## Technologies Used

- **Programming Language:** [Kotlin](https://kotlinlang.org/)
- **User Interface:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Networking:** [Retrofit](https://square.github.io/retrofit/) for API integration
- **Dependency Injection:** [Dagger-Hilt](https://dagger.dev/hilt/)
- **Asynchronous Programming:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) and [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)
- **Local Data Storage:** [Room Persistence Library](https://developer.android.com/jetpack/androidx/releases/room)
- **Navigation:** [Cicerone](https://github.com/terrakok/Cicerone) – lightweight library for navigation in Android applications
- **Build System:** [Gradle with Kotlin DSL](https://developer.android.com/build)

## Design Reference

The application's user interface is designed based on the following **Figma prototype**:

[![Figma Design](https://user-images.githubusercontent.com/66072196/166246753-662d7a8c-cab7-4ff8-84d1-4c4dd525da53.svg)](https://www.figma.com/design/oo82257TrZuLTGxSukFhYF/BlaBlaCar-UZ-%2F-Hamroh-UZ-%2F-UI?node-id=3-3045&p=f&t=qFZYKMGoH4viJbwm-0)
