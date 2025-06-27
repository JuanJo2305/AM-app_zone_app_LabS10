# 🎮 Evidencias del funcionamiento del proyecto (Parte 1 :Autenticación)

  - Login

 <img src="App_Login.png" width="250" />

  - Registro

 <img src="App_Registro.png" width="250" />

  - Dasboard (Autenticación Realizada)

 <img src="App_Dashboard.png" width="250" />

  - Dashboard Invitado

 <img src="App_Invitado.png" width="250" />

# 🎮 Evidencias del funcionamiento del proyecto (Parte 2 : Base de Datos en Tiempo Real)

  - Se agregó las actividades de Agregar Juegos y Listar Juegos (aquí se podrá mostrar los juegos para poder filtrar ,editarlos y eliminarlos)

 <img src="App_Main.jpeg" width="250" />

  - Los usuarios pueden registrar sus juegos favoritos

 <img src="App_Registrar_1.jpeg" width="250" />

 <img src="App_Registrar_2.jpeg" width="250" />

  - Los datos se almacen en Firebase
 <img src="App_Database.jpg" width="1920" />

# ✨ Funcionalidades Extra
  - Los usuarios pueden editar juegos existentes (Tocando una sola vez las cardView del juego)
 <img src="App_Editar_1.jpeg" width="250" />
 <img src="App_Editar_2.jpeg" width="250" />
 
   - Los usuarios pueden eliminar juegos (Manteniendo presionado la cardView del juego)
 <img src="App_Eliminar_1.jpeg" width="250" />
 <img src="App_Eliminar_2.jpeg" width="250" />

  - Los usuarios pueden filtrar sus juegos por género
 <img src="App_Filtrar_Genero_1.jpeg" width="250" />
 <img src="App_Filtrar_Genero_2.jpeg" width="250" />

- Los usuarios pueden buscar sus juegos por título 
 <img src="App_Filtrar_Titulo.jpeg" width="250" />

# 🎮 GameVault - Firebase Authentication Android 

Una aplicación Android moderna con **Firebase Authentication** y tema gaming completo. Perfecta para aprender autenticación móvil con una interfaz atractiva de videojuegos.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-039BE5?style=for-the-badge&logo=Firebase&logoColor=white)

## 📱 Características

### 🔐 **Autenticación Completa**
- ✅ Login/Registro con email y contraseña
- ✅ Login anónimo (modo invitado)
- ✅ Recuperación de contraseña
- ✅ Verificación de email
- ✅ Validaciones y manejo de errores
- ✅ Logout seguro

### 🎨 **Tema Gaming**
- 🌈 Paleta de colores neón (púrpura, cyan, verde)
- 🎮 Iconos gaming personalizados
- 🌙 Modo oscuro con gradientes
- ✨ Efectos visuales atractivos
- 🎯 Interfaz completamente en español

### 🏗️ **Arquitectura**
- 📱 Material Design 3
- 🏛️ MVVM pattern ready
- 🔧 Kotlin moderno
- 🚀 Firebase SDK actualizado

## 🚀 Instalación y Configuración

### 1️⃣ **Fork del Proyecto**

```bash
# 1. Haz fork de este repositorio en GitHub
# 2. Clona tu fork
git clone https://github.com/TU_USUARIO/app_s10.git
cd app_s10
```

### 2️⃣ **Configurar Firebase**

