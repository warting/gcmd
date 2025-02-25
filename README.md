# gcmd

**gcmd** is a Gradle-based tool that enables tracking and measuring shell command executions using **Gradle tasks and Develocity Build Scans**. It allows running multiple shell commands while leveraging Gradle's execution tracking, making it ideal for CI/CD workflows and performance analysis.

## 🚀 Features

- **Execute Multiple Commands as Gradle Tasks**
- **Fully Measurable in Develocity Build Scans** 📊
- **Easy-to-Use `gcmd` Wrapper** for seamless command execution
- **Customizable Gradle Task Registration**

---

## 📦 Installation

### 1️⃣ Clone the Repository:
```bash
git clone https://github.com/yourusername/gcmd.git
cd gcmd
```

### 2️⃣ Ensure the `gcmd` Script is Executable:
```bash
chmod +x gcmd
```

### 3️⃣ (Optional) Install `gcmd` Globally:
To use `gcmd` from anywhere:
```bash
sudo mv gcmd /usr/local/bin/gcmd
```

---

## 🔥 Usage

### Running Commands via Gradle:
Instead of executing shell commands manually, wrap them with **Gradle tracking**:

```bash
./gradlew runAll -Pcommand="pwd && sleep 5 && ls -la"
```

This will:
1. Execute `pwd`
2. Execute `sleep 5`
3. Execute `ls -la`

Each command will be **tracked separately** as a Gradle task in **Develocity Build Scans**.
