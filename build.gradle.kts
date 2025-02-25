group = "se.warting.gcmd"
version = "1.0-SNAPSHOT"

// Get the shell command list from -Pcommand="cmd1 && cmd2 && cmd3"
val cmdTasks = (project.findProperty("command") as? String)?.split("&&")?.map { it.trim() } ?: emptyList()

val shellTasks = cmdTasks.mapIndexed { index, cmd ->
    val taskName = "runTask$index"

    tasks.register(taskName) {
        group = "Shell Commands"
        description = "Executes: $cmd"

        doLast {
            println("Executing: $cmd")
            val result = exec {
                commandLine("bash", "-c", cmd)
                isIgnoreExitValue = false // Stop if command fails
            }
            if (result.exitValue != 0) {
                throw GradleException("Command failed: $cmd")
            }
        }
    }
}

// Register runAll task to execute all shell tasks sequentially
tasks.register("runAll") {
    group = "Shell Commands"
    description = "Runs all shell commands sequentially"

    dependsOn(shellTasks)
}