#### **Crear Proyecto Firebase:**
1. Ve a [Firebase Console](https://console.firebase.google.com/)
2. Haz clic en "Crear un proyecto"
3. Ingresa el nombre: `GameVault` (o el que prefieras)
4. Habilita Google Analytics (opcional)
5. Crea el proyecto

#### **Agregar App Android:**
1. En la consola de Firebase, haz clic en "Agregar app" → Android
2. **Nombre del paquete:** `com.example.app_s10`
3. **Nombre de la app:** `GameVault`
4. **Certificado SHA-1:** (opcional por ahora)
5. Descarga el archivo `google-services.json`

#### **Reemplazar archivo de configuración:**
```bash
# Reemplaza el archivo placeholder con tu archivo real
cp ruta/a/tu/google-services.json app/google-services.json
```

### 3️⃣ **Habilitar Authentication**

1. En Firebase Console, ve a **Authentication**
2. Haz clic en **Sign-in method**
3. Habilita estos proveedores:
   - ✅ **Correo electrónico/contraseña**
   - ✅ **Anónimo** (opcional, para modo invitado)

### 4️⃣ **Abrir en Android Studio**

```bash
# Abre Android Studio
# File → Open → Selecciona la carpeta app_s10
# Espera a que Gradle sincronice
```

### 5️⃣ **Ejecutar la App**

1. Conecta tu dispositivo Android o inicia un emulador
2. Haz clic en **Run** ▶️
3. ¡La app se instalará y abrirá!

## 📁 Estructura del Proyecto

```
app_s10/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/app_s10/
│   │   │   ├── LoginActivity.kt      # 🔐 Pantalla de login
│   │   │   └── MainActivity.kt       # 🏠 Dashboard principal
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_login.xml    # 🎨 UI Login
│   │   │   │   └── activity_main.xml     # 🎨 UI Dashboard
│   │   │   ├── values/
│   │   │   │   ├── colors.xml        # 🌈 Colores gaming
│   │   │   │   └── strings.xml       # 🇪🇸 Textos en español
│   │   │   └── drawable/             # 🎮 Iconos y fondos
│   │   └── AndroidManifest.xml       # ⚙️ Configuración app
│   ├── google-services.json          # 🔥 Config Firebase
│   └── build.gradle.kts              # 📦 Dependencias
└── README.md                         # 📖 Este archivo
```

## 🎮 Cómo Usar la App

### **1. Primera Vez**
- Abre la app
- Verás la pantalla de login con tema gaming
- Haz clic en "REGISTRARSE" para crear una cuenta

### **2. Registro**
- Ingresa tu email y contraseña (mín. 6 caracteres)
- Haz clic en "REGISTRARSE"
- Se enviará un email de verificación (opcional)

### **3. Login**
- Ingresa tus credenciales
- Haz clic en "INICIAR SESIÓN"
- Accederás al dashboard gaming

### **4. Modo Invitado**
- Haz clic en "Continuar como invitado"
- Acceso instantáneo sin registro

### **5. Dashboard**
- Ve tu información de usuario
- Explora las secciones gaming
- Cierra sesión cuando quieras

## 🛠️ Personalización

### **Cambiar Colores**
Edita `app/src/main/res/values/colors.xml`:
```xml
<color name="gaming_purple">#TU_COLOR</color>
<color name="gaming_cyan">#TU_COLOR</color>
```

### **Cambiar Textos**
Edita `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Tu App Name</string>
<string name="login_title">Tu Título</string>
```

### **Agregar Funcionalidades**
- Edita `MainActivity.kt` para agregar más features
- Crea nuevas Activities para pantallas adicionales
- Integra Firestore para guardar datos de usuario

## 🔧 Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Kotlin** | 2.0.21 | Lenguaje principal |
| **Android Gradle Plugin** | 8.9.2 | Build system |
| **Firebase BOM** | 33.7.0 | Gestión de versiones Firebase |
| **Firebase Auth** | Latest | Autenticación |
| **Material Design** | 1.12.0 | Componentes UI |
| **ConstraintLayout** | 2.2.1 | Layouts responsive |

## 🚨 Solución de Problemas

### **Error: "google-services.json not found"**
```bash
# Asegúrate de que el archivo esté en la ubicación correcta
ls app/google-services.json
# Si no existe, descárgalo desde Firebase Console
```

### **Error: "Default FirebaseApp is not initialized"**
- Verifica que `google-services.json` sea válido
- Asegúrate de que el package name coincida: `com.example.app_s10`
- Limpia y reconstruye el proyecto: Build → Clean Project

### **Error de autenticación**
- Verifica que Email/Password esté habilitado en Firebase Console
- Revisa la conexión a internet
- Verifica las reglas de seguridad de Firebase

### **Problemas de compilación**
```bash
# Limpia el proyecto
./gradlew clean

# Reconstruye
./gradlew build
```

## 🤝 Contribuir

1. **Fork** este repositorio
2. **Crea** una rama para tu feature: `git checkout -b mi-nueva-feature`
3. **Commit** tus cambios: `git commit -am 'Agregar nueva feature'`
4. **Push** a la rama: `git push origin mi-nueva-feature`
5. **Crea** un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ve el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**GxJohan**
- GitHub: [@GxJohan](https://github.com/GxJohan)
- Proyecto: [app_zone_app](https://github.com/GxJohan/app_zone_app)

## 🌟 ¿Te gustó el proyecto?

¡Dale una ⭐ al repositorio si te sirvió! Ayuda a otros developers a encontrarlo.

## 📚 Recursos Adicionales

- [📖 Documentación Firebase Auth](https://firebase.google.com/docs/auth/android/start)
- [🎨 Material Design Guidelines](https://material.io/design)
- [📱 Android Developer Guide](https://developer.android.com/guide)
- [🔥 Firebase Console](https://console.firebase.google.com/)

---

### 🎮 **¡Happy Gaming & Coding!** 🎮

> Desarrollado con ❤️ para la comunidad de developers Android
