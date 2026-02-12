# Programming and Data Structures  
# Programación y Estructura de Datos

This repository contains the laboratory work for the subject **Programming and Data Structures**.  
Este repositorio contiene las prácticas de laboratorio de la asignatura **Programación y Estructura de Datos**.

The project is intended to be used by a group of three students.  
El proyecto está pensado para ser utilizado por un grupo de tres estudiantes.

**Programming language used:** Java  
**IDE used:** IntelliJ IDEA  

---

# 📁 Repository Structure / Estructura del Repositorio

```
/Practicas
     /Practica1/
     /Practica2/
     /Practica3/
```

Each folder contains the corresponding lab assignment.  
Cada carpeta contiene la práctica correspondiente.

---

# 🚀 HOW TO USE THIS REPOSITORY (ENGLISH)

If you have never used GitHub before, follow these steps carefully.

---

## 1️⃣ Install Git

Download Git from:

https://git-scm.com/

Install it with default settings.

After installation, open **Git Bash** and check:

```bash
git --version
```

If a version number appears, Git is correctly installed.

---

## 2️⃣ Configure SSH (Required to Push Changes)

To upload changes without entering your password every time, configure SSH once.

### Generate SSH Key

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

Press **Enter** when asked where to save the file.

### Start SSH Agent

```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
```

### Copy Public Key

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy everything displayed.

### Add Key to GitHub

1. Go to GitHub  
2. Profile → **Settings**  
3. **SSH and GPG Keys**  
4. **New SSH Key**  
5. Paste the key  
6. Click **Add SSH Key**

### Test Connection

```bash
ssh -T git@github.com
```

If successful:

```
Hi your-username! You've successfully authenticated.
```

---

## 3️⃣ Clone the Repository (Using SSH)

Go to the folder where you want to save the project:

```bash
cd Desktop
```

Clone using SSH:

```bash
git clone git@github.com:YOUR_USERNAME/REPOSITORY_NAME.git
```

Example:

```bash
git clone git@github.com:diegomorasol/programming-and-data-structures.git
```

---

## 4️⃣ Open the Project in IntelliJ IDEA

1. Open IntelliJ IDEA  
2. Click **Open**  
3. Select the cloned project folder  
4. Configure JDK:  
   `File → Project Structure → SDK`

We will only work in Java.

---

## 5️⃣ Working on a Practice

Each practice is located inside:

```
/Practicas/PracticaX/
```

You can:

- Modify existing files  
- Add new Java classes  
- Implement required algorithms  
- Test your code locally  

---

## 6️⃣ Updating Your Local Version

Before starting work:

```bash
git pull
```

---

## 7️⃣ Uploading Changes (Basic Git Workflow)

After making changes:

```bash
git add .
git commit -m "Description of changes"
git push
```

Example:

```bash
git commit -m "Implemented recursive method for exercise 2"
```

---

# 📘 CÓMO USAR ESTE REPOSITORIO (ESPAÑOL)

Si nunca has usado GitHub, sigue estos pasos cuidadosamente.

---

## 1️⃣ Instalar Git

Descarga Git desde:

https://git-scm.com/

Instálalo con las opciones por defecto.

Después, abre **Git Bash** y escribe:

```bash
git --version
```

Si aparece un número de versión, Git está correctamente instalado.

---

## 2️⃣ Configurar SSH (Necesario para Subir Cambios)

Para poder subir cambios sin introducir la contraseña cada vez, configura SSH una vez.

### Generar Clave SSH

```bash
ssh-keygen -t ed25519 -C "tu_email@example.com"
```

Pulsa **Enter** cuando pregunte dónde guardar el archivo.

### Iniciar el Agente SSH

```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
```

### Copiar Clave Pública

```bash
cat ~/.ssh/id_ed25519.pub
```

Copia todo el contenido.

### Añadir la Clave a GitHub

1. Ve a GitHub  
2. Perfil → **Settings**  
3. **SSH and GPG Keys**  
4. **New SSH Key**  
5. Pega la clave  
6. Pulsa **Add SSH Key**

### Probar la Conexión

```bash
ssh -T git@github.com
```

Si todo está correcto aparecerá:

```
Hi tu-usuario! You've successfully authenticated.
```

---

## 3️⃣ Clonar el Repositorio (Usando SSH)

Ve a la carpeta donde quieras guardar el proyecto:

```bash
cd Desktop
```

Clona usando SSH:

```bash
git clone git@github.com:TU_USUARIO/NOMBRE_REPOSITORIO.git
```

---

## 4️⃣ Abrir el Proyecto en IntelliJ IDEA

1. Abrir IntelliJ IDEA  
2. Pulsar en **Open**  
3. Seleccionar la carpeta clonada  
4. Configurar JDK en:  
   `File → Project Structure → SDK`

Solo trabajaremos en Java.

---

## 5️⃣ Trabajar en una Práctica

Cada práctica se encuentra en:

```
/Practicas/PracticaX/
```

Puedes:

- Modificar archivos  
- Añadir nuevas clases Java  
- Implementar algoritmos  
- Probar tu código localmente  

---

## 6️⃣ Actualizar tu Versión Local

Antes de empezar:

```bash
git pull
```

---

## 7️⃣ Subir Cambios

Después de hacer cambios:

```bash
git add .
git commit -m "Descripción de los cambios"
git push
```

---

# 👥 Collaboration Rules / Reglas de Colaboración

**English**

- Work only inside your assigned practice folder  
- Always run `git pull` before starting  
- Write clear commit messages  
- Do not delete other people’s work  
- Keep the repository organized  

**Español**

- Trabaja solo en la práctica asignada  
- Haz siempre `git pull` antes de empezar  
- Escribe mensajes de commit claros  
- No borres el trabajo de otros compañeros  
- Mantén el repositorio organizado  

---

# 🎯 Objective / Objetivo

This repository is intended for academic use and collaborative learning in Java, focusing on data structures and algorithmic problem solving.

Este repositorio está destinado al uso académico y al aprendizaje colaborativo en Java, enfocado en estructuras de datos y resolución de problemas algorítmicos.

